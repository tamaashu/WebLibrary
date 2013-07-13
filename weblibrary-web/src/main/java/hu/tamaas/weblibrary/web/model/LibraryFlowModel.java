/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.web.model;

import hu.tamaas.weblibrary.business.ejb.service.interfaces.UserService;
import hu.tamaas.weblibrary.persistence.entity.User;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import org.apache.log4j.Logger;

/**
 *
 * @author edi
 */
@Model
@SessionScoped
public class LibraryFlowModel extends BaseFlowModel {

    protected static Logger LOG = Logger.getLogger(LibraryFlowModel.class);
    //TODO fix EJB injection 
    //@EJB(name="java:global/business/UserServiceBean", beanInterface=UserService.class)
    @EJB
    UserService userService;

    public User getUser() {
        /*UserService userService = null;
        try {
            userService = (UserService) new InitialContext().lookup("java:global/weblibrary-business-ear/UserServiceBean");
        } catch (NamingException ex) {
            java.util.logging.Logger.getLogger(LibraryFlowModel.class.getName()).log(Level.SEVERE, null, ex);
        }*
        
        /*try {
            userService = new ServiceLocator().getUserService();
        } catch (NamingException ex) {
            LOG.error(ex);
        }
        
        if (userService == null) {
            return new User();
        }*/
        
        User user = userService.getUser(1L);
        return user;
    }
}
