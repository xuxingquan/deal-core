package com.bill99.base.account.deal.domain.repository;

import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.UPDATE_DEAL_FLOW_FAILED;
import static com.bill99.base.account.common.util.Validator.checkNotBlank;
import static com.bill99.base.account.common.util.Validator.checkNotNull;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.JournalDetailStatusEnum;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.common.util.WrappedBeanCopier;
import com.bill99.base.account.deal.domain.entity.DealJournal;
import com.bill99.base.account.deal.domain.entity.DealJournalExample;
import com.bill99.base.account.deal.domain.entity.DealJournalExample.Criteria;
import com.bill99.base.account.deal.domain.vo.DealJournalVo;
import com.bill99.base.account.deal.infrastructure.persistence.DealJournalMapper;
import com.google.common.base.Optional;

@Service
public class DealJournalRepository {
	private static final Logger LOG = LoggerFactory.getLogger(DealJournalRepository.class);
	@Autowired
	private DealJournalMapper journalMapper;
	/**
	 * @Description:新增交易流水记录
	 * @param accountDetailVo
	 * @return
	 */
	public DealJournalVo save(DealJournalVo dealJournalVo) {
		DealJournal dealJournal = WrappedBeanCopier.copyProperties(dealJournalVo, DealJournal.class);
		dealJournal.setVersion(Optional.fromNullable(dealJournalVo.getVersion()).or(0));
		Date dateNow = new Date();
		dealJournal.setRequestTime(Optional.fromNullable(dealJournal.getRequestTime()).or(dateNow));
		dealJournal.setCrtTime(Optional.fromNullable(dealJournal.getCrtTime()).or(dateNow));
		dealJournal.setUpdTime(Optional.fromNullable(dealJournal.getUpdTime()).or(dateNow));
		journalMapper.insertSelective(dealJournal);
		return WrappedBeanCopier.copyProperties(dealJournal, DealJournalVo.class);
	}

	/**
	 * @Description:
	 * @满足场景1:根据biz_Code+out_trade_no查询
	 * @满足场景2：根据biz_Code+orig_out_trade_no查询,冲正交易时查询
	 * @return
	 */
	public DealJournalVo queryByCondition(DealJournalVo dealJournalVo) {
		checkNotNull(dealJournalVo, "DealJournalVo cant be null");
		DealJournalExample example = new DealJournalExample();
		Criteria criteria = example.createCriteria();
		
		if (StringUtils.isNotBlank(dealJournalVo.getJournalId())) {
			criteria.andJournalIdEqualTo(dealJournalVo.getJournalId());
		}
		
		if (StringUtils.isNotBlank(dealJournalVo.getBizCode())) {
			criteria.andBizCodeEqualTo(dealJournalVo.getBizCode());
		}
		
		if (StringUtils.isNotBlank(dealJournalVo.getOutTradeNo())) {
			criteria.andOutTradeNoEqualTo(dealJournalVo.getOutTradeNo());
		}
		
		if (dealJournalVo.getDealType() != null) {
			criteria.andDealTypeEqualTo(dealJournalVo.getDealType());
		}
		
		if (StringUtils.isNotBlank(dealJournalVo.getOrderId())) {
			criteria.andOrderIdEqualTo(dealJournalVo.getOrderId());
		}
		
		if (StringUtils.isNotBlank(dealJournalVo.getOrigOutTradeNo())) {
			criteria.andOrigOutTradeNoEqualTo(dealJournalVo.getOrigOutTradeNo());
		}
		
		if (StringUtils.isNotBlank(dealJournalVo.getOrigJournalId())) {
			criteria.andOrigJournalIdEqualTo(dealJournalVo.getOrigJournalId());
		}
		
		List<DealJournal> dealJournalList = journalMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(dealJournalList)) {
			DealJournal DealJournal = CommonUtil.getUnique(dealJournalList);
			return WrappedBeanCopier.copyProperties(DealJournal, DealJournalVo.class);
		}
		return null;
	}

	/**
	 * @Description:根据条件，变更交易主表信息
	 * @param dealJournalVo
	 * @return
	 */
	public void update(DealJournalVo dealJournalVo) {
		checkNotNull(dealJournalVo, "DealJournalVo cant be null");
		String journalId = dealJournalVo.getJournalId();
		checkNotBlank(journalId,"DealJournalVo.journalId cant be blank");
		Integer version = dealJournalVo.getVersion();
		checkNotNull(version,"DealJournalVo.version cant be null");
		DealJournal dealJournal = WrappedBeanCopier.copyProperties(dealJournalVo, DealJournal.class);
		dealJournal.setUpdTime(new Date());
		dealJournal.setVersion(version+1);
		//更新条件
		DealJournalExample example = new DealJournalExample();
		Criteria criteria = example.createCriteria();
		criteria.andJournalIdEqualTo(journalId);
		criteria.andVersionEqualTo(version);
		//更新主表
		int result = journalMapper.updateByExampleSelective(dealJournal, example);
		LOG.info("update dealJournal,result={},journalId={}",result, journalId);
		//更新是否成功
		if (result <= 0) {
			LOG.error("updateDealJournal failed,DealJournalVo={}",dealJournalVo);
			ExceptionFactory.throwException(UPDATE_DEAL_FLOW_FAILED);
		}
		dealJournalVo.setVersion(version+1);
	}
	/**
	* @Description: 定时任务批量查询数据 
	* @param DealJournalVo
	* @return List<DealJournalVo>
	* @throws
	 */
	public List<DealJournalVo> queryForTimeTask() {
		DealJournalExample example = new DealJournalExample();
		Criteria criteria = example.createCriteria();
		DateTime dateTime = DateTime.now().minusHours(24);
		criteria.andCrtTimeGreaterThan(dateTime.toDate());
		criteria.andStatusNotEqualTo(JournalDetailStatusEnum.SUCC.getStatus());
		List<DealJournal> dealJournalList = journalMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(dealJournalList)) {
			return WrappedBeanCopier.copyPropertiesOfList(dealJournalList, DealJournalVo.class);
		}
		return null;
	}

}
