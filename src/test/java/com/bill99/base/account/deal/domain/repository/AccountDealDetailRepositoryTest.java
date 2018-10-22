package com.bill99.base.account.deal.domain.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bill99.base.account.deal.domain.vo.DealDetailVo;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountDealDetailRepositoryTest {
	@Autowired
	private DealDetailRepository detailRepository;
	@Test
	public void testSaveDealDetail(){
		DealDetailVo detailVo = new DealDetailVo();
		detailVo.setAmount(12l);
		detailVo.setCurrencyCode("CNY");
		detailVo.setDirection(1);
		detailVo.setFlowId("23343435");
		detailVo.setMemberCode(200000000000125l);
		detailVo.setSubAcctType("SPAD0001");
		System.out.println(detailRepository.save(detailVo));
	}
	
	@Test
	public void testUpdateDealDetail(){
		DealDetailVo detailVo = new DealDetailVo();
		detailVo.setAmount(22l);
		detailVo.setFlowId("23343435");
		detailVo.setSubId(1568l);
		detailVo.setVersion(0);
		detailRepository.update(detailVo);
		System.out.println(detailVo);
	}

}
