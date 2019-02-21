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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ControllerDataBarangGudang {
    String sql;
    public static List<DataBarangGudang> DataG;
    koneksi con = new koneksi();
    
    public ControllerDataBarangGudang() {
    }
    
    public void MelihatDataBarangGudang(){
        DataG = new ArrayList();
    }
    public void UpdatedataBarangGudang(){
        
    }
    public void CheckDataBarang(){
        
    }
    public void inputPermintaan(){ 
        
    }
    public void ProsesPermintaan(){
        
    } 

}