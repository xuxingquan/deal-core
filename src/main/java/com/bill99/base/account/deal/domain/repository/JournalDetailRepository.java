package com.bill99.base.account.deal.domain.repository;

import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.UPDATE_DEAL_DETAIL_FAILED;
import static com.bill99.base.account.common.util.Validator.checkNotBlank;
import static com.bill99.base.account.common.util.Validator.checkNotNull;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bill99.base.account.common.constant.Constant;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.common.util.WrappedBeanCopier;
import com.bill99.base.account.deal.domain.entity.JournalDetail;
import com.bill99.base.account.deal.domain.entity.JournalDetailExample;
import com.bill99.base.account.deal.domain.entity.JournalDetailExample.Criteria;
import com.bill99.base.account.deal.domain.vo.JournalDetailVo;
import com.bill99.base.account.deal.infrastructure.persistence.JournalDetailMapper;
import com.google.common.base.Optional;

@Service
public class JournalDetailRepository {
	private static final Logger LOG = LoggerFactory.getLogger(JournalDetailRepository.class);
	@Autowired
	private JournalDetailMapper journalDetailMapper;
	/**
	 * @Desccription:新增分户流水记录
	 * @param journalDetailVo
	 * @return
	 */
	public JournalDetailVo save(JournalDetailVo journalDetailVo) {
		JournalDetail detail = WrappedBeanCopier.copyProperties(journalDetailVo, JournalDetail.class);
		detail.setVersion(Optional.fromNullable(detail.getVersion()).or(0));
		detail.setCurrencyCode(Optional.fromNullable(detail.getCurrencyCode()).or(Constant.CURRENCY_CODE));
		String origJournalId = detail.getOrigJournalId();
		detail.setOrigJournalId(Optional.fromNullable(origJournalId).or(detail.getJournalId()));
		Date dateNow = new Date();
		detail.setRequestTime(Optional.fromNullable(detail.getRequestTime()).or(dateNow));
		detail.setCrtTime(Optional.fromNullable(detail.getCrtTime()).or(dateNow));
		detail.setUpdTime(Optional.fromNullable(detail.getUpdTime()).or(dateNow));
		journalDetailMapper.insertSelective(detail);
		return WrappedBeanCopier.copyProperties(detail, JournalDetailVo.class);
	}
	/**
	* @Description: 根据flowId查询明细
	* @param accountJournalDetailVo
	* @return int
	 */
	public List<JournalDetailVo> queryByJournalId(String journalId) {
		JournalDetailExample example = new JournalDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andJournalIdEqualTo(journalId);
		List<JournalDetail> detailList = journalDetailMapper.selectByExample(example);
		return WrappedBeanCopier.copyPropertiesOfList(detailList, JournalDetailVo.class);
	}
	/**
	 * @Description:变更明细
	 * @param detailVo
	 * @return
	 */
	public void update(JournalDetailVo detailVo) {
		
		checkNotNull(detailVo, "JournalDetailVo cant be null");
		String journalId = detailVo.getJournalId();
		checkNotBlank(journalId,"JournalDetailVo.journalId cant be blank");
		Long subId = detailVo.getSubId();
		checkNotNull(subId,"JournalDetailVo.subId cant be null");
		Integer version = detailVo.getVersion();
		checkNotNull(version,"JournalDetailVo.version cant be null");
		
		JournalDetail journalDetail = WrappedBeanCopier.copyProperties(detailVo, JournalDetail.class);
		journalDetail.setUpdTime(new Date());
		journalDetail.setVersion(version+1);
		//更新条件
		JournalDetailExample example = new JournalDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andJournalIdEqualTo(journalId);
		criteria.andSubIdEqualTo(subId);
		criteria.andVersionEqualTo(version);
		//更新明细
		int result = journalDetailMapper.updateByExampleSelective(journalDetail, example);
		LOG.info("updateJournalDetail,result={},subId={},journalId={}",result,subId,journalId);
		//更新是否成功
		if (result <= 0) {
			LOG.error("updateJournalDetail failed,detailVo={}",detailVo);
			ExceptionFactory.throwException(UPDATE_DEAL_DETAIL_FAILED);
		}
		detailVo.setVersion(version+1);
	}
	
	
	/**
	 * @Description:变更明细
	 * @param detailVo
	 * @return
	 */
	private void update(JournalDetail detail) {
		Integer version = detail.getVersion();
		detail.setUpdTime(new Date());
		detail.setVersion(version+1);
		Long subId = detail.getSubId();
		String journalId = detail.getJournalId();
		//更新条件
		JournalDetailExample example = new JournalDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andJournalIdEqualTo(journalId);
		criteria.andSubIdEqualTo(subId);
		criteria.andVersionEqualTo(version);
		//更新明细
		int result = journalDetailMapper.updateByExampleSelective(detail, example);
		LOG.info("updateJournalDetail,result={},subId={},journalId={}",result,subId,journalId);
		//更新是否成功
		if (result <= 0) {
			LOG.error("updateJournalDetail failed,detailVo={}",detail);
			ExceptionFactory.throwException(UPDATE_DEAL_DETAIL_FAILED);
		}
	}
	
	/**
	 * @Description:变更明细
	 * @param detailVo
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateAfterPostingRule(JournalDetailVo detailVo) {
		checkNotNull(detailVo, "JournalDetailVo cant be null");
		String journalId = detailVo.getJournalId();
		checkNotBlank(journalId,"JournalDetailVo.journalId cant be blank");
		Long subId = detailVo.getSubId();
		checkNotNull(subId,"JournalDetailVo.subId cant be null");
		Integer seq = detailVo.getSeq();
		checkNotNull(seq,"JournalDetailVo.version cant be null");
		
		JournalDetailExample example = new JournalDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andJournalIdEqualTo(journalId);
		criteria.andSeqEqualTo(seq);
		List<JournalDetail> detailList = journalDetailMapper.selectByExample(example);
		for (JournalDetail journalDetail : detailList) {
			journalDetail.setPeDealId(detailVo.getPeDealId());
			journalDetail.setPeOrderSeqId(detailVo.getPeOrderSeqId());
			journalDetail.setStatus(detailVo.getStatus());
			journalDetail.setPeOrderId(detailVo.getPeOrderId());
			update(journalDetail);
		}
	}
}
