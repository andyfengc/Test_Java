package andy.test.ws;

import java.beans.ConstructorProperties;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.config.FieldRetrievingFactoryBean;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPathFactoryBean;
import org.springframework.beans.factory.config.SetFactoryBean;

public class HelloWorldClient {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:7010/helloWorldService?wsdl");
		QName qName = new QName("http://ws.test.andy/", "HelloWorldServerService");
		Service service  = Service.create(url, qName);
		HelloWorldServer server = service.getPort(HelloWorldServer.class);
		System.out.println(server.sayBye("kevin"));
	}

}
