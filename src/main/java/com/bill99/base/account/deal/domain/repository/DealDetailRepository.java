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

import com.bill99.base.account.common.constant.Constant;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.common.util.WrappedBeanCopier;
import com.bill99.base.account.deal.domain.entity.DealDetail;
import com.bill99.base.account.deal.domain.entity.DealDetailExample;
import com.bill99.base.account.deal.domain.entity.DealDetailExample.Criteria;
import com.bill99.base.account.deal.domain.vo.DealDetailVo;
import com.bill99.base.account.deal.infrastructure.persistence.DealDetailMapper;
import com.google.common.base.Optional;
@Service
public class DealDetailRepository {
	private static final Logger LOG = LoggerFactory.getLogger(DealDetailRepository.class);
	@Autowired
	private DealDetailMapper dealDetailMapper;
	/**
	 * @Desccription:新增分户流水记录
	 * @param dealDetailVo
	 * @return
	 */
	public DealDetailVo save(DealDetailVo dealDetailVo) {
		DealDetail detail = WrappedBeanCopier.copyProperties(dealDetailVo, DealDetail.class);
		detail.setVersion(0);
		detail.setCurrencyCode(Optional.fromNullable(detail.getCurrencyCode()).or(Constant.CURRENCY_CODE));
		String origFlowId = detail.getOrigFlowId();
		detail.setOrigFlowId(Optional.fromNullable(origFlowId).or(detail.getFlowId()));
		Date dateNow = new Date();
		detail.setRequestTime(Optional.fromNullable(detail.getRequestTime()).or(dateNow));
		detail.setCrtTime(Optional.fromNullable(detail.getCrtTime()).or(dateNow));
		detail.setUpdTime(Optional.fromNullable(detail.getUpdTime()).or(dateNow));
		dealDetailMapper.insertSelective(detail);
		return WrappedBeanCopier.copyProperties(detail, DealDetailVo.class);
	}
	/**
	* @Description: 根据flowId查询明细
	* @param accountDealDetailVo
	* @return int
	 */
	public List<DealDetailVo> queryByFlowId(String flowId) {
		DealDetailExample example = new DealDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlowIdEqualTo(flowId);
		List<DealDetail> detailList = dealDetailMapper.selectByExample(example);
		return WrappedBeanCopier.copyPropertiesOfList(detailList, DealDetailVo.class);
	}
	/**
	 * @Description:变更明细
	 * @param detailVo
	 * @return
	 */
	public void update(DealDetailVo detailVo) {
		
		checkNotNull(detailVo, "DealDetailVo cant be null");
		String flowId = detailVo.getFlowId();
		checkNotBlank(flowId,"DealDetailVo.flowId cant be blank");
		Long subId = detailVo.getSubId();
		checkNotNull(subId,"DealDetailVo.subId cant be null");
		Integer version = detailVo.getVersion();
		checkNotNull(version,"DealDetailVo.version cant be null");
		
		DealDetail dealDetail = WrappedBeanCopier.copyProperties(detailVo, DealDetail.class);
		dealDetail.setUpdTime(new Date());
		dealDetail.setVersion(version+1);
		//更新条件
		DealDetailExample example = new DealDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlowIdEqualTo(flowId);
		criteria.andSubIdEqualTo(subId);
		criteria.andVersionEqualTo(version);
		//更新明细
		int result = dealDetailMapper.updateByExampleSelective(dealDetail, example);
		LOG.info("updateDealDetail,result={},subId={},flowId={}",result,subId,flowId);
		//更新是否成功
		if (result <= 0) {
			LOG.error("updateDealDetail failed,detailVo={}",detailVo);
			ExceptionFactory.throwException(UPDATE_DEAL_DETAIL_FAILED);
		}
		detailVo.setVersion(version+1);
	}
}
