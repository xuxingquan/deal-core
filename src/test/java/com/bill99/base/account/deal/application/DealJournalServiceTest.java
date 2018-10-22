package com.bill99.base.account.deal.application;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bill99.base.account.deal.application.request.ChargeRequest;
import com.bill99.base.account.deal.application.request.ChargeQueryRequest;
import com.bill99.base.account.deal.application.request.ChargeDetail;
import com.google.common.collect.Lists;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DealJournalServiceTest {
	@Autowired
	private DealJournalService dealJournalService;
	@Test
	public void testChangeBalance(){
		ChargeRequest request = new ChargeRequest();
		request.setAppId("123");
		request.setBizCode("test12");
		request.setOrderId(String.valueOf(System.currentTimeMillis()));
		request.setOutTradeNo(DateTime.now().toString("yyyyMMddhhmmssSSS"));
		ChargeDetail detail1 = new ChargeDetail();
		detail1.setPayeeMemberCode("111111");
		detail1.setPayerMemberCode("222222");
		detail1.setPostingRuleType("10");
		detail1.setAmount("100");
		detail1.setCurrencyCode("CNY");
		detail1.setMemo("memo1");
//		ChargeDetail detail2 = new ChargeDetail();
//		detail2.setPayeeMemberCode("333333");
//		detail2.setPayerMemberCode("555555");
//		detail2.setPostingRuleType("11");
//		detail2.setAmount("200");
//		detail2.setCurrencyCode("CNY");
//		detail2.setMemo("memo2");
		List<ChargeDetail> bcs = Lists.newArrayList(detail1);
		request.setChargeDetailList(bcs);
		System.out.println(dealJournalService.charge(request));
	}
	
	@Test
	public void testQueryDetail(){
		ChargeQueryRequest request = new ChargeQueryRequest();
		request.setAppId("123");
		request.setBizCode("finder.DatailQry");
		request.setOrderId("1534297029270");
		request.setOutTradeNo("20180815093709280");
		System.out.println(dealJournalService.queryBalanceDetail(request));
	}
}
