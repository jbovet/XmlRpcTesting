package cl.bbr.xmlrpctesting.servicesImpl;

import cl.bbr.xmlrpctesting.services.TestService;

public class TestServiceImpl implements TestService {

	@Override
	public String hello(String nombre, Integer edad){
		return nombre + edad.toString();
	}

}
