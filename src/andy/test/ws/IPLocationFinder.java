package andy.test.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder {
	@WebServiceRef(wsdlLocation="http://www.webservicex.net/geoipservice.asmx?WSDL")
	private static GeoIPService ipService2;

	public static void main(String[] args) throws MalformedURLException {
//		callWebServiceByJdkWsimport();
		callWebServiceByJdkWsimport2();

		
//		String ip = "212.58.246.104";
//		GeoIPServiceSoap ipServiceSoap2 = ipService2.getGeoIPServiceSoap();
//		GeoIP geoIp2 = ipServiceSoap2.getGeoIP(ip);
//		System.out.println(geoIp2.getCountryCode() + " " + geoIp2.getCountryName());
	}

	private static void callWebServiceByJdkWsimport() {
		String ip = "212.58.246.104";

		// create service
		GeoIPService ipService = new GeoIPService();
		// get service port
		GeoIPServiceSoap ipServiceSoap = ipService.getGeoIPServiceSoap();
		// call method
		GeoIP geoIp = ipServiceSoap.getGeoIP(ip);
		// get return value
		String country = geoIp.getCountryName();
		
		System.out.println(country);
	}
	
	private static void callWebServiceByJdkWsimport2() throws MalformedURLException{
		String ip = "202.106.0.20";
		URL url = new URL("http://www.webservicex.net/geoipservice.asmx?WSDL");
		QName qName = new QName("http://www.webservicex.net/", "GeoIPService");
		Service service = GeoIPService.create(url, qName);
		GeoIPServiceSoap geoIp = service.getPort(GeoIPServiceSoap.class);
		
		System.out.println(geoIp.getGeoIP(ip).getCountryName());
	}

}
