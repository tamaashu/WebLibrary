/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.web.model;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import org.apache.log4j.Logger;

/**
 *
 * @author edi
 */
@Model
@SessionScoped
public class PropertyModel extends BaseModel {
    protected static Logger LOG = Logger.getLogger(PropertyModel.class); 
}
