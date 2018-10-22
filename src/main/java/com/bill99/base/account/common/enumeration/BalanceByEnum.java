package com.bill99.base.account.common.enumeration;

/**
 * @Description:借贷方向
 * @author yunlong.liu
 *
 */
public enum BalanceByEnum {
	// 借方科目
	DEBIT(1, "借方"),
	// 贷方科目
	CREDIT(2, "贷方"), ;
	private BalanceByEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private Integer code;

	private String desc;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}
	
	public static boolean isDebit(String balanceBy){
		return DEBIT.getCode().toString().equals(balanceBy);
	}
	
	public static boolean isCredit(String balanceBy){
		return CREDIT.getCode().toString().equals(balanceBy);
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
