package com.bill99.base.account.deal.domain.util;

import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.REPEAT_REQUEST;
import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.UNIQUE_SEVICE_KEY_EMPTY;
import static com.bill99.base.account.common.enumeration.ReturnCodeEnum.UNIQUE_SEVICE_NULL;
import static com.bill99.base.account.common.util.Validator.checkArgument;
import static com.bill99.base.account.common.util.Validator.checkNotBlank;
import static com.bill99.base.account.common.util.Validator.checkNotNull;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bill99.inf.unique.UniqueModuleService;
/**
 * 防重服务
 * @author jerry.xu.coc
 */
public class UniqueServiceUtil {
	private static Logger LOG = LoggerFactory.getLogger(UniqueServiceUtil.class);
	//架构组提供的防重服务
	private UniqueModuleService uniqueModuleService;
	//防重服务是否注册成功
	private Boolean isUnique = null;
	//关键字符串
	private String key = null;
	//超时时间
	private int timeOut = 300;
	
	private UniqueServiceUtil(UniqueModuleService uniqueModuleService){
		this.uniqueModuleService = uniqueModuleService;
	}
	
	public static UniqueServiceUtil build(UniqueModuleService uniqueModuleService){
		return new UniqueServiceUtil(checkNotNull(uniqueModuleService,UNIQUE_SEVICE_NULL));
	}
	/**
	* @Description: 防重 
	* @param @param key
	* @return void
	* @throws
	 */
	public void tryLock(String key){
		this.key = checkNotBlank(key,UNIQUE_SEVICE_KEY_EMPTY);
		isUnique = uniqueModuleService.isUnique(key, timeOut);
		checkArgument(BooleanUtils.isTrue(isUnique), REPEAT_REQUEST);
	}
	/**
	* @Description: 防重释放 
	* @param 
	* @return void
	* @throws
	 */
	public void release(){
		key = checkNotBlank(key,UNIQUE_SEVICE_KEY_EMPTY);
		try {
			if (BooleanUtils.isTrue(isUnique)) {
				uniqueModuleService.remove(key);
			}
		} catch (Exception e) {
			LOG.error("uniqueService release error,key={}",key,e);
		}
		key = StringUtils.EMPTY;
	}
}
