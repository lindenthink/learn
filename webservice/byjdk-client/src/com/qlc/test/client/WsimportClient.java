package com.qlc.test.client;

import com.qlc.test.byjdk.MyService;
import com.qlc.test.byjdk.MyServiceServer;

/**
 * ʹ��jdk�Դ���wsimport�������ɿͻ��ˣ�������command�ļ���
 * 
 * @author Linden
 * @date 2016��2��16�� ����5:58:53
 */
public class WsimportClient {
	public static void main(String[] args) {
		/*ִ��wsimport��������ɵ�MyServiceServer�����Ѿ��Զ����ɻ��MyService����
		 * ����ֱ��ʹ�ö�������byjdk��Ŀ����ȥ���÷���
		 */
		MyServiceServer myServiceServer = new MyServiceServer();
		MyService myService = myServiceServer.getMyServiceServerPort();
		System.out.println("��������Ӧ��" + myService.sayHi("Linden"));
	}
}
