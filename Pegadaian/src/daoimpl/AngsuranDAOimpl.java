/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.AngsuranDAO;
import java.util.List;
import model.Angsuran;

/**
 *
 * @author RuliKA
 */
public class AngsuranDAOimpl extends GeneralDAOimpl implements AngsuranDAO{

    @Override
    public List<Angsuran> getAll() {
        return em.createQuery("select a from angsuran a").getResultList();
    }

    @Override
    public Angsuran getById(long id) {
        return em.find(Angsuran.class, id);
    }
    
}
