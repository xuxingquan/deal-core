package com.bill99.base.account.deal.domain.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.common.util.DateUtil;
import com.bill99.inf.bdal.sequence.combination.impl.SequenceResult;
import com.bill99.inf.bdal.sequence.mycat.MycatSequence;
@Service
public class DealSequenceService {
	private static final Logger LOG = LoggerFactory.getLogger(DealSequenceService.class);
	@Autowired
	private MycatSequence dealFlowSequence;
	private static final String SEQUENCE_NAME = "BASE_ACCOUNT_DEAL_FLOW_SEQUENCE";
	private static final String SEQUENCE_RULE = "AccountDealFlowSequenceRule";
	private static final String DATE_PATTERN = "yyyyMMddHHmmss";
	/**
	 * @Description:FLOW_ID生成规则，由时间戳+10位的sequence值
	 * @return
	 */
	public String getFlowId() {
		StringBuilder sb = new StringBuilder();
		SequenceResult sequenceResult = null;
		try {
			sequenceResult = dealFlowSequence.getNextValue(SEQUENCE_NAME, SEQUENCE_RULE, "1");
			String seqValue = sequenceResult.getSequenceValue();
			String dateTime = DateUtil.format(new Date(), DATE_PATTERN);
			sb.append(dateTime).append(seqValue);
		} catch (Exception e) {
			LOG.error("getFlowId error",e);
			ExceptionFactory.throwException(ReturnCodeEnum.GET_FLOW_ID_ERROR);
		}
		return sb.toString();
	}
}
