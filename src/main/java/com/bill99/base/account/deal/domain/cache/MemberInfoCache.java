package com.bill99.base.account.deal.domain.cache;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.deal.domain.repository.MemberInfoRepository;
import com.bill99.base.account.deal.domain.vo.MemberInfoVo;
/**
 * 会员信息缓存
 * @author jerry.xu.coc
 */
@Service("memberInfoCache")
public class MemberInfoCache extends AbstractCache<Long, MemberInfoVo> {
	@Autowired
	private MemberInfoRepository memberInfoRepository;
	private final static MemberInfoVo DEFAULT_VALUE = new MemberInfoVo();
	@Override
	protected MemberInfoVo getValueWhenExpired(Long key) throws Exception {
		logger.info("GetMemberInfoWhenExpired key={}",key);
		MemberInfoVo memberInfo = memberInfoRepository.queryMemberInfo(key);
		logger.info("GetMemberInfo from DB,memberInfo={}",memberInfo);
		return ObjectUtils.defaultIfNull(memberInfo, DEFAULT_VALUE);
	}
	
	@PostConstruct
	protected void initProperties() {
		setRefreshDuration(acmsVariable.getMemberInfoRefreshDuration());
		setExpireDuration(acmsVariable.getMemberInfoExpireDuration());
		setMaxSize(acmsVariable.getMemberInfoMaxSize());
		setInitialCapacity(acmsVariable.getMemberInfoInitialCapacity());
	}
}
