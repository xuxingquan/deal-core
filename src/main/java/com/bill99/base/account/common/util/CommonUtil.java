package com.bill99.base.account.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;


public class CommonUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T getUnique(Collection<T> list){
		
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		
		Iterator<T> iterator = list.iterator(); 
		while(iterator.hasNext()){
			Object obj = iterator.next();
			if(obj != null){
				return (T)obj;
			}
		}
		return null;
	}
	
	public static Long toLong(String src){
		return NumberUtils.createLong(src);
	}
	
	public static Integer toInteger(String src){
		return NumberUtils.createInteger(src);
	}
	
	public static Integer toInteger(Short src){
		if(src == null) return null;
		return Integer.valueOf(src);
	}
	
	public static Short toShort(String src){
		if(StringUtils.isBlank(src) || 
				!StringUtils.isNumeric(src)){
			return null;
		}
		return Short.valueOf(src);
	}
	
	public static String toString(Object src){
		if(src == null){
			return null;
		}
		return src.toString();
	}
	
	public static Boolean toBoolean(String src){
		return BooleanUtils.toBooleanObject(src);
	}

	public static long random(long origNumber){
		StringBuilder currentTime = new StringBuilder(DateTime.now().toString("yyyyMMddHH"));
		long origRandom = ThreadLocalRandom.current().nextLong(9999)+origNumber;
		currentTime.append(origRandom);
		String random = StringUtils.rightPad(currentTime.toString(),18,"0");
		return  Long.valueOf(random);
	}

	public static String getLocalIp(){
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return null;
		}
	}
	
	/**
	* @Description: 是否整数（包括负整数） 
	* @param src
	* @return boolean
	 */
	public static boolean isNumeric(String src){
		if (StringUtils.isBlank(src)) {
			return false;
		}
		return src.matches("^[-\\+]?[\\d]*$");
	}
	/**
	 * @Description: 对象元素个数（约定：obj == null，则size=0） 
	 */
	public static int size(Object obj){
		if (obj == null) {
			return 0;
		}
		return CollectionUtils.size(obj);
	}
}
