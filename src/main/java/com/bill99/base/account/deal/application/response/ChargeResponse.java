package com.bill99.base.account.deal.application.response;

import lombok.Getter;
import lombok.Setter;

import com.bill99.mam.application.MamResponse;
import com.google.common.base.MoreObjects;
@Getter
@Setter
public class ChargeResponse extends MamResponse {
	private static final long serialVersionUID = -1615267284339289062L;
	private String dealId;
	private String status;
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("dealId", dealId)
				.add("status", status)
				.addValue(toInternalString())
				.toString();
	}
}
