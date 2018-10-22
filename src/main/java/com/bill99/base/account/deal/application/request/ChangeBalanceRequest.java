package com.bill99.base.account.deal.application.request;

import java.util.List;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.bill99.base.account.deal.application.annotation.BalanceChangeCheck;
import com.bill99.base.account.deal.application.annotation.MamRequestCheck;
import com.bill99.mam.application.MamRequest;
import com.google.common.base.MoreObjects;
@Getter
@Setter
@MamRequestCheck
@BalanceChangeCheck(message="余额变更请求参数非法")
public class ChangeBalanceRequest extends MamRequest {
	private static final long serialVersionUID = 4407944431751039128L;
	@NotBlank(message = "外部订单号不能为空")
	@Length(max = 32)
	private String outTradeNo;
	@NotBlank(message="平台会员号不能为空")
	@Length(min = 11, max = 15)
	private String platformCode;
	// 订单id(可以为业务系统中的交易单号)
	@Length(max = 64)
	private String orderId;
	@Valid
	private List<BalanceChange> balanceChange;
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("outTradeNo", outTradeNo)
				.add("platformCode", platformCode)
				.add("orderId", orderId)
				.add("balanceChange", balanceChange)
				.addValue(toInternalString()).toString();
	}
}
