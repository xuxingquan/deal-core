package com.bill99.base.account.common.enumeration;

import org.apache.commons.lang.StringUtils;


public enum MemberStatusEnum {
	// 0:创建;1:正常,2:冻结,3:注销
	CREATE(0, "创建"),
    NORMAL(1, "正常"),
    FROZEN(2, "冻结"),
    CANCEL(3, "注销");

    private Integer status;
    private String desc;

    MemberStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

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
    
    public MemberStatusEnum getMemberStatusEnum(String status) {
    	if (!StringUtils.isEmpty(status)) {
    		for (MemberStatusEnum e : MemberStatusEnum.values()) {
        		if (e.getStatus().equals(status)) {
        			return e;
        		}
        	}
    	}
    	return null;
    }
}
