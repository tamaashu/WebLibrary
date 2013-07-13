/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.business.ejb.service;

import hu.tamaas.weblibrary.business.ejb.service.interfaces.UserService;
import hu.tamaas.weblibrary.persistence.dataservice.UserDataService;
import hu.tamaas.weblibrary.persistence.dataservice.WebLibraryDataServiceFactory;
import hu.tamaas.weblibrary.persistence.entity.User;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author edi
 */
@Stateless//(name = UserService.BEAN_NAME, mappedName = UserService.BEAN_NAME)
@Remote
//@EJB(beanName="UserServiceBean", beanInterface=UserService.class)
public class UserServiceBean implements UserService {

    private static Logger LOG = Logger.getLogger(UserServiceBean.class);
    @PersistenceContext(unitName = "weblibrary-unit")
    private EntityManager entityManager;

    public User getUser(Long userId) {
        UserDataService userDataService = WebLibraryDataServiceFactory.getUserDataService(entityManager);
        User result = userDataService.getUser(userId);

        return result;
    }
}
