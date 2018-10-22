package com.bill99.base.account.deal.infrastructure.persistence;

import com.bill99.base.account.deal.domain.entity.JournalDetail;
import com.bill99.base.account.deal.domain.entity.JournalDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JournalDetailMapper {
    int deleteByPrimaryKey(Long subId);

    int insert(JournalDetail record);

    int insertSelective(JournalDetail record);

    List<JournalDetail> selectByExample(JournalDetailExample example);

    JournalDetail selectByPrimaryKey(Long subId);

    int updateByExampleSelective(@Param("record") JournalDetail record, @Param("example") JournalDetailExample example);

    int updateByExample(@Param("record") JournalDetail record, @Param("example") JournalDetailExample example);

    int updateByPrimaryKeySelective(JournalDetail record);

    int updateByPrimaryKey(JournalDetail record);
}