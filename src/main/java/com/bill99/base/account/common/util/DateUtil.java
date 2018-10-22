package com.bill99.base.account.common.util;

import java.util.Date;

import org.joda.time.DateTime;

public class DateUtil {
	
	public static final String DATE_PATTERN = "yyyyMMddHHmmss";
	public static final String DATE_PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date,String patten){
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(patten);
	}
	
	public static String defaultFormat(Date date){
		return format(date,DATE_PATTERN_YYYYMMDDHHMMSS);
	}
}
