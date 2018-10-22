package com.bill99.base.account.deal.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.deal.application.DealJournalService;
import com.bill99.base.account.deal.application.request.ChargeQueryRequest;
import com.bill99.base.account.deal.application.request.ChargeRequest;
import com.bill99.base.account.deal.application.response.ChargeQueryResponse;
import com.bill99.base.account.deal.application.response.ChargeResponse;
import com.bill99.base.account.deal.domain.service.journal.ChargeService;
import com.bill99.base.account.deal.domain.service.journal.JournalQueryService;
import com.bill99.mam.application.MamRequest;
import com.bill99.mam.application.MamResponse;
@Service
public class DealJournalServiceImpl implements DealJournalService {
	@Autowired
	private ChargeService chargeChangeService;
	@Autowired
	private JournalQueryService journalQueryService;
	/**
	 * PE记账
	 */
	@Override
	public ChargeResponse charge(ChargeRequest request) {
		return chargeChangeService.charge(request);
	}
	/**
	 * PE记账查询
	 */
	@Override
	public ChargeQueryResponse queryBalanceDetail(ChargeQueryRequest request) {
		return journalQueryService.queryDetail(request);
	}
	@Override
	public MamResponse chargeForTask(MamRequest request) {
		chargeChangeService.chargeForTask(request);
		return new MamResponse();
	}
}
