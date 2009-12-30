package cl.bbr.xmlrpctesting.handlermapping;

import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.server.RequestProcessorFactoryFactory;

public class SimpleRequestProcessorFactoryFactory implements RequestProcessorFactoryFactory {
    private Map<Class, Object> serviceBeans = new HashMap<Class, Object>();

    public RequestProcessorFactory getRequestProcessorFactory(Class pClass) throws XmlRpcException {
        // Obtener el bean desde el Map
        final Object serviceBean = serviceBeans.get(pClass);

        // es nulo?
        if (serviceBean == null) {
            throw new XmlRpcException("Handler " + pClass.getCanonicalName() + " no encontrado.");
        }

        // creacion del factory
        return new RequestProcessorFactory() {
            public Object getRequestProcessor(XmlRpcRequest pRequest) throws XmlRpcException {
                return serviceBean;
            }
        };
    }

    public void registerServiceBean(Class clazz, Object serviceBean) {
    	serviceBeans.put(clazz, serviceBean);
    }
}