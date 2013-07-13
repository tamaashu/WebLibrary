/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.persistence.dataservice;

import hu.tamaas.weblibrary.persistence.entity.User;
import java.util.List;

/**
 *
 * @author edi
 */
public interface UserDataService extends DataService {
    
    public User getUser(Long userId);

    public User getUser(String name);

    public User getUserByEmail(String email);

    public List<User> getUserList(int startIndex, int number) throws IllegalArgumentException;
}
