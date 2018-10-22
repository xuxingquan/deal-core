package com.bill99.base.account.deal.domain.service.flow;

import static com.bill99.base.account.common.constant.Constant.UNDER_LINE;
import static com.bill99.base.account.common.util.Validator.checkNotNull;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bill99.base.account.common.constant.Constant;
import com.bill99.base.account.common.enumeration.BalanceByEnum;
import com.bill99.base.account.common.enumeration.DealDirectionEnum;
import com.bill99.base.account.common.enumeration.DealStatusEnum;
import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.enumeration.SubAcctTypeEnum;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.common.util.DealContext;
import com.bill99.base.account.common.util.DealContextHelper;
import com.bill99.base.account.deal.domain.cache.MemberInfoCache;
import com.bill99.base.account.deal.domain.cache.SubAccountCache;
import com.bill99.base.account.deal.domain.repository.DealFlowRepository;
import com.bill99.base.account.deal.domain.repository.SubAcctBalanceRepository;
import com.bill99.base.account.deal.domain.service.acct.MemberInfoService;
import com.bill99.base.account.deal.domain.service.acct.SubAccountService;
import com.bill99.base.account.deal.domain.vo.DealDetailVo;
import com.bill99.base.account.deal.domain.vo.DealFlowVo;
import com.bill99.base.account.deal.domain.vo.MemberInfoVo;
import com.bill99.base.account.deal.domain.vo.SubAccountVo;
import com.bill99.base.account.deal.domain.vo.SubAcctBalanceVo;
import com.google.common.base.Optional;
import com.google.common.collect.Sets;

@Service
public class DealCoreService {
	private static final Logger LOG = LoggerFactory.getLogger(DealCoreService.class);
	@Autowired
	private DealFlowRepository dealFlowRepository;
	@Autowired
	private SubAcctBalanceRepository balanceRepository;
	@Autowired
	private SubAccountService subAccountService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private DealFlowService dealFlowService;
	@Autowired
	@Qualifier("subAccountCache")
	private SubAccountCache subAccountCache;
	@Autowired
	@Qualifier("memberInfoCache")
	private MemberInfoCache memberInfoCache;
	/**
	 * @Description: 冲正变更余额
	 * @param
	 * @return void
	 * @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void changeBalanceForReverse(DealFlowVo reverseFlowVo,DealFlowVo orignFlowVo) {
		// 变更余额
		changeBalance(reverseFlowVo);
		// 更新原记账表信息
		orignFlowVo.setIsReverse(1);
		dealFlowRepository.update(orignFlowVo);
		// 更新冲正记账表信息
		updateDealForSuccess(reverseFlowVo);
	}
	/**
	 * @Description: 变更余额
	 * @param
	 * @return void
	 * @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateDealAndBalance(DealFlowVo dealFlowVo) {
		// 校验及变更余额
		changeBalance_New(dealFlowVo);
		// 更新记账表信息 暂时放外面，减少该核心事物等待时间
//		updateDealForSuccess(dealFlowVo);
	}
	
	/**
	 * @Description:分户余额信息变更，当为多个分户时，要保证多个分户变更的一致性。
	 * 变更余额金额<br>
	 * 规则: <br>
	 * 1.借记类科目，如果为收款方(DealDirection.INCREASE)，借记余额+;如果为付款方，贷记余额+；<br/>
	 * 2.贷记类科目，如果为收款方(DealDirection.INCREASE)，贷记余额+，如果为付款方，借记余额+；
	 * @param list
	 */
	private void changeBalance_New(DealFlowVo dealFlowVo) {
		List<DealDetailVo> detailVos = dealFlowVo.getDetailVos();
		Collections.sort(detailVos);//收款账户先执行变更，保证成功率
		SubAcctBalanceVo balanceVo = null;
		// 余额变更信息列表。信息包含: 待变更的账户号、余额发生额、借方发生额、贷方发生额等
		for (DealDetailVo detailVo : detailVos) {
			balanceVo = detailVo.getSubAcctBalanceVo();
			//余额变更
			setSubAcctBalance_New(detailVo, balanceVo);
			//执行变更
			balanceRepository.update_New(balanceVo);
			//校验金额  更改之后再校验
			checkSubAcctBalance(detailVo);
			//设置变更后余额
			detailVo.setPostdealBalance(balanceVo.getSubAcctBalance());
		}
	}

	/**
	 * @Description:分户余额信息变更，当为多个分户时，要保证多个分户变更的一致性。
	 * 变更余额金额<br>
	 * 规则: <br>
	 * 1.借记类科目，如果为收款方(DealDirection.INCREASE)，借记余额+;如果为付款方，贷记余额+；<br/>
	 * 2.贷记类科目，如果为收款方(DealDirection.INCREASE)，贷记余额+，如果为付款方，借记余额+；
	 * @param list
	 */
	private void changeBalance(DealFlowVo dealFlowVo) {
		List<DealDetailVo> detailVos = dealFlowVo.getDetailVos();
		Collections.sort(detailVos);//收款账户先执行变更，保证成功率
		SubAcctBalanceVo balanceVo = null;
		Set<SubAcctBalanceVo> balanceVos = Sets.newTreeSet();
		// 余额变更信息列表。信息包含: 待变更的账户号、余额发生额、借方发生额、贷方发生额等
		for (DealDetailVo detailVo : detailVos) {
			balanceVo = detailVo.getSubAcctBalanceVo();
			balanceVos.add(balanceVo);
			//余额变更
			setSubAcctBalance(detailVo, balanceVo);
			//校验金额  更改之后再校验
			checkSubAcctBalance(detailVo);
			//设置变更后余额
			detailVo.setPostdealBalance(balanceVo.getSubAcctBalance());
		}
		//合并同一个账户的多次变更，可减少与数据库的交互次数
		for (SubAcctBalanceVo subAcctBalanceVo : balanceVos) {
			balanceRepository.update(subAcctBalanceVo);//执行变更
		}
	}
	/**
	* @Description: 变更金额 
	* @param detailVo
	* @param direction
	* @param balanceVo
	* @return void
	* @throws
	 */
	private void setSubAcctBalance(DealDetailVo detailVo,SubAcctBalanceVo balanceVo) {
		SubAccountVo subAccountVo = detailVo.getSubAccountVo();
		Long balanceDelta = 0L;//分账户余额
		Long debitBalanceDelta = 0L;//借方余额
		Long creditBalanceDelta = 0l;//贷方余额
		Long amount = detailVo.getAmount();//变更金额
		Integer direction = detailVo.getDirection();//收付方向
		String subAcctBalanceby = subAccountVo.getSubAcctBalanceby();//分账户方向
		/**
		 * 1.借记类科目，如果为收款方(DealDirection.INCREASE)，借记余额+;如果为付款方，贷记余额+
		 * 2.贷记类科目，如果为收款方(DealDirection.INCREASE)，贷记余额+，如果为付款方，借记余额+
		 */
		if ((BalanceByEnum.isDebit(subAcctBalanceby) && DealDirectionEnum.isDecrease(direction))
				|| (BalanceByEnum.isCredit(subAcctBalanceby) && DealDirectionEnum.isIncrease(direction))) {
			debitBalanceDelta = amount;
		} else {
			creditBalanceDelta = amount;
		}
		
		boolean isIncrease = DealDirectionEnum.isIncrease(direction);//是否收款方
		balanceDelta = isIncrease ? amount : -amount;
		balanceVo.setSubAcctBalance(balanceVo.getSubAcctBalance()+balanceDelta);
		balanceVo.setCreditbalance(balanceVo.getCreditbalance()+creditBalanceDelta);
		balanceVo.setDebitbalance(balanceVo.getDebitbalance()+debitBalanceDelta);
		//设置分账户余额表可提现金额条件:余额类型为可提现账户且请求参数中的可提现变更金额大于0
		Long allowWithDrawAmount = Optional.fromNullable(detailVo.getAllowWithDrawAmount()).or(0l);
		if (allowWithDrawAmount > 0 && SubAcctTypeEnum.isWithDrawFund(subAccountVo.getSubAcctType())) {
			allowWithDrawAmount = isIncrease ? allowWithDrawAmount : -allowWithDrawAmount;
			Long allowWithdrawBalance = balanceVo.getAllowWithdrawBalance();
			balanceVo.setAllowWithdrawBalance(allowWithdrawBalance+allowWithDrawAmount);
		}
	}
	
	
	/**
	* @Description: 新增变更金额 
	 */
	private void setSubAcctBalance_New(DealDetailVo detailVo,SubAcctBalanceVo balanceVo) {
		SubAccountVo subAccountVo = detailVo.getSubAccountVo();
		Long balanceDelta = 0L;//分账户余额
		Long debitBalanceDelta = 0L;//借方余额
		Long creditBalanceDelta = 0l;//贷方余额
		Long amount = detailVo.getAmount();//变更金额
		
		Integer direction = detailVo.getDirection();//收付方向
		String subAcctBalanceby = subAccountVo.getSubAcctBalanceby();//分账户方向
		/**
		 * 1.借记类科目，如果为收款方(DealDirection.INCREASE)，借记余额+;如果为付款方，贷记余额+
		 * 2.贷记类科目，如果为收款方(DealDirection.INCREASE)，贷记余额+，如果为付款方，借记余额+
		 */
		if ((BalanceByEnum.isDebit(subAcctBalanceby) && DealDirectionEnum.isDecrease(direction))
				|| (BalanceByEnum.isCredit(subAcctBalanceby) && DealDirectionEnum.isIncrease(direction))) {
			debitBalanceDelta = amount;
		} else {
			creditBalanceDelta = amount;
		}
		
		boolean isIncrease = DealDirectionEnum.isIncrease(direction);//是否收款方
		balanceDelta = isIncrease ? amount : -amount;
		balanceVo.setSubAcctBalance(balanceDelta);
		balanceVo.setCreditbalance(creditBalanceDelta);
		balanceVo.setDebitbalance(debitBalanceDelta);
		
		//设置分账户余额表可提现金额条件:余额类型为可提现账户且请求参数中的可提现变更金额大于0
		Long allowWithDrawAmount = Optional.fromNullable(detailVo.getAllowWithDrawAmount()).or(0l);
		balanceVo.setAllowWithdrawBalance(allowWithDrawAmount);
		if (allowWithDrawAmount > 0 && SubAcctTypeEnum.isWithDrawFund(subAccountVo.getSubAcctType())) {
			allowWithDrawAmount = isIncrease ? allowWithDrawAmount : -allowWithDrawAmount;
			balanceVo.setAllowWithdrawBalance(allowWithDrawAmount);
		}
	}
	
	/**
	* @Description: 校验账户余额 
	* @param detailVo
	* @return void
	* @throws
	 */
	private void checkSubAcctBalance(DealDetailVo detailVo) {
		SubAccountVo subAccountVo = detailVo.getSubAccountVo();
		SubAcctBalanceVo balanceVo = detailVo.getSubAcctBalanceVo();
		Long subAcctBalance = balanceVo.getSubAcctBalance();//账户余额
		Long allowWithdrawBalance = balanceVo.getAllowWithdrawBalance();//可提现余额
		Long frozenbalance = balanceVo.getFrozenbalance();
		//是否允许透支
		String subAcctAllowOverdraft = subAccountVo.getSubAcctAllowOverdraft();
		if (Constant.ZERO.equals(subAcctAllowOverdraft)) {
			Long avaliable = subAcctBalance - frozenbalance;
			//余额不能小于0
			if (subAcctBalance < 0 || allowWithdrawBalance < 0 || avaliable < 0) {
				LOG.error("subAcctBalance or allowWithdrawBalance or avaliableBalance less than 0,balanceVo={}",balanceVo);
				ExceptionFactory.throwException(ReturnCodeEnum.BALANCE_NOT_ENOUGH);
			}
		}
		//可提现金额校验：余额类型为可提现账户且可提现金额要小于余额
		if (subAcctBalance < allowWithdrawBalance && SubAcctTypeEnum.isWithDrawFund(subAccountVo.getSubAcctType())) {
			LOG.error("allowWithdrawBalance greater than subAcctBalance,balanceVo={}",balanceVo);
			ExceptionFactory.throwException(ReturnCodeEnum.ALLOW_WITHDRAW_BALANCE_ERROR);
		}
	}
	/**
	 * @Description: 冲正成功后更新记账主表与明细表
	 * @param reverseSummaryVo
	 * @param orignFlowVo
	 * @return void
	 * @throws
	 */
	public  void updateDealForSuccess(DealFlowVo dealFlowVo) {
		dealFlowVo.setStatus(DealStatusEnum.SUCC.getStatus());
		dealFlowVo.setTxnEndTime(new Date());
		dealFlowVo.setErrorCode(ReturnCodeEnum.SUCC.getCode());
		dealFlowVo.setErrorMessage(ReturnCodeEnum.SUCC.getMsg());
		dealFlowService.updateDealFlowAndDetail(dealFlowVo);
	}
	/**
	* @Description: 查询并设置账户信息
	* @param reverseSummaryVo
	* @return void
	* @throws
	 */
	public void queryAndSetSubAcct(DealFlowVo dealFlowVo) {
		DealContextHelper.removeThreadLoacal();//先删除缓存
		List<DealDetailVo> dealDetailVos = dealFlowVo.getDetailVos();
		SubAccountVo accountVo = null;
		SubAcctBalanceVo subAcctBalanceVo = null;
		for (DealDetailVo detailVo : dealDetailVos) {
			//查询分账户
			accountVo = querySubAccountVo(detailVo);
			//查询分账户余额对象
			subAcctBalanceVo = queryBalanceVo(accountVo.getSubAcctId());
			//dealDetailVo设置分账户与分账户余额对象
			detailVo.setSubAccountVo(accountVo);
			detailVo.setSubAcctBalanceVo(subAcctBalanceVo);
			detailVo.setSubAcctSubjectCode(accountVo.getSubAcctId());
			detailVo.setSubAcctType(accountVo.getSubAcctType());
		}
	}
	/**
	* @Description: 查询余额表
	* @param  subAcctId
	* @return SubAcctBalanceVo
	* @throws
	 */
	private SubAcctBalanceVo queryBalanceVo(String subAcctId) {
		SubAcctBalanceVo subAcctBalanceVo;
		//先从Context查找
		DealContext context = DealContextHelper.getDealContext();
		subAcctBalanceVo = context.getVarValue(subAcctId, SubAcctBalanceVo.class);
		if (subAcctBalanceVo == null) {
			//查询数据库
			subAcctBalanceVo = balanceRepository.queryById(subAcctId);
			context.setVariables(subAcctId, subAcctBalanceVo);
		}
		
		if (subAcctBalanceVo == null) {
			LOG.error("subAcctBalanceVo not exist,subacctId={}",subAcctId);
			ExceptionFactory.throwException(ReturnCodeEnum.ACCT_NOT_EXIST);
		}
		
		return subAcctBalanceVo;
	}
	
	/**
	* @Description: 查询子账户 
	* @param dealDetailVo
	* @return SubAccountVo
	* @throws
	 */
	private SubAccountVo querySubAccountVo(DealDetailVo dealDetailVo) {
		String memberCode = CommonUtil.toString(dealDetailVo.getMemberCode());
		String subAcctType = dealDetailVo.getSubAcctType();
		String subAcctSubjectCode = dealDetailVo.getSubAcctSubjectCode();
		//组装查询key
		String key = subAcctSubjectCode;
		if (!StringUtils.isAnyBlank(memberCode,subAcctType)) {
			key = StringUtils.join(memberCode,UNDER_LINE,subAcctType);
		}
		
		SubAccountVo subAccountVo = subAccountCache.getValue(key);
		if (subAccountVo.getSubAcctId() == null) {
			LOG.error("SubAccount not exist,key={}",key);
			ExceptionFactory.throwException(ReturnCodeEnum.ACCT_NOT_EXIST);
		}
		
		return subAccountVo;
	}
	/**
	* @Description: 校验账户状态（冻结、注销/止入止出、余额） 
	* @param @param reverseSummaryVo
	* @return void
	* @throws
	 */
	public void checkAccount(DealFlowVo dealFlowVo) {
		List<DealDetailVo> dealDetailVos = dealFlowVo.getDetailVos();
		SubAccountVo subAccountVo = null;
		for (DealDetailVo dealDetailVo : dealDetailVos) {
			subAccountVo = dealDetailVo.getSubAccountVo();
			Integer direction = dealDetailVo.getDirection();
			subAccountService.checkAccount(subAccountVo,direction);
		}
	}
	/**
	* @Description: 校验会员是否存在、状态是否正常
	* @param dealFlowVo
	* @return void
	* @throws
	 */
	public void checkMemberInfo(DealFlowVo dealFlowVo) {
		List<DealDetailVo> listVos = dealFlowVo.getDetailVos();
		MemberInfoVo memberInfo = null;
		for (DealDetailVo dealDetailVo : listVos) {
			Long memberCode = dealDetailVo.getMemberCode();
			memberInfo = memberInfoCache.getValue(memberCode);
			checkNotNull(memberInfo.getId(), StringUtils.join("memberCode=",memberCode,"not exist"));
			memberInfoService.checkMemberInfo(memberInfo);
		}
	}
}
