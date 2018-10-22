package com.bill99.base.account.common.exception;

import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.mam.exception.ServiceFailException;

public class ExceptionFactory {
	
	public static ServiceFailException create(ReturnCodeEnum returnCode){
		return new ServiceFailException(returnCode.getCode(),returnCode.getMsg());
	}
	
	public static ServiceFailException create(String errorCode,String errorMsg){
		return new ServiceFailException(errorCode,errorMsg);
	}
	
	public static void throwException(ReturnCodeEnum returnCode) throws ServiceFailException{
		throw create(returnCode);
	}
	
	public static void throwException(String errorCode,String errorMsg) throws ServiceFailException{
		throw create(errorCode,errorMsg);
	}
}