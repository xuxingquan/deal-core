package com.bill99.base.account.deal.domain.vo;

import java.util.Date;
import java.util.List;

import com.google.common.base.MoreObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class DealJournalVo {

	private List<JournalDetailVo> detailVos;
	private Long id;

	private String journalId;

	private String origJournalId;

	private String bizCode;

	private String outTradeNo;

	private String origOutTradeNo;

	private String orderId;

	private Integer isReverse;

	private Integer status;

	private Integer dealType;

	private Integer version;

	private String appId;

	private String errorCode;

	private String errorMessage;

	private Date requestTime;

	private Date txnEndTime;

	private Date crtTime;

	private Date updTime;

	private String ext1;

	private String ext2;

	private String ext3;

	private String ext4;

	private String ext5;

	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("detailVos", detailVos)
				.add("id", id)
				.add("journalId", journalId)
				.add("origJournalId", origJournalId)
				.add("bizCode", bizCode)
				.add("outTradeNo", outTradeNo)
				.add("origOutTradeNo", origOutTradeNo)
				.add("orderId", orderId)
				.add("isReverse", isReverse)
				.add("status", status)
				.add("dealType", dealType)
				.add("version", version)
				.add("appId", appId)
				.add("errorCode", errorCode)
				.add("errorMessage", errorMessage)
				.add("requestTime", requestTime)
				.add("txnEndTime", txnEndTime)
				.add("crtTime", crtTime)
				.add("updTime", updTime)
				.add("ext1", ext1)
				.add("ext2", ext2)
				.add("ext3", ext3)
				.add("ext4", ext4)
				.add("ext5", ext5).toString();
	}

}
