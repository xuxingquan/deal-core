package com.bill99.base.account.deal.gateway.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bill99.base.account.deal.application.AccountDealService;
import com.bill99.base.account.deal.application.request.BalanceDetailRequest;
import com.bill99.base.account.deal.application.request.ChangeBalanceRequest;
import com.bill99.base.account.deal.application.request.ReverseRequest;
import com.bill99.base.account.deal.application.response.BalanceDetailResponse;
import com.bill99.base.account.deal.application.response.ChangeBalanceResponse;
import com.bill99.base.account.deal.application.response.ReverseResponse;

@RestController
@RequestMapping("/accounting")
public class AccountDealController {
	@Autowired
	private AccountDealService accountDealService;

	@RequestMapping("/balance/change")
	@ResponseBody
	public ChangeBalanceResponse changeBalance(@RequestBody ChangeBalanceRequest request) {
		return accountDealService.changeBalance(request);
	}

	@RequestMapping("/detail")
	@ResponseBody
	public BalanceDetailResponse queryBalanceDetail(@RequestBody BalanceDetailRequest request) {
		return accountDealService.queryBalanceDetail(request);
	}
	
	@RequestMapping("/reverse")
	@ResponseBody
	public ReverseResponse balanceChangeReverse(@RequestBody ReverseRequest request) {
		return accountDealService.balanceChangeReverse(request);
	}
}
