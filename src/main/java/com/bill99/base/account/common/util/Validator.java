package com.bill99.base.account.common.util;

import org.apache.commons.lang3.StringUtils;

import com.bill99.base.account.common.enumeration.ReturnCodeEnum;
import com.bill99.base.account.common.exception.ExceptionFactory;

public class Validator {

    public static void checkArgument(boolean expression) {
        if (!expression){
            ExceptionFactory.throwException("1000","argument illegal");
        }
    }
    
    public static void checkArgument(boolean expression,String message) {
        if (!expression){
            ExceptionFactory.throwException("1000",message);
        }
    }
    
    public static void checkArgument(boolean expression, ReturnCodeEnum returnCode) {
        if (!expression){
            ExceptionFactory.throwException(returnCode);
        }
    }
    
    public static String checkNotBlank(String src,String message) {
        if (StringUtils.isBlank(src)){
            ExceptionFactory.throwException("1000",message);
        }
        return src;
    }
    
    public static String checkNotBlank(String src,ReturnCodeEnum returnCode) {
        if (StringUtils.isBlank(src)){
            ExceptionFactory.throwException(returnCode);
        }
        return src;
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            ExceptionFactory.throwException("2000","object is null");
        }
        return reference;
    }
    
    public static <T> T checkNotNull(T reference,String message) {
    	
        if (reference == null) {
            ExceptionFactory.throwException("2000",message);
        }
        return reference;
    }


    public static <T> T checkNotNull(T reference,ReturnCodeEnum returnCode) {
        if (reference == null) {
            ExceptionFactory.throwException(returnCode);
        }
        return reference;
    }
}
