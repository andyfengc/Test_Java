
package andy.happywork.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloServerSoap", targetNamespace = "http://ws.happywork.andy")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloServerSoap {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "HelloWorld", action = "http://ws.happywork.andy/HelloWorld")
    @WebResult(name = "HelloWorldResult", targetNamespace = "http://ws.happywork.andy")
    @RequestWrapper(localName = "HelloWorld", targetNamespace = "http://ws.happywork.andy", className = "andy.happywork.ws.HelloWorld")
    @ResponseWrapper(localName = "HelloWorldResponse", targetNamespace = "http://ws.happywork.andy", className = "andy.happywork.ws.HelloWorldResponse")
    public String helloWorld(
        @WebParam(name = "name", targetNamespace = "http://ws.happywork.andy")
        String name);

}
