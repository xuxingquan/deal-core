package com.bill99.base.account.deal.domain.entity;

import java.util.Date;

public class DealFlow {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId == null ? null : flowId.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public Long getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(Long platformCode) {
        this.platformCode = platformCode;
    }

    public String getOrigOutTradeNo() {
        return origOutTradeNo;
    }

    public void setOrigOutTradeNo(String origOutTradeNo) {
        this.origOutTradeNo = origOutTradeNo == null ? null : origOutTradeNo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode == null ? null : bizCode.trim();
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getTxnEndTime() {
        return txnEndTime;
    }

    public void setTxnEndTime(Date txnEndTime) {
        this.txnEndTime = txnEndTime;
    }

    public Integer getIsReverse() {
        return isReverse;
    }

    public void setIsReverse(Integer isReverse) {
        this.isReverse = isReverse;
    }

    public String getOrigFlowId() {
        return origFlowId;
    }

    public void setOrigFlowId(String origFlowId) {
        this.origFlowId = origFlowId == null ? null : origFlowId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
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
}