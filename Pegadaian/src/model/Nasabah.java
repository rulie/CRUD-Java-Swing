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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 12345
 */
@Entity
//@Table(name = "NASABAH")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Nasabah.findAll", query = "SELECT n FROM Nasabah n"),
//    @NamedQuery(name = "Nasabah.findById", query = "SELECT n FROM Nasabah n WHERE n.id = :id"),
//    @NamedQuery(name = "Nasabah.findByAlamat", query = "SELECT n FROM Nasabah n WHERE n.alamat = :alamat"),
//    @NamedQuery(name = "Nasabah.findByHp", query = "SELECT n FROM Nasabah n WHERE n.hp = :hp"),
//    @NamedQuery(name = "Nasabah.findByNamaNasabah", query = "SELECT n FROM Nasabah n WHERE n.namaNasabah = :namaNasabah"),
//    @NamedQuery(name = "Nasabah.findByNoKtp", query = "SELECT n FROM Nasabah n WHERE n.noKtp = :noKtp")})
public class Nasabah implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Basic(optional = false)
//    @Column(name = "ID")
    private Long id;
//    @Column(name = "ALAMAT")
    private String alamat;
//    @Column(name = "HP")
    private String hp;
//    @Column(name = "NAMA_NASABAH")
    private String namaNasabah;
//    @Column(name = "NO_KTP")
    private String noKtp;
//    @Lob
//    @Column(name = "TGL_DAFTAR")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglDaftar;
//    @OneToMany(mappedBy = "nasabahId")
//    private List<Gadai> gadaiList;
//    @OneToMany(mappedBy = "nasabahId")
//    private List<Pelunasan> pelunasanList;

    public Nasabah() {
    }

    public Nasabah(Long id) {
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        String oldAlamat = this.alamat;
        this.alamat = alamat;
        changeSupport.firePropertyChange("alamat", oldAlamat, alamat);
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        String oldHp = this.hp;
        this.hp = hp;
        changeSupport.firePropertyChange("hp", oldHp, hp);
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        String oldNamaNasabah = this.namaNasabah;
        this.namaNasabah = namaNasabah;
        changeSupport.firePropertyChange("namaNasabah", oldNamaNasabah, namaNasabah);
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        String oldNoKtp = this.noKtp;
        this.noKtp = noKtp;
        changeSupport.firePropertyChange("noKtp", oldNoKtp, noKtp);
    }

    public Date getTglDaftar() {
        return tglDaftar;
    }

    public void setTglDaftar(Date tglDaftar) {
        Date oldTglDaftar = this.tglDaftar;
        this.tglDaftar = tglDaftar;
        changeSupport.firePropertyChange("tglDaftar", oldTglDaftar, tglDaftar);
    }

//    @XmlTransient
//    public List<Gadai> getGadaiList() {
//        return gadaiList;
//    }
//
//    public void setGadaiList(List<Gadai> gadaiList) {
//        this.gadaiList = gadaiList;
//    }
//
//    @XmlTransient
//    public List<Pelunasan> getPelunasanList() {
//        return pelunasanList;
//    }
//
//    public void setPelunasanList(List<Pelunasan> pelunasanList) {
//        this.pelunasanList = pelunasanList;
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
        if (!(object instanceof Nasabah)) {
            return false;
        }
        Nasabah other = (Nasabah) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Nasabah[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
