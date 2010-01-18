package cl.bbr.xmlrpctesting.services;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jbovet
 * @since  18-01-2010
 */
public interface ObjetivoService {

	/***
	 * Método que recibe los saldos y punto a vencer desde CEA
	 * @param list Lista de mapas que indican una actividad en CEA
	 * @param usuario 
	 * @param password
	 * @return En caso de error se debe retornar un mapa con clave "ERROR"
	 */
	public Map<String, Object> getSaldosPuntosaVencer(
			List<Map<String, Object>> list, String usuario,
			String password);
	
}
