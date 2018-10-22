package com.bill99.base.account.deal.domain.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bill99.base.account.common.enumeration.DealTypeEnum;
import com.bill99.base.account.deal.domain.vo.DealFlowVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DealFlowRepositoryTest {
	@Autowired
	private DealFlowRepository flowRepository;
	@Test
	public void testSave(){
		DealFlowVo dealFlowVo = new DealFlowVo();
		dealFlowVo.setAppId("234");
		dealFlowVo.setBizCode("balancechange");
		dealFlowVo.setDealType(DealTypeEnum.DEAL.getCode());
		dealFlowVo.setFlowId("23343435");
		dealFlowVo.setOrderId("testout21323");
		dealFlowVo.setOutTradeNo("testout21323");
		dealFlowVo.setStatus(0);
		dealFlowVo.setPlatformCode(200000000000117l);
		System.out.println(flowRepository.save(dealFlowVo));
	}
	
	@Test
	public void testUpdate(){
		DealFlowVo dealFlowVo = new DealFlowVo();
		dealFlowVo.setFlowId("23343435");
		dealFlowVo.setStatus(3);
		dealFlowVo.setVersion(0);
		flowRepository.update(dealFlowVo);
		System.out.println(dealFlowVo);
	}
}
