package com.bill99.base.account.deal.domain.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.util.WrappedBeanCopier;
import com.bill99.base.account.deal.domain.entity.SubAccount;
import com.bill99.base.account.deal.domain.entity.SubAccountExample;
import com.bill99.base.account.deal.domain.entity.SubAccountExample.Criteria;
import com.bill99.base.account.deal.domain.vo.SubAccountVo;
import com.bill99.base.account.deal.infrastructure.persistence.SubAccountMapper;

/**
 * @Description:分户表
 * @author yunlong.liu
 *
 */
@Service
public class SubAccountRepository {
	@Autowired
	private SubAccountMapper subAccountMapper;

	/**
	 * @Description:根据条件查询对应的分户信息
	 * @param subAccount
	 */
	public List<SubAccountVo> queryByCondition(SubAccountVo vo) {
		SubAccountExample example = new SubAccountExample();
		Criteria criteria = example.createCriteria();
		// 账户ID
		if (StringUtils.isNotBlank(vo.getSubAcctId())) {
			criteria.andSubAcctIdEqualTo(vo.getSubAcctId());
		}
		// 会员号
		if (StringUtils.isNotBlank(vo.getMemberCode())) {
			criteria.andMemberCodeEqualTo(vo.getMemberCode());
		}
		// 分户账户类型
		if (StringUtils.isNotEmpty(vo.getSubAcctType())) {
			criteria.andSubAcctTypeEqualTo(vo.getSubAcctType());
		}
		// 分户状态 1:正常 0:注销
		if (StringUtils.isNotBlank(vo.getStatus())) {
			criteria.andStatusEqualTo(vo.getStatus());
		}
		List<SubAccount> subAccounts = subAccountMapper.selectByExample(example);
		return WrappedBeanCopier.copyPropertiesOfList(subAccounts, SubAccountVo.class);
	}
}