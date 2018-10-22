package com.bill99.base.account.deal.domain.service.journal;

import static com.bill99.base.account.common.util.Validator.checkNotNull;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bill99.base.account.deal.domain.repository.DealJournalRepository;
import com.bill99.base.account.deal.domain.repository.JournalDetailRepository;
import com.bill99.base.account.deal.domain.vo.DealJournalVo;
import com.bill99.base.account.deal.domain.vo.JournalDetailVo;
import com.google.common.collect.Lists;
@Service
public class JournalService {
	@Autowired
	private DealJournalRepository journalRepository;
	@Autowired
	private JournalDetailRepository detailRepository;
	
	public DealJournalVo query(String outTradeNo, String orderId) {
		DealJournalVo condition = new DealJournalVo();
		condition.setOrderId(orderId);
		condition.setOutTradeNo(outTradeNo);
		return query(condition);
	}
	
	public DealJournalVo query(DealJournalVo condition) {
		checkNotNull(condition, "query DealJournalVo condition is null");
		DealJournalVo respVo = journalRepository.queryByCondition(condition);
		if (respVo == null) {
			return null;
		}
		String journalId = respVo.getJournalId();
		List<JournalDetailVo> detailVos = detailRepository.queryByJournalId(journalId);
		respVo.setDetailVos(detailVos);;
		return respVo;
	}
	/**
	 * @Description:保存交易流水主表、分户流水表在同一个事务当中
	 * @param dealSummaryVo
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public DealJournalVo saveJournalAndDetail(DealJournalVo dealJournalVo) {
		List<JournalDetailVo> detailVos = dealJournalVo.getDetailVos();
		//保存记账主表
		dealJournalVo = journalRepository.save(dealJournalVo);
		//保存记账明细
		List<JournalDetailVo> newDetailVos = Lists.newArrayList();
		if (CollectionUtils.isNotEmpty(detailVos)) {
			for (JournalDetailVo JournalDetailVo : detailVos) {
				newDetailVos.add(detailRepository.save(JournalDetailVo));
			}
			dealJournalVo.setDetailVos(newDetailVos);
		}
		return dealJournalVo;	
	}
	/**
	* @Description: 更新记账主表及明细表
	* @param DealJournalVo
	* @return void
	* @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateJournalAndDetail(DealJournalVo dealJournalVo) {
		if (dealJournalVo == null) return ;
		journalRepository.update(dealJournalVo);
		List<JournalDetailVo> detailVos = dealJournalVo.getDetailVos();
		if (CollectionUtils.isNotEmpty(detailVos)) {
			for (JournalDetailVo detailVo : detailVos) {
				detailRepository.update(detailVo);
			}
		}
	}
}
