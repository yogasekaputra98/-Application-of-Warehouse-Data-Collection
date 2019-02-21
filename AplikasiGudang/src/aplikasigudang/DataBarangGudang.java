/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigudang;

import java.util.logging.Logger;

/**
 *
 * @author yogas
 */
public class DataBarangGudang extends Permintaan {
    private String idBarangG;
    private String namaBrgG;
    private int hargaBrgG;
    private String stockBrgG;
    private String idKategoriG;
    private String idSupplierG;
    
    public DataBarangGudang(){
}
    private static final Logger LOG = Logger.getLogger(DataBarangGudang.class.getName());
    

    public DataBarangGudang(String idBarangG, String namaBrgG, int hargaBrgG, String stockBrgG, String idKategoriG, String idSupplierG) {
        this.idBarangG = idBarangG;
        this.namaBrgG = namaBrgG;
        this.hargaBrgG = hargaBrgG;
        this.stockBrgG = stockBrgG;
        this.idKategoriG = idKategoriG;
        this.idSupplierG = idSupplierG;
    }

    public String getIdBarangG() {
        return idBarangG;
    }

    public void setIdBarangG(String idBarangG) {
        this.idBarangG = idBarangG;
    }

    public String getNamaBrgG() {
        return namaBrgG;
    }

    public void setNamaBrgG(String namaBrgG) {
        this.namaBrgG = namaBrgG;
    }

    public int getHargaBrgG() {
        return hargaBrgG;
    }

    /**
     *
     * @param hargaBrgG
     */
    public void setHargaBrgG(int hargaBrgG) {
        this.hargaBrgG = hargaBrgG;
    }

    public String getStockBrgG() {
        return stockBrgG;
    }

    public void setStockBrgG(String stockBrgG) {
        this.stockBrgG = stockBrgG;
    }

    public String getIdKategoriG() {
        return idKategoriG;
    }

    public void setIdKategoriG(String idKategoriG) {
        this.idKategoriG = idKategoriG;
    }

    public String getIdSupplierG() {
        return idSupplierG;
    }

    public void setIdSupplierG(String idSupplierG) {
        this.idSupplierG = idSupplierG;
    }

    @Override
    public String toString() {
        return "DataBarangGudang{" + "idBarangG=" + idBarangG + ", namaBrgG=" + namaBrgG + ", hargaBrgG=" + hargaBrgG + ", stockBrgG=" + stockBrgG + ", idKategoriG=" + idKategoriG + ", idSupplierG=" + idSupplierG + '}';
    }

}
