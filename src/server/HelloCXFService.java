package server;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloCXFService {

	@WebMethod
	public String say(String hello);
}
