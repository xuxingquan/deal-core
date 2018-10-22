package com.bill99.base.account.deal.infrastructure.persistence;

import com.bill99.base.account.deal.domain.entity.SubAcctBalance;
import com.bill99.base.account.deal.domain.entity.SubAcctBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubAcctBalanceMapper {
    int deleteByPrimaryKey(String subAcctId);

    int insert(SubAcctBalance record);

    int insertSelective(SubAcctBalance record);

    List<SubAcctBalance> selectByExample(SubAcctBalanceExample example);

    SubAcctBalance selectByPrimaryKey(String subAcctId);

    int updateByExampleSelective(@Param("record") SubAcctBalance record, @Param("example") SubAcctBalanceExample example);

    int updateByExample(@Param("record") SubAcctBalance record, @Param("example") SubAcctBalanceExample example);

    int updateByPrimaryKeySelective(SubAcctBalance record);

    int updateByPrimaryKey(SubAcctBalance record);
    
}