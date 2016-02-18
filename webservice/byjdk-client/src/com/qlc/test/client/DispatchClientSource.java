package com.qlc.test.client;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

/**
 * dispatch的Source泛型实现方式
 * @author Linden
 * @date   2016年2月18日 下午2:16:49
 */
public class DispatchClientSource {
	public static void main(String[] args) {
		try {
			//创建服务
			URL url = new URL("http://localhost:8080/extService?wsdl");
			QName qName = new QName("http://byjdk.test.qlc.com/","MyServiceServer");
			Service service = Service.create(url,qName);
			
			//创建Dispatch
			Dispatch<Source> dispatch = service.createDispatch(new QName("http://byjdk.test.qlc.com/","MyServiceServerPort"), Source.class, Service.Mode.PAYLOAD);
			
			String body = "<ns2:sayHi xmlns:ns2=\"http://byjdk.test.qlc.com/\"><value>Linden</value></ns2:sayHi>";
			Source result = dispatch.invoke(new StreamSource(new StringReader(body)));
			System.out.println(sourceToXMLString(result));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	 private static String sourceToXMLString(Source result) {
		 
	        String xmlResult = null;
	        try {
	            TransformerFactory factory = TransformerFactory.newInstance();
	            Transformer transformer = factory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	            OutputStream out = new ByteArrayOutputStream();
	            StreamResult streamResult = new StreamResult();
	            streamResult.setOutputStream(out);
	            transformer.transform(result, streamResult);
	            xmlResult = streamResult.getOutputStream().toString();
	        } catch (TransformerException e) {
	            e.printStackTrace();
	        }
	        return xmlResult;
	    }
}
