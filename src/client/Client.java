package client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import server.HelloCXFService;

public class Client {

	public static void main(String[] args) {
		try {
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
			factory.setServiceClass(HelloCXFService.class);
			factory.setAddress("http://localhost:8899/HelloService");
			factory.getOutInterceptors().add(new AddHeaderInterceptor("zyl", "123456"));
			HelloCXFService service = (HelloCXFService) factory.create();
//			factory.getOutInterceptors().add(new LoggingOutInterceptor(new PrintWriter(new FileWriter("in.txt"))));
//			factory.getInInterceptors().add(new LoggingInInterceptor(new PrintWriter(new FileWriter("out.txt"))));
			System.out.println(service.say("»·¶ù"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
