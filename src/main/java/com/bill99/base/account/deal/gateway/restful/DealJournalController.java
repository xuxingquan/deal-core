package com.bill99.base.account.deal.gateway.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bill99.base.account.deal.application.DealJournalService;
import com.bill99.base.account.deal.application.request.ChargeQueryRequest;
import com.bill99.base.account.deal.application.request.ChargeRequest;
import com.bill99.base.account.deal.application.response.ChargeQueryResponse;
import com.bill99.base.account.deal.application.response.ChargeResponse;
import com.bill99.mam.application.MamRequest;
import com.bill99.mam.application.MamResponse;

@RestController
@RequestMapping("charge")
public class DealJournalController {
	@Autowired
	private DealJournalService journalService;

	@RequestMapping("change")
	@ResponseBody
	public ChargeResponse charge(@RequestBody ChargeRequest request) {
		return journalService.charge(request);
	}

	@RequestMapping("detail")
	@ResponseBody
	public ChargeQueryResponse queryBalanceDetail(@RequestBody ChargeQueryRequest request) {
		return journalService.queryBalanceDetail(request);
	}
	
	@RequestMapping("chargeForTask")
	@ResponseBody
	public MamResponse chargeForTask(@RequestBody MamRequest request) {
		return journalService.chargeForTask(request);
	}
}
