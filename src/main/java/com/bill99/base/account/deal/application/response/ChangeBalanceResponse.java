package com.bill99.base.account.deal.application.response;

import lombok.Getter;
import lombok.Setter;

import com.bill99.mam.application.MamResponse;
import com.google.common.base.MoreObjects;
@Getter
@Setter
public class ChangeBalanceResponse extends MamResponse {
	private static final long serialVersionUID = -8373599150070132072L;
	private String dealId;
	private String status;
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("dealId", dealId)
				.add("status", status)
				.addValue(toInternalString())
				.toString();
	}
}
