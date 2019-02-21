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
@Table(name = "barang_gudang", catalog = "apg", schema = "")
@NamedQueries({
    @NamedQuery(name = "BarangGudang.findAll", query = "SELECT b FROM BarangGudang b")
    , @NamedQuery(name = "BarangGudang.findByIdbarangG", query = "SELECT b FROM BarangGudang b WHERE b.idbarangG = :idbarangG")
    , @NamedQuery(name = "BarangGudang.findByNamaBarang", query = "SELECT b FROM BarangGudang b WHERE b.namaBarang = :namaBarang")
    , @NamedQuery(name = "BarangGudang.findByHargaBarang", query = "SELECT b FROM BarangGudang b WHERE b.hargaBarang = :hargaBarang")
    , @NamedQuery(name = "BarangGudang.findByStock", query = "SELECT b FROM BarangGudang b WHERE b.stock = :stock")
    , @NamedQuery(name = "BarangGudang.findByTanggalPasok", query = "SELECT b FROM BarangGudang b WHERE b.tanggalPasok = :tanggalPasok")
    , @NamedQuery(name = "BarangGudang.findByIdKategori", query = "SELECT b FROM BarangGudang b WHERE b.idKategori = :idKategori")
    , @NamedQuery(name = "BarangGudang.findByIdSupplier", query = "SELECT b FROM BarangGudang b WHERE b.idSupplier = :idSupplier")})
public class BarangGudang implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_barangG")
    private String idbarangG;
    @Column(name = "nama_barang")
    private String namaBarang;
    @Column(name = "harga_barang")
    private Integer hargaBarang;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "tanggal_pasok")
    @Temporal(TemporalType.DATE)
    private Date tanggalPasok;
    @Column(name = "id_kategori")
    private String idKategori;
    @Column(name = "id_supplier")
    private String idSupplier;

    public BarangGudang() {
    }

    public BarangGudang(String idbarangG) {
        this.idbarangG = idbarangG;
    }

    public String getIdbarangG() {
        return idbarangG;
    }

    public void setIdbarangG(String idbarangG) {
        String oldIdbarangG = this.idbarangG;
        this.idbarangG = idbarangG;
        changeSupport.firePropertyChange("idbarangG", oldIdbarangG, idbarangG);
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        Integer oldStock = this.stock;
        this.stock = stock;
        changeSupport.firePropertyChange("stock", oldStock, stock);
    }

    public Date getTanggalPasok() {
        return tanggalPasok;
    }

    public void setTanggalPasok(Date tanggalPasok) {
        Date oldTanggalPasok = this.tanggalPasok;
        this.tanggalPasok = tanggalPasok;
        changeSupport.firePropertyChange("tanggalPasok", oldTanggalPasok, tanggalPasok);
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        String oldIdKategori = this.idKategori;
        this.idKategori = idKategori;
        changeSupport.firePropertyChange("idKategori", oldIdKategori, idKategori);
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        String oldIdSupplier = this.idSupplier;
        this.idSupplier = idSupplier;
        changeSupport.firePropertyChange("idSupplier", oldIdSupplier, idSupplier);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbarangG != null ? idbarangG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BarangGudang)) {
            return false;
        }
        BarangGudang other = (BarangGudang) object;
        if ((this.idbarangG == null && other.idbarangG != null) || (this.idbarangG != null && !this.idbarangG.equals(other.idbarangG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikasigudang.BarangGudang[ idbarangG=" + idbarangG + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
