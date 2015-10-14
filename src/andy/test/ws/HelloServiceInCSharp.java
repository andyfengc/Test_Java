package andy.test.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import andy.happywork.ws.HelloServer;
import andy.happywork.ws.HelloServerSoap;
import andy.happywork.ws.HelloWorld;

public class HelloServiceInCSharp {

	public static void main(String[] args) throws MalformedURLException {
		
		// way1
//		callWs();
		
		// way2
		HelloServer server = new HelloServer();
		HelloServerSoap soap = server.getHelloServerSoap();
		String returnVal = soap.helloWorld("John");
		System.out.println(returnVal);
	}

	private static void callWs() throws MalformedURLException {
		URL url = new URL("http://localhost:20213/ws/HelloServer.asmx");
		QName qName = new QName("http://ws.happywork.andy", "HelloServer");
		Service service = Service.create(url, qName);
		HelloServerSoap server = service.getPort(HelloServerSoap.class);
		System.out.println(server.helloWorld("kevin"));
	}

}
