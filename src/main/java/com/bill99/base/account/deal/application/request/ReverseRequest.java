package com.bill99.base.account.deal.application.request;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotBlank;

import com.bill99.base.account.deal.application.annotation.MamRequestCheck;
import com.bill99.base.account.deal.application.annotation.ReverseRequestCheck;
import com.bill99.mam.application.MamRequest;
import com.google.common.base.MoreObjects;
@Getter
@Setter
@MamRequestCheck
@ReverseRequestCheck(message="冲正请求参数非法")
public class ReverseRequest extends MamRequest {
	private static final long serialVersionUID = 8571257725013893954L;
	@Size(max=32,message="原基础记账主表ID长度非法")
	private String orignDealId;
	@Size(max=64,message="原订单ID长度非法")
	private String orignOrderId;
	@Size(max=32,message="原外部订单号长度非法")
	private String orignOutTradeNo;
	@NotBlank(message="外部订单号不能为空")
	@Size(max=32,message="外部订单号长度非法")
	private String outTradeNo;
	
	/**
	* @Description: 返回BizCode+OutTradeNo组成的key
	 */
	public String getUniqueTradeNo(){
		StringBuilder builder = new StringBuilder()
			.append(getBizCode())
			.append("_")
			.append(getOutTradeNo());
		return builder.toString();
	}
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("orignDealId", orignDealId)
				.add("orignOrderId", orignOrderId)
				.add("orignOutTradeNo", orignOutTradeNo)
				.add("outTradeNo", outTradeNo)
				.addValue(toInternalString())
				.toString();
	}
}
