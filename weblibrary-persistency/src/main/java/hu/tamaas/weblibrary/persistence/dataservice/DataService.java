/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.persistence.dataservice;

/**
 *
 * @author edi
 */
public interface DataService {
    public void delete(Object obj);

    public void save(Object obj);

    public void saveOrUpdate(Object obj);

    public void update(Object obj);
}
