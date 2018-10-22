package com.bill99.base.account.deal.domain.vo;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.google.common.base.MoreObjects;
@Getter
@Setter
public class DealFlowVo {
	//记账明细
	private List<DealDetailVo> detailVos;
	private Long id;

    private String flowId;

    private String outTradeNo;

    private Long platformCode;

    private String origOutTradeNo;

    private Integer status;

    private Integer dealType;

    private String errorCode;

    private String errorMessage;

    private String bizCode;

    private Date requestTime;

    private Date txnEndTime;

    private Integer isReverse;

    private String origFlowId;

    private String appId;

    private String orderId;

    private Date crtTime;

    private Date updTime;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private Integer version;
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("detailVos", detailVos)
				.add("id", id)
				.add("flowId", flowId)
				.add("outTradeNo", outTradeNo)
				.add("platformCode", platformCode)
				.add("origOutTradeNo", origOutTradeNo)
				.add("status", status)
				.add("dealType", dealType)
				.add("errorCode", errorCode)
				.add("errorMessage", errorMessage)
				.add("bizCode", bizCode)
				.add("txnEndTime", txnEndTime)
				.add("isReverse", isReverse)
				.add("origFlowId", origFlowId)
				.add("appId", appId)
				.add("orderId", orderId)
				.add("ext1", ext1)
				.add("ext2", ext2)
				.add("ext3", ext3)
				.add("ext4", ext4)
				.add("version", version)
				.toString();
	}
}
