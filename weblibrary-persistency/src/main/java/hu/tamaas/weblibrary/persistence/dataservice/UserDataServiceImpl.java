/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.persistence.dataservice;

import hu.tamaas.weblibrary.persistence.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author tamaas
 */
public class UserDataServiceImpl extends DataServiceImpl implements UserDataService {

    protected static final Logger LOG = Logger.getLogger(UserDataServiceImpl.class);

    public UserDataServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public User getUser(Long userId) {
        User user;
        Query q = entityManager.createQuery("FROM User WHERE userId=:userid1");
        q.setParameter("userid1", userId);
        q.setMaxResults(1);
        user = (User) q.getSingleResult();
        return user;
    }

    public User getUser(String name) {
        User user;
        Query q = entityManager.createQuery("FROM User WHERE name=:name1");
        q.setParameter("name1", name);
        q.setMaxResults(1);
        user = (User) q.getSingleResult();
        return user;
    }

    public User getUserByEmail(String email) {
        User user;
        Query q = entityManager.createQuery("FROM User WHERE email=:email1");
        q.setParameter("email1", email);
        q.setMaxResults(1);
        user = (User) q.getSingleResult();
        return user;
    }

    public List<User> getUserList(int startIndex, int number) throws IllegalArgumentException {
        List<User> users;
        if (startIndex < 0 || number < 0) {
            throw new IllegalArgumentException();
        }
        Query q = entityManager.createQuery("FROM User AS u order BY u.name");
        q.setMaxResults(number);
        users = q.getResultList();
        return users;
    }
}
