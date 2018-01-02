package com.wwd.spring.cloud.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwd.spring.cloud.service.SimpleService;

@Controller
@RequestMapping("simple")
public class SimpleController {
	
	private final static Logger log = LoggerFactory.getLogger(SimpleController.class);
	
	@Autowired
	private SimpleService simpleService;
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@RequestMapping("out")
	@ResponseBody
	public String out() {
		simpleService.out();
		log.info("Cloud Client Simple Controller Call Success!!!");
		return "hello world";
	}
	
	@RequestMapping("find")
	public void find() {
		List<String> strings = discoveryClient.getServices();
		for (String S : strings) {
			log.info("service out {}", S);
		}
	}
}
