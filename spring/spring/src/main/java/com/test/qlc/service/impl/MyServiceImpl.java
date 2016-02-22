package com.test.qlc.service.impl;

import com.test.qlc.service.MyService;

public class MyServiceImpl implements MyService {
	
	public String sayHi(String value) {
		System.out.println("success!");
		return "hi:" + value;
	}

}
