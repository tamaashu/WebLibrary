/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.persistence.dataservice;

import javax.persistence.EntityManager;
import org.apache.log4j.Logger;

/**
 *
 * @author tamaas
 */
public abstract class DataServiceImpl implements DataService {

    protected static final Logger LOG = Logger.getLogger(DataServiceImpl.class);

    protected EntityManager entityManager;

    public DataServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public synchronized void delete(Object obj) {
        entityManager.remove(obj);
    }

    public synchronized void save(Object obj) {
        entityManager.persist(obj);
        entityManager.flush();
    }

    public synchronized void saveOrUpdate(Object obj) {
        entityManager.persist(obj);
        entityManager.flush();
    }

    public synchronized void update(Object obj) {
        entityManager.persist(obj);
        entityManager.flush();
    }
}
