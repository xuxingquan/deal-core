package com.bill99.base.account.deal.infrastructure.acms;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class AcmsVariable {
	@Value("${mam.finder.dealcore.repetion.seconds}")
	private String balanceChangeTimeout;
	// 子账户缓存自动刷新周期(分)
	@Value("${mam.finder.dealcore.cache.subacct.refreshDuration}")
	protected Integer subAcctRefreshDuration;
	// 子账户缓存过期时间(小时)
	@Value("${mam.finder.dealcore.cache.subacct.expireDuration}")
	protected Integer subAcctExpireDuration;
	// 子账户缓存最大容量
	@Value("${mam.finder.dealcore.cache.subacct.maxSize}")
	protected Integer subAcctMaxSize;
	// 子账户缓存初始化缓存容量
	@Value("${mam.finder.dealcore.cache.subacct.initialCapacity}")
	protected Integer subAcctInitialCapacity;

	// 会员信息缓存自动刷新周期(分)
	@Value("${mam.finder.dealcore.cache.memberInfo.refreshDuration}")
	protected Integer memberInfoRefreshDuration;
	// 会员信息缓存过期时间(小时)
	@Value("${mam.finder.dealcore.cache.memberInfo.expireDuration}")
	protected Integer memberInfoExpireDuration;
	// 会员信息缓存最大容量
	@Value("${mam.finder.dealcore.cache.memberInfo.maxSize}")
	protected Integer memberInfoMaxSize;
	// 会员信息缓存初始化缓存容量
	@Value("${mam.finder.dealcore.cache.memberInfo.initialCapacity}")
	protected Integer memberInfoInitialCapacity;
	// 缓存刷新线程池容量
	@Value("${mam.finder.dealcore.cache.refreshPoolSize}")
	protected Integer refreshPoolSize;
	
	// 调用PE记账服务URL
	@Value("${mam.finder.dealcore.url.peHessianUrl}")
	protected String peHessianUrl;
	// 调用PE记账服务超时时间
	@Value("${mam.finder.dealcore.url.peReadTimeOut}")
	protected Integer peReadTimeOut;
}
