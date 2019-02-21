/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigudang;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yogas
 */
public class beranda extends javax.swing.JFrame {
    Connection con;
    Statement st,st1;
    ResultSet rs,rs1;
    String sql,sql1,idbarang,nmbarang,hrg;

    
    /**
     * Creates new form beranda
     */
    public beranda() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        st = DB.stm;
        ShowDataStore();
        ShowPermintaanStore();
        ShowPermintaanGudang();
        ShowDataStoreKurang15();
    }
    
    private void ShowPermintaanStore(){
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn ("No");
        data.addColumn ("Id Barang");
        data.addColumn ("Nama Barang");
        data.addColumn ("Jumlah");
        try{    
            int i = 1;
            st=con.createStatement();
            rs=st.executeQuery("SELECT p.id_barang,b.nama_barang, p.jumlah FROM permintaan p JOIN barang_gudang b ON b.id_barangG = p.id_barang JOIN user u ON p.id_user = u.id_user JOIN job j ON j.id_job = u.id_job WHERE j.id_job ='J003'");
            while (rs.next())
                data.addRow(new Object[]{
                (""+i++),
                    rs.getString(1), rs.getString(2),
                    rs.getString(3)
                });
            TablePermintaanStore1.setModel(data);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }  
    }
    private void ShowPermintaanGudang(){
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn ("No");
        data.addColumn ("Id Barang");
        data.addColumn ("Nama Barang");
        data.addColumn ("Jumlah");
        try{    
            int i = 1;
            st=con.createStatement();
            rs=st.executeQuery("SELECT p.id_barang,b.nama_barang, p.jumlah FROM permintaan p JOIN barang_gudang b ON b.id_barangG = p.id_barang JOIN user u ON p.id_user = u.id_user JOIN job j ON j.id_job = u.id_job WHERE j.id_job ='J002'");
            while (rs.next())
                data.addRow(new Object[]{
                (""+i++),
                    rs.getString(1), rs.getString(2),
                    rs.getString(3)
                });
            TablePermintaanGudang.setModel(data);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }  
    }
    private void ShowDataStoreKurang15(){
        DefaultTableModel data1 = new DefaultTableModel();
        data1.addColumn ("No");
        data1.addColumn ("Id Barang");
        data1.addColumn ("Nama Barang");
        data1.addColumn ("stok");
        
        try{    
            int i = 1;
            st=con.createStatement();
            rs=st.executeQuery("select id_barangS, nama_barang, stok from barang_store where stok <= 15");
            while (rs.next())
                data1.addRow(new Object[]{
                (""+i++),
                    rs.getString(1), rs.getString(2),
                    rs.getString(3) 
                });
            TableBarangStock.setModel(data1);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        } 
    }
    private void ShowDataStore(){
        DefaultTableModel data1 = new DefaultTableModel();
        data1.addColumn ("No");
        data1.addColumn ("Id Barang");
        data1.addColumn ("Nama Barang");
        data1.addColumn ("Harga");
        data1.addColumn ("tanggal");
        data1.addColumn ("stock");
        
        try{    
            int i = 1;
            st=con.createStatement();
            rs=st.executeQuery("select * from barang_store");
            while (rs.next())
                data1.addRow(new Object[]{
                (""+i++),
                    rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),
                    rs.getString(5)
                });
            TabelDataBarangStore.setModel(data1);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }  
    }
    private void ShowDataGudang(String sql){
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn ("No");
        data.addColumn ("ID BARANG");
        data.addColumn ("NAMA BARANG");
        data.addColumn ("HARGA POKOK");
        data.addColumn ("STOCK");
        
        try{    
            int i = 1;
            st=con.createStatement();
            rs=st.executeQuery("select * from barang_gudang");
            while (rs.next())
                data.addRow(new Object[]{
                (""+i++),
                    rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)
                });
            tblInputbarang.setModel(data);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("apg?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        barangGudangQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM BarangGudang b");
        barangGudangList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barangGudangQuery.getResultList();
        TabGudang = new javax.swing.JTabbedPane();
        PanelGudang = new javax.swing.JPanel();
        TabGudangData = new javax.swing.JTabbedPane();
        ButtonDataBarang = new javax.swing.JPanel();
        TabelDataBarangGudang = new javax.swing.JScrollPane();
        TDG1 = new javax.swing.JTable();
        ButtonPermintaanGudang = new javax.swing.JPanel();
        validasibarang = new javax.swing.JLabel();
        TabelPermintaanStore = new javax.swing.JScrollPane();
        TablePermintaanStore1 = new javax.swing.JTable();
        ButtonCheckBarang = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        TabelValidasi = new javax.swing.JScrollPane();
        TabelHasilValidasiGudang = new javax.swing.JTable();
        labelRequestStore = new javax.swing.JLabel();
        ButtonPermintaanFGudang = new javax.swing.JButton();
        IdBarang = new javax.swing.JLabel();
        Jumlah = new javax.swing.JLabel();
        IdBarangtxt = new javax.swing.JTextField();
        jumlahtxt = new javax.swing.JTextField();
        ButtonSubmit = new javax.swing.JButton();
        TabelPermintaanGudang = new javax.swing.JScrollPane();
        TabelHasilSubmitGudang = new javax.swing.JTable();
        ButtonProses = new javax.swing.JButton();
        ButtonUpdateData = new javax.swing.JPanel();
        SubmitBTN = new javax.swing.JButton();
        IdBarang1 = new javax.swing.JLabel();
        ResetBTN = new javax.swing.JButton();
        namaBarang = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Harga = new javax.swing.JLabel();
        hasilsubmitUpdateGudang = new javax.swing.JScrollPane();
        tblInputbarang = new javax.swing.JTable();
        IdBarangtxtGudang = new javax.swing.JTextField();
        namabarangtxt = new javax.swing.JTextField();
        hargatxt = new javax.swing.JTextField();
        PanelLogistik = new javax.swing.JPanel();
        TabLogistik = new javax.swing.JTabbedPane();
        ButtonDataBarangLogistik = new javax.swing.JPanel();
        TabelDataBarangLogistik = new javax.swing.JScrollPane();
        TableDataBarangLogistik = new javax.swing.JTable();
        ButtonPermintaanLogistik = new javax.swing.JPanel();
        TabelPermintaanGudang1 = new javax.swing.JScrollPane();
        TablePermintaanGudang = new javax.swing.JTable();
        labeldatabarang3 = new javax.swing.JLabel();
        SubmitButtonLog = new javax.swing.JButton();
        ResetButtonLog = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        IdBarangtxtLog = new javax.swing.JTextField();
        NamaBarangtxtLog = new javax.swing.JTextField();
        StocktxtLog = new javax.swing.JTextField();
        labeldatabarang4 = new javax.swing.JLabel();
        TableSubmitLog1 = new javax.swing.JScrollPane();
        TableSubmitLog = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        PanelStore = new javax.swing.JPanel();
        TabStore = new javax.swing.JTabbedPane();
        ButtonDataBarangStore = new javax.swing.JPanel();
        TblDataBarangStore = new javax.swing.JScrollPane();
        TabelDataBarangStore = new javax.swing.JTable();
        ButtonPermintaanStore = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TableBarangStock = new javax.swing.JTable();
        labeldatabarang5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        labeldatabarang6 = new javax.swing.JLabel();
        TableSubmitPermintaanStore = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idBrgtxtStore = new javax.swing.JTextField();
        jumlahtxtStore = new javax.swing.JTextField();
        BtnResetStore = new javax.swing.JButton();
        BtnSubmitStore = new javax.swing.JButton();
        BtnReqStore = new javax.swing.JButton();
        ButtonUpdateDataStore = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idbarangtxtStoreUpdate = new javax.swing.JTextField();
        NamatxtStoreUpdate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        StocktxtStoreUpdate = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        submittablestoreupdate = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        HargatxtStoreUpdate = new javax.swing.JTextField();
        labeldatabarang = new javax.swing.JLabel();
        ExitButtonSystem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabGudang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TabGudang.setToolTipText("");
        TabGudang.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N

        TabGudangData.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TabGudangData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, barangGudangList, TDG1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idbarangG}"));
        columnBinding.setColumnName("Idbarang G");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hargaBarang}"));
        columnBinding.setColumnName("Harga Barang");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idKategori}"));
        columnBinding.setColumnName("Id Kategori");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idSupplier}"));
        columnBinding.setColumnName("Id Supplier");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${namaBarang}"));
        columnBinding.setColumnName("Nama Barang");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stock}"));
        columnBinding.setColumnName("Stock");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        TabelDataBarangGudang.setViewportView(TDG1);

        javax.swing.GroupLayout ButtonDataBarangLayout = new javax.swing.GroupLayout(ButtonDataBarang);
        ButtonDataBarang.setLayout(ButtonDataBarangLayout);
        ButtonDataBarangLayout.setHorizontalGroup(
            ButtonDataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonDataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabelDataBarangGudang, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
                .addContainerGap())
        );
        ButtonDataBarangLayout.setVerticalGroup(
            ButtonDataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonDataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabelDataBarangGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabGudangData.addTab("Data Barang", ButtonDataBarang);

        validasibarang.setFont(new java.awt.Font("Source Code Pro Semibold", 1, 18)); // NOI18N
        validasibarang.setText("VALIDASI BARANG");

        TablePermintaanStore1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Id Barang", "Nama Barang", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePermintaanStore1.getTableHeader().setReorderingAllowed(false);
        TabelPermintaanStore.setViewportView(TablePermintaanStore1);
        if (TablePermintaanStore1.getColumnModel().getColumnCount() > 0) {
            TablePermintaanStore1.getColumnModel().getColumn(0).setResizable(false);
            TablePermintaanStore1.getColumnModel().getColumn(1).setResizable(false);
            TablePermintaanStore1.getColumnModel().getColumn(2).setResizable(false);
            TablePermintaanStore1.getColumnModel().getColumn(3).setResizable(false);
        }

        ButtonCheckBarang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ButtonCheckBarang.setText("CHECK BARANG");
        ButtonCheckBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCheckBarangActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        TabelHasilValidasiGudang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Barang", "Nama Barang", "Status"
            }
        ));
        TabelValidasi.setViewportView(TabelHasilValidasiGudang);

        labelRequestStore.setFont(new java.awt.Font("Source Code Pro Semibold", 1, 18)); // NOI18N
        labelRequestStore.setText("REQUEST STORE");

        ButtonPermintaanFGudang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ButtonPermintaanFGudang.setText("PERMINTAAN");

        IdBarang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IdBarang.setText("ID BARANG");

        Jumlah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Jumlah.setText("Jumlah");

        IdBarangtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdBarangtxtActionPerformed(evt);
            }
        });

        ButtonSubmit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ButtonSubmit.setText("Submit");
        ButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSubmitActionPerformed(evt);
            }
        });

        TabelHasilSubmitGudang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama", "Jumlah"
            }
        ));
        TabelPermintaanGudang.setViewportView(TabelHasilSubmitGudang);

        ButtonProses.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ButtonProses.setText("PROSES");
        ButtonProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProsesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonPermintaanGudangLayout = new javax.swing.GroupLayout(ButtonPermintaanGudang);
        ButtonPermintaanGudang.setLayout(ButtonPermintaanGudangLayout);
        ButtonPermintaanGudangLayout.setHorizontalGroup(
            ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TabelPermintaanStore, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCheckBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPermintaanGudangLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TabelValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(validasibarang))
                            .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                                .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                                        .addGap(107, 107, 107)
                                        .addComponent(ButtonSubmit))
                                    .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                                                .addComponent(IdBarang)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(IdBarangtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                                                .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addComponent(jumlahtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TabelPermintaanGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPermintaanGudangLayout.createSequentialGroup()
                        .addComponent(ButtonProses, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonPermintaanFGudang)
                        .addGap(5, 5, 5)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                    .addGap(226, 226, 226)
                    .addComponent(labelRequestStore)
                    .addContainerGap(783, Short.MAX_VALUE)))
        );
        ButtonPermintaanGudangLayout.setVerticalGroup(
            ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TabelPermintaanStore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPermintaanGudangLayout.createSequentialGroup()
                        .addComponent(validasibarang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TabelValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                                .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IdBarang)
                                    .addComponent(IdBarangtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Jumlah)
                                    .addComponent(jumlahtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonSubmit))
                            .addComponent(TabelPermintaanGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCheckBarang)
                    .addComponent(ButtonPermintaanFGudang)
                    .addComponent(ButtonProses))
                .addContainerGap())
            .addGroup(ButtonPermintaanGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPermintaanGudangLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(labelRequestStore)
                    .addContainerGap(388, Short.MAX_VALUE)))
        );

        TabGudangData.addTab("Permintaan", ButtonPermintaanGudang);

        SubmitBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SubmitBTN.setText("Submit");
        SubmitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBTNActionPerformed(evt);
            }
        });

        IdBarang1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IdBarang1.setText("ID BARANG");

        ResetBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetBTN.setText("Reset");
        ResetBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBTNActionPerformed(evt);
            }
        });

        namaBarang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namaBarang.setText("NAMA BARANG");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Harga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Harga.setText("HARGA");

        tblInputbarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblInputbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "ID BARANG", "NAMA BARANG", "HARGA POKOK", "STOCK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInputbarang.getTableHeader().setReorderingAllowed(false);
        tblInputbarang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblInputbarangAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        hasilsubmitUpdateGudang.setViewportView(tblInputbarang);
        if (tblInputbarang.getColumnModel().getColumnCount() > 0) {
            tblInputbarang.getColumnModel().getColumn(0).setResizable(false);
            tblInputbarang.getColumnModel().getColumn(1).setResizable(false);
            tblInputbarang.getColumnModel().getColumn(2).setResizable(false);
            tblInputbarang.getColumnModel().getColumn(3).setResizable(false);
            tblInputbarang.getColumnModel().getColumn(4).setResizable(false);
        }

        IdBarangtxtGudang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdBarangtxtGudangActionPerformed(evt);
            }
        });

        namabarangtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namabarangtxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonUpdateDataLayout = new javax.swing.GroupLayout(ButtonUpdateData);
        ButtonUpdateData.setLayout(ButtonUpdateDataLayout);
        ButtonUpdateDataLayout.setHorizontalGroup(
            ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonUpdateDataLayout.createSequentialGroup()
                .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ButtonUpdateDataLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ResetBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SubmitBTN))
                    .addGroup(ButtonUpdateDataLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaBarang)
                            .addComponent(Harga)
                            .addComponent(IdBarang1))
                        .addGap(29, 29, 29)
                        .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namabarangtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdBarangtxtGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hasilsubmitUpdateGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ButtonUpdateDataLayout.setVerticalGroup(
            ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonUpdateDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ButtonUpdateDataLayout.createSequentialGroup()
                        .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ButtonUpdateDataLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IdBarang1)
                                    .addComponent(IdBarangtxtGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namaBarang)
                                    .addComponent(namabarangtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Harga)
                                    .addComponent(hargatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(ButtonUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SubmitBTN)
                                    .addComponent(ResetBTN)))
                            .addComponent(hasilsubmitUpdateGudang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TabGudangData.addTab("Update Data", ButtonUpdateData);

        javax.swing.GroupLayout PanelGudangLayout = new javax.swing.GroupLayout(PanelGudang);
        PanelGudang.setLayout(PanelGudangLayout);
        PanelGudangLayout.setHorizontalGroup(
            PanelGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGudangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabGudangData))
        );
        PanelGudangLayout.setVerticalGroup(
            PanelGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGudangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabGudangData)
                .addContainerGap())
        );

        TabGudang.addTab("Gudang", PanelGudang);

        TabLogistik.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TabLogistik.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TableDataBarangLogistik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Barang", "Nama", "Harga", "Stock", "Kategori", "Supplier"
            }
        ));
        TabelDataBarangLogistik.setViewportView(TableDataBarangLogistik);

        javax.swing.GroupLayout ButtonDataBarangLogistikLayout = new javax.swing.GroupLayout(ButtonDataBarangLogistik);
        ButtonDataBarangLogistik.setLayout(ButtonDataBarangLogistikLayout);
        ButtonDataBarangLogistikLayout.setHorizontalGroup(
            ButtonDataBarangLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1153, Short.MAX_VALUE)
            .addGroup(ButtonDataBarangLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonDataBarangLogistikLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TabelDataBarangLogistik, javax.swing.GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        ButtonDataBarangLogistikLayout.setVerticalGroup(
            ButtonDataBarangLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(ButtonDataBarangLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonDataBarangLogistikLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TabelDataBarangLogistik, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(197, Short.MAX_VALUE)))
        );

        TabLogistik.addTab("Data Barang", ButtonDataBarangLogistik);

        TablePermintaanGudang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Id Barang", "Nama Barang", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePermintaanGudang.getTableHeader().setReorderingAllowed(false);
        TabelPermintaanGudang1.setViewportView(TablePermintaanGudang);
        if (TablePermintaanGudang.getColumnModel().getColumnCount() > 0) {
            TablePermintaanGudang.getColumnModel().getColumn(0).setResizable(false);
            TablePermintaanGudang.getColumnModel().getColumn(1).setResizable(false);
            TablePermintaanGudang.getColumnModel().getColumn(2).setResizable(false);
            TablePermintaanGudang.getColumnModel().getColumn(3).setResizable(false);
        }

        labeldatabarang3.setFont(new java.awt.Font("Source Code Pro Semibold", 1, 18)); // NOI18N
        labeldatabarang3.setText("REQUEST GUDANG");

        SubmitButtonLog.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SubmitButtonLog.setText("Submit");

        ResetButtonLog.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ResetButtonLog.setText("Reset");
        ResetButtonLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonLogActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID BARANG");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nama Barang");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Stock");

        IdBarangtxtLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdBarangtxtLogActionPerformed(evt);
            }
        });

        labeldatabarang4.setFont(new java.awt.Font("Source Code Pro Semibold", 1, 18)); // NOI18N
        labeldatabarang4.setText("INPUT DATA BARANG");

        TableSubmitLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama", "Stock"
            }
        ));
        TableSubmitLog1.setViewportView(TableSubmitLog);

        javax.swing.GroupLayout ButtonPermintaanLogistikLayout = new javax.swing.GroupLayout(ButtonPermintaanLogistik);
        ButtonPermintaanLogistik.setLayout(ButtonPermintaanLogistikLayout);
        ButtonPermintaanLogistikLayout.setHorizontalGroup(
            ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(labeldatabarang3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeldatabarang4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
            .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabelPermintaanGudang1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                            .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(49, 49, 49)
                            .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(IdBarangtxtLog, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NamaBarangtxtLog)
                                        .addComponent(StocktxtLog, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                            .addComponent(ResetButtonLog)
                            .addGap(18, 18, 18)
                            .addComponent(SubmitButtonLog)))
                    .addComponent(TableSubmitLog1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4))
            .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                    .addGap(525, 525, 525)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(626, Short.MAX_VALUE)))
        );
        ButtonPermintaanLogistikLayout.setVerticalGroup(
            ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPermintaanLogistikLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeldatabarang3)
                    .addComponent(labeldatabarang4))
                .addGap(5, 5, 5)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabelPermintaanGudang1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                        .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(IdBarangtxtLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(NamaBarangtxtLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(StocktxtLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ResetButtonLog)
                            .addComponent(SubmitButtonLog))
                        .addGap(18, 18, 18)
                        .addComponent(TableSubmitLog1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(216, 216, 216))
            .addGroup(ButtonPermintaanLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPermintaanLogistikLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );

        TabLogistik.addTab("Permintaan", ButtonPermintaanLogistik);

        javax.swing.GroupLayout PanelLogistikLayout = new javax.swing.GroupLayout(PanelLogistik);
        PanelLogistik.setLayout(PanelLogistikLayout);
        PanelLogistikLayout.setHorizontalGroup(
            PanelLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogistikLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabLogistik)
                .addContainerGap())
        );
        PanelLogistikLayout.setVerticalGroup(
            PanelLogistikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogistikLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabLogistik, javax.swing.GroupLayout.PREFERRED_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabGudang.addTab("Logistik", PanelLogistik);

        TabStore.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        TabStore.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TabStore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TabelDataBarangStore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Id Barang", "Nama Barang", "Harga", "tanggal", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelDataBarangStore.getTableHeader().setReorderingAllowed(false);
        TblDataBarangStore.setViewportView(TabelDataBarangStore);
        if (TabelDataBarangStore.getColumnModel().getColumnCount() > 0) {
            TabelDataBarangStore.getColumnModel().getColumn(0).setResizable(false);
            TabelDataBarangStore.getColumnModel().getColumn(1).setResizable(false);
            TabelDataBarangStore.getColumnModel().getColumn(2).setResizable(false);
            TabelDataBarangStore.getColumnModel().getColumn(3).setResizable(false);
            TabelDataBarangStore.getColumnModel().getColumn(4).setResizable(false);
            TabelDataBarangStore.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout ButtonDataBarangStoreLayout = new javax.swing.GroupLayout(ButtonDataBarangStore);
        ButtonDataBarangStore.setLayout(ButtonDataBarangStoreLayout);
        ButtonDataBarangStoreLayout.setHorizontalGroup(
            ButtonDataBarangStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonDataBarangStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TblDataBarangStore, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE))
        );
        ButtonDataBarangStoreLayout.setVerticalGroup(
            ButtonDataBarangStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonDataBarangStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TblDataBarangStore, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        TabStore.addTab("Data Barang", ButtonDataBarangStore);

        TableBarangStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Barang", "Nama Barang", "Stok"
            }
        ));
        jScrollPane9.setViewportView(TableBarangStock);

        labeldatabarang5.setFont(new java.awt.Font("Source Code Pro Semibold", 1, 18)); // NOI18N
        labeldatabarang5.setText("DATA BARANG");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        labeldatabarang6.setFont(new java.awt.Font("Source Code Pro Semibold", 1, 18)); // NOI18N
        labeldatabarang6.setText("REQUEST BARANG");

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Id Barang", "Nama Barang", "Jumlah"
            }
        ));
        TableSubmitPermintaanStore.setViewportView(jTable9);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ID BARANG");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Jumlah");

        idBrgtxtStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBrgtxtStoreActionPerformed(evt);
            }
        });

        BtnResetStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnResetStore.setText("Reset");
        BtnResetStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetStoreActionPerformed(evt);
            }
        });

        BtnSubmitStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnSubmitStore.setText("Submit");

        BtnReqStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnReqStore.setText("Request");

        javax.swing.GroupLayout ButtonPermintaanStoreLayout = new javax.swing.GroupLayout(ButtonPermintaanStore);
        ButtonPermintaanStore.setLayout(ButtonPermintaanStoreLayout);
        ButtonPermintaanStoreLayout.setHorizontalGroup(
            ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(labeldatabarang5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeldatabarang6)
                .addGap(253, 253, 253))
            .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnReqStore)
                        .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                            .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnResetStore))
                            .addGap(29, 29, 29)
                            .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BtnSubmitStore)
                                .addComponent(idBrgtxtStore, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addComponent(jumlahtxtStore))
                            .addGap(144, 144, 144)))
                    .addComponent(TableSubmitPermintaanStore, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jSeparator5)
                    .addGap(5, 5, 5)))
            .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                    .addGap(508, 508, 508)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(643, Short.MAX_VALUE)))
        );
        ButtonPermintaanStoreLayout.setVerticalGroup(
            ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeldatabarang5)
                    .addComponent(labeldatabarang6))
                .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(idBrgtxtStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jumlahtxtStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnResetStore)
                            .addComponent(BtnSubmitStore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TableSubmitPermintaanStore, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnReqStore)
                .addGap(24, 24, 24))
            .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(383, Short.MAX_VALUE)))
            .addGroup(ButtonPermintaanStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPermintaanStoreLayout.createSequentialGroup()
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
        );

        TabStore.addTab("Permintaan", ButtonPermintaanStore);

        ButtonUpdateDataStore.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ID BARANG");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Nama Barang");

        idbarangtxtStoreUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idbarangtxtStoreUpdateActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Stock");

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setText("Reset");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setText("Submit");

        submittablestoreupdate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama", "Stock", "Harga"
            }
        ));
        jScrollPane11.setViewportView(submittablestoreupdate);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Harga");

        javax.swing.GroupLayout ButtonUpdateDataStoreLayout = new javax.swing.GroupLayout(ButtonUpdateDataStore);
        ButtonUpdateDataStore.setLayout(ButtonUpdateDataStoreLayout);
        ButtonUpdateDataStoreLayout.setHorizontalGroup(
            ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonUpdateDataStoreLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(ButtonUpdateDataStoreLayout.createSequentialGroup()
                        .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jButton10))
                        .addGap(49, 49, 49)
                        .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(idbarangtxtStoreUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ButtonUpdateDataStoreLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(NamatxtStoreUpdate)
                                        .addComponent(StocktxtStoreUpdate)
                                        .addComponent(HargatxtStoreUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jButton11))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonUpdateDataStoreLayout.setVerticalGroup(
            ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonUpdateDataStoreLayout.createSequentialGroup()
                .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ButtonUpdateDataStoreLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(idbarangtxtStoreUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(NamatxtStoreUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(StocktxtStoreUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HargatxtStoreUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(ButtonUpdateDataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11)
                            .addComponent(jButton10)))
                    .addGroup(ButtonUpdateDataStoreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabStore.addTab("Update Data", ButtonUpdateDataStore);

        javax.swing.GroupLayout PanelStoreLayout = new javax.swing.GroupLayout(PanelStore);
        PanelStore.setLayout(PanelStoreLayout);
        PanelStoreLayout.setHorizontalGroup(
            PanelStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabStore)
                .addContainerGap())
        );
        PanelStoreLayout.setVerticalGroup(
            PanelStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabStore)
                .addContainerGap())
        );

        TabGudang.addTab("Store", PanelStore);

        labeldatabarang.setBackground(new java.awt.Color(204, 0, 0));
        labeldatabarang.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        labeldatabarang.setText("APLIKASI PENDATAAN GUDANG");

        ExitButtonSystem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ExitButtonSystem.setText("EXIT");
        ExitButtonSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonSystemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(ExitButtonSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TabGudang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeldatabarang)
                .addGap(389, 389, 389))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labeldatabarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TabGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExitButtonSystem)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonSystemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitButtonSystemActionPerformed

    private void namabarangtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namabarangtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namabarangtxtActionPerformed

    private void IdBarangtxtGudangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdBarangtxtGudangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdBarangtxtGudangActionPerformed

    private void tblInputbarangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblInputbarangAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblInputbarangAncestorAdded

    private void ResetBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetBTNActionPerformed

    private void SubmitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBTNActionPerformed
        // TODO add your handling code here:
        idbarang = String.valueOf(IdBarangtxtGudang.getText());
        nmbarang = String.valueOf(namabarangtxt.getText());
        hrg = String.valueOf(hargatxt.getText());
             
      try {
            sql = "UPDATE barang_gudang SET nama_barang='" + nmbarang + "',harga_barang='" + hrg  +"' WHERE id_barangG='" + idbarang + "'";
       
            st=con.createStatement();
            st.executeUpdate(sql);
            ShowDataGudang(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR \n Data Gagal Disimpan\n"+e.getMessage());
        }
    }//GEN-LAST:event_SubmitBTNActionPerformed

    private void ButtonCheckBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCheckBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCheckBarangActionPerformed

    private void ResetButtonLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetButtonLogActionPerformed

    private void IdBarangtxtLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdBarangtxtLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdBarangtxtLogActionPerformed

    private void idBrgtxtStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBrgtxtStoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBrgtxtStoreActionPerformed

    private void BtnResetStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetStoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnResetStoreActionPerformed

    private void idbarangtxtStoreUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idbarangtxtStoreUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idbarangtxtStoreUpdateActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void IdBarangtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdBarangtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdBarangtxtActionPerformed

    private void ButtonProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProsesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonProsesActionPerformed

    private void ButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new beranda().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnReqStore;
    private javax.swing.JButton BtnResetStore;
    private javax.swing.JButton BtnSubmitStore;
    private javax.swing.JButton ButtonCheckBarang;
    private javax.swing.JPanel ButtonDataBarang;
    private javax.swing.JPanel ButtonDataBarangLogistik;
    private javax.swing.JPanel ButtonDataBarangStore;
    private javax.swing.JButton ButtonPermintaanFGudang;
    private javax.swing.JPanel ButtonPermintaanGudang;
    private javax.swing.JPanel ButtonPermintaanLogistik;
    private javax.swing.JPanel ButtonPermintaanStore;
    private javax.swing.JButton ButtonProses;
    private javax.swing.JButton ButtonSubmit;
    private javax.swing.JPanel ButtonUpdateData;
    private javax.swing.JPanel ButtonUpdateDataStore;
    private javax.swing.JButton ExitButtonSystem;
    private javax.swing.JLabel Harga;
    private javax.swing.JTextField HargatxtStoreUpdate;
    private javax.swing.JLabel IdBarang;
    private javax.swing.JLabel IdBarang1;
    private javax.swing.JTextField IdBarangtxt;
    private javax.swing.JTextField IdBarangtxtGudang;
    private javax.swing.JTextField IdBarangtxtLog;
    private javax.swing.JLabel Jumlah;
    private javax.swing.JTextField NamaBarangtxtLog;
    private javax.swing.JTextField NamatxtStoreUpdate;
    private javax.swing.JPanel PanelGudang;
    private javax.swing.JPanel PanelLogistik;
    private javax.swing.JPanel PanelStore;
    private javax.swing.JButton ResetBTN;
    private javax.swing.JButton ResetButtonLog;
    private javax.swing.JTextField StocktxtLog;
    private javax.swing.JTextField StocktxtStoreUpdate;
    private javax.swing.JButton SubmitBTN;
    private javax.swing.JButton SubmitButtonLog;
    private javax.swing.JTable TDG1;
    private javax.swing.JTabbedPane TabGudang;
    private javax.swing.JTabbedPane TabGudangData;
    private javax.swing.JTabbedPane TabLogistik;
    private javax.swing.JTabbedPane TabStore;
    private javax.swing.JScrollPane TabelDataBarangGudang;
    private javax.swing.JScrollPane TabelDataBarangLogistik;
    private javax.swing.JTable TabelDataBarangStore;
    private javax.swing.JTable TabelHasilSubmitGudang;
    private javax.swing.JTable TabelHasilValidasiGudang;
    private javax.swing.JScrollPane TabelPermintaanGudang;
    private javax.swing.JScrollPane TabelPermintaanGudang1;
    private javax.swing.JScrollPane TabelPermintaanStore;
    private javax.swing.JScrollPane TabelValidasi;
    private javax.swing.JTable TableBarangStock;
    private javax.swing.JTable TableDataBarangLogistik;
    private javax.swing.JTable TablePermintaanGudang;
    private javax.swing.JTable TablePermintaanStore1;
    private javax.swing.JTable TableSubmitLog;
    private javax.swing.JScrollPane TableSubmitLog1;
    private javax.swing.JScrollPane TableSubmitPermintaanStore;
    private javax.swing.JScrollPane TblDataBarangStore;
    private java.util.List<aplikasigudang.BarangGudang> barangGudangList;
    private javax.persistence.Query barangGudangQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField hargatxt;
    private javax.swing.JScrollPane hasilsubmitUpdateGudang;
    private javax.swing.JTextField idBrgtxtStore;
    private javax.swing.JTextField idbarangtxtStoreUpdate;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jumlahtxt;
    private javax.swing.JTextField jumlahtxtStore;
    private javax.swing.JLabel labelRequestStore;
    private javax.swing.JLabel labeldatabarang;
    private javax.swing.JLabel labeldatabarang3;
    private javax.swing.JLabel labeldatabarang4;
    private javax.swing.JLabel labeldatabarang5;
    private javax.swing.JLabel labeldatabarang6;
    private javax.swing.JLabel namaBarang;
    private javax.swing.JTextField namabarangtxt;
    private javax.swing.JTable submittablestoreupdate;
    private javax.swing.JTable tblInputbarang;
    private javax.swing.JLabel validasibarang;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
