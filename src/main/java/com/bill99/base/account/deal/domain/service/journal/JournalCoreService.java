package com.bill99.base.account.deal.domain.service.journal;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bill99.base.account.common.enumeration.DealDirectionEnum;
import com.bill99.base.account.common.enumeration.DealStatusEnum;
import com.bill99.base.account.common.enumeration.JournalDetailStatusEnum;
import com.bill99.base.account.common.enumeration.PostingRuleEnum;
import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.deal.domain.repository.DealJournalRepository;
import com.bill99.base.account.deal.domain.repository.JournalDetailRepository;
import com.bill99.base.account.deal.domain.service.DealSequenceService;
import com.bill99.base.account.deal.domain.util.DealJournalUtil;
import com.bill99.base.account.deal.domain.vo.DealJournalVo;
import com.bill99.base.account.deal.domain.vo.JournalDetailVo;
import com.bill99.seashell.domain.dto.entry.QueryOrderResultDto;
import com.bill99.seashell.domain.dto.order.DealDto;
import com.bill99.seashell.domain.service.common.COSResponse;
import com.bill99.seashell.domain.service.pe.hessian.order.HessianOrderService;
@Service
public class JournalCoreService {
	private static final Logger LOG = LoggerFactory.getLogger(ChargeService.class);
	@Autowired
	private JournalDetailRepository detailRepository;
	@Autowired
	private DealJournalRepository journalRepository;
	@Autowired
	private HessianOrderService hessianOrderService;
	@Autowired
	private DealSequenceService sequenceService;
	/**
	* @Description: PE记账(bizStatus为处理中) 异步
	* @param dealJournalVo
	* @return void
	* @throws
	 */
	@Async
	public void asyncCharge(DealJournalVo dealJournalVo) {
		LOG.info("async charge,journalId={}",dealJournalVo.getJournalId());
		syncCharge(dealJournalVo);
	}
	/**
	* @Description: PE记账-同步
	* @param dealJournalVo
	* @return void
	* @throws
	 */
	public void syncCharge(DealJournalVo dealJournalVo) {
		LOG.info("sync charge,journalId={}",dealJournalVo.getJournalId());
		List<JournalDetailVo> detailVos = dealJournalVo.getDetailVos();
		if (CollectionUtils.isEmpty(detailVos)) {
			return ;
		}
		/**
		 * 为防止重复记账 ：默认以付款方明细发起PE记账
		 * 注：调用PE记账更新状态等信息时收付方两条明细都要做更新
		 */
		for (JournalDetailVo detailVo : detailVos) {
			Integer status = detailVo.getStatus();
			Integer direction = detailVo.getDirection();
			if (JournalDetailStatusEnum.isSuccess(status) || 
					DealDirectionEnum.isIncrease(direction)) {
				//如果已经成功则不能重复PE记账
				continue;
			}
			
			if (JournalDetailStatusEnum.isProcessing(status)) {
				String chargeRuleType = detailVo.getPostingRuleType();
				PostingRuleEnum chargeRuleEnum = PostingRuleEnum.getRule(chargeRuleType);
				//如果状态是处理中，则需要先查询PE记账结果
				//如果是成功、超时或未知，continue
				Integer orderCode = chargeRuleEnum.getOrderCode();
				String orderId = detailVo.getPeOrderId();
				Integer[] orderstatus = new Integer[]{111};//101 创建  111 记账成功
				QueryOrderResultDto result = null;
				try {
					result = hessianOrderService.queryOrder(orderCode, orderId, orderstatus);
					LOG.info("hessianOrderService queryOrder,orderId={},result={}",orderId,JSON.toJSONString(result));
				} catch (Exception e) {
					LOG.error("hessianOrderService queryOrder error,orderId={}",orderId,e);
					continue;
				}
				
				if (result != null && CollectionUtils.isNotEmpty(result.getDealList())) {
					List<DealDto> dealList = result.getDealList();
					DealDto dealDto = CommonUtil.getUnique(dealList);
					if (dealDto != null && dealDto.getDealStatus().intValue() == 1) {//记账成功
						detailVo.setPeDealId(dealDto.getDealId());
						detailVo.setPeOrderSeqId(dealDto.getOrder().getSequenceId());
						detailVo.setStatus(JournalDetailStatusEnum.SUCC.getStatus());
						detailRepository.updateAfterPostingRule(detailVo);
						continue;
					}
				}
			} 
			//状态是初始化或失败，则发起PE记账请求
			callPeOrderService(detailVo);
		}
		//PE记账是否都成功，存在不成功则待定时任务补偿
		for (JournalDetailVo detailVo : detailVos) {
			Integer status = detailVo.getStatus();
			if (DealDirectionEnum.isDecrease(detailVo.getDirection())) {
				if (!JournalDetailStatusEnum.isSuccess(status)) {
					return ;
				}
			}
		}
		// 所有明细都记账成功，更新记账主表
		updateJournalForSuccess(dealJournalVo);
	}
	
	// 所有明细都记账成功，更新记账主表
	private void updateJournalForSuccess(DealJournalVo dealJournalVo) {
		dealJournalVo.setStatus(DealStatusEnum.SUCC.getStatus());
		dealJournalVo.setTxnEndTime(new Date());
		dealJournalVo.setErrorCode(ReturnCodeEnum.SUCC.getCode());
		dealJournalVo.setErrorMessage(ReturnCodeEnum.SUCC.getMsg());
		journalRepository.update(dealJournalVo);
	}
	/**
	* @Description: 调用PE记账服务
	* @param detailVo
	* @return void
	* @throws
	 */
	private void callPeOrderService(JournalDetailVo detailVo) {
		String orderId = sequenceService.getFlowId();
		detailVo.setPeOrderId(orderId);
		detailVo.setStatus(JournalDetailStatusEnum.PROCESSING.getStatus());
		detailRepository.updateAfterPostingRule(detailVo);
		
		DealDto dealDto = DealJournalUtil.buildDealDto(detailVo,orderId);
		try {
			COSResponse peResponse = hessianOrderService.processOrderWithDeal(dealDto, true);
			LOG.info("processOrderWithDeal,orderId={},peResponse={}",orderId,JSON.toJSONString(peResponse));
			int cosActionStatus = peResponse.getCosActionStatus();
			detailVo.setStatus(JournalDetailStatusEnum.FAILID.getStatus());
			if (cosActionStatus == 1) {
				detailVo.setPeDealId(peResponse.getDealId());
				detailVo.setPeOrderSeqId(peResponse.getOrderSeqId());
				detailVo.setStatus(JournalDetailStatusEnum.SUCC.getStatus());
			}
		} catch (Exception e) {
			LOG.error("call PE failed,detailVo={}", detailVo, e);
			detailVo.setStatus(JournalDetailStatusEnum.PROCESSING.getStatus());
		}
		detailRepository.updateAfterPostingRule(detailVo);
	}
}
