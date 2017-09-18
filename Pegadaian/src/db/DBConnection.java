/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 12345
 */
public class DBConnection {
    public static EntityManager getConnection(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PegadaianPU");
    EntityManager em = emf.createEntityManager();
    return em;
    }    
}
