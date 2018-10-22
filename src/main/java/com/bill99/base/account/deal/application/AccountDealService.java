package com.bill99.base.account.deal.application;

import javax.validation.Valid;

import com.bill99.base.account.deal.application.request.BalanceDetailRequest;
import com.bill99.base.account.deal.application.request.ChangeBalanceRequest;
import com.bill99.base.account.deal.application.request.ReverseRequest;
import com.bill99.base.account.deal.application.response.BalanceDetailResponse;
import com.bill99.base.account.deal.application.response.ChangeBalanceResponse;
import com.bill99.base.account.deal.application.response.ReverseResponse;

public interface AccountDealService {

	/**
	 * @Description:根据条件，进行分户余额变更
	 */
	ChangeBalanceResponse changeBalance(@Valid ChangeBalanceRequest request);

	/**
	 * @Description:根据会员号+外部订单号，查询余额变更明细结果
	 */
	BalanceDetailResponse queryBalanceDetail(@Valid BalanceDetailRequest request);

	/**
	 * @Description:冲正,冲正判断条件：原交易订单号一致，订单状态为成功
	 */
	ReverseResponse balanceChangeReverse(@Valid ReverseRequest request);
}
