
package br.com.supote.supoteinfotec.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author Marcos
 */
public class FacesContexUtil {
    private static final String HIBERNATE_SESSION = "hibernate_session";

    public static void setRequestSession(Session session){
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION,session);
    }
    
    public static Session getRequestSession() {
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    }
}
