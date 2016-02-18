package com.qlc.test.client;

import com.qlc.test.byjdk.MyService;
import com.qlc.test.byjdk.MyServiceServer;

/**
 * 使用jdk自带的wsimport命令生成客户端，命令在command文件中
 * 
 * @author Linden
 * @date 2016年2月16日 下午5:58:53
 */
public class WsimportClient {
	public static void main(String[] args) {
		/*执行wsimport命令后生成的MyServiceServer类中已经自动生成获得MyService方法
		 * 可以直接使用而不必像byjdk项目那样去调用服务
		 */
		MyServiceServer myServiceServer = new MyServiceServer();
		MyService myService = myServiceServer.getMyServiceServerPort();
		System.out.println("服务器响应：" + myService.sayHi("Linden"));
	}
}
