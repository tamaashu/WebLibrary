/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.business.ejb.service.interfaces;

import javax.ejb.Remote;

/**
 *
 * @author edi
 */
@Remote
public interface HelloService {
    
    public static final String BEAN_NAME = HelloService.class.getName();
    
    public String getHello(String name);
}
