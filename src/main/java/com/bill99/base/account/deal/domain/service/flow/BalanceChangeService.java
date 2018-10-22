package com.bill99.base.account.deal.domain.service.flow;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.DealStatusEnum;
import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.deal.application.request.ChangeBalanceRequest;
import com.bill99.base.account.deal.application.response.ChangeBalanceResponse;
import com.bill99.base.account.deal.domain.repository.DealDetailRepository;
import com.bill99.base.account.deal.domain.repository.DealFlowRepository;
import com.bill99.base.account.deal.domain.service.DealSequenceService;
import com.bill99.base.account.deal.domain.util.DealFlowUtil;
import com.bill99.base.account.deal.domain.vo.DealFlowVo;
import com.bill99.mam.exception.ServiceFailException;

@Service
public class BalanceChangeService {
	private static final Logger LOG = LoggerFactory.getLogger(BalanceChangeService.class);
	@Autowired
	private DealFlowService dealFlowService;
	@Autowired
	private DealDetailRepository detailRepository;
	@Autowired
	private DealFlowRepository flowRepository;
	@Autowired
	private DealCoreService dealCoreService;
	@Autowired
	private DealSequenceService sequenceService;
	/**
	* @Description: 余额变更 
	* @param request
	* @param response
	* @return void
	* @throws
	 */
	public ChangeBalanceResponse changeBalance(ChangeBalanceRequest request){
		ChangeBalanceResponse response = new ChangeBalanceResponse();
		DealFlowVo dealFlowVo = null;
		try {
			//1.查询记账记录是否存在
			dealFlowVo = queryOrsaveDealFlowAndDetail(request);
			if (DealStatusEnum.isSuccess(dealFlowVo.getStatus())) {
				return buildResponse(dealFlowVo,response);
			}
			//2.查询并验证会员状态
			dealCoreService.checkMemberInfo(dealFlowVo);
			//3.查询并设置分账户及分账户余额对象
			dealCoreService.queryAndSetSubAcct(dealFlowVo);
			//4.校验账户状态（冻结、注销/止入止出）
			dealCoreService.checkAccount(dealFlowVo);
			//5.校验账户余额、变更账户余额及更新记账信息
			dealCoreService.updateDealAndBalance(dealFlowVo);
			//6.减少同一个事物的等待，后面可以以其他办法保证更新成功
			dealCoreService.updateDealForSuccess(dealFlowVo);
			//7.设置并返回记账交易ID与状态
			buildResponse(dealFlowVo,response);
		} catch (Exception e) {
			LOG.error("changeBalance error,request={}",request,e);
			//7.异常处理
			exceptionHandler(response, dealFlowVo, e);
		}
		
		return response;
	}
	/**
	* @Description: 交易成功返回
	* @param dealFlowVo
	* @param response
	* @return ChangeBalanceResponse
	 */
	private ChangeBalanceResponse buildResponse(DealFlowVo dealFlowVo,ChangeBalanceResponse response) {
		response.setDealId(dealFlowVo.getFlowId());
		response.setStatus(dealFlowVo.getStatus().toString());
		response.setRspCode(ReturnCodeEnum.SUCC.getCode());
		response.setRspMsg(ReturnCodeEnum.SUCC.getMsg());
		return response;
	}
	/**
	* @Description: 查询或保存记账记录(不存在则保存)
	* @param request
	* @param response
	* @return DealFlowVo
	* @throws
	 */
	private DealFlowVo queryOrsaveDealFlowAndDetail(ChangeBalanceRequest request) {
		String bizCode = request.getBizCode();
		String outTradeNo = request.getOutTradeNo();
		DealFlowVo condition = new DealFlowVo();
		condition.setBizCode(bizCode);
		condition.setOutTradeNo(outTradeNo);
		DealFlowVo dealFlowVo = dealFlowService.query(condition);
		if (dealFlowVo == null) {//不存在则保存新记录
			String flowId = sequenceService.getFlowId();
			DealFlowVo flowVo = DealFlowUtil.buildFlowVo(request, flowId);
			dealFlowVo = dealFlowService.saveDealFlowAndDetail(flowVo);
		}
		return dealFlowVo;
	}
	/**
	* @Description: 异常处理
	* @param response
	* @param dealFlowVo
	* @param e
	* @return void
	* @throws
	 */
	private void exceptionHandler(ChangeBalanceResponse response,
			DealFlowVo dealFlowVo, Exception e) {
		//返回错误信息
		String errorCode = ReturnCodeEnum.SERVICE_ERROR.getCode();
		String errorMsg = ReturnCodeEnum.SERVICE_ERROR.getMsg();
		if (e instanceof ServiceFailException) {
			errorCode = ((ServiceFailException) e).getErrorCode();
			errorMsg = ((ServiceFailException) e).getMessage();
		}
		
		response.setRspCode(errorCode);
		response.setRspMsg(errorMsg);
		if (dealFlowVo == null) {
			return ;
		}
		//返回冲正记录状态
		String status = DealStatusEnum.FAILID.getStatus().toString();
		response.setDealId(dealFlowVo.getFlowId());
		response.setStatus(status);
		//更新记账表状态与错误信息
		dealFlowVo.setErrorCode(errorCode);
		dealFlowVo.setErrorMessage(errorMsg);
		dealFlowVo.setStatus(CommonUtil.toInteger(status));
		dealFlowVo.setTxnEndTime(new Date());
		//执行更新
		flowRepository.update(dealFlowVo);
	}
}
