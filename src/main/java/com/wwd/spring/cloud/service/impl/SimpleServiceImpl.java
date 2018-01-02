package com.wwd.spring.cloud.service.impl;

import org.springframework.stereotype.Service;

import com.wwd.spring.cloud.service.SimpleService;

/**
 * 
		* ClassName: SimpleServiceImpl <br/>
		* Function: TODO ADD FUNCTION. <br/>
		* @author wangwending
		* @since JDK 1.7
 */
@Service
public class SimpleServiceImpl implements SimpleService{

	@Override
	public void out() {
		System.err.println("Spring CLoud CLient Simple Out!!!");
	}

}
