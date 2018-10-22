package com.bill99.base.account.common.util;
public class DealContextHelper {
	private static ThreadLocal<DealContext> dealContextThreadLocal = new ThreadLocal<DealContext>();
	/**
	 * 保存上下文对象
	 */
	public void addDealContext(DealContext dealContext) {
		dealContextThreadLocal.set(dealContext);
	}
	/**
	 * 获取上下文对象
	 */
	public static DealContext getDealContext() {
		DealContext txnContext = dealContextThreadLocal.get();
		if (txnContext == null) {
			txnContext = new DealContext();
			dealContextThreadLocal.set(txnContext);
		}
		return txnContext;
	}
	/**
	  * @Description:删除变量
	 */
	public static void removeThreadLoacal() {
		dealContextThreadLocal.remove();
	}

}
