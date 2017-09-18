/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.GeneralDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author RuliKA
 */
public class GeneralDAOimpl implements GeneralDAO{
    
    EntityManager em;
    
        
    public GeneralDAOimpl(){
        em = db.DBConnection.getConnection();
    }

    @Override
    public void insert(Object o) {
        try{
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Object o) {
        try{
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Object o) {
        try{
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void refresh(Object o) {
        em.getTransaction().rollback();
        em.getTransaction().begin();
    }
    
}
