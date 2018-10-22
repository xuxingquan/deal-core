package com.bill99.base.account.deal.domain.service.journal;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.DealStatusEnum;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.deal.application.request.ChargeRequest;
import com.bill99.base.account.deal.application.response.ChargeResponse;
import com.bill99.base.account.deal.domain.repository.DealJournalRepository;
import com.bill99.base.account.deal.domain.repository.JournalDetailRepository;
import com.bill99.base.account.deal.domain.service.DealSequenceService;
import com.bill99.base.account.deal.domain.util.DealJournalUtil;
import com.bill99.base.account.deal.domain.vo.DealJournalVo;
import com.bill99.base.account.deal.domain.vo.JournalDetailVo;
import com.bill99.mam.application.MamRequest;
/**
 * PE记账
 * @author jerry.xu.coc
 */
@Service
public class ChargeService {
	private static final Logger LOG = LoggerFactory.getLogger(ChargeService.class);
	@Autowired
	private JournalService journalService;
	@Autowired
	private DealJournalRepository JournalRepository;
	@Autowired
	private JournalDetailRepository JournalDetailRepository;
	@Autowired
	private DealSequenceService sequenceService;
	@Autowired
	private JournalCoreService journalCoreService;
	/**
	* @Description: PE记账
	* @param request
	* @param response
	* @return void
	* @throws
	 */
	public ChargeResponse charge(ChargeRequest request){
		ChargeResponse response = new ChargeResponse();
		DealJournalVo dealJournalVo = queryOrSaveJournalAndDetail(request);
		if (DealStatusEnum.isProcessing(dealJournalVo.getStatus())) {
			journalCoreService.asyncCharge(dealJournalVo);
		}
		return buildResponse(dealJournalVo,response);
	}
	/**
	* @Description: 查询记账记录，不存在则保存新记录
	* @param request
	* @return DealJournalVo
	* @throws
	 */
	private DealJournalVo queryOrSaveJournalAndDetail(ChargeRequest request) {
		String bizCode = request.getBizCode();
		String outTradeNo = request.getOutTradeNo();
		DealJournalVo condition = new DealJournalVo();
		condition.setBizCode(bizCode);
		condition.setOutTradeNo(outTradeNo);
		DealJournalVo dealJournalVo = journalService.query(condition);
		if (dealJournalVo == null) {//不存在则保存新记录
			String flowId = sequenceService.getFlowId();
			DealJournalVo flowVo = DealJournalUtil.buildJournalVo(request, flowId);
			dealJournalVo = journalService.saveJournalAndDetail(flowVo);
		}
		return dealJournalVo;
	}
	/**
	* @Description: 交易返回
	* @param dealFlowVo
	* @param response
	* @return ChangeBalanceResponse
	 */
	private ChargeResponse buildResponse(DealJournalVo dealFlowVo,ChargeResponse response) {
		response.setDealId(dealFlowVo.getJournalId());
		response.setStatus(dealFlowVo.getStatus().toString());
		return response;
	}
	/**
	* @Description: 定时任务调用PE记账 
	* @param request
	* @return void
	* @throws
	 */
	public void chargeForTask(MamRequest request) {
		LOG.info("chargeForTask start");
		List<JournalDetailVo> detailVos = null;
		List<DealJournalVo> journalVos = JournalRepository.queryForTimeTask();
		LOG.info("queryForTimeTask result size={}",CommonUtil.size(journalVos));
		if (CollectionUtils.isNotEmpty(journalVos)) {
			for (DealJournalVo journalVo : journalVos) {
				String journalId = journalVo.getJournalId();
				LOG.info("compensateTask,journalId={}",journalId);
				try {
					detailVos = JournalDetailRepository.queryByJournalId(journalId);
					journalVo.setDetailVos(detailVos);
					journalCoreService.syncCharge(journalVo);
				} catch (Exception e) {
					LOG.info("chargeForTask occur exception,journalId={}",journalId,e);
				}
			}
		}
	}
}
