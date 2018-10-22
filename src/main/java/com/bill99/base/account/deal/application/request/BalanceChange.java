package com.bill99.base.account.deal.application.request;

import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.bill99.base.account.common.enumeration.DealDirectionEnum;
import com.bill99.base.account.deal.application.annotation.EnumValue;
import com.google.common.base.MoreObjects;
@Getter
@Setter
public class BalanceChange {
	@NotBlank(message="会员号不能为空")
	private String memberCode;
	@Length(max = 20)
	private String subAcctType;
	@Length(max = 64)
	private String subAcctSubjectCode;
	@NotBlank(message="金额不能空")
	@Pattern(regexp = "^[0-9]*$", message = "金额格式错误")
	private String amount;
	private String currencyCode;
	@NotBlank(message="收付方向不能为空")
	@EnumValue(enumClass=DealDirectionEnum.class, 
				enumMethod="isValidDirection",
				message="收付方向非法")
	private String direction;
	//可提现金额（已分账账户，其它账户不涉及此项金额）
	@Pattern(regexp = "^[0-9]*$", message = "可提现金额格式错误")
	private String allowWithDrawAmount;
	private String remark;
	
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("memberCode", memberCode)
				.add("subAcctType", subAcctType)
				.add("subAcctSubjectCode", subAcctSubjectCode)
				.add("amount", amount)
				.add("currencyCode", currencyCode)
				.add("direction", direction)
				.add("allowWithDrawAmount", allowWithDrawAmount)
				.add("remark", remark)
				.toString();
	}
	
}
