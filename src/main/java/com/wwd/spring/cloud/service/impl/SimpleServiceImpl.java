package com.wwd.spring.cloud.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwd.mapper.StudentMapper;
import com.wwd.model.Student;
import com.wwd.spring.cloud.service.SimpleService;

/**
 * 
		* ClassName: SimpleServiceImpl <br/>
		* Function: TODO ADD FUNCTION. <br/>
		* @author wangwending
		* @since JDK 1.7
 */
@Service
public class SimpleServiceImpl implements SimpleService {

	private static final Logger log = LoggerFactory.getLogger(SimpleServiceImpl.class);

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public void out() {
		Student student = studentMapper.selectByPrimaryKey(1);
		System.err.println("Spring CLoud CLient Simple Out!!!");
		log.info("out Success !!! info {} {} {} {}", student.getId(), student.getName(), student.getAge(),
				student.getSex());
	}

}
