package com.bill99.base.account.deal.infrastructure.persistence;

import com.bill99.base.account.deal.domain.entity.DealJournal;
import com.bill99.base.account.deal.domain.entity.DealJournalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealJournalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DealJournal record);

    int insertSelective(DealJournal record);

    List<DealJournal> selectByExample(DealJournalExample example);

    DealJournal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DealJournal record, @Param("example") DealJournalExample example);

    int updateByExample(@Param("record") DealJournal record, @Param("example") DealJournalExample example);

    int updateByPrimaryKeySelective(DealJournal record);

    int updateByPrimaryKey(DealJournal record);
}