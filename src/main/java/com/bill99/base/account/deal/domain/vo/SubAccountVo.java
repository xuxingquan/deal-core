package com.bill99.base.account.deal.domain.vo;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.google.common.base.MoreObjects;
@Getter
@Setter
@EqualsAndHashCode
public class SubAccountVo {
	
    private String subAcctId;

    private String memberCode;

    private String status;

    private String subAcctName;

    private String subAcctType;

    private String subAcctDescription;

    private String subAcctSubject;

    private String subAcctCurrency;

    private String subAcctBalanceby;

    private String subAcctInterest;

    private String subAcctAllowDeposit;

    private String subAcctAllowWithdraw;

    private String subAcctAllowOverdraft;

    private String subAcctAllowPay;

    private String subAcctLevel;

    private String subAcctVisible;

    private String subAcctFrozen;

    private String subAcctForbidIn;

    private String subAcctForbidOut;

    private String createOperator;

    private String updateOperator;

    private Date crtTime;

    private Date updTime;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("subAcctId", subAcctId)
                .add("memberCode", memberCode)
                .add("status", status)
                .add("subAcctName", subAcctName)
                .add("subAcctType", subAcctType)
                .add("subAcctDescription", subAcctDescription)
                .add("subAcctSubject", subAcctSubject)
                .add("subAcctCurrency", subAcctCurrency)
                .add("subAcctBalanceby", subAcctBalanceby)
                .add("subAcctInterest", subAcctInterest)
                .add("subAcctAllowDeposit", subAcctAllowDeposit)
                .add("subAcctAllowWithdraw", subAcctAllowWithdraw)
                .add("subAcctAllowOverdraft", subAcctAllowOverdraft)
                .add("subAcctAllowPay", subAcctAllowPay)
                .add("subAcctLevel", subAcctLevel)
                .add("subAcctVisible", subAcctVisible)
                .add("subAcctFrozen", subAcctFrozen)
                .add("subAcctForbidIn", subAcctForbidIn)
                .add("subAcctForbidOut", subAcctForbidOut)
                .add("createOperator", createOperator)
                .add("updateOperator", updateOperator)
                .add("ext1", ext1)
                .add("ext2", ext2)
                .add("ext3", ext3)
                .add("ext4", ext4)
                .add("ext5", ext5)
                .toString();
    }
}
