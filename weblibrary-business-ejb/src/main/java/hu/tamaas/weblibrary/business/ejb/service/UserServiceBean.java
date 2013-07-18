/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.business.ejb.service;

import hu.tamaas.weblibrary.business.ejb.service.interfaces.UserService;
import hu.tamaas.weblibrary.persistence.dataservice.UserDataService;
import hu.tamaas.weblibrary.persistence.dataservice.WebLibraryDataServiceFactory;
import hu.tamaas.weblibrary.persistence.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author edi
 */
@Stateless//(name="UserServiceBean", mappedName = UserService.BEAN_NAME)
public class UserServiceBean implements UserService {

    @PersistenceContext(unitName = "weblibrary-unit")
    private EntityManager entityManager;

    public User getUser(Long userId) {
        UserDataService userDataService = WebLibraryDataServiceFactory.getUserDataService(entityManager);
        User result = userDataService.getUser(userId);

        return result;
    }
}
