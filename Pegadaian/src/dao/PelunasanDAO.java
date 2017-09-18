/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Pelunasan;

/**
 *
 * @author RuliKA
 */
public interface PelunasanDAO extends GeneralDAO {
    public List<Pelunasan> getAll();
    public Pelunasan getById(long id);
    public Pelunasan getByStatus(String status);    
}
