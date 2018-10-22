package com.bill99.base.account.deal.domain.service.flow;

import static com.bill99.base.account.common.util.Validator.checkNotNull;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bill99.base.account.common.enumeration.SubAcctTypeEnum;
import com.bill99.base.account.deal.domain.repository.DealDetailRepository;
import com.bill99.base.account.deal.domain.repository.DealFlowRepository;
import com.bill99.base.account.deal.domain.vo.DealDetailVo;
import com.bill99.base.account.deal.domain.vo.DealFlowVo;
import com.google.common.collect.Lists;
@Service
public class DealFlowService {
	@Autowired
	private DealFlowRepository dealFlowRepository;
	@Autowired
	private DealDetailRepository detailRepository;
	
	public DealFlowVo query(String outTradeNo, String orderId) {
		DealFlowVo condition = new DealFlowVo();
		condition.setOrderId(orderId);
		condition.setOutTradeNo(outTradeNo);
		return query(condition);
	}
	
	public DealFlowVo query(DealFlowVo condition) {
		checkNotNull(condition, "query DealFlowVo condition is null");
		DealFlowVo respVo = dealFlowRepository.queryByCondition(condition);
		if (respVo == null) {
			return null;
		}
		String flowId = respVo.getFlowId();
		List<DealDetailVo> detailVos = detailRepository.queryByFlowId(flowId);
		respVo.setDetailVos(detailVos);
		return respVo;
	}
	/**
	 * @Description:保存交易流水主表、分户流水表在同一个事务当中
	 * @param dealSummaryVo
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public DealFlowVo saveDealFlowAndDetail(DealFlowVo dealFlowVo) {
		List<DealDetailVo> detailVos = dealFlowVo.getDetailVos();
		//保存记账主表
		dealFlowVo = dealFlowRepository.save(dealFlowVo);
		//保存记账明细
		List<DealDetailVo> newDetailVos = Lists.newArrayList();
		if (CollectionUtils.isNotEmpty(detailVos)) {
			for (DealDetailVo dealDetailVo : detailVos) {
				newDetailVos.add(detailRepository.save(dealDetailVo));
			}
			dealFlowVo.setDetailVos(newDetailVos);
		}
		return dealFlowVo;
	}
	/**
	* @Description: 更新记账主表及明细表
	* @param dealFlowVo
	* @return void
	* @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateDealFlowAndDetail(DealFlowVo dealFlowVo) {
		if (dealFlowVo == null) return ;
		dealFlowRepository.update(dealFlowVo);
		List<DealDetailVo> detailVos = dealFlowVo.getDetailVos();
		if (CollectionUtils.isNotEmpty(detailVos)) {
			for (DealDetailVo detailVo : detailVos) {
				//对于非可提现账户记账明细表中AllowWithDrawAmount值归0
				if (!SubAcctTypeEnum.isWithDrawFund(detailVo.getSubAcctType())) {
					detailVo.setAllowWithDrawAmount(0l);
				}
				detailRepository.update(detailVo);
			}
		}
	}
}
