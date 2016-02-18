package com.qlc.test.byjdk;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
/**
 * 服务端程序
 * @author Linden
 *
 */

//endpointInterface:指定接入点借口,接口必须存在且用@WebService标记
//serviceName:指定服务名称，默认为类名+Service
@WebService(endpointInterface="com.qlc.test.byjdk.MyService",serviceName="MyServiceServer")
public class MyServiceServer implements MyService{
	
	@Override
	public String sayHi(@WebParam(name="value")String value) {//该标记 以后都要加上
		return "Hi:"+value;
	}
	
	public static void main(String[] args) {
		System.out.println("开始启动webservice服务...");
		Endpoint.publish("http://localhost:8080/extService", new MyServiceServer());
		System.out.println("webservice服务启动成功!");
	}
}
