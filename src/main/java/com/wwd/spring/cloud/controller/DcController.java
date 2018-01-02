package com.wwd.spring.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
		* ClassName: DcController <br/>
		* Function: 打印服务实例. <br/>
		* @author wangwending
		* @since JDK 1.7
 */
@RestController
public class DcController {
	
	private static final Logger log = LoggerFactory.getLogger(DcController.class);
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("dc")
	public String dc() {
		String services = "Services: " + discoveryClient.getServices();
        log.info("CLoud Provider Service {}", services);
        return services;
	}
}
