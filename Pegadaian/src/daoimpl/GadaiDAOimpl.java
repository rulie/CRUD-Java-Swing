/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.GadaiDAO;
import java.util.List;
import model.Gadai;

/**
 *
 * @author RuliKA
 */
public class GadaiDAOimpl extends GeneralDAOimpl implements GadaiDAO{

    @Override
    public List<Gadai> getAll() {
        return em.createQuery("select g from Gadai g").getResultList();
    }

    @Override
    public Gadai getById(long id) {
        return em.find(Gadai.class, id);
    }
    
}
