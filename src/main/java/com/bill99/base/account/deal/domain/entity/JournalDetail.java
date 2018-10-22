package com.bill99.base.account.deal.domain.entity;

import java.util.Date;

public class JournalDetail {
    private Long subId;

    private String journalId;

    private String origJournalId;

    private String postingRule;

    private String postingRuleType;

    private Integer seq;

    private Long amount;

    private String membercode;

    private Integer direction;

    private String currencyCode;

    private String peOrderId;

    private String peDealId;

    private Long peOrderSeqId;

    private Integer status;

    private String memo;

    private Integer version;

    private Date requestTime;

    private Date crtTime;

    private Date updTime;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId == null ? null : journalId.trim();
    }

    public String getOrigJournalId() {
        return origJournalId;
    }

    public void setOrigJournalId(String origJournalId) {
        this.origJournalId = origJournalId == null ? null : origJournalId.trim();
    }

    public String getPostingRule() {
        return postingRule;
    }

    public void setPostingRule(String postingRule) {
        this.postingRule = postingRule == null ? null : postingRule.trim();
    }

    public String getPostingRuleType() {
        return postingRuleType;
    }

    public void setPostingRuleType(String postingRuleType) {
        this.postingRuleType = postingRuleType == null ? null : postingRuleType.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getMembercode() {
        return membercode;
    }

    public void setMembercode(String membercode) {
        this.membercode = membercode == null ? null : membercode.trim();
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

    public String getPeOrderId() {
        return peOrderId;
    }

    public void setPeOrderId(String peOrderId) {
        this.peOrderId = peOrderId == null ? null : peOrderId.trim();
    }

    public String getPeDealId() {
        return peDealId;
    }

    public void setPeDealId(String peDealId) {
        this.peDealId = peDealId == null ? null : peDealId.trim();
    }

    public Long getPeOrderSeqId() {
        return peOrderSeqId;
    }

    public void setPeOrderSeqId(Long peOrderSeqId) {
        this.peOrderSeqId = peOrderSeqId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
}