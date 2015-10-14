package andy.test.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface HelloWorldServer {

	@WebMethod
	String sayHello(String name);

	String sayBye(String name);

}