package com.bill99.base.account.deal.domain.vo;

import java.util.Date;

import com.google.common.base.MoreObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class JournalDetailVo {
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
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("subId", subId)
                .add("journalId", journalId)
                .add("origJournalId", origJournalId)
                .add("postingRule", postingRule)
                .add("postingRuleType", postingRuleType)
                .add("seq", seq)
                .add("amount", amount)
                .add("membercode", membercode)
                .add("direction", direction)
                .add("currencyCode", currencyCode)
                .add("peOrderId", peOrderId)
                .add("peDealId", peDealId)
                .add("peOrderSeqId", peOrderSeqId)
                .add("status", status)
                .add("memo", memo)
                .add("version", version)
                .add("requestTime", requestTime)
                .add("crtTime", crtTime)
                .add("updTime", updTime)
                .add("ext1", ext1)
                .add("ext2", ext2)
                .add("ext3", ext3)
                .add("ext4", ext4)
                .toString();
    }
}
