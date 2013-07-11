/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.web.model;

import hu.tamaas.weblibrary.db.entities.User;
import hu.tamaas.weblibrary.db.services.UserDataService;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import org.apache.log4j.Logger;

/**
 *
 * @author edi
 */
@Model
@SessionScoped
public class LibraryFlowModel extends BaseFlowModel {
    protected static Logger LOG = Logger.getLogger(LibraryFlowModel.class); 
    
    public User getUser() {
        User user = UserDataService.getInstance().getUser(1L);
        return user;
    }
}
