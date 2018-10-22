package com.bill99.base.account.deal.domain.service.flow;

import static com.bill99.base.account.common.util.Validator.checkArgument;
import static com.bill99.base.account.common.util.Validator.checkNotNull;
import static com.bill99.base.account.deal.domain.util.DealFlowUtil.buildFlowVo;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.DealStatusEnum;
import com.bill99.base.account.common.enumeration.DealTypeEnum;
import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.deal.application.request.ReverseRequest;
import com.bill99.base.account.deal.application.response.ReverseResponse;
import com.bill99.base.account.deal.domain.repository.DealDetailRepository;
import com.bill99.base.account.deal.domain.repository.DealFlowRepository;
import com.bill99.base.account.deal.domain.service.DealSequenceService;
import com.bill99.base.account.deal.domain.vo.DealDetailVo;
import com.bill99.base.account.deal.domain.vo.DealFlowVo;
import com.bill99.mam.exception.ServiceFailException;
import com.google.common.base.Objects;
@Service
public class ReverseService {
	private static final Logger LOG = LoggerFactory.getLogger(ReverseService.class);
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
	* @Description: 冲正 
	* 		1.原交易存在且交易成功
	* 		2.是否存在冲正交易，失败？成功?
	* 		3.不存在冲正交易：保存冲正记录
	* 		4.校验会员状态
	* 		5.校验账户状态（冻结、注销/止入止出、余额）
	* 		6.变更余额
	* 		7.更改冲正交易记录与原交易记录状态与时间
	* @param request
	* @return ReverseResponse
	 */
	public ReverseResponse reverse(ReverseRequest request) {
		ReverseResponse response = new ReverseResponse();
		DealFlowVo reverseFlowVo = null;
		try {
			//1.查询原交易
			DealFlowVo orignFlowVo = queryOrignDealFlow(request,response);
			//2.查询冲正交易
			reverseFlowVo = queryOrSaveReverseDealFlow(request,orignFlowVo,response);
			//3.查询并验证会员状态
			dealCoreService.checkMemberInfo(reverseFlowVo);
			//4.查询并设置子账户
			dealCoreService.queryAndSetSubAcct(reverseFlowVo);
			//5.校验账户状态（冻结、注销/止入止出）
			dealCoreService.checkAccount(reverseFlowVo);
			//6.变更账户余额及更新记账信息
			dealCoreService.changeBalanceForReverse(reverseFlowVo,orignFlowVo);
			//7.设置并返回冲正成功状态
			response.setReverseDealStatus(DealStatusEnum.SUCC.getStatus().toString());
		} catch (Exception e) {
			LOG.error("reverse error,request={}",request,e);
			//8.异常处理
			exceptionHandler(response, reverseFlowVo, e);
		}
		return response;
	}
	/**
	* @Description:发生异常更新记账信息
	* @param response
	* @param reverseSummaryVo
	* @param e
	* @return void
	 */
	private void exceptionHandler(ReverseResponse response,
			DealFlowVo reverseFlowVo, Exception e) {
		//返回错误信息
		String errorCode = ReturnCodeEnum.SERVICE_ERROR.getCode();
		String errorMsg = ReturnCodeEnum.SERVICE_ERROR.getMsg();
		if (e instanceof ServiceFailException) {
			errorCode = ((ServiceFailException) e).getErrorCode();
			errorMsg = ((ServiceFailException) e).getMessage();
		}
		
		response.setRspCode(errorCode);
		response.setRspMsg(errorMsg);
		if (reverseFlowVo == null) {
			return ;
		}
		
		//返回冲正记录状态
		String status = DealStatusEnum.FAILID.getStatus().toString();
		response.setReverseDealStatus(status);
		
		reverseFlowVo.setErrorCode(errorCode);
		reverseFlowVo.setErrorMessage(errorMsg);
		reverseFlowVo.setStatus(CommonUtil.toInteger(status));
		reverseFlowVo.setTxnEndTime(new Date());
		//更新冲正表记录错误信息
		flowRepository.update(reverseFlowVo);
	}
	/**
	* @Description: 查询或保存冲正记录 
	* @param request
	* @param dealSummaryVo
	* @param response
	* @return DealSummaryVo
	* @throws
	 */
	private DealFlowVo queryOrSaveReverseDealFlow(
			ReverseRequest request,
			DealFlowVo orignDealFlowVo,
			ReverseResponse response) {
	
		String orignDealId = orignDealFlowVo.getFlowId();
		DealFlowVo reverseDealFlowVo = queryReverseDealVo(orignDealId);
		if(reverseDealFlowVo == null){
			//不存在则直接保存
			String flowId = sequenceService.getFlowId();
			reverseDealFlowVo = buildFlowVo(flowId,request, orignDealFlowVo);
			reverseDealFlowVo = dealFlowService.saveDealFlowAndDetail(reverseDealFlowVo);
		} else if (DealStatusEnum.isSuccess(reverseDealFlowVo.getStatus())){
			//存在且成功则抛异常,返回
			response.setReverseDealStatus(DealStatusEnum.SUCC.getStatus().toString());
			response.setReverseDealId(reverseDealFlowVo.getFlowId());
			ExceptionFactory.throwException(ReturnCodeEnum.REVERSE_SUCCEED);
		}
		//设置冲正记录ID与状态
		response.setReverseDealId(reverseDealFlowVo.getFlowId());
		response.setReverseDealStatus(reverseDealFlowVo.getStatus().toString());
		return reverseDealFlowVo;	
	}
	private DealFlowVo queryReverseDealVo(String dealId) {
		DealFlowVo queryCondition = new DealFlowVo();
		queryCondition.setOrigFlowId(dealId);
		queryCondition.setDealType(DealTypeEnum.REVERSE.getCode());
		DealFlowVo reverseDealFlowVo = queryDealFlowAndDetail(queryCondition);
		return reverseDealFlowVo;
	}
	/**
	* @Description: 查询原交易记账记录
	* 				1.查询结果是否存在
	* 				2.交易是否成功 
	* @param request
	* @param response
	* @return AccountDealSummaryVo
	 */
	private DealFlowVo queryOrignDealFlow(ReverseRequest request,ReverseResponse response) {
		//查询原交易记账记录
		DealFlowVo orignDealFlowVo = queryDealFlowVo(request);
		response.setOrignDealStatus(CommonUtil.toString(orignDealFlowVo.getStatus()));
		//正向交易是否成功
		boolean isSuccess = Objects.equal(DealStatusEnum.SUCC.getStatus(), orignDealFlowVo.getStatus());
		checkArgument(isSuccess, ReturnCodeEnum.ORIGN_FLOW_STATUS_ERROR);
		return orignDealFlowVo;
	}
	/**
	* @Description: 查询记账主表与明细表 
	* @param request
	* @return DealFlowVo
	 */
	private DealFlowVo queryDealFlowVo(ReverseRequest request) {
		String outTradeNo = request.getOrignOutTradeNo();
		String orderId = request.getOrignOrderId();
		String orignDealId = request.getOrignDealId();
		//组装查询条件
		DealFlowVo queryCondition = new DealFlowVo();
		queryCondition.setIsReverse(0);//正向交易
		if (StringUtils.isNotBlank(outTradeNo) && StringUtils.isNotBlank(orderId)) {
			queryCondition.setOutTradeNo(outTradeNo);
			queryCondition.setOrderId(orderId);
		} else if(StringUtils.isNotBlank(orignDealId)){
			queryCondition.setFlowId(orignDealId);
		}
		
		DealFlowVo orignDealFlowVo = queryDealFlowAndDetail(queryCondition);
		checkNotNull(orignDealFlowVo, ReturnCodeEnum.ORIGN_FLOW_NOT_EXIST);
		return orignDealFlowVo;
	}
	
	/**
	* @Description: 查询记账记录（主表及明细记录） 
	* @param queryCondition
	* @return AccountDealSummaryVo
	 */
	private DealFlowVo queryDealFlowAndDetail(DealFlowVo queryCondition) {
		DealFlowVo orignDealFlowVo = dealFlowService.query(queryCondition);
		if (orignDealFlowVo == null) {
			return null;
		}
		//查询明细
		List<DealDetailVo> detailVos = orignDealFlowVo.getDetailVos();
		checkNotNull(CollectionUtils.isNotEmpty(detailVos), ReturnCodeEnum.FLOW_DETAIL_NOT_EXIST);	
		return orignDealFlowVo;
	}
}
