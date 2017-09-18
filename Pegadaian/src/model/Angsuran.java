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
 * @author 12345
 */
@Entity
//@Table(name = "ANGSURAN")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Angsuran.findAll", query = "SELECT a FROM Angsuran a"),
//    @NamedQuery(name = "Angsuran.findById", query = "SELECT a FROM Angsuran a WHERE a.id = :id"),
//    @NamedQuery(name = "Angsuran.findByKodeAngsuran", query = "SELECT a FROM Angsuran a WHERE a.kodeAngsuran = :kodeAngsuran")})
public class Angsuran implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Basic(optional = false)
//    @Column(name = "ID")
    private Long id;
//    @Column(name = "KODE_ANGSURAN")
    private String kodeAngsuran;
//    @Lob
//    @Column(name = "TGL_ANGSURAN")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglAngsuran;
//    @JoinColumn(name = "GADAI_ID", referencedColumnName = "ID")
//    @ManyToOne
//    private Gadai gadaiId;
    @ManyToOne
    private Gadai gadai;

    public Angsuran() {
    }

    public Angsuran(Long id) {
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

    public String getKodeAngsuran() {
        return kodeAngsuran;
    }

    public void setKodeAngsuran(String kodeAngsuran) {
        String oldKodeAngsuran = this.kodeAngsuran;
        this.kodeAngsuran = kodeAngsuran;
        changeSupport.firePropertyChange("kodeAngsuran", oldKodeAngsuran, kodeAngsuran);
    }

    public Date getTglAngsuran() {
        return tglAngsuran;
    }

    public void setTglAngsuran(Date tglAngsuran) {
        Date oldTglAngsuran = this.tglAngsuran;
        this.tglAngsuran = tglAngsuran;
        changeSupport.firePropertyChange("tglAngsuran", oldTglAngsuran, tglAngsuran);
    }

//    public Gadai getGadaiId() {
//        return gadaiId;
//    }
//
//    public void setGadaiId(Gadai gadaiId) {
//        this.gadaiId = gadaiId;
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
        if (!(object instanceof Angsuran)) {
            return false;
        }
        Angsuran other = (Angsuran) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Angsuran[ id=" + id + " ]";
    }

    /**
     * @return the gadai
     */
    public Gadai getGadai() {
        return gadai;
    }

    /**
     * @param gadai the gadai to set
     */
    public void setGadai(Gadai gadai) {
        Gadai oldGadai = this.gadai;
        this.gadai = gadai;
        changeSupport.firePropertyChange("gadai", oldGadai, gadai);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
