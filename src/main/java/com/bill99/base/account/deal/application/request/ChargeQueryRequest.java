package com.bill99.base.account.deal.application.request;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.bill99.base.account.deal.application.annotation.MamRequestCheck;
import com.bill99.mam.application.MamRequest;
import com.google.common.base.MoreObjects;
@Getter
@Setter
@MamRequestCheck
public class ChargeQueryRequest extends MamRequest{
	private static final long serialVersionUID = -6868764487515248416L;
	@NotBlank(message = "外部订单号不能为空")
	@Length(max = 32)
	private String outTradeNo;
	@NotBlank(message="订单ID不能为空")
	@Size(max=64,message="订单ID长度非法")
	private String orderId;
	
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("outTradeNo", outTradeNo)
				.add("orderId", orderId)
				.addValue(toInternalString())
				.toString();
	}

}
