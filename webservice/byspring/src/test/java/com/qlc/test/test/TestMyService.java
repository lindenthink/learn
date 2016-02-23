package com.qlc.test.test;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.qlc.bean.User;
import com.test.qlc.bean.UserImpl;
import com.test.qlc.service.MyService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class TestMyService implements ApplicationContextAware{
	//获得ApplicationContent实例
	private ApplicationContext context = null;
	public void setApplicationContext(ApplicationContext arg)
			throws BeansException {
		this.context = arg;
	}
	
	@Test
	public void testClient(){
		//方法一测试：
//		MyService service = (MyService) context.getBean("helloClient");
		
		//方法二测试：
		MyService service = (MyService) context.getBean("client");
		System.out.println(service.sayHi("Linden"));
		
		User user = new UserImpl("Linden");
		System.out.println(service.sayHiToUser(user));
		
		Map<Integer,User> users = service.getUsers();
		System.out.println(users.size());
	}
	
}
