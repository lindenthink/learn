
package com.qlc.test.byjdk;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MyService", targetNamespace = "http://byjdk.test.qlc.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MyService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://byjdk.test.qlc.com/", className = "com.qlc.test.byjdk.SayHi")
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://byjdk.test.qlc.com/", className = "com.qlc.test.byjdk.SayHiResponse")
    @Action(input = "http://byjdk.test.qlc.com/MyService/sayHiRequest", output = "http://byjdk.test.qlc.com/MyService/sayHiResponse")
    public String sayHi(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
