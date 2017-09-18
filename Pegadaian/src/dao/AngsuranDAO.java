/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Angsuran;

/**
 *
 * @author RuliKA
 */
public interface AngsuranDAO extends GeneralDAO{
    public List<Angsuran> getAll();
    public Angsuran getById(long id);    
}
