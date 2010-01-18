package cl.bbr.xmlrpctesting.servicesImpl;

import java.util.List;
import java.util.Map;

import cl.bbr.xmlrpctesting.services.ObjetivoService;

/**
 *
 * @author jbovet
 * @since  18-01-2010
 */
public class ObjetivoServiceImpl implements ObjetivoService {

	/* (non-Javadoc)
	 * @see cl.bbr.xmlrpctesting.services.ObjetivoService#getSaldosPuntosaVencer(java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> getSaldosPuntosaVencer(
			List<Map<String, Object>> list, String usuario, String password) {
		// TODO Auto-generated method stub
		System.out.println("llegue");
		return null;
	}

}
