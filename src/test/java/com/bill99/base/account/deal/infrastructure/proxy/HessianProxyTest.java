package com.bill99.base.account.deal.infrastructure.proxy;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.bill99.base.account.common.enumeration.PostingRuleEnum;
import com.bill99.seashell.common.helper.cos.DealStatus;
import com.bill99.seashell.domain.dto.entry.QueryOrderResultDto;
import com.bill99.seashell.domain.dto.order.DealDto;
import com.bill99.seashell.domain.dto.order.PaymentOrderDto;
import com.bill99.seashell.domain.service.common.COSResponse;
import com.bill99.seashell.domain.service.pe.hessian.order.HessianOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HessianProxyTest {
	@Autowired
	private HessianOrderService orderService;
	@Test
	public void testHessianOrderService(){
		PostingRuleEnum chargeRuleEnum = PostingRuleEnum.RECEIVABLE_SETTLE_FEE;
		//组装paymentOrder
		PaymentOrderDto paymentOrderDto = new PaymentOrderDto();
		paymentOrderDto.setOrderId(DateTime.now().toString("yyyyMMddHHmmssSSS"));//必传，且必须唯一
		paymentOrderDto.setOrderType(chargeRuleEnum.getOrderCode());//TODO::待分配  与查询时的orderCode一致
		paymentOrderDto.setOrderAmount(22000l);//单位：厘
		paymentOrderDto.setOrderTime(new Date());
		paymentOrderDto.setPayMethod(1);
		paymentOrderDto.setOrderStatus(101);
		paymentOrderDto.setVersion("v2.0");
		//组装DealDto
		DealDto dealDto = new DealDto();
		dealDto.setDealId(null);
		dealDto.setHasCaculatedPrice(true);
		dealDto.setDealBeginDate(new Date());
		dealDto.setDealAmount(22000l); //yes
		dealDto.setDealStatus(DealStatus.created.getValue());
		dealDto.setDealCode(chargeRuleEnum.getDealCode()); //TODO::待分配
//		dealDto.setPayerChannel("1280020010002");//TODO::待分配
//		dealDto.setPayeeAcctCode("1001219857701");//TODO::待分配
//		dealDto.setPayerAcctCode("1280020010002");//TODO::待分配
		dealDto.setPaymentServicePkgCode(chargeRuleEnum.getPskPkgCode());//TODO::待分配
		dealDto.setDealType(30);
		dealDto.setOrder(paymentOrderDto);

		COSResponse processOrderWithDealAndAction = orderService.processOrderWithDeal(dealDto,true);
		System.out.println("==================================================");
		System.out.println("OrderId="+paymentOrderDto.getOrderId());
		System.out.println(JSON.toJSON(processOrderWithDealAndAction));
	}
	
	@Test
	public void testQueryOrder(){
		PostingRuleEnum chargeRuleEnum = PostingRuleEnum.RECEIVABLE_SETTLE_FEE;
		Integer orderCode = chargeRuleEnum.getOrderCode();//TODO::待分配
		String orderId = "20190820191315930";
		Integer[] orderstatus = new Integer[]{101,111};//101 创建  111 记账成功
		QueryOrderResultDto result = orderService.queryOrder(orderCode, orderId, orderstatus);
		System.out.println("==================================================");
		System.out.println(JSON.toJSON(result));
	}
	
	
}
