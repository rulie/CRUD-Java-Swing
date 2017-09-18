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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
//@Table(name = "GADAI")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Gadai.findAll", query = "SELECT g FROM Gadai g"),
//    @NamedQuery(name = "Gadai.findById", query = "SELECT g FROM Gadai g WHERE g.id = :id"),
//    @NamedQuery(name = "Gadai.findByBeratEmas", query = "SELECT g FROM Gadai g WHERE g.beratEmas = :beratEmas"),
//    @NamedQuery(name = "Gadai.findByBunga", query = "SELECT g FROM Gadai g WHERE g.bunga = :bunga"),
//    @NamedQuery(name = "Gadai.findByHargaTafsiran", query = "SELECT g FROM Gadai g WHERE g.hargaTafsiran = :hargaTafsiran"),
//    @NamedQuery(name = "Gadai.findByJmlAngsuran", query = "SELECT g FROM Gadai g WHERE g.jmlAngsuran = :jmlAngsuran"),
//    @NamedQuery(name = "Gadai.findByJmlKarat", query = "SELECT g FROM Gadai g WHERE g.jmlKarat = :jmlKarat"),
//    @NamedQuery(name = "Gadai.findByJmlPinjaman", query = "SELECT g FROM Gadai g WHERE g.jmlPinjaman = :jmlPinjaman"),
//    @NamedQuery(name = "Gadai.findByKodeGadai", query = "SELECT g FROM Gadai g WHERE g.kodeGadai = :kodeGadai"),
//    @NamedQuery(name = "Gadai.findByLamaAngsuran", query = "SELECT g FROM Gadai g WHERE g.lamaAngsuran = :lamaAngsuran"),
//    @NamedQuery(name = "Gadai.findByStatus", query = "SELECT g FROM Gadai g WHERE g.status = :status"),
//    @NamedQuery(name = "Gadai.findByTotalTebusan", query = "SELECT g FROM Gadai g WHERE g.totalTebusan = :totalTebusan")})
public class Gadai implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Basic(optional = false)
//    @Column(name = "ID")
    private Long id;
//    @Column(name = "BERAT_EMAS")
    private int beratEmas;
//    @Column(name = "BUNGA")
    private int bunga;
//    @Column(name = "HARGA_TAFSIRAN")
    private Double hargaTafsiran;
//    @Column(name = "JML_ANGSURAN")
    private Double jmlAngsuran;
//    @Column(name = "JML_KARAT")
    private int jmlKarat;
//    @Column(name = "JML_PINJAMAN")
    private Double jmlPinjaman;
//    @Column(name = "KODE_GADAI")
    private String kodeGadai;
//    @Column(name = "LAMA_ANGSURAN")
    private int lamaAngsuran;
//    @Column(name = "STATUS")
    private String status;
//    @Lob
//    @Column(name = "TGL_GADAI")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglGadai;
//    @Lob
//    @Column(name = "TGL_JATUH_TEMPO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglJatuhTempo;
//    @Column(name = "TOTAL_TEBUSAN")
    private Double totalTebusan;
//    @JoinColumn(name = "NASABAH_ID", referencedColumnName = "ID")
//    @ManyToOne
//    private Nasabah nasabahId;
//    @OneToMany(mappedBy = "gadaiId")
//    private List<Angsuran> angsuranList;
    @ManyToOne
    private Nasabah nasabah;

    public Gadai() {
    }

    public Gadai(Long id) {
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

    public int getBeratEmas() {
        return beratEmas;
    }

    public void setBeratEmas(int beratEmas) {
        int oldBeratEmas = this.beratEmas;
        this.beratEmas = beratEmas;
        changeSupport.firePropertyChange("beratEmas", oldBeratEmas, beratEmas);
    }

    public int getBunga() {
        return bunga;
    }

    public void setBunga(int bunga) {
        int oldBunga = this.bunga;
        this.bunga = bunga;
        changeSupport.firePropertyChange("bunga", oldBunga, bunga);
    }

    public Double getHargaTafsiran() {
        return hargaTafsiran;
    }

    public void setHargaTafsiran(Double hargaTafsiran) {
        Double oldHargaTafsiran = this.hargaTafsiran;
        this.hargaTafsiran = hargaTafsiran;
        changeSupport.firePropertyChange("hargaTafsiran", oldHargaTafsiran, hargaTafsiran);
    }

    public Double getJmlAngsuran() {
        return jmlAngsuran;
    }

    public void setJmlAngsuran(Double jmlAngsuran) {
        Double oldJmlAngsuran = this.jmlAngsuran;
        this.jmlAngsuran = jmlAngsuran;
        changeSupport.firePropertyChange("jmlAngsuran", oldJmlAngsuran, jmlAngsuran);
    }

    public int getJmlKarat() {
        return jmlKarat;
    }

    public void setJmlKarat(int jmlKarat) {
        int oldJmlKarat = this.jmlKarat;
        this.jmlKarat = jmlKarat;
        changeSupport.firePropertyChange("jmlKarat", oldJmlKarat, jmlKarat);
    }

    public Double getJmlPinjaman() {
        return jmlPinjaman;
    }

    public void setJmlPinjaman(Double jmlPinjaman) {
        Double oldJmlPinjaman = this.jmlPinjaman;
        this.jmlPinjaman = jmlPinjaman;
        changeSupport.firePropertyChange("jmlPinjaman", oldJmlPinjaman, jmlPinjaman);
    }

    public String getKodeGadai() {
        return kodeGadai;
    }

    public void setKodeGadai(String kodeGadai) {
        String oldKodeGadai = this.kodeGadai;
        this.kodeGadai = kodeGadai;
        changeSupport.firePropertyChange("kodeGadai", oldKodeGadai, kodeGadai);
    }

    public int getLamaAngsuran() {
        return lamaAngsuran;
    }

    public void setLamaAngsuran(int lamaAngsuran) {
        int oldLamaAngsuran = this.lamaAngsuran;
        this.lamaAngsuran = lamaAngsuran;
        changeSupport.firePropertyChange("lamaAngsuran", oldLamaAngsuran, lamaAngsuran);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Serializable getTglGadai() {
        return tglGadai;
    }

    public void setTglGadai(Date tglGadai) {
        Date oldTglGadai = this.tglGadai;
        this.tglGadai = tglGadai;
        changeSupport.firePropertyChange("tglGadai", oldTglGadai, tglGadai);
    }

    public Serializable getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Date tglJatuhTempo) {
        Date oldTglJatuhTempo = this.tglJatuhTempo;
        this.tglJatuhTempo = tglJatuhTempo;
        changeSupport.firePropertyChange("tglJatuhTempo", oldTglJatuhTempo, tglJatuhTempo);
    }

    public Double getTotalTebusan() {
        return totalTebusan;
    }

    public void setTotalTebusan(Double totalTebusan) {
        Double oldTotalTebusan = this.totalTebusan;
        this.totalTebusan = totalTebusan;
        changeSupport.firePropertyChange("totalTebusan", oldTotalTebusan, totalTebusan);
    }

//    public Nasabah getNasabahId() {
//        return nasabahId;
//    }
//
//    public void setNasabahId(Nasabah nasabahId) {
//        this.nasabahId = nasabahId;
//    }
//
//    @XmlTransient
//    public List<Angsuran> getAngsuranList() {
//        return angsuranList;
//    }
//
//    public void setAngsuranList(List<Angsuran> angsuranList) {
//        this.angsuranList = angsuranList;
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
        if (!(object instanceof Gadai)) {
            return false;
        }
        Gadai other = (Gadai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Gadai[ id=" + id + " ]";
    }

    /**
     * @return the nasabah
     */
    public Nasabah getNasabah() {
        return nasabah;
    }

    /**
     * @param nasabah the nasabah to set
     */
    public void setNasabah(Nasabah nasabah) {
        Nasabah oldNasabah = this.nasabah;
        this.nasabah = nasabah;
        changeSupport.firePropertyChange("nasabah", oldNasabah, nasabah);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
