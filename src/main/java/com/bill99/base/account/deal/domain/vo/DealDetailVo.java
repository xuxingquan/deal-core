package com.bill99.base.account.deal.domain.vo;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
@Getter
@Setter
@EqualsAndHashCode
public class DealDetailVo implements Comparable<DealDetailVo>{
	//子账户
	private SubAccountVo subAccountVo;
	//余额
	private SubAcctBalanceVo subAcctBalanceVo;
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
	
	@Override
	public int compareTo(DealDetailVo o) {
		return ComparisonChain.start()
				.compare(o.subAcctSubjectCode, this.subAcctSubjectCode)
				.compare(o.direction,this.direction).result();
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("subId", subId)
				.add("flowId", flowId)
				.add("origFlowId", origFlowId)
				.add("memberCode", memberCode)
				.add("subAcctType", subAcctType)
				.add("subAcctSubjectCode", subAcctSubjectCode)
				.add("amount", amount)
				.add("direction", direction)
				.add("currencyCode", currencyCode)
				.add("postdealBalance", postdealBalance)
				.add("memo", memo)
				.add("ext1", ext1)
				.add("ext2", ext2)
				.add("ext3", ext3)
				.add("ext4", ext4)
				.add("version", version)
				.add("allowWithDrawAmount", allowWithDrawAmount)
				.toString();
	}
}
