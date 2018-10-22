package com.bill99.base.account.deal.application;

import javax.validation.Valid;

import com.bill99.base.account.deal.application.request.ChargeQueryRequest;
import com.bill99.base.account.deal.application.request.ChargeRequest;
import com.bill99.base.account.deal.application.response.ChargeQueryResponse;
import com.bill99.base.account.deal.application.response.ChargeResponse;
import com.bill99.mam.application.MamRequest;
import com.bill99.mam.application.MamResponse;

public interface DealJournalService {
	
	/**
	 * @Description:PE记账
	 */
	ChargeResponse charge(@Valid ChargeRequest request);

	/**
	 * @Description:根据会员号+外部订单号，查询余额变更明细结果
	 */
	ChargeQueryResponse queryBalanceDetail(@Valid ChargeQueryRequest request);
	/**
	* @Description: 定时任务调用PE记账
	* @param request
	* @return MamResponse
	* @throws
	 */
	MamResponse chargeForTask(@Valid MamRequest request);
}
