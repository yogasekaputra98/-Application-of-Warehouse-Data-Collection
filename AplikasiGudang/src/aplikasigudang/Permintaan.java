/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigudang;

/**
 *
 * @author yogas
 */
public class Permintaan {
    private String idBarangG;
    private String namaBrgG;
    private int hargaBrgG;
    private String stockBrgG;
    private String idKategoriG;
    private String idSupplierG;

    public Permintaan() {
    }
    
    public Permintaan(String idBarangG, String namaBrgG, int hargaBrgG, String stockBrgG, String idKategoriG, String idSupplierG) {
        this.idBarangG = idBarangG;
        this.namaBrgG = namaBrgG;
        this.hargaBrgG = hargaBrgG;
        this.stockBrgG = stockBrgG;
        this.idKategoriG = idKategoriG;
        this.idSupplierG = idSupplierG;
    }
    
    public void inputPermintaan(){   
    }
    public void ProsesPermintaan(){
    } 
    
}
