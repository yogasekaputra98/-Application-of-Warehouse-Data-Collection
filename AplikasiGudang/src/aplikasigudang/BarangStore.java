/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigudang;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author yogas
 */
@Entity
@Table(name = "barang_store", catalog = "apg", schema = "")
@NamedQueries({
    @NamedQuery(name = "BarangStore.findAll", query = "SELECT b FROM BarangStore b")
    , @NamedQuery(name = "BarangStore.findByIdbarangS", query = "SELECT b FROM BarangStore b WHERE b.idbarangS = :idbarangS")
    , @NamedQuery(name = "BarangStore.findByNamaBarang", query = "SELECT b FROM BarangStore b WHERE b.namaBarang = :namaBarang")
    , @NamedQuery(name = "BarangStore.findByHargaBarang", query = "SELECT b FROM BarangStore b WHERE b.hargaBarang = :hargaBarang")
    , @NamedQuery(name = "BarangStore.findByTanggalPasok", query = "SELECT b FROM BarangStore b WHERE b.tanggalPasok = :tanggalPasok")
    , @NamedQuery(name = "BarangStore.findByStok", query = "SELECT b FROM BarangStore b WHERE b.stok = :stok")})
public class BarangStore implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_barangS")
    private String idbarangS;
    @Column(name = "nama_barang")
    private String namaBarang;
    @Column(name = "harga_barang")
    private Integer hargaBarang;
    @Column(name = "tanggal_pasok")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalPasok;
    @Column(name = "stok")
    private Integer stok;

    public BarangStore() {
    }

    public BarangStore(String idbarangS) {
        this.idbarangS = idbarangS;
    }

    public String getIdbarangS() {
        return idbarangS;
    }

    public void setIdbarangS(String idbarangS) {
        String oldIdbarangS = this.idbarangS;
        this.idbarangS = idbarangS;
        changeSupport.firePropertyChange("idbarangS", oldIdbarangS, idbarangS);
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        String oldNamaBarang = this.namaBarang;
        this.namaBarang = namaBarang;
        changeSupport.firePropertyChange("namaBarang", oldNamaBarang, namaBarang);
    }

    public Integer getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(Integer hargaBarang) {
        Integer oldHargaBarang = this.hargaBarang;
        this.hargaBarang = hargaBarang;
        changeSupport.firePropertyChange("hargaBarang", oldHargaBarang, hargaBarang);
    }

    public Date getTanggalPasok() {
        return tanggalPasok;
    }

    public void setTanggalPasok(Date tanggalPasok) {
        Date oldTanggalPasok = this.tanggalPasok;
        this.tanggalPasok = tanggalPasok;
        changeSupport.firePropertyChange("tanggalPasok", oldTanggalPasok, tanggalPasok);
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        Integer oldStok = this.stok;
        this.stok = stok;
        changeSupport.firePropertyChange("stok", oldStok, stok);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbarangS != null ? idbarangS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BarangStore)) {
            return false;
        }
        BarangStore other = (BarangStore) object;
        if ((this.idbarangS == null && other.idbarangS != null) || (this.idbarangS != null && !this.idbarangS.equals(other.idbarangS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikasigudang.BarangStore[ idbarangS=" + idbarangS + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
