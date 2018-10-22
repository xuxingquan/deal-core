package com.bill99.base.account.deal.domain.vo;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
@Getter
@Setter
@EqualsAndHashCode(of={"subAcctId"})
public class SubAcctBalanceVo implements Comparable<SubAcctBalanceVo>{
	
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
    
    @Override
	public int compareTo(SubAcctBalanceVo o) {
    	return ComparisonChain.start()
				.compare(o.subAcctId, this.subAcctId).result();
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
