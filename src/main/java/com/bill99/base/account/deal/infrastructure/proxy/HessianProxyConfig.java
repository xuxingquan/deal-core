package com.bill99.base.account.deal.infrastructure.proxy;

import static com.bill99.base.account.common.constant.Constant.PE_ORDER_SERVICE_URI;

import java.net.MalformedURLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.bill99.base.account.deal.infrastructure.acms.AcmsVariable;
import com.bill99.seashell.domain.service.pe.hessian.order.HessianOrderService;
import com.caucho.hessian.client.HessianProxyFactory;
/**
 * Hessian Config
 * @author jerry.xu.coc
 */
@Configuration
public class HessianProxyConfig {
	/**
	* @Description: PE记账服务
	* @param acmsVariable
	* @param MalformedURLException
	* @return HessianOrderService
	* @throws
	 */
	@DependsOn({"acmsVariable"})
	@Bean
	public HessianOrderService hessianOrderService(AcmsVariable acmsVariable)throws MalformedURLException {
		String peHessianUrl = acmsVariable.getPeHessianUrl();
		String url = StringUtils.join(peHessianUrl,PE_ORDER_SERVICE_URI);
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setReadTimeout(acmsVariable.getPeReadTimeOut());
		factory.setOverloadEnabled(true);
		return (HessianOrderService) factory.create(HessianOrderService.class, url);
	}
}
