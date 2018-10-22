package com.bill99.base.account.common.enumeration;
public enum SubAcctTypeEnum {
	
	SPLIT_FUND("SPAD0001", "应付待分账资金"),
	WITHDRQW_FUND("SPAW0001", "应付可提现资金"),
	FORBID_FUND("SPAF0001", "应付冻结资金款"),
	TRANSIT_FUND("SPWD0001", "应付在途资金");
	
	private String code;
	private String info;

	private SubAcctTypeEnum(String code, String info) {
		this.code = code;
		this.info = info;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	/**
	* @Description: 是否可提现余额账户类型
	* @param subAcctType 子账户余额类型
	* @return boolean
	 */
	public static boolean isWithDrawFund(String subAcctType){
		return WITHDRQW_FUND.getCode().equals(subAcctType);
	}
}