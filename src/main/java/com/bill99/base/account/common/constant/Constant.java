package com.bill99.base.account.common.constant;


public class Constant {
	// 时间格式
	public static final String TIME_PATTERN = "yyyyMMddHHmmss";
	// 币种
	public static final String CURRENCY_CODE = "CNY";
	// 币种
	public static final String STATUS_ON = "1";
	public static final String ZERO = "0";
	public static final String UNDER_LINE = "_";
	public static final String BIZ_CODE = "bizCode";
	public static final String OUT_TRADE_NO = "outTradeNo";
	public static final String REDIS_KEY_PREFIX = "baseDeal_";
	public static final String CACHE_REFRESH_POOL_SIZE = "mam.finder.dealcore.cache.refreshPoolSize";
	//pe记账服务URI
	public static final String PE_ORDER_SERVICE_URI = "/hessianOrderServiceRemoting.do";
	//PE记账冲正服务URI
	public static final String PE_REVERSE_ORDER_SERVICE_URI = "/hessianReverseOrderServiceRemoting.do";
	//PE记账冲正服务读超时时间
	public static final int HESSIAN_READ_TIME_OUT = 100000;
}
