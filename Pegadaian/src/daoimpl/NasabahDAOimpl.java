/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.NasabahDAO;
import java.util.List;
import model.Nasabah;

/**
 *
 * @author RuliKA
 */
public class NasabahDAOimpl extends GeneralDAOimpl implements NasabahDAO{

    @Override
    public List<Nasabah> getAll() {
        return em.createQuery("select n from Nasabah n").getResultList();        
    }

    @Override
    public Nasabah getById(long id) {
        return em.find(Nasabah.class, id);
    }

    @Override
    public Nasabah getByNama(String nama) {
        return (Nasabah)em.createQuery("select n from Nasabah n where n.namaNasabah =?1").setParameter(1, nama).getSingleResult();
    }
    
}
