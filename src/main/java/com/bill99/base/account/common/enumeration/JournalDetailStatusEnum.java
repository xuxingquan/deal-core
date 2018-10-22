package com.bill99.base.account.common.enumeration;

import com.google.common.base.Objects;

public enum JournalDetailStatusEnum {
	INIT(0, "初始化"),
	// 成功
	SUCC(1, "成功"),
	// 失败
	FAILID(2, "失败"),
	// 冲正
	REVERSE(3, "冲正"),
	// 处理中
	PROCESSING(4,"处理中"),
	;
	private JournalDetailStatusEnum(Integer status, String desc) {
		this.status = status;
		this.desc = desc;
	}
	// 记账状态
	private Integer status;
	// 描述
	private String desc;

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static boolean isProcessing(Integer status){
		return Objects.equal(PROCESSING.getStatus(), status);
	}
	
	public static boolean isSuccess(Integer status){
		return Objects.equal(SUCC.getStatus(), status);
	}

}
