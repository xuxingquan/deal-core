package com.bill99.base.account.deal.infrastructure.persistence;

import com.bill99.base.account.deal.domain.entity.DealFlow;
import com.bill99.base.account.deal.domain.entity.DealFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealFlowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DealFlow record);

    int insertSelective(DealFlow record);

    List<DealFlow> selectByExample(DealFlowExample example);

    DealFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DealFlow record, @Param("example") DealFlowExample example);

    int updateByExample(@Param("record") DealFlow record, @Param("example") DealFlowExample example);

    int updateByPrimaryKeySelective(DealFlow record);

    int updateByPrimaryKey(DealFlow record);
}