package com.bill99.base.account.deal.application.request;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotBlank;

import com.bill99.base.account.common.enumeration.PostingRuleEnum;
import com.bill99.base.account.deal.application.annotation.EnumValue;
import com.google.common.base.MoreObjects;

@Getter
@Setter
public class ChargeDetail implements Serializable{
	private static final long serialVersionUID = -8264914182142392905L;
	@NotBlank(message="记账规则类型")
	@EnumValue(enumClass=PostingRuleEnum.class, 
				enumMethod="isLegalRuleType",
				message="记账规则类型非法")
	private String postingRuleType;
	@NotBlank(message="金额不能空")
	@Pattern(regexp = "^[0-9]*$", message = "金额格式错误")
	private String amount;
	@NotBlank(message="收款方会员号不能空")
	private String payeeMemberCode;
	@NotBlank(message="付款方会员号不能空")
	private String payerMemberCode;
//	@NotBlank(message="方向不能为空")
	private String direction;
	private String currencyCode;
	private String memo;
	
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("postingRuleType", postingRuleType)
				.add("amount", amount)
				.add("currencyCode", currencyCode)
				.add("payeeMemberCode", payeeMemberCode)
				.add("payerMemberCode", payerMemberCode)
				.add("direction", direction)
				.add("memo", memo)
				.toString();
	}
}
