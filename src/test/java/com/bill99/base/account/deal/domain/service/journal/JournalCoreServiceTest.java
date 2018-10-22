package com.bill99.base.account.deal.domain.service.journal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bill99.base.account.deal.domain.repository.DealJournalRepository;
import com.bill99.base.account.deal.domain.repository.JournalDetailRepository;
import com.bill99.base.account.deal.domain.vo.DealJournalVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JournalCoreServiceTest {
	@Autowired
	private JournalCoreService journalCoreService;
	@Autowired
	private DealJournalRepository dealJournalRepository;
	@Autowired
	private JournalDetailRepository detailRepository;
	@Test
	public void testAyncCharge(){
		DealJournalVo journalVo = new DealJournalVo();
		journalVo.setJournalId("201808211915061000078000");
		DealJournalVo vo = dealJournalRepository.queryByCondition(journalVo);
		vo.setDetailVos(detailRepository.queryByJournalId(journalVo.getJournalId()));
		journalCoreService.syncCharge(vo);
	}
	

}
