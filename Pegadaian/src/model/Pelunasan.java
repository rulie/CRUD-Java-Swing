/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RuliKA
 */
@Entity
//@Table(name = "PELUNASAN")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Pelunasan.findAll", query = "SELECT p FROM Pelunasan p"),
//    @NamedQuery(name = "Pelunasan.findById", query = "SELECT p FROM Pelunasan p WHERE p.id = :id"),
//    @NamedQuery(name = "Pelunasan.findByJmlPelunasan", query = "SELECT p FROM Pelunasan p WHERE p.jmlPelunasan = :jmlPelunasan"),
//    @NamedQuery(name = "Pelunasan.findByKodePelunasan", query = "SELECT p FROM Pelunasan p WHERE p.kodePelunasan = :kodePelunasan"),
//    @NamedQuery(name = "Pelunasan.findByStatusPelunasan", query = "SELECT p FROM Pelunasan p WHERE p.statusPelunasan = :statusPelunasan")})
public class Pelunasan implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Basic(optional = false)
//    @Column(name = "ID")
    private Long id;
//    @Column(name = "JML_PELUNASAN")
    private Long jmlPelunasan;
//    @Column(name = "KODE_PELUNASAN")
    private String kodePelunasan;
//    @Column(name = "STATUS_PELUNASAN")
    private String statusPelunasan;
//    @Lob
//    @Column(name = "TGL_PELUNASAN")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglPelunasan;
//    @JoinColumn(name = "NASABAH_ID", referencedColumnName = "ID")

//    @ManyToOne
//    private Nasabah nasabahId;
    
    @ManyToOne
    private Nasabah nasabahId;

    public Pelunasan() {
    }

    public Pelunasan(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Long getJmlPelunasan() {
        return jmlPelunasan;
    }

    public void setJmlPelunasan(Long jmlPelunasan) {
        Long oldJmlPelunasan = this.jmlPelunasan;
        this.jmlPelunasan = jmlPelunasan;
        changeSupport.firePropertyChange("jmlPelunasan", oldJmlPelunasan, jmlPelunasan);
    }

    public String getKodePelunasan() {
        return kodePelunasan;
    }

    public void setKodePelunasan(String kodePelunasan) {
        String oldKodePelunasan = this.kodePelunasan;
        this.kodePelunasan = kodePelunasan;
        changeSupport.firePropertyChange("kodePelunasan", oldKodePelunasan, kodePelunasan);
    }

    public String getStatusPelunasan() {
        return statusPelunasan;
    }

    public void setStatusPelunasan(String statusPelunasan) {
        String oldStatusPelunasan = this.statusPelunasan;
        this.statusPelunasan = statusPelunasan;
        changeSupport.firePropertyChange("statusPelunasan", oldStatusPelunasan, statusPelunasan);
    }

    public Date getTglPelunasan() {
        return tglPelunasan;
    }

    public void setTglPelunasan(Date tglPelunasan) {
        Date oldTglPelunasan = this.tglPelunasan;
        this.tglPelunasan = tglPelunasan;
        changeSupport.firePropertyChange("tglPelunasan", oldTglPelunasan, tglPelunasan);
    }

//    public Nasabah getNasabahId() {
//        return nasabahId;
//    }
//
//    public void setNasabahId(Nasabah nasabahId) {
//        this.nasabahId = nasabahId;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelunasan)) {
            return false;
        }
        Pelunasan other = (Pelunasan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Pelunasan[ id=" + id + " ]";
    }

    /**
     * @return the nasabah
     */
    public Nasabah getNasabah() {
        return nasabahId;
    }

    /**
     * @param nasabah the nasabah to set
     */
    public void setNasabah(Nasabah nasabah) {
        Nasabah oldNasabah = this.nasabahId;
        this.nasabahId = nasabah;
        changeSupport.firePropertyChange("nasabah", oldNasabah, nasabah);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
