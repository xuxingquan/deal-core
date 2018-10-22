package com.bill99.base.account.deal.application.aop;

import static com.bill99.base.account.common.constant.Constant.BIZ_CODE;
import static com.bill99.base.account.common.constant.Constant.OUT_TRADE_NO;
import static com.bill99.base.account.common.constant.Constant.REDIS_KEY_PREFIX;
import static com.bill99.base.account.common.constant.Constant.UNDER_LINE;
import static org.apache.commons.beanutils.BeanUtils.getProperty;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.deal.domain.util.UniqueServiceUtil;
import com.bill99.inf.unique.UniqueModuleService;

@Service
public class UniqueAspect {
	@Autowired
	private UniqueModuleService uniqueModuleService;
	/**
	* @Description: 防重服务
	* @param proceedingJoinPoint
	* @param Throwable
	* @return Object
	* @throws
	 */
	public Object preventRepetition(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		
		UniqueServiceUtil uniqueService = UniqueServiceUtil.build(uniqueModuleService);
		Signature signature = proceedingJoinPoint.getSignature();
		String bizCode = null;
		String outTradeNo = null;
		if (signature instanceof MethodSignature) {
			Object[] args = proceedingJoinPoint.getArgs();
			if (ArrayUtils.isNotEmpty(args)) {
				Object obj = args[0];
				try {
					bizCode = getProperty(obj, BIZ_CODE);
					outTradeNo = getProperty(obj, OUT_TRADE_NO);
				} catch (Exception e) {
				}
			}
		}
		
		if (StringUtils.isAnyBlank(bizCode,outTradeNo)) {
			return proceedingJoinPoint.proceed();
		}
		
		try {
			// 防重服务
			String key = buildKey(bizCode, outTradeNo);
			uniqueService.tryLock(key);
			return proceedingJoinPoint.proceed();
		} finally {
			// 防重释放
			uniqueService.release();
		}
	}

	private String buildKey(String bizCode, String outTradeNo) {
		return StringUtils.join(REDIS_KEY_PREFIX,bizCode,UNDER_LINE,outTradeNo);
	}
}
