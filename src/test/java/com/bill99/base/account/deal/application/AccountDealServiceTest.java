package com.bill99.base.account.deal.application;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bill99.base.account.common.enumeration.DealDirectionEnum;
import com.bill99.base.account.deal.application.request.BalanceChange;
import com.bill99.base.account.deal.application.request.ChangeBalanceRequest;
import com.bill99.base.account.deal.application.request.ReverseRequest;
import com.google.common.collect.Lists;

/**
 * 
 * @author jerry.xu.coc
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountDealServiceTest {
	@Autowired
	private AccountDealService dealAppService;
	@Test
	public void testReverse(){
		ReverseRequest request = new ReverseRequest();
		request.setAppId("123");
		request.setBizCode("finder.reverse");
		request.setOrignDealId("201806291119081000010528");
//		request.setOrignOrderId("");
//		request.setOrignOutTradeNo("");
		request.setOutTradeNo(String.valueOf(System.nanoTime()));
		request.setRequestTime(new Date());
		System.out.println(dealAppService.balanceChangeReverse(request));
	}
	
	@Test
	public void testChangeBalance(){
		
		ChangeBalanceRequest request = new ChangeBalanceRequest();
		request.setAppId("123");
		request.setBizCode("finder.ChangeBalance");
		request.setOrderId(String.valueOf(System.currentTimeMillis()));
		request.setOutTradeNo(DateTime.now().toString("yyyyMMddhhmmssSSS"));
		request.setPlatformCode("200000000000117");
		
		BalanceChange balanceChange1 = new BalanceChange();
		balanceChange1.setAmount("11");
		balanceChange1.setDirection(DealDirectionEnum.DECREASE.getValue().toString());
		balanceChange1.setMemberCode("200000000000125");
		balanceChange1.setSubAcctType("SPAW0001");
		
		BalanceChange balanceChange2 = new BalanceChange();
		balanceChange2.setAmount("31");
		balanceChange2.setDirection(DealDirectionEnum.INCREASE.getValue().toString());
		balanceChange2.setMemberCode("200000000000125");
//		balanceChange2.setSubAcctType("SPAD0001");
		balanceChange2.setSubAcctType("SPAW0001");
		
		List<BalanceChange> bcs = Lists.newArrayList(balanceChange1,balanceChange2);
		request.setBalanceChange(bcs);
		
		System.out.println(dealAppService.changeBalance(request));
	}
	
	@Test
	public void testChangeBalance2(){
		
		ChangeBalanceRequest request = new ChangeBalanceRequest();
		request.setAppId("123");
		request.setBizCode("finder.ChangeBalance");
		request.setOrderId("201107301444230100101000");
		request.setOutTradeNo(DateTime.now().toString("yyyyMMddhhmmssSSS"));
		request.setPlatformCode("200000000000117");
		
		BalanceChange balanceChange6 = new BalanceChange();
		balanceChange6.setAmount("111");
		balanceChange6.setDirection("1");
		balanceChange6.setMemberCode("200000000000126");
		balanceChange6.setSubAcctType("SPWD0001");
		
		BalanceChange balanceChange2 = new BalanceChange();
		balanceChange2.setAmount("2");
		balanceChange2.setDirection("1");
		balanceChange2.setMemberCode("200000000000126");
		balanceChange2.setSubAcctType("SPWD0001");
		
		BalanceChange balanceChange4 = new BalanceChange();
		balanceChange4.setAmount("3");
		balanceChange4.setDirection("1");
		balanceChange4.setMemberCode("200000000000117");
		balanceChange4.setSubAcctType("SPWD0001");
		
		BalanceChange balanceChange1 = new BalanceChange();
		balanceChange1.setAmount("2");
		balanceChange1.setDirection("-1");
		balanceChange1.setMemberCode("200000000000126");
		balanceChange1.setSubAcctType("SPAW0001");
		
		BalanceChange balanceChange3 = new BalanceChange();
		balanceChange3.setAmount("3");
		balanceChange3.setDirection("-1");
		balanceChange3.setMemberCode("200000000000117");
		balanceChange3.setSubAcctType("SPAW0001");
		
		BalanceChange balanceChange5 = new BalanceChange();
		balanceChange5.setAmount("111");
		balanceChange5.setDirection("-1");
		balanceChange5.setMemberCode("200000000000126");
		balanceChange5.setSubAcctType("SPAW0001");
		
		List<BalanceChange> bcs = Lists.newArrayList(
				balanceChange1,balanceChange2,balanceChange3,balanceChange4,balanceChange5,balanceChange6);
		request.setBalanceChange(bcs);
		
		System.out.println(dealAppService.changeBalance(request));
	}
	
}
