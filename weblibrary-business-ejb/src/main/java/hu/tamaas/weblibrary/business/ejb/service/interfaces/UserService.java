/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.business.ejb.service.interfaces;

import hu.tamaas.weblibrary.persistence.entity.User;
import javax.ejb.Remote;

/**
 *
 * @author edi
 */
@Remote
public interface UserService {
    
    public static final String BEAN_NAME = "ejb/UserServiceBean";
    
    public User getUser(Long userId);
}
