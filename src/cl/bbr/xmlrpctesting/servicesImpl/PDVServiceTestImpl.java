package cl.bbr.xmlrpctesting.servicesImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.bbr.xmlrpctesting.services.PDVServiceTest;

/**
 * @author jbovet
 *
 */
public class PDVServiceTestImpl implements PDVServiceTest {

	@Override
	public Map<String, Object> reciveDatosTesting(List<Map<String, Object>> mapa,String usuario, String password) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> subMapa = new HashMap<String, Object>();
		
		subMapa.put("tradingLocationName","v1");
		subMapa.put("tradingLocationNumber","v2");
		subMapa.put("ageSegment","v3");
		subMapa.put("businessType","v4");
		subMapa.put("businessSubType","v5");
		subMapa.put("channel","v6");
		subMapa.put("channel2","v2");
		
		result.put("data", subMapa);
		result.put("ack", "ACKdata");
		return result;
	}


}
