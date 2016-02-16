package com.qlc.test.byjdk;

import javax.jws.WebService;

//JAX-WS注解，表示java api xml for webservice。JDK自带API的XML格式的webservice 
@WebService
public interface MyService {
	String sayHi(String value);
}
