package com.bill99.base.account.deal.infrastructure.persistence;

import com.bill99.base.account.deal.domain.entity.DealDetail;
import com.bill99.base.account.deal.domain.entity.DealDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealDetailMapper {
    int deleteByPrimaryKey(Long subId);

    int insert(DealDetail record);

    int insertSelective(DealDetail record);

    List<DealDetail> selectByExample(DealDetailExample example);

    DealDetail selectByPrimaryKey(Long subId);

    int updateByExampleSelective(@Param("record") DealDetail record, @Param("example") DealDetailExample example);

    int updateByExample(@Param("record") DealDetail record, @Param("example") DealDetailExample example);

    int updateByPrimaryKeySelective(DealDetail record);

    int updateByPrimaryKey(DealDetail record);
}