package client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import server.HelloCXFService;

public class Client {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloCXFService.class);
		factory.setAddress("http://localhost:8899/HelloService");
		HelloCXFService service = (HelloCXFService) factory.create();
		System.out.println(service.say("»·¶ù"));
	}
}
