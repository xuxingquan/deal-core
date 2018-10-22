package com.bill99.base.account.deal.domain.service.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.util.DateUtil;
import com.bill99.base.account.deal.application.request.BalanceDetailRequest;
import com.bill99.base.account.deal.application.response.BalanceDetailResponse;
import com.bill99.base.account.deal.domain.vo.DealFlowVo;

@Service
public class DealQueryService {
	@Autowired
	private DealFlowService dealFlowService;
	public BalanceDetailResponse queryDetail(BalanceDetailRequest request) {
		DealFlowVo flowVo = dealFlowService.query(request.getOutTradeNo(),request.getOrderId());
		BalanceDetailResponse resp = new BalanceDetailResponse();
		if (flowVo == null) {
			resp.setRspCode(ReturnCodeEnum.DEAL_NOT_EXIST.getCode());
			resp.setRspMsg(ReturnCodeEnum.DEAL_NOT_EXIST.getMsg());
			return resp;
		}
		resp.setDealId(flowVo.getFlowId());
		resp.setStatus(flowVo.getStatus() + "");
		resp.setOutTradeNo(flowVo.getOutTradeNo());
		resp.setDealType(flowVo.getDealType() + "");
		resp.setRequestTime(DateUtil.defaultFormat(flowVo.getRequestTime()));
		resp.setTxnEndTime(DateUtil.defaultFormat(flowVo.getTxnEndTime()));
		resp.setIsReverse(flowVo.getIsReverse() + "");
		resp.setRspCode(ReturnCodeEnum.SUCC.getCode());
		resp.setRspMsg(ReturnCodeEnum.SUCC.getMsg());
		return resp;
	}
}
