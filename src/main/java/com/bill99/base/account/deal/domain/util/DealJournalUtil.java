package com.bill99.base.account.deal.domain.util;

import static com.bill99.base.account.common.constant.Constant.CURRENCY_CODE;

import java.util.Date;
import java.util.List;

import com.bill99.base.account.common.enumeration.DealDirectionEnum;
import com.bill99.base.account.common.enumeration.PostingRuleEnum;
import com.bill99.base.account.common.enumeration.DealStatusEnum;
import com.bill99.base.account.common.enumeration.DealTypeEnum;
import com.bill99.base.account.common.enumeration.JournalDetailStatusEnum;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.deal.application.request.ChargeDetail;
import com.bill99.base.account.deal.application.request.ChargeRequest;
import com.bill99.base.account.deal.domain.vo.DealJournalVo;
import com.bill99.base.account.deal.domain.vo.JournalDetailVo;
import com.bill99.seashell.common.helper.cos.DealStatus;
import com.bill99.seashell.domain.dto.order.DealDto;
import com.bill99.seashell.domain.dto.order.PaymentOrderDto;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class DealJournalUtil {

	public static DealJournalVo buildJournalVo(ChargeRequest request,String journalId) {

		DealJournalVo journalVo = new DealJournalVo();
		journalVo.setAppId(request.getAppId());
		journalVo.setBizCode(request.getBizCode());
		journalVo.setDealType(DealTypeEnum.DEAL.getCode());
		journalVo.setJournalId(journalId);
		journalVo.setIsReverse(0);
		journalVo.setOrderId(request.getOrderId());
		journalVo.setOutTradeNo(request.getOutTradeNo());
		journalVo.setStatus(DealStatusEnum.PROCESSING.getStatus());//处理中
		journalVo.setVersion(0);

		List<JournalDetailVo> detailVos = Lists.newArrayList();
		List<ChargeDetail> chargeDetailList = request.getChargeDetailList();
		int seq = 1;
		
		for (ChargeDetail chargeDetail : chargeDetailList) {
			String postingRuleType = chargeDetail.getPostingRuleType();
			PostingRuleEnum rule = PostingRuleEnum.getRule(postingRuleType);
			
			String payeeMemberCode = chargeDetail.getPayeeMemberCode();
			String payerMemberCode = chargeDetail.getPayerMemberCode();
			Long amount = CommonUtil.toLong(chargeDetail.getAmount());
			String currencyCode = Optional.fromNullable(chargeDetail.getCurrencyCode()).or(CURRENCY_CODE);
			String memo = chargeDetail.getMemo();
			//收款方
			JournalDetailVo payeeDetailVo = new JournalDetailVo();
			payeeDetailVo.setPostingRuleType(postingRuleType);
			payeeDetailVo.setAmount(amount);
			payeeDetailVo.setSeq(seq);
			payeeDetailVo.setCurrencyCode(currencyCode);
			payeeDetailVo.setPostingRule(rule.getDebitRule());
			payeeDetailVo.setStatus(JournalDetailStatusEnum.INIT.getStatus());
			payeeDetailVo.setMembercode(payeeMemberCode);
			payeeDetailVo.setJournalId(journalId);
			payeeDetailVo.setDirection(DealDirectionEnum.INCREASE.getValue());
			payeeDetailVo.setMemo(memo);
			payeeDetailVo.setVersion(0);
			detailVos.add(payeeDetailVo);
			//付款方
			JournalDetailVo payerDetailVo = new JournalDetailVo();
			payerDetailVo.setPostingRuleType(postingRuleType);
			payerDetailVo.setAmount(amount);
			payerDetailVo.setCurrencyCode(currencyCode);
			payerDetailVo.setStatus(JournalDetailStatusEnum.INIT.getStatus());
			payerDetailVo.setJournalId(journalId);
			payerDetailVo.setPostingRule(rule.getCreditRule());
			payerDetailVo.setSeq(seq++);
			payerDetailVo.setMembercode(payerMemberCode);
			payerDetailVo.setDirection(DealDirectionEnum.DECREASE.getValue());
			payerDetailVo.setMemo(memo);
			payerDetailVo.setVersion(0);
			detailVos.add(payerDetailVo);
		}
		journalVo.setDetailVos(detailVos);
		return journalVo;
	}

	/**
	 * @Description: 构建PE记账服务请求对象
	 */
	public static DealDto buildDealDto(JournalDetailVo detailVo,String orderId) {
		Long amount = detailVo.getAmount()*10;
		String chargeRuleType = detailVo.getPostingRuleType();
		PostingRuleEnum chargeRuleEnum = PostingRuleEnum.getRule(chargeRuleType);
		// 组装paymentOrder
		PaymentOrderDto paymentOrderDto = new PaymentOrderDto();
		paymentOrderDto.setOrderId(orderId);// 必传，且必须唯一
		paymentOrderDto.setOrderType(chargeRuleEnum.getOrderCode());
		paymentOrderDto.setOrderAmount(amount);// 单位：厘
		paymentOrderDto.setOrderTime(new Date());
		paymentOrderDto.setPayMethod(1);
		paymentOrderDto.setOrderStatus(101);
		paymentOrderDto.setVersion("v2.0");
		// 组装DealDto
		DealDto dealDto = new DealDto();
		dealDto.setDealId(null);
		dealDto.setHasCaculatedPrice(true);
		dealDto.setDealBeginDate(new Date());
		dealDto.setDealAmount(amount);
		dealDto.setDealStatus(DealStatus.created.getValue());
		dealDto.setDealCode(chargeRuleEnum.getDealCode());
		dealDto.setPaymentServicePkgCode(chargeRuleEnum.getPskPkgCode());
		dealDto.setDealType(30);
		dealDto.setOrder(paymentOrderDto);
		return dealDto;
	}
}
