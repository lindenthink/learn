package com.qlc.test.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.qlc.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class TestMyService {
	@Autowired
	@Qualifier("myService")//配合byName使用，如果不指定则byType
	private MyService service;
	
	@Test
	public void testServer(){
		service.sayHi("Linden");
	}
	
}
