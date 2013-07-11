/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.db.services;

import hu.tamaas.weblibrary.db.entities.User;
import static hu.tamaas.weblibrary.db.services.DataService.entityManager;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author tamaas
 */
public class UserDataService extends DataService {

    protected static final Logger LOG = Logger.getLogger(UserDataService.class);
    protected static UserDataService dataService;

    public static UserDataService getInstance() {
        if (dataService == null) {
            dataService = new UserDataService();
        }
        return dataService;
    }

    protected UserDataService() {
    }

    public User getUser(Long userId) {
        User user = null;
        Query q = entityManager.createQuery("FROM User WHERE userId=:userid1");
        q.setParameter("userid1", userId);
        q.setMaxResults(1);
        user = (User) q.getSingleResult();
        return user;
    }

    public User getUser(String name) {
        User user = null;
        Query q = entityManager.createQuery("FROM User WHERE name=:name1");
        q.setParameter("name1", name);
        q.setMaxResults(1);
        user = (User) q.getSingleResult();
        return user;
    }

    public User getUserByEmail(String email) {
        User user = null;
        Query q = entityManager.createQuery("FROM User WHERE email=:email1");
        q.setParameter("email1", email);
        q.setMaxResults(1);
        user = (User) q.getSingleResult();
        return user;
    }

    public List getUserList(int startIndex, int number) throws IllegalArgumentException {
        List users = null;
        if (startIndex < 0 || number < 0) {
            throw new IllegalArgumentException();
        }
        Query q = entityManager.createQuery("FROM User AS u order BY u.name");
        q.setMaxResults(number);
        users = q.getResultList();
        return users;
    }
}
