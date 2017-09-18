/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Gadai;

/**
 *
 * @author RuliKA
 */
public interface GadaiDAO extends GeneralDAO{
    public List<Gadai> getAll();
    public Gadai getById(long id);    
}
