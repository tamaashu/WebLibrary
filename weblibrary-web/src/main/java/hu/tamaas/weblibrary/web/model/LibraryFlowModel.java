/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.web.model;

//import hu.tamaas.weblibrary.business.ejb.service.ServiceLocator;
import hu.tamaas.weblibrary.business.ejb.service.interfaces.HelloService;
import hu.tamaas.weblibrary.persistence.entity.User;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.Logger;

/**
 *
 * @author edi
 */
@Model
@SessionScoped
public class LibraryFlowModel extends BaseFlowModel {
    
    protected boolean loaded = false;
    protected User user = null;
    protected String hello = "";

    protected static Logger LOG = Logger.getLogger(LibraryFlowModel.class);

    /*public User getUser() {
        LOG.debug("getUser begin");
        try{
            if (user == null) {
                UserService userService = null;
                try {
                    userService = (UserService) new InitialContext().lookup("hu.tamaas.weblibrary.business.ejb.service.interfaces.UserService#hu.tamaas.weblibrary.business.ejb.service.interfaces.UserService");
                } catch (NamingException ex) {
                    java.util.logging.Logger.getLogger(LibraryFlowModel.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*try {
                 userService = new ServiceLocator().getUserService();
                 setLoaded(true);
                 } catch (NamingException ex) {
                 LOG.error(ex);
                 }*/

       /*         if (userService == null) {
                    return new User();
                }

                user = userService.getUser(1L);
            }
            return user;
        }
        finally {
            LOG.debug("getUser end");
        }
    }*/
    
    public String getHello() {
        LOG.debug("getHello begin");
        try{
            if ("".equals(hello)) {
                HelloService helloService = null;
                try {
                    helloService = (HelloService) new InitialContext().lookup(HelloService.BEAN_NAME + "#" + HelloService.BEAN_NAME);
                } catch (NamingException ex) {
                    LOG.error(ex);
                }

                /*try {
                    helloService = new ServiceLocator().getHelloService();
                    setLoaded(true);
                } catch (NamingException ex) {
                    LOG.error(ex);
                }*/

                if (helloService == null) {
                    return "xXx";
                }

                hello = helloService.getHello("Tamaas");
            }
            return hello;
        }
        finally {
            LOG.debug("getHello end");
        }
    }

    /**
     * @return the loaded
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * @param loaded the loaded to set
     */
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
