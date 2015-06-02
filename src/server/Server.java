package server;


import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import server.interceptor.AuthInterceptor;

public class Server {

	public static void main(String[] args) {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		HelloCXFService analysisWS = new HelloCXFServiceImpl();
		factory.setServiceClass(HelloCXFService.class);
		factory.setAddress("http://localhost:8899/HelloService");
		factory.setServiceBean(analysisWS);
		factory.getInInterceptors().add(new AuthInterceptor());
		factory.create();
	}

}
