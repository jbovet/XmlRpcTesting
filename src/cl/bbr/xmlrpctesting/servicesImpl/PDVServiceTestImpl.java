package cl.bbr.xmlrpctesting.servicesImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import cl.bbr.xmlrpctesting.services.PDVServiceTest;

/**
 * @author jbovet
 *
 */
public class PDVServiceTestImpl implements PDVServiceTest {

	@Override
	public Map<String, Object> reciveDatosTesting(Vector<Map<String, Object>> mapa,String usuario, String password) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("OK", "OK");
		return result;
	}


}
