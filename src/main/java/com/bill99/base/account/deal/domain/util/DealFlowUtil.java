package com.bill99.base.account.deal.domain.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.bill99.base.account.common.constant.Constant;
import com.bill99.base.account.common.enumeration.DealDirectionEnum;
import com.bill99.base.account.common.enumeration.DealStatusEnum;
import com.bill99.base.account.common.enumeration.DealTypeEnum;
import com.bill99.base.account.common.enumeration.SubAcctTypeEnum;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.deal.application.request.BalanceChange;
import com.bill99.base.account.deal.application.request.ChangeBalanceRequest;
import com.bill99.base.account.deal.application.request.ReverseRequest;
import com.bill99.base.account.deal.domain.vo.DealDetailVo;
import com.bill99.base.account.deal.domain.vo.DealFlowVo;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class DealFlowUtil {

	// 构建冲正VO对象
	public static DealFlowVo buildFlowVo(
			String flowId,
			ReverseRequest request, 
			DealFlowVo orignDealFlowVo) {
		// 冲正记账主表
		DealFlowVo reverseFlowVo = new DealFlowVo();
		reverseFlowVo.setAppId(request.getAppId());
		reverseFlowVo.setOutTradeNo(request.getOutTradeNo());
		reverseFlowVo.setBizCode(request.getBizCode());
		reverseFlowVo.setFlowId(flowId);
		reverseFlowVo.setPlatformCode(orignDealFlowVo.getPlatformCode());
		reverseFlowVo.setOrderId(orignDealFlowVo.getOrderId());
		reverseFlowVo.setRequestTime(new Date());
		reverseFlowVo.setStatus(DealStatusEnum.INIT.getStatus());
		reverseFlowVo.setIsReverse(0);
		reverseFlowVo.setOrigOutTradeNo(orignDealFlowVo.getOutTradeNo());
		reverseFlowVo.setDealType(DealTypeEnum.REVERSE.getCode());
		reverseFlowVo.setOrigFlowId(orignDealFlowVo.getFlowId());
		// 原记账明细
		List<DealDetailVo> orignDealDetailVos = orignDealFlowVo.getDetailVos();
		List<DealDetailVo> detailVos = new ArrayList<DealDetailVo>();
		for (DealDetailVo orignDealDetailVo : orignDealDetailVos) {
			DealDetailVo dealDetailVo = new DealDetailVo();
			dealDetailVo.setMemberCode(orignDealDetailVo.getMemberCode());
			dealDetailVo.setSubAcctType(orignDealDetailVo.getSubAcctType());
			dealDetailVo.setSubAcctSubjectCode(orignDealDetailVo.getSubAcctSubjectCode());
			dealDetailVo.setAmount(orignDealDetailVo.getAmount());
			Long allowWithDrawAmount = orignDealDetailVo.getAllowWithDrawAmount();
			dealDetailVo.setAllowWithDrawAmount(allowWithDrawAmount);
			dealDetailVo.setOrigFlowId(orignDealFlowVo.getFlowId());
			dealDetailVo.setFlowId(reverseFlowVo.getFlowId());
			Integer dealDirection = orignDealDetailVo.getDirection();
			DealDirectionEnum direction = DealDirectionEnum.convert2ReverseDirection(dealDirection);
			dealDetailVo.setDirection(direction.getValue());
			dealDetailVo.setCurrencyCode(orignDealDetailVo.getCurrencyCode());
			detailVos.add(dealDetailVo);
		}
		reverseFlowVo.setDetailVos(detailVos);
		return reverseFlowVo;
	}
	/**
	* @Description: 从变更余额请求参数构造对象 DealFlowVo
	* @param request
	* @param flowId
	* @return DealFlowVo
	* @throws
	 */
	public static DealFlowVo buildFlowVo(ChangeBalanceRequest request,String flowId) {
		
		DealFlowVo flowVo = new DealFlowVo();
		flowVo.setAppId(request.getAppId());
		flowVo.setBizCode(request.getBizCode());
		flowVo.setDealType(DealTypeEnum.DEAL.getCode());
		flowVo.setFlowId(flowId);
		flowVo.setIsReverse(0);
		flowVo.setOrderId(request.getOrderId());
		flowVo.setOutTradeNo(request.getOutTradeNo());
		flowVo.setPlatformCode(CommonUtil.toLong(request.getPlatformCode()));
		flowVo.setStatus(DealStatusEnum.INIT.getStatus());
		flowVo.setVersion(0);
		
		List<DealDetailVo> detailVos = Lists.newArrayList();
		List<BalanceChange> balanceChanges = request.getBalanceChange();
		
		for (BalanceChange balanceChange : balanceChanges) {
			DealDetailVo detailVo = new DealDetailVo();
			detailVo.setAmount(CommonUtil.toLong(balanceChange.getAmount()));
			String currencyCode = balanceChange.getCurrencyCode();
			detailVo.setCurrencyCode(Optional.fromNullable(currencyCode).or(Constant.CURRENCY_CODE));
			detailVo.setDirection(CommonUtil.toInteger(balanceChange.getDirection()));
			detailVo.setFlowId(flowId);
			detailVo.setMemberCode(CommonUtil.toLong(balanceChange.getMemberCode()));
			detailVo.setMemo(balanceChange.getRemark());
			detailVo.setSubAcctType(balanceChange.getSubAcctType());
			detailVo.setSubAcctSubjectCode(balanceChange.getSubAcctSubjectCode());
			String allowWithDrawAmount = StringUtils.defaultString(balanceChange.getAllowWithDrawAmount(), "0");
			if (SubAcctTypeEnum.isWithDrawFund(detailVo.getSubAcctType())) {
				detailVo.setAllowWithDrawAmount(CommonUtil.toLong(allowWithDrawAmount));
			}
			detailVo.setVersion(0);
			detailVos.add(detailVo);
		}
		flowVo.setDetailVos(detailVos);
		return flowVo;
	}
}
