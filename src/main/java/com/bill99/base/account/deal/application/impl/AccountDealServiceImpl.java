package com.bill99.base.account.deal.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.deal.application.AccountDealService;
import com.bill99.base.account.deal.application.request.BalanceDetailRequest;
import com.bill99.base.account.deal.application.request.ChangeBalanceRequest;
import com.bill99.base.account.deal.application.request.ReverseRequest;
import com.bill99.base.account.deal.application.response.BalanceDetailResponse;
import com.bill99.base.account.deal.application.response.ChangeBalanceResponse;
import com.bill99.base.account.deal.application.response.ReverseResponse;
import com.bill99.base.account.deal.domain.service.flow.BalanceChangeService;
import com.bill99.base.account.deal.domain.service.flow.DealQueryService;
import com.bill99.base.account.deal.domain.service.flow.ReverseService;
@Service
public class AccountDealServiceImpl implements AccountDealService {
	@Autowired
	private BalanceChangeService balanceChangeService;
	@Autowired
	private ReverseService reverseService;
	@Autowired
	private DealQueryService dealQueryService;
	/**
	 * 变更余额
	 */
	@Override
	public ChangeBalanceResponse changeBalance(ChangeBalanceRequest request) {
		return balanceChangeService.changeBalance(request);
	}
	/**
	 * 查询
	 */
	@Override
	public BalanceDetailResponse queryBalanceDetail(BalanceDetailRequest request) {
		return dealQueryService.queryDetail(request);
	}
	/**
	 * 冲正
	 */
	@Override
	public ReverseResponse balanceChangeReverse(ReverseRequest request) {
		return reverseService.reverse(request);
	}
}
