package com.bill99.base.account.deal.domain.repository;
import static com.bill99.base.account.common.util.Validator.checkArgument;
import static com.bill99.base.account.common.util.Validator.checkNotBlank;
import static com.bill99.base.account.common.util.Validator.checkNotNull;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.exception.ExceptionFactory;
import com.bill99.base.account.common.util.WrappedBeanCopier;
import com.bill99.base.account.deal.domain.entity.SubAcctBalance;
import com.bill99.base.account.deal.domain.entity.SubAcctBalanceExample;
import com.bill99.base.account.deal.domain.entity.SubAcctBalanceExample.Criteria;
import com.bill99.base.account.deal.domain.vo.SubAcctBalanceVo;
import com.bill99.base.account.deal.infrastructure.persistence.SubAcctBalanceExtMapper;
import com.bill99.base.account.deal.infrastructure.persistence.SubAcctBalanceMapper;
import com.google.common.base.Optional;

/**
 * @Description:余额表
 * @author yunlong.liu
 *
 */
@Service
public class SubAcctBalanceRepository {
	private static final Logger LOG = LoggerFactory.getLogger(SubAcctBalanceRepository.class);
	@Autowired
	private SubAcctBalanceMapper SubAcctBalanceMapper;
	
	@Autowired
	private SubAcctBalanceExtMapper subAcctBalanceExtMapper;
	/**
	 * @Description:根据条件查询对应的分户信息
	 * @param subAccount
	 */
	public List<SubAcctBalanceVo> querySubAcctBalanceByIds(List<String> subAcctIds) {
		checkArgument(CollectionUtils.isNotEmpty(subAcctIds), "subAcctIds is empty");
		SubAcctBalanceExample example = new SubAcctBalanceExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubAcctIdIn(subAcctIds);
		List<SubAcctBalance> subAcctBalances = SubAcctBalanceMapper.selectByExample(example);
		return WrappedBeanCopier.copyPropertiesOfList(subAcctBalances, SubAcctBalanceVo.class);
	}
	
	/**
	 * @Description:根据条件查询对应的分户信息
	 * @param subAccount
	 */
	public SubAcctBalanceVo queryById(String subAcctId) {
		checkNotBlank(subAcctId, "subAcctId is blank");
		SubAcctBalance balance = SubAcctBalanceMapper.selectByPrimaryKey(subAcctId);
		return WrappedBeanCopier.copyProperties(balance, SubAcctBalanceVo.class);
	}
	
	public void update(SubAcctBalanceVo balanceVo){
		checkNotNull(balanceVo, "balanceVo cant be null");
		String subAcctId = balanceVo.getSubAcctId();
		checkNotBlank(subAcctId, "SubAcctBalanceVo.SubAcctId cant be blank");
		SubAcctBalance balance = WrappedBeanCopier.copyProperties(balanceVo, SubAcctBalance.class);
		Long version = Optional.fromNullable(balance.getVersion()).or(0l);
		balance.setVersion(version+1);
		balance.setUpdTime(new Date());
		//更新条件
		SubAcctBalanceExample example = new SubAcctBalanceExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubAcctIdEqualTo(subAcctId);
		criteria.andVersionEqualTo(version);
		//更新余额
		int result = SubAcctBalanceMapper.updateByExampleSelective(balance, example);
		LOG.info("update SubAcctBalance,result={},balanceVo={}",result,balance);
		//更新是否成功
		if (result <= 0) {
			//注意覆写SubAcctBalance对象的toString方法
			LOG.error("updateSubAcctBalance failed,balanceVo={}",balance);
			ExceptionFactory.throwException(ReturnCodeEnum.UPDATE_ACCT_BALANCE_FAILED);
		}
		balanceVo.setVersion(version+1);
	}
	
	
	public void update_New(SubAcctBalanceVo balanceVo){
		checkNotNull(balanceVo, "balanceVo cant be null");
		String subAcctId = balanceVo.getSubAcctId();
		checkNotBlank(subAcctId, "SubAcctBalanceVo.SubAcctId cant be blank");
		SubAcctBalance balance = WrappedBeanCopier.copyProperties(balanceVo, SubAcctBalance.class);
		Long version = Optional.fromNullable(balance.getVersion()).or(0l);
		balance.setVersion(version+1);
		balance.setUpdTime(new Date());
		
		//更新余额
		int result = subAcctBalanceExtMapper.updateByPrimaryKeySelectiveForDeal(balance);
		SubAcctBalance queryRecord = SubAcctBalanceMapper.selectByPrimaryKey(subAcctId);
		balanceVo.setAllowWithdrawBalance(queryRecord.getAllowWithdrawBalance());
		balanceVo.setCreditbalance(queryRecord.getCreditbalance());
		balanceVo.setDebitbalance(queryRecord.getDebitbalance());
		balanceVo.setFrozenbalance(queryRecord.getFrozenbalance());
		balanceVo.setSubAcctBalance(queryRecord.getSubAcctBalance());
		balanceVo.setVersion(queryRecord.getVersion());
		LOG.info("update SubAcctBalance,result={},balanceVo={}",result,balanceVo);
		//更新是否成功
		if (result <= 0) {
			//注意覆写SubAcctBalance对象的toString方法
			LOG.error("updateSubAcctBalance failed,balanceVo={}",balanceVo);
			ExceptionFactory.throwException(ReturnCodeEnum.UPDATE_ACCT_BALANCE_FAILED);
		}
	}
}
