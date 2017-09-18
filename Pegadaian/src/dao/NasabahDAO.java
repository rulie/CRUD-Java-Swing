/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Nasabah;

/**
 *
 * @author RuliKA
 */
public interface NasabahDAO extends GeneralDAO {
    public List<Nasabah> getAll();
    public Nasabah getById(long id);
    public Nasabah getByNama(String nama);
}
