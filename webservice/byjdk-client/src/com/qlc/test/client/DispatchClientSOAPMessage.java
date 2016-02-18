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
 * �ο���http://sishuok.com/forum/blogPost/list/5703.html
 * ʹ��dispatch���ƣ�������ͱ��ģ�����Ҫ���ɿͻ��˶�ֱ�Ӷ�̬ȥ����service
 * ֱ�����ɵ��ñ���ȥ���÷������ɵĿͻ��˵��ñ���Ҳ�����
 * ˵�����ڲ��Թ����г��ַ��ؽ��Ϊ"Hi:null"������ͨ����MyServiceServer������@WebParam(name="value")���Խ��
 * @author Linden
 * @date   2016��2��17�� ����6:32:09
 */
public class DispatchClientSOAPMessage {
	public static void main(String[] args) {
		try {
			//��������
			URL url = new URL("http://localhost:8080/extService?wsdl");
			QName qName = new QName("http://byjdk.test.qlc.com/","MyServiceServer");
			Service service = Service.create(url,qName);
			
			//����Dispatch
			Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName("http://byjdk.test.qlc.com/","MyServiceServerPort"), SOAPMessage.class, Service.Mode.MESSAGE);
			
			//����������Ϣ
			SOAPMessage message = MessageFactory.newInstance().createMessage();
			SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
			SOAPBody body = envelope.getBody();
				
			//����QName��ָ����Ϣ�д������ݣ�����������Ϊǰ׺ò�ƿ��Բ���
			QName ename = new QName("http://byjdk.test.qlc.com/","sayHi","ns2");
			SOAPElement element = body.addBodyElement(ename);
			element.addChildElement("value").setValue("Linden");
			System.out.print("�������ݣ�");
			message.writeTo(System.out);
			
			//ͨ��dispatch������Ϣ���᷵����Ӧ��Ϣ
			System.out.println("\n��������...");
			SOAPMessage response = dispatch.invoke(message);
			System.out.print("��Ӧ���ݣ�");
			response.writeTo(System.out);
			
			//��Ӧ��Ϣ����,����Ӧ����Ϣת��Ϊdom���� 
			Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
			String result = doc.getElementsByTagName("return").item(0).getTextContent();
			System.out.println("\n��������" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
