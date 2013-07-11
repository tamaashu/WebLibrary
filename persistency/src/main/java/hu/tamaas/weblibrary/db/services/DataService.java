/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.db.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author tamaas
 */
public abstract class DataService {

    protected static final Logger LOG = Logger.getLogger(DataService.class);
    @PersistenceContext
    protected static final EntityManagerFactory entityManagerFactory;
    protected static final EntityManager entityManager;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("weblibrary-unit");
            entityManager = entityManagerFactory.createEntityManager();
        } catch (Throwable e) {
            LOG.error("Error in creating EntityManager object." + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public synchronized void delete(Object obj) {
        entityManager.remove(obj);
    }

    public synchronized void save(Object obj) {
        entityManager.persist(obj);
    }

    public synchronized void saveOrUpdate(Object obj) {
        entityManager.persist(obj);
    }

    public synchronized void update(Object obj) {
        entityManager.persist(obj);
    }
}
