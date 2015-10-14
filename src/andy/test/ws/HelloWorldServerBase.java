package andy.test.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.EndpointReference;

@WebService
public class HelloWorldServerBase implements HelloWorldServer {
	/* (non-Javadoc)
	 * @see andy.test.ws.HelloWorldServer#sayHello(java.lang.String)
	 */
	@Override
	@WebMethod
	public String sayHello(String name) {
		return "Hello " + name;
	}

	/* (non-Javadoc)
	 * @see andy.test.ws.HelloWorldServer#sayBye(java.lang.String)
	 */
	@Override
	@WebMethod
	public String sayBye(String name) {
		return "Byebye " + name;
	}
	
	public static void main(String[] args) {
		String url = "http://localhost:7010/helloWorldService";
		Endpoint endpoint = Endpoint.publish(url, new HelloWorldServerBase());
//		EndpointReference epReference = endpoint.getEndpointReference();
		System.out.println(endpoint.isPublished());
	}
}
