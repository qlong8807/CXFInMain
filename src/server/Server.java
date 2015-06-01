package server;


import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

	public static void main(String[] args) {
		JaxWsServerFactoryBean config_DataAnalysisfactory = new JaxWsServerFactoryBean();
		HelloCXFService analysisWS = new HelloCXFServiceImpl();
		config_DataAnalysisfactory.setServiceClass(HelloCXFService.class);
		config_DataAnalysisfactory.setAddress("http://localhost:8899/HelloService");
		config_DataAnalysisfactory.setServiceBean(analysisWS);
		config_DataAnalysisfactory.create();
		
	}

}
