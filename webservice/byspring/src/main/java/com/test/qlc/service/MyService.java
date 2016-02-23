package com.test.qlc.service;

import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.test.qlc.bean.IntegerUserMapAdapter;
import com.test.qlc.bean.User;


/**
 * 
 * @author Linden
 * @date   2016年2月21日 下午7:42:23
 */
@WebService
public interface MyService {
	String sayHi(String value);
	
	String sayHiToUser(User user);
	
	@XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
	Map<Integer,User> getUsers();
}
