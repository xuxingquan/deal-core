package com.bill99.base.account.deal.domain.repository;

import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.UPDATE_DEAL_FLOW_FAILED;
import static com.bill99.base.account.common.util.Validator.checkNotBlank;
import static com.bill99.base.account.common.util.Validator.checkNotNull;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.common.util.WrappedBeanCopier;
import com.bill99.base.account.deal.domain.entity.DealFlow;
import com.bill99.base.account.deal.domain.entity.DealFlowExample;
import com.bill99.base.account.deal.domain.entity.DealFlowExample.Criteria;
import com.bill99.base.account.deal.domain.vo.DealFlowVo;
import com.bill99.base.account.deal.infrastructure.persistence.DealFlowMapper;
import com.google.common.base.Optional;
@Service
public class DealFlowRepository {
	private static final Logger LOG = LoggerFactory.getLogger(DealFlowRepository.class);
	@Autowired
	private DealFlowMapper dealFlowMapper;
	/**
	 * @Description:新增交易流水记录
	 * @param accountDetailVo
	 * @return
	 */
	public DealFlowVo save(DealFlowVo dealFlowVo) {
		DealFlow dealFlow = WrappedBeanCopier.copyProperties(dealFlowVo, DealFlow.class);
		dealFlow.setVersion(0);
		Date dateNow = new Date();
		dealFlow.setRequestTime(Optional.fromNullable(dealFlow.getRequestTime()).or(dateNow));
		dealFlow.setCrtTime(Optional.fromNullable(dealFlow.getCrtTime()).or(dateNow));
		dealFlow.setUpdTime(Optional.fromNullable(dealFlow.getUpdTime()).or(dateNow));
		dealFlowMapper.insertSelective(dealFlow);
		return WrappedBeanCopier.copyProperties(dealFlow, DealFlowVo.class);
	}

	/**
	 * @Description:
	 * @满足场景1:根据biz_Code+out_trade_no查询
	 * @满足场景2：根据biz_Code+orig_out_trade_no查询,冲正交易时查询
	 * @return
	 */
	public DealFlowVo queryByCondition(DealFlowVo dealFlowVo) {
		checkNotNull(dealFlowVo, "DealFlowVo cant be null");
		DealFlowExample example = new DealFlowExample();
		Criteria criteria = example.createCriteria();
		
		if (StringUtils.isNotBlank(dealFlowVo.getFlowId())) {
			criteria.andFlowIdEqualTo(dealFlowVo.getFlowId());
		}
		
		if (StringUtils.isNotBlank(dealFlowVo.getBizCode())) {
			criteria.andBizCodeEqualTo(dealFlowVo.getBizCode());
		}
		
		if (StringUtils.isNotBlank(dealFlowVo.getOutTradeNo())) {
			criteria.andOutTradeNoEqualTo(dealFlowVo.getOutTradeNo());
		}
		
		if (dealFlowVo.getDealType() != null) {
			criteria.andDealTypeEqualTo(dealFlowVo.getDealType());
		}
		
		if (StringUtils.isNotBlank(dealFlowVo.getOrderId())) {
			criteria.andOrderIdEqualTo(dealFlowVo.getOrderId());
		}
		
		if (StringUtils.isNotBlank(dealFlowVo.getOrigOutTradeNo())) {
			criteria.andOrigOutTradeNoEqualTo(dealFlowVo.getOrigOutTradeNo());
		}
		
		if (StringUtils.isNotBlank(dealFlowVo.getOrigFlowId())) {
			criteria.andOrigFlowIdEqualTo(dealFlowVo.getOrigFlowId());
		}
		
		List<DealFlow> dealFlowList = dealFlowMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(dealFlowList)) {
			DealFlow dealFlow = CommonUtil.getUnique(dealFlowList);
			return WrappedBeanCopier.copyProperties(dealFlow, DealFlowVo.class);
		}
		return null;
	}

	/**
	 * @Description:根据条件，变更交易主表信息
	 * @param dealFlowVo
	 * @return
	 */
	public void update(DealFlowVo dealFlowVo) {
		checkNotNull(dealFlowVo, "DealFlowVo cant be null");
		String flowId = dealFlowVo.getFlowId();
		checkNotBlank(flowId,"DealFlowVo.flowId cant be blank");
		Integer version = dealFlowVo.getVersion();
		checkNotNull(version,"DealFlowVo.version cant be null");
		DealFlow dealFlow = WrappedBeanCopier.copyProperties(dealFlowVo, DealFlow.class);
		dealFlow.setUpdTime(new Date());
		dealFlow.setVersion(version+1);
		//更新条件
		DealFlowExample example = new DealFlowExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlowIdEqualTo(flowId);
		criteria.andVersionEqualTo(version);
		//更新主表
		int result = dealFlowMapper.updateByExampleSelective(dealFlow, example);
		LOG.info("update Deal,result={},flowId={}",result, flowId);
		//更新是否成功
		if (result <= 0) {
			LOG.error("updateDealFlow failed,dealFlowVo={}",dealFlowVo);
			ExceptionFactory.throwException(UPDATE_DEAL_FLOW_FAILED);
		}
		dealFlowVo.setVersion(version+1);
	}
}
