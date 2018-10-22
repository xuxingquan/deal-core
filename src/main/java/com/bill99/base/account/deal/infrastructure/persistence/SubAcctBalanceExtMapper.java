package com.bill99.base.account.deal.infrastructure.persistence;

import com.bill99.base.account.deal.domain.entity.SubAcctBalance;

public interface SubAcctBalanceExtMapper {
    
    int updateByPrimaryKeySelectiveForDeal(SubAcctBalance record);
}