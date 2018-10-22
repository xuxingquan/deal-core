package com.bill99.base.account.deal.domain.service.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.common.util.DateUtil;
import com.bill99.base.account.deal.application.request.ChargeQueryRequest;
import com.bill99.base.account.deal.application.response.ChargeQueryResponse;
import com.bill99.base.account.deal.domain.vo.DealJournalVo;

@Service
public class JournalQueryService {
	@Autowired
	private JournalService journalService;
	public ChargeQueryResponse queryDetail(ChargeQueryRequest request) {
		DealJournalVo journalVo = journalService.query(request.getOutTradeNo(),request.getOrderId());
		ChargeQueryResponse resp = new ChargeQueryResponse();
		if (journalVo == null) {
			resp.setRspCode(ReturnCodeEnum.DEAL_NOT_EXIST.getCode());
			resp.setRspMsg(ReturnCodeEnum.DEAL_NOT_EXIST.getMsg());
			return resp;
		}
		resp.setDealId(journalVo.getJournalId());
		resp.setStatus(CommonUtil.toString(journalVo.getStatus()));
		resp.setOutTradeNo(journalVo.getOutTradeNo());
		resp.setDealType(CommonUtil.toString(journalVo.getDealType()));
		resp.setRequestTime(DateUtil.defaultFormat(journalVo.getRequestTime()));
		resp.setTxnEndTime(DateUtil.defaultFormat(journalVo.getTxnEndTime()));
		resp.setIsReverse(CommonUtil.toString(journalVo.getIsReverse()));
		resp.setRspCode(ReturnCodeEnum.SUCC.getCode());
		resp.setRspMsg(ReturnCodeEnum.SUCC.getMsg());
		return resp;
	}
}
