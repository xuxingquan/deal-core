package com.bill99.base.account.deal.domain.entity;

import java.util.Date;

public class DealDetail {
    private Long subId;

    private String flowId;

    private String origFlowId;

    private Long memberCode;

    private String subAcctType;

    private String subAcctSubjectCode;

    private Long amount;

    private Integer direction;

    private String currencyCode;

    private Long postdealBalance;

    private String memo;

    private Date requestTime;

    private Date crtTime;

    private Date updTime;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private Integer version;

    private Long allowWithDrawAmount;

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId == null ? null : flowId.trim();
    }

    public String getOrigFlowId() {
        return origFlowId;
    }

    public void setOrigFlowId(String origFlowId) {
        this.origFlowId = origFlowId == null ? null : origFlowId.trim();
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getSubAcctType() {
        return subAcctType;
    }

    public void setSubAcctType(String subAcctType) {
        this.subAcctType = subAcctType == null ? null : subAcctType.trim();
    }

    public String getSubAcctSubjectCode() {
        return subAcctSubjectCode;
    }

    public void setSubAcctSubjectCode(String subAcctSubjectCode) {
        this.subAcctSubjectCode = subAcctSubjectCode == null ? null : subAcctSubjectCode.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public Long getPostdealBalance() {
        return postdealBalance;
    }

    public void setPostdealBalance(Long postdealBalance) {
        this.postdealBalance = postdealBalance;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4 == null ? null : ext4.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getAllowWithDrawAmount() {
        return allowWithDrawAmount;
    }

    public void setAllowWithDrawAmount(Long allowWithDrawAmount) {
        this.allowWithDrawAmount = allowWithDrawAmount;
    }
}