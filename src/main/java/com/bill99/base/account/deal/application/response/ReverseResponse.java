package com.bill99.base.account.deal.application.response;

import lombok.Getter;
import lombok.Setter;

import com.bill99.mam.application.MamResponse;
import com.google.common.base.MoreObjects;
@Getter
@Setter
public class ReverseResponse extends MamResponse {
	private static final long serialVersionUID = -7043283421352814065L;
	private String orignDealStatus;
	private String reverseDealStatus;
	private String reverseDealId;
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("orignDealStatus", orignDealStatus)
				.add("reverseDealStatus", reverseDealStatus)
				.add("reverseDealId", reverseDealId)
				.addValue(toInternalString())
				.toString();
	}
}
