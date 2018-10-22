package com.bill99.base.account.deal.domain.entity;

import java.util.Date;

import com.google.common.base.MoreObjects;

public class SubAcctBalance {
    private String subAcctId;

    private Long subAcctBalance;

    private Long creditbalance;

    private Long debitbalance;

    private Long frozenbalance;

    private Date crtTime;

    private Date updTime;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;

    private Long allowWithdrawBalance;

    private Long version;

    public String getSubAcctId() {
        return subAcctId;
    }

    public void setSubAcctId(String subAcctId) {
        this.subAcctId = subAcctId == null ? null : subAcctId.trim();
    }

    public Long getSubAcctBalance() {
        return subAcctBalance;
    }

    public void setSubAcctBalance(Long subAcctBalance) {
        this.subAcctBalance = subAcctBalance;
    }

    public Long getCreditbalance() {
        return creditbalance;
    }

    public void setCreditbalance(Long creditbalance) {
        this.creditbalance = creditbalance;
    }

    public Long getDebitbalance() {
        return debitbalance;
    }

    public void setDebitbalance(Long debitbalance) {
        this.debitbalance = debitbalance;
    }

    public Long getFrozenbalance() {
        return frozenbalance;
    }

    public void setFrozenbalance(Long frozenbalance) {
        this.frozenbalance = frozenbalance;
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

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5 == null ? null : ext5.trim();
    }

    public Long getAllowWithdrawBalance() {
        return allowWithdrawBalance;
    }

    public void setAllowWithdrawBalance(Long allowWithdrawBalance) {
        this.allowWithdrawBalance = allowWithdrawBalance;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("subAcctId", subAcctId)
                .add("subAcctBalance", subAcctBalance)
                .add("creditbalance", creditbalance)
                .add("debitbalance", debitbalance)
                .add("frozenbalance", frozenbalance)
                .add("ext1", ext1)
                .add("ext2", ext2)
                .add("ext3", ext3)
                .add("ext4", ext4)
                .add("ext5", ext5)
                .add("allowWithdrawBalance", allowWithdrawBalance)
                .add("version", version)
                .toString();
    }
}