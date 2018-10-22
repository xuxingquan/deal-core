package com.bill99.base.account.deal.domain.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bill99.base.account.deal.infrastructure.acms.AcmsVariable;
import com.google.common.base.MoreObjects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

/**
 * 内存缓存抽象类：后台线程定时刷新缓存值。刷新失败时将继续返回旧缓存
 * @author jerry.xu.coc
 */
public abstract class AbstractCache <K, V> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
    // 缓存自动刷新周期
    private int refreshDuration;
    // 缓存过期时间
    private int expireDuration;
    // 缓存最大容量
    private int maxSize;
    // 初始化缓存容量
    private int initialCapacity;
    @Autowired
	protected AcmsVariable acmsVariable;
    // 数据刷新线程池
    @Autowired
    @Qualifier(value="cacheExecutorService")
    private ListeningExecutorService executorService;
    
    private volatile LoadingCache<K, V> cache = null;
    /**
    * @Description: 定义缓存值的计算方法:
    * 					新值计算失败时抛出异常，get操作时将继续返回旧的缓存
    * @param key
    * @param @throws Exception
    * @return V
     */
    protected abstract V getValueWhenExpired(K key) throws Exception;
    protected abstract void initProperties();

    /**
     * @description: 从cache中拿出数据操作
     * @param key
     */
    public V getValue(K key) {
        return getValueOrDefault(key,null);
    }

    public V getValueOrDefault(K key, V defaultValue) {
        try {
            return getCache().get(key);
        } catch (Exception e) {
            logger.error("GetValue occur Exception,key=",key, e);
            return defaultValue;
        }
    }

    /**
     * 设置基本属性
     */
    public AbstractCache<K, V> setRefreshDuration( int refreshDuration ){
        this.refreshDuration = refreshDuration;
        return this;
    }

    public AbstractCache<K, V> setExpireDuration( int expireDuration ){
        this.expireDuration = expireDuration;
        return this;
    }

    public AbstractCache<K, V> setMaxSize( int maxSize ){
        this.maxSize = maxSize;
        return this;
    }

    public AbstractCache<K, V> setInitialCapacity(int initialCapacity) {
		this.initialCapacity = initialCapacity;
		return this;
	}

	public void clearAll(){
        this.getCache().invalidateAll();
    }

    /**
     * @description: 获取cache实例
     */
    private LoadingCache<K, V> getCache() {
        if(cache == null){
            synchronized (this) {
                if(cache == null){
                    CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder().maximumSize(maxSize);
                    cacheBuilder.initialCapacity(initialCapacity);
                    cacheBuilder.removalListener(new RemovalListener<K, V>() {
						@Override
						public void onRemoval(RemovalNotification<K, V> notification) {
							logger.info("removeCacheKey,key={},cause={}",notification.getKey(),notification.getCause());
						}
					});
                    
                    if(refreshDuration > 0) {
                        cacheBuilder = cacheBuilder.refreshAfterWrite(refreshDuration, TimeUnit.MINUTES);
                    }
                    
                    if(expireDuration > 0) {
                        cacheBuilder = cacheBuilder.expireAfterAccess(expireDuration, TimeUnit.HOURS);
                    }

                    cache = cacheBuilder.build(new CacheLoader<K, V>() {
                            @Override
                            public V load(K key) throws Exception {
                                return getValueWhenExpired(key);
                            }
                            @Override
                            public ListenableFuture<V> reload(final K key,V oldValue) throws Exception {
                                return executorService.submit(new Callable<V>() {
                                    public V call() throws Exception {
                                        return getValueWhenExpired(key);
                                    }
                                });
                            }
                        } );
                }
            }
        }
        return cache;
    }

	@Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("refreshDuration", refreshDuration)
                .add("expireDuration", expireDuration)
                .add("maxSize", maxSize)
                .toString();
    }
}