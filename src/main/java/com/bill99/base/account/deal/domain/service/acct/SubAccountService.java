package com.bill99.base.account.deal.domain.service.acct;

import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.ACCT_FORBID_IN;
import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.ACCT_FORBID_OUT;
import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.ACCT_FROZEN;
import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.ACCT_STATUS_ERROR;
import static com.bill99.base.account.common.util.Validator.checkNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.constant.Constant;
import com.bill99.base.account.common.enumeration.DealDirectionEnum;
import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.deal.domain.vo.SubAccountVo;

@Service
public class SubAccountService {
	private static final Logger LOG = LoggerFactory.getLogger(SubAccountService.class);
	/**
	* @Description: 校验账户状态（冻结、注销/止入止出） 
	* @param reverseSummaryVo
	* @return void
	* @throws
	 */
	public void checkAccount(SubAccountVo subAccountVo,Integer direction) {
		checkNotNull(subAccountVo, "checkAccount subAccountVo is null");
		//校验账户状态与冻结状态
		String status = subAccountVo.getStatus();//账户状态  0-失效;1-正常;2-冻结
		checkArgument(isStatusOn(status),"illegal status",subAccountVo,ACCT_STATUS_ERROR);
		String subAcctFrozen = subAccountVo.getSubAcctFrozen();//是否冻结 1：冻结
		checkArgument(!isStatusOn(subAcctFrozen),"subAcctFrozen",subAccountVo,ACCT_FROZEN);
		//校验止入止出
		if (DealDirectionEnum.isIncrease(direction)) {
			String subAcctForbidIn = subAccountVo.getSubAcctForbidIn();//止入 0-否 1-是
			checkArgument(!isStatusOn(subAcctForbidIn),"subAcctForbidIn",subAccountVo,ACCT_FORBID_IN);
		} else {
			String subAcctForbidOut = subAccountVo.getSubAcctForbidOut();//止出 0-否 1-是
			checkArgument(!isStatusOn(subAcctForbidOut),"subAcctForbidOut",subAccountVo,ACCT_FORBID_OUT);
		}
	}
	
	private void checkArgument(boolean expression,String msg,SubAccountVo subAccountVo, ReturnCodeEnum returnCode){
		if (!expression) {
			LOG.error("checkAccount error,message={},subAccountVo={}",msg,subAccountVo);
			ExceptionFactory.throwException(returnCode);
		}
	}
	
	private boolean isStatusOn(String status){
		return Constant.STATUS_ON.equals(status);
	}
}
