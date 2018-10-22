package com.bill99.base.account.deal.infrastructure.persistence;

import com.bill99.base.account.deal.domain.entity.SubAccount;
import com.bill99.base.account.deal.domain.entity.SubAccountExample;
import java.util.List;

public interface SubAccountMapper {
    int deleteByPrimaryKey(String subAcctId);

    int insert(SubAccount record);

    int insertSelective(SubAccount record);

    List<SubAccount> selectByExample(SubAccountExample example);

    SubAccount selectByPrimaryKey(String subAcctId);

    int updateByPrimaryKeySelective(SubAccount record);

    int updateByPrimaryKey(SubAccount record);
}