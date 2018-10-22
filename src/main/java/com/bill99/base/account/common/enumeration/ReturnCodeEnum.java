package com.bill99.base.account.common.enumeration;

public enum ReturnCodeEnum {

	SUCC("0000", "成功"),
	// 公共报文头参数无效
	INVALID_PARAM("1001", "参数校验错误"),
	DEAL_NOT_EXIST("2000", "交易不存在"),
	// 账户状态
	ACCT_STATUS_ERROR("5000", "账户已注销"),
	// 账户冻结
	ACCT_FROZEN("5001", "账户冻结"),
	// 账户止入
	ACCT_FORBID_IN("5002", "账户止入"),
	// 账户止出
	ACCT_FORBID_OUT("5003", "账户止出"),
	// 账户不存在
	ACCT_NOT_EXIST("5004", "账户不存在"),
	// 会员不存在
	MEMBER_NOT_EXIST("5005", "会员不存在或者已注销"),
	// 余额不足
	BALANCE_NOT_ENOUGH("5006", "余额不足"),
	//
	BIZ_PARAM_NOT_MATCH("5007", "memberCode+subAcctType与subAcctSubjectCode不匹配"),
	// 订单已经存在
	DEAL_ALREADY_EXIST("5008", "余额变更订单已经存在"),
	// 订单已经存在
	GET_FLOW_ID_ERROR("5009", "获取FlowId发生异常"),
	// 订单已经存在
	ALLOW_WITHDRAW_BALANCE_ERROR("5009", "可提现金额错误"),
	
	ORIGN_FLOW_NOT_EXIST("5010", "原记账交易不存在"),
	ORIGN_FLOW_STATUS_ERROR("5011", "原记账交易状态异常"),
	REVERSE_SUCCEED("5012", "冲正交易已成功"),
	FLOW_DETAIL_NOT_EXIST("5013", "记账交易明细不存在"),
	//子账户余额表记录不存在
	ACCT_BALANCE_NOT_EXIST("5014", "子账户余额记录不存在"),
	//更新记账明细失败
	UPDATE_DEAL_DETAIL_FAILED("5020","记账失败"),
	//更新记账主表失败
	UPDATE_DEAL_FLOW_FAILED("5021","记账失败"),
	//更新余额失败
	UPDATE_ACCT_BALANCE_FAILED("5022","记账失败"),
	
	REPEAT_REQUEST("7001","请勿在短时间内重复请求"),
	SUB_ACCT_ERROR("7002","子账户异常"),
	UNIQUE_SEVICE_KEY_EMPTY("7004", "防重服务关键字符串为空"),
	UNIQUE_SEVICE_NULL("7005", "防重服务为NULL"),
	
	// 服务异常
	SERVICE_ERROR("9999", "系统内部异常");

	private ReturnCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static boolean isSuccess(String code){
		return SUCC.getCode().equals(code);
	}

	public static ReturnCodeEnum buildReturnCode(String code) {
		ReturnCodeEnum[] returnCodes = ReturnCodeEnum.values();
		for (ReturnCodeEnum r : returnCodes) {
			if (r.getCode().equals(code)) {
				return r;
			}
		}
		return null;
	}

}
