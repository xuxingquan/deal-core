package com.bill99.base.account.deal.application.request;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotBlank;

import com.bill99.mam.application.MamRequest;
import com.google.common.base.MoreObjects;
@Getter
@Setter
public class BalanceDetailRequest extends MamRequest {
	private static final long serialVersionUID = -3937121642391476889L;
	private String platformCode;
	@NotBlank
	private String outTradeNo;
	@NotBlank
	private String orderId;
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("platformCode", platformCode)
				.add("outTradeNo", outTradeNo)
				.add("orderId", orderId)
				.addValue(toInternalString())
				.toString();
	}
}
