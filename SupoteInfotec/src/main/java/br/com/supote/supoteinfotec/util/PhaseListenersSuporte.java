
package br.com.supote.supoteinfotec.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author Marcos
 */
public class PhaseListenersSuporte implements PhaseListener{
    
    // antes da fase
    
    @Override
    public void beforePhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            System.out.println("Antes da fase"+ getPhaseId());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContexUtil.setRequestSession(session);
            
        }
    }
    
  // antes da depois
    @Override
    public void afterPhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            System.out.println("Depois da fase"+ getPhaseId());
            Session session = FacesContexUtil.getRequestSession();
            try{
                session.getTransaction().commit();
            }catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                    
                }
            }finally{
                session.close();
            }
            
        }
    }
    
    
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
    
}
