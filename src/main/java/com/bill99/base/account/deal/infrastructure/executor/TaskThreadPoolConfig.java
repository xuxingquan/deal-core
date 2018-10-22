package com.bill99.base.account.deal.infrastructure.executor;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.task.pool")
public class TaskThreadPoolConfig {
	private int corePoolSize;
	private int maxPoolSize;
	private int keepAliveSeconds;
	private int queueCapacity;
}