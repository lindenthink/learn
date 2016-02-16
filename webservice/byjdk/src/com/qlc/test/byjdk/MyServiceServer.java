package com.qlc.test.byjdk;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
/**
 * ����˳���
 * @author Linden
 *
 */

//endpointInterface:ָ���������,�ӿڱ����������@WebService���
//serviceName:ָ���������ƣ�Ĭ��Ϊ����+Service
@WebService(endpointInterface="com.qlc.test.byjdk.MyService",serviceName="MyServiceServer")
public class MyServiceServer implements MyService{
	
	@Override
	public String sayHi(String value) {
		return "Hi:"+value;
	}
	
	public static void main(String[] args) {
		System.out.println("��ʼ����webservice����...");
		Endpoint.publish("http://localhost:8080/extService", new MyServiceServer());
		System.out.println("webservice���������ɹ�!");
	}
}
