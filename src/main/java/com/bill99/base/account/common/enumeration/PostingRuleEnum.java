package com.bill99.base.account.common.enumeration;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

@Getter
public enum PostingRuleEnum {
	//应收分账手续费
	RECEIVABLE_SETTLE_FEE("10",797,372,"1302","6501033","1260300010001","5151300010002"),
	//实收分账手续费
	ACTUAL_SETTLE_FEE("11",797,372,"1303","6501034","1280300010001","1260300010001"),
	//应收提现手续费
	RECEIVABLE_WITHDRAW_FEE("12",798,373,"1304","6501035","1260300010001","5151300010001"),
	//应付提现成本(实时付)
	PAYABLE_WITHDRAW_ONLINE_COST("13",798,373,"1305","6501036","5451300010001","1280300010001"),
	//应付提现成本(后付)
	PAYABLE_WITHDRAW_COST("14",798,373,"1306","6501037","5451300010001","2260300010001"),
	//确认实收提现手续费
	CONFIRM_ACTUAL_WITHDRAW_FEE("15",798,373,"1307","6501038","1280300010001","1260300010001"),
	
	// TODO 当前为华夏银行专用户, 后期需调整 (1022300010393)
	//收入提现至银行账户
	INCOME_WITHDRAW_BANK_ACCT("16",799,374,"1308","6501039","1022300010393","1280300010001"),
	//银行扣收成本
	BANK_DEDUCT_COST("17",802,375,"1309","6501040","2260300010001","1022300010393"),
	;
	private String chargeRuleType;
	private Integer orderCode;
	private Integer dealCode;
	private String pskPkgCode;
	private String psCode;
	private String debitRule;
	private String creditRule;
	
	private PostingRuleEnum(String chargeRuleType,Integer orderCode,Integer dealCode,String pskPkgCode,
			String psCode,String debitRule,String creditRule){
		this.chargeRuleType = chargeRuleType;
		this.orderCode = orderCode;
		this.dealCode = dealCode;
		this.pskPkgCode = pskPkgCode;
		this.psCode = psCode;
		this.debitRule = debitRule;
		this.creditRule = creditRule;
	}
	
	public static boolean isLegalRuleType(String chargeRuleType){
		if (StringUtils.isBlank(chargeRuleType)) {
			return false;
		}
		for (PostingRuleEnum chargeRuleEnum : PostingRuleEnum.values()) {
			if (chargeRuleEnum.getChargeRuleType().equals(chargeRuleType)) {
				return true;
			}
		}
		return false;
	}
	
	public static PostingRuleEnum getRule(String chargeRuleType){
		if (StringUtils.isBlank(chargeRuleType)) {
			return null;
		}
		for (PostingRuleEnum chargeRuleEnum : PostingRuleEnum.values()) {
			if (chargeRuleEnum.getChargeRuleType().equals(chargeRuleType)) {
				return chargeRuleEnum;
			}
		}
		return null;
	}
	
	
}
