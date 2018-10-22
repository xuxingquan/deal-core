package com.bill99.base.account.deal.domain.service.acct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.MemberStatusEnum;
import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.deal.domain.vo.MemberInfoVo;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
@Service
public class MemberInfoService {
	public static final Logger LOG = LoggerFactory.getLogger(MemberInfoService.class);
	/**
	* @Description: 校验会员是否存在，会员是否有效
	* @param MemberInfo
	* @return void
	 */
	public void checkMemberInfo(MemberInfoVo memberInfo) {
		//校验会员状态
		Integer status = Optional.fromNullable(memberInfo.getMemberStatus()).or(0);
		if (Objects.equal(status, MemberStatusEnum.CANCEL.getStatus())) {
			LOG.warn("memberInfo canceled,memberCode={}",memberInfo.getMemberCode());
			ExceptionFactory.throwException(ReturnCodeEnum.MEMBER_NOT_EXIST);
		}
	}
}