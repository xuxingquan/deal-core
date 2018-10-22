package com.bill99.base.account.deal.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.common.util.WrappedBeanCopier;
import com.bill99.base.account.deal.domain.entity.MemberInfo;
import com.bill99.base.account.deal.domain.entity.MemberInfoExample;
import com.bill99.base.account.deal.domain.entity.MemberInfoExample.Criteria;
import com.bill99.base.account.deal.domain.vo.MemberInfoVo;
import com.bill99.base.account.deal.infrastructure.persistence.MemberInfoMapper;
@Service
public class MemberInfoRepository {
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	/**
	* @Description: 根据会员号查询会员信息 
	* @param memberCode
	* @return MemberInfoVo
	* @throws
	 */
	public MemberInfoVo queryMemberInfo(Long memberCode) {
		if (memberCode == null) return null;
		MemberInfoExample example = new MemberInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberCodeEqualTo(memberCode);
		List<MemberInfo> result = memberInfoMapper.selectByExample(example);
		MemberInfo memberInfo = CommonUtil.getUnique(result);
		return WrappedBeanCopier.copyProperties(memberInfo, MemberInfoVo.class);
	}
}
