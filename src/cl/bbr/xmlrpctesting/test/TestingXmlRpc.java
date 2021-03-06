package cl.bbr.xmlrpctesting.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.junit.Before;
import org.junit.Test;



public class TestingXmlRpc {
	
	private XmlRpcClient client =  null;
	private XmlRpcClientConfigImpl config = null;
	private static final String URL = "http://127.0.0.1:8080/XmlRpcTesting/xmlrpcrequest.htm";
	
	@Before public void setUp() throws Exception {
		client = new XmlRpcClient();
		config = new XmlRpcClientConfigImpl();
		config.setServerURL(new java.net.URL(URL));
		client.setConfig(config);
	}
	
	@Test public void callMethodRpc() throws XmlRpcException{
		String nombre ="jose";
		Integer edad = 25;
		Object[] params = new Object[] { nombre, edad};
		Assert.assertEquals(nombre+edad, client.execute("ServiceTest.hello", params));
	
	}
	
	@Test public void callMethodRpcMap() throws XmlRpcException{
		String usuario = "user";
		String password = "password";
		HashMap<String, Object> mapa = new HashMap<String, Object>();
		List<Map<String, Object>> lista = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> subLista= new HashMap<String, Object>();
		
		subLista.put("v1", "v1-sublist");		
		subLista.put("v2", "v2-sublist");		
		subLista.put("v3", "v3-sublist");		

		mapa.put("sublist", subLista);
		
		mapa.put("campo1", "valor1");
		mapa.put("campo2", "valor2");
		mapa.put("campo3", "valor3");
		
		//agregamos el mapa a la lista
		lista.add(mapa);
		
		Object[] params = new Object[] { lista, usuario, password};
		HashMap resultMap = (HashMap) client.execute("PDVServiceTest.reciveDatosTesting", params);
		Assert.assertEquals(2, resultMap.size());
	}
	
}