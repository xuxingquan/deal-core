package com.bill99.base.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill99.base.account.deal.infrastructure.executor.TaskThreadPoolConfig;
@EnableAsync
@EnableFeignClients
@EnableConfigurationProperties({TaskThreadPoolConfig.class} )
@SpringBootApplication(scanBasePackages="com.bill99.base.account")
@ImportResource({ "classpath:spring/spring-config.xml" })
@RestController
public class BootApplication extends SpringBootServletInitializer implements
		HealthIndicator {

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		application.bannerMode(Banner.Mode.LOG);
		return application.sources(BootApplication.class);
	}

	/**
	 * 监控检查
	 */
	@Override
	public Health health() {
		return Health.up().withDetail("appName", appName).build();
	}

	@RequestMapping(value = "/")
	public String index() {
		return appName;
	}
}