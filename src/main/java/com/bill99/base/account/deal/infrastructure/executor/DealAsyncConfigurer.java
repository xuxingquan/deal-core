package com.bill99.base.account.deal.infrastructure.executor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
@Service
public class DealAsyncConfigurer implements AsyncConfigurer {
	private static final Logger LOG = LoggerFactory.getLogger(DealAsyncConfigurer.class);
	@Autowired
	private TaskThreadPoolConfig config; 
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(config.getCorePoolSize());
		executor.setMaxPoolSize(config.getMaxPoolSize());
		executor.setQueueCapacity(config.getQueueCapacity());
		executor.setKeepAliveSeconds(config.getKeepAliveSeconds());
		executor.setThreadNamePrefix("DealCoreExecutor-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		executor.initialize();
		return executor;
	}

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new DealAsyncExceptionHandler();
	}

	/**
	 * 自定义异常处理类
	 */
	class DealAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
		@Override
		public void handleUncaughtException(Throwable throwable, Method method,Object... arg) {
			LOG.info("Exception message={},Method={}", throwable.getMessage(),method.getName());
			for (Object param : arg) {
				LOG.info("Parameter value={}", param);
			}
		}
	}
}