/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tamaas.weblibrary.web.model;

import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import org.apache.log4j.Logger;

/**
 *
 * @author edi
 */
@Model
@SessionScoped
public class LocaleModel extends BaseModel {
    protected static Logger LOG = Logger.getLogger(LocaleModel.class); 
    
    private Locale locale = Locale.ENGLISH;

    /**
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
}
