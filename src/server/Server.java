package server;


import java.io.Serializable;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server implements Serializable {

	public static void main(String[] args) {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		HelloCXFService analysisWS = new HelloCXFServiceImpl();
		factory.setServiceClass(HelloCXFService.class);
		factory.setAddress("http://localhost:8899/HelloService");
		factory.setServiceBean(analysisWS);
		factory.create();
//		factory.getInInterceptors().add(new LoggingInInterceptor());
	}

}
