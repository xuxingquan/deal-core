package com.bill99.base.account.deal.domain.cache;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.bill99.base.account.deal.infrastructure.acms.AcmsVariable;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
/**
 * 
 * @author jerry.xu.coc
 *
 */
@Configuration
public class CacheConfig {
	// 缓存数据刷新线程池
	@DependsOn({"acmsVariable"})
	@Bean
	public ListeningExecutorService cacheExecutorService(AcmsVariable acmsVariable){
		int refreshPoolSize = acmsVariable.getRefreshPoolSize();
    	return MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(refreshPoolSize));
	}
}
