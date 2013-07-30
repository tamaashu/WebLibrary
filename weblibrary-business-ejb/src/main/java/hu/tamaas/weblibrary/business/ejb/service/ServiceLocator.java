/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.business.ejb.service;

import hu.tamaas.weblibrary.business.ejb.service.interfaces.HelloService;
import java.util.Properties;
//import hu.tamaas.weblibrary.business.ejb.service.interfaces.UserService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.Logger;

/**
 *
 * @author edi
 */
public class ServiceLocator {

    private static Logger LOG = Logger.getLogger(UserServiceBean.class);

    public Object lookup(String jndiName) throws NamingException {
        Object result = null;
        Context context = null;
        try {
            Properties props = new Properties();
            /*props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            // optional.  Defaults to localhost.  Only needed if web server is running  
            // on a different host than the appserver     
            props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");*/
            context = new InitialContext(props);
            result = context.lookup(jndiName);
        } catch (NamingException ex) {
            LOG.error("lookup of jndiName='" + jndiName + " failed with " + ex.getMessage(), ex);
            throw ex;
        } finally {
            if (context != null) {
                try {
                    context.close();
                } catch (NamingException ex) {
                    LOG.error("close of context after lookup of jndiName='" + jndiName + " failed with " + ex.getMessage(), ex);
                    throw ex;
                }
            }
        }
        return result;
    }

    /*  public UserService getUserService() throws NamingException {
     String jndiName = UserService.BEAN_NAME + "#" + UserService.BEAN_NAME;
     UserService service = (UserService) lookup(jndiName);
     return service;
     }
     */
    public HelloService getHelloService() throws NamingException {
        String jndiName = HelloService.BEAN_NAME + "#" + HelloService.BEAN_NAME;
        HelloService service = (HelloService) lookup(jndiName);
        return service;
    }
}
