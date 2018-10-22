package com.bill99.base.account.deal.application.request;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

import com.bill99.base.account.deal.application.annotation.MamRequestCheck;
import com.bill99.mam.application.MamRequest;
import com.google.common.base.MoreObjects;
@Getter
@Setter
@MamRequestCheck
public class ChargeRequest extends MamRequest {
	private static final long serialVersionUID = -5383995153905947611L;
	@NotBlank(message = "外部订单号不能为空")
	@Length(max = 32)
	private String outTradeNo;
	// 订单id(可以为业务系统中的交易单号)
	@Length(max = 64)
	private String orderId;
	@NotEmpty(message="手续费变更明细不能为空")
	@Valid
	private List<ChargeDetail> chargeDetailList;
	
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("outTradeNo", outTradeNo)
				.add("orderId", orderId)
				.add("chargeDetailList", chargeDetailList)
				.addValue(toInternalString())
				.toString();
	}
}
