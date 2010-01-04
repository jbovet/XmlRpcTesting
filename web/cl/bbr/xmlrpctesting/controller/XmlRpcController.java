package cl.bbr.xmlrpctesting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xmlrpc.server.XmlRpcHandlerMapping;
import org.apache.xmlrpc.webserver.XmlRpcServletServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class XmlRpcController {

	private XmlRpcServletServer xmlRpcServletServer = new XmlRpcServletServer();
	
	@Autowired
	private XmlRpcHandlerMapping mapping;
	
	@RequestMapping(value="/xmlrpcrequest")
	public void xmlHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		try {
			
			xmlRpcServletServer.setHandlerMapping(mapping);
			xmlRpcServletServer.execute(httpServletRequest,httpServletResponse);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setMapping(XmlRpcHandlerMapping mapping) {
		this.mapping = mapping;
	}
}