package com.wwd.spring.cloud.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
		* ClassName: CloudClientApplication <br/>
		* Function: Spring Cloud CLient Application. <br/>
		* @author wangwending
		* @since JDK 1.7
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(value = {"com.wwd"})
public class CloudProviderApplication {
	
	private final static Logger log = LoggerFactory.getLogger(CloudProviderApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CloudProviderApplication.class, args);
		log.info("Spring Cloud Client Start Success!!!");
	}
}
