package com.bill99.base.account.deal.domain.service.journal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChargeServiceTest {
	@Autowired
	private ChargeService chargeService;
	@Test
	public void testChargeForTask(){
		System.out.println();
		chargeService.chargeForTask(null);
	}
	

}
