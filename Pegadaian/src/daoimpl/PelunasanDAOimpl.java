/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.PelunasanDAO;
import java.util.List;
import model.Pelunasan;

/**
 *
 * @author RuliKA
 */
public class PelunasanDAOimpl extends GeneralDAOimpl implements PelunasanDAO{

    @Override
    public List<Pelunasan> getAll() {
        return em.createQuery("select p from Pelunasan p").getResultList();        
    }

    @Override
    public Pelunasan getById(long id) {
        return em.find(Pelunasan.class, id);        
    }

    @Override
    public Pelunasan getByStatus(String status) {
        return (Pelunasan)em.createQuery("select p from Pelunasan p where p.statusPelunasan =?1").setParameter(1, status).getSingleResult();
    }
    
}
