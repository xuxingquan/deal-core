package com.bill99.base.account.common.enumeration;

/**
 * @Description:交易类型枚举
 * @author yunlong.liu
 *
 */
public enum DealTypeEnum {
	// 交易
	DEAL(1, "交易"),
	// 冲正
	REVERSE(2, "冲正");

	private DealTypeEnum(Integer code, String desc) {
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

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
