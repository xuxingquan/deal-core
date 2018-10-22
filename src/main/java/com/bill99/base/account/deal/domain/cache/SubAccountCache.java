package com.bill99.base.account.deal.domain.cache;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.constant.Constant;
import com.bill99.base.account.common.util.CommonUtil;
import com.bill99.base.account.deal.domain.repository.SubAccountRepository;
import com.bill99.base.account.deal.domain.vo.SubAccountVo;

/**
 * 子账户查询缓存
 * @author jerry.xu.coc
 */
@Service("subAccountCache")
public class SubAccountCache extends AbstractCache<String, SubAccountVo> {
	@Autowired
	private SubAccountRepository subAccountRepository;
	private final static SubAccountVo DEFAULT_VALUE = new SubAccountVo();
	@Override
	protected SubAccountVo getValueWhenExpired(String key) throws Exception {
		logger.info("GetSubAccountWhenExpired key={}", key);
		if (StringUtils.isBlank(key)) {
			return null;
		}
		String[] arrayStrings = key.split(Constant.UNDER_LINE);
		int size = CollectionUtils.size(arrayStrings);
		if (size > 2) {
			return null;
		}
		// 组装查询条件
		SubAccountVo condition = new SubAccountVo();
		condition.setStatus(Constant.STATUS_ON);
		if (size == 2) {
			condition.setMemberCode(arrayStrings[0]);
			condition.setSubAcctType(arrayStrings[1]);
		} else if (size == 1) {
			condition.setSubAcctId(arrayStrings[0]);
		}
		// 查询并返回分账户
		List<SubAccountVo> result = subAccountRepository.queryByCondition(condition);
		SubAccountVo subAccountVo = CommonUtil.getUnique(result);
		logger.info("GetSubAccount from DB,subAccountVo={}",subAccountVo);
		return ObjectUtils.defaultIfNull(subAccountVo, DEFAULT_VALUE);
	}

	@PostConstruct
	protected void initProperties() {
		setRefreshDuration(acmsVariable.getSubAcctRefreshDuration());
		setExpireDuration(acmsVariable.getSubAcctExpireDuration());
		setMaxSize(acmsVariable.getSubAcctMaxSize());
		setInitialCapacity(acmsVariable.getSubAcctInitialCapacity());
	}
}
