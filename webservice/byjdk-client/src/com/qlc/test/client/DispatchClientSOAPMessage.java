package com.qlc.test.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.w3c.dom.Document;

/**
 * 参考：http://sishuok.com/forum/blogPost/list/5703.html
 * 使用dispatch机制，向服务发送报文，不需要生成客户端而直接动态去调用service
 * 直接生成调用报文去调用服务，生成的客户端调用本质也是如此
 * 说明：在测试过程中出现返回结果为"Hi:null"，最终通过再MyServiceServer中增加@WebParam(name="value")得以解决
 * @author Linden
 * @date   2016年2月17日 下午6:32:09
 */
public class DispatchClientSOAPMessage {
	public static void main(String[] args) {
		try {
			//创建服务
			URL url = new URL("http://localhost:8080/extService?wsdl");
			QName qName = new QName("http://byjdk.test.qlc.com/","MyServiceServer");
			Service service = Service.create(url,qName);
			
			//创建Dispatch
			Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName("http://byjdk.test.qlc.com/","MyServiceServerPort"), SOAPMessage.class, Service.Mode.MESSAGE);
			
			//创建请求消息
			SOAPMessage message = MessageFactory.newInstance().createMessage();
			SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
			SOAPBody body = envelope.getBody();
				
			//创建QName来指定消息中传递数据，第三个参数为前缀貌似可以不用
			QName ename = new QName("http://byjdk.test.qlc.com/","sayHi","ns2");
			SOAPElement element = body.addBodyElement(ename);
			element.addChildElement("value").setValue("Linden");
			System.out.print("请求内容：");
			message.writeTo(System.out);
			
			//通过dispatch传递消息，会返回响应消息
			System.out.println("\n发送请求...");
			SOAPMessage response = dispatch.invoke(message);
			System.out.print("响应内容：");
			response.writeTo(System.out);
			
			//响应消息处理,将响应的消息转换为dom对象 
			Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
			String result = doc.getElementsByTagName("return").item(0).getTextContent();
			System.out.println("\n请求结果：" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
