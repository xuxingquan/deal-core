package com.bill99.base.account.common.enumeration;

public enum BizStateEnum {
	// PE记账处理成功
	PE_SUCCESS(1,"PE记账处理成功"),
	// PE记账处理失败
	PE_FAILED(2,"PE记账处理失败"),
	// PE记账处理中
	PE_PROCESSING(3,"PE记账处理中"),
	;

	private int status;
	private String message;

	private BizStateEnum(int status,String message) {
		this.status = status;
		this.message = message;
	}

	public int status() {
		return status;
	}
	
	public String message() {
		return message;
	}
	
	public static boolean isPEProcessing(int status){
		return PE_PROCESSING.status() == status;
	}
	
	public static boolean isPESuccess(int status){
		return PE_SUCCESS.status() == status;
	}
}
