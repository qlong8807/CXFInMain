package server;


public class HelloCXFServiceImpl implements HelloCXFService {

	@Override
	public String say(String hello) {
		System.out.println(hello);
		return "zhang "+hello;
	}

}
