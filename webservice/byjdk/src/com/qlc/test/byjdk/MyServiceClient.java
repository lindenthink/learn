package com.qlc.test.byjdk;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class MyServiceClient {
	/**
	 * ���ؿͻ��˲���
	 * @param Linden
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/extService?wsdl");
			
			//QName->qualified name �ļ�д  
			//��һ������Ϊ���������namespace���ڶ�������Ϊ�����ķ������ƣ��ɷ�����wsdl���Ի��
			QName qName = new QName("http://byjdk.test.qlc.com/","MyServiceServer");
			
			Service service = Service.create(url,qName);
			
			//�˴�MyService����ֱ�ӻ�õ������ͻ��˺ͷ�����һ�㲻��ͬһ����Ŀ�У����Կͻ�����Ҫ���ǵ��Ǹ���Ļ��
			MyService myService = service.getPort(MyService.class);
			
			System.out.println("��������Ӧ��" + myService.sayHi("Linden"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
