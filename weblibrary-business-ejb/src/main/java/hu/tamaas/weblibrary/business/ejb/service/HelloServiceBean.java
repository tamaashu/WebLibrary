/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.business.ejb.service;

import hu.tamaas.weblibrary.business.ejb.service.interfaces.HelloService;
import javax.ejb.Stateless;

/**
 *
 * @author edi
 */
@Stateless
public class HelloServiceBean implements HelloService {

    @Override
    public String getHello(String name) {
        String result = "Hello "+name;

        return result;
    }
}
