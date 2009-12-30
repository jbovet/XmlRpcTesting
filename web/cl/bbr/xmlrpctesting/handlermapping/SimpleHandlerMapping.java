package cl.bbr.xmlrpctesting.handlermapping;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.AbstractReflectiveHandlerMapping;
import org.springframework.util.Assert;

public class SimpleHandlerMapping extends AbstractReflectiveHandlerMapping {
    public void setServices(Map<String, Object> services) throws XmlRpcException {
        // Comprobar parametros
        Assert.notNull(services, "No debería ser nulo.");

        //  RequestProcessorFactoryFactory
        SimpleRequestProcessorFactoryFactory factory = new SimpleRequestProcessorFactoryFactory();

        // registrar los service bean con el factory
        for (Object serviceBean : services.values()) {
        	factory.registerServiceBean(serviceBean.getClass(), serviceBean);
        }

        // Setear RequestFactoryFactory que sera  usado por el mapping
        setRequestProcessorFactoryFactory(factory);

        Iterator<Entry<String, Object>> it = services.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            String serviceName = entry.getKey();
            Object serviceBean = entry.getValue();
            registerPublicMethods(serviceName, serviceBean.getClass());
        }
    }
}