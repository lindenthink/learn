package com.qlc.test.byjdk;

import javax.jws.WebService;

//JAX-WSע�⣬��ʾjava api xml for webservice��JDK�Դ�API��XML��ʽ��webservice 
@WebService
public interface MyService {
	String sayHi(String value);
}
