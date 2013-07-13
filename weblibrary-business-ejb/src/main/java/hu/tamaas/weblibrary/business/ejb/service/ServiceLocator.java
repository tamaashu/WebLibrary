/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.business.ejb.service;

import hu.tamaas.weblibrary.business.ejb.service.interfaces.UserService;
import java.util.Properties;
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
    private final String CONTEXT_FACTORY = "com.sun.enterprise.naming.SerialInitContextFactory";

    public Object lookup(String jndiName) throws NamingException {
        Object result = null;
        Context context = null;
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, CONTEXT_FACTORY);
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

    public UserService getUserService() throws NamingException {
        String jndiName = UserService.BEAN_NAME + "#hu.tamaas.weblibrary.business.ejb.service.interfaces.UserService";
        UserService service = (UserService) lookup(jndiName);
        return service;
    }
}
