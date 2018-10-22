package com.bill99.base.account.deal.application.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.bill99.base.account.deal.application.request.BalanceChange;
import com.bill99.mam.application.MamResponse;
import com.google.common.base.MoreObjects;
@Getter
@Setter
public class BalanceDetailResponse extends MamResponse {
	private static final long serialVersionUID = 137030767760298286L;
	private String platformCode;
	private String dealId;
	private String outTradeNo;
	private String status;
	private String dealType;
	private String requestTime;
	private String txnEndTime;
	private String isReverse;
	private List<BalanceChange> balanceChange;
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("platformCode", platformCode)
				.add("dealId", dealId)
				.add("outTradeNo", outTradeNo)
				.add("status", status)
				.add("dealType", dealType)
				.add("requestTime", requestTime)
				.add("txnEndTime", txnEndTime)
				.add("isReverse", isReverse)
				.add("balanceChange", balanceChange)
				.addValue(toInternalString())
				.toString();
	}
}
