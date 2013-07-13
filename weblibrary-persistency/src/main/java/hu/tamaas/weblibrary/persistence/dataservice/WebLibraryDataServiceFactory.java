/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.persistence.dataservice;

import javax.persistence.EntityManager;

/**
 *
 * @author edi
 */
public class WebLibraryDataServiceFactory {
    public static UserDataServiceImpl getUserDataService(EntityManager entityManager){
        return new UserDataServiceImpl(entityManager);
    }
}
