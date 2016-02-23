package com.test.qlc.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.test.qlc.bean.User;
import com.test.qlc.service.MyService;
/**
 * 
 * @author Linden
 * @date   2016年2月21日 下午7:42:30
 */
@WebService(endpointInterface="com.test.qlc.service.MyService")
public class MyServiceImpl implements MyService {
	Map<Integer,User> users = new LinkedHashMap<Integer, User>();
	
	public String sayHi(@WebParam(name="value")String value) {
		System.out.println("sayHi called!");
		return "hi:" + value;
	}

	public String sayHiToUser(User user) {
		System.out.println("sayHiToUser called!");
		users.put(users.size()+1, user);
		return "Hello "  + user.getName();
	}

	public Map<Integer, User> getUsers() {
		System.out.println("getUsers called!");
		return users;
	}

}
