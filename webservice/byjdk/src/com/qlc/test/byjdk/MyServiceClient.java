package com.qlc.test.byjdk;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class MyServiceClient {
	/**
	 * 本地客户端测试
	 * @param Linden
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/extService?wsdl");
			
			//QName->qualified name 的简写  
			//第一个参数为发布服务的namespace，第二个参数为发布的服务名称，由发布的wsdl可以获得
			QName qName = new QName("http://byjdk.test.qlc.com/","MyServiceServer");
			
			Service service = Service.create(url,qName);
			
			//此处MyService可以直接获得到，但客户端和服务器一般不在同一个项目中，所以客户端主要考虑的是该类的获得
			MyService myService = service.getPort(MyService.class);
			
			System.out.println("服务器响应：" + myService.sayHi("Linden"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
