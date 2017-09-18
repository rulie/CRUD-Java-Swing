/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.GadaiDAO;
import dao.NasabahDAO;
import daoimpl.GadaiDAOimpl;
import daoimpl.NasabahDAOimpl;
import java.beans.Beans;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.*;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import model.Gadai;
import model.Nasabah;

/**
 *
 * @author RuliKA
 */
public class GadaiForm extends javax.swing.JDialog {

    /**
     * Creates new form GadaiForm
     */
    public GadaiForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        isicombo();
        if (!Beans.isDesignTime()) {
            PegadaianPUEntityManager.getTransaction().begin();
        }
        txtID.setVisible(false);
    }    
    
    public void refreshTable(){
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        PegadaianPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("PegadaianPU").createEntityManager();
        gadaiQuery = java.beans.Beans.isDesignTime() ? null : PegadaianPUEntityManager.createQuery("SELECT g FROM Gadai g");
        gadaiList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : gadaiQuery.getResultList();
        
        //tabelGadai = new javax.swing.JTable();

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gadaiList, tabelGadai);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${kodeGadai}"));
        columnBinding.setColumnName("Kode Gadai");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nasabah.namaNasabah}"));
        columnBinding.setColumnName("Nasabah");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${beratEmas}"));
        columnBinding.setColumnName("Berat Emas");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jmlKarat}"));
        columnBinding.setColumnName("Jml Karat");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hargaTafsiran}"));
        columnBinding.setColumnName("Harga Tafsiran");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jmlPinjaman}"));
        columnBinding.setColumnName("Jml Pinjaman");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lamaAngsuran}"));
        columnBinding.setColumnName("Lama Angsuran");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bunga}"));
        columnBinding.setColumnName("Bunga");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalTebusan}"));
        columnBinding.setColumnName("Total Tebusan");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jmlAngsuran}"));
        columnBinding.setColumnName("Jml Angsuran");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tglGadai}"));
        columnBinding.setColumnName("Tgl Gadai");
        columnBinding.setColumnClass(java.io.Serializable.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tglJatuhTempo}"));
        columnBinding.setColumnName("Tgl Jatuh Tempo");
        columnBinding.setColumnClass(java.io.Serializable.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(tabelGadai);
        bindingGroup.bind();
    }
    GadaiDAO gdao = new GadaiDAOimpl();
    Nasabah n = new Nasabah();            

    public void isicombo() {
            NasabahDAO ndao = new NasabahDAOimpl();
                ndao.getAll().stream().forEach((n) -> {
                comboNasabah.addItem(n.getNamaNasabah());
    });
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

        PegadaianPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("PegadaianPU").createEntityManager();
        gadaiQuery = java.beans.Beans.isDesignTime() ? null : PegadaianPUEntityManager.createQuery("SELECT g FROM Gadai g");
        gadaiList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : gadaiQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelGadai = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtHargaEmas = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtJmlPinjam = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLamaAngsuran = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBunga = new javax.swing.JTextField();
        btnHitungTebusan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtJmlTebusan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtJmlAngsuran = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTglGadai = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txtJatuhTempo = new javax.swing.JFormattedTextField();
        btnReset = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtKodeGadai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboNasabah = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBerat = new javax.swing.JTextField();
        txtJmlKarat = new javax.swing.JTextField();
        btnHitungTafsiran = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gadaiList, tabelGadai);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${kodeGadai}"));
        columnBinding.setColumnName("Kode Gadai");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nasabah.namaNasabah}"));
        columnBinding.setColumnName("Nasabah");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${beratEmas}"));
        columnBinding.setColumnName("Berat Emas");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jmlKarat}"));
        columnBinding.setColumnName("Jml Karat");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hargaTafsiran}"));
        columnBinding.setColumnName("Harga Tafsiran");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jmlPinjaman}"));
        columnBinding.setColumnName("Jml Pinjaman");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lamaAngsuran}"));
        columnBinding.setColumnName("Lama Angsuran");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bunga}"));
        columnBinding.setColumnName("Bunga");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalTebusan}"));
        columnBinding.setColumnName("Total Tebusan");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jmlAngsuran}"));
        columnBinding.setColumnName("Jml Angsuran");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tglGadai}"));
        columnBinding.setColumnName("Tgl Gadai");
        columnBinding.setColumnClass(java.io.Serializable.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tglJatuhTempo}"));
        columnBinding.setColumnName("Tgl Jatuh Tempo");
        columnBinding.setColumnClass(java.io.Serializable.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabelGadai);

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-property-32.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit-property-32.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel6.setText("Harga Tafsiran Emas :");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.hargaTafsiran}"), txtHargaEmas, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel14.setText("Jumlah Max Pinjaman :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jmlPinjaman}"), txtJmlPinjam, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel7.setText("Lama Angsuran (bulan) :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.lamaAngsuran}"), txtLamaAngsuran, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel8.setText("Bunga (%) :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.bunga}"), txtBunga, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        btnHitungTebusan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHitungTebusan.setText("HITUNG");
        btnHitungTebusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungTebusanActionPerformed(evt);
            }
        });

        jLabel9.setText("Total Tebusan :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.totalTebusan}"), txtJmlTebusan, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel10.setText("Angsuran / Bulan :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jmlAngsuran}"), txtJmlAngsuran, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel11.setText("Tanggal Gadai :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tglGadai}"), txtTglGadai, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jLabel12.setText("Tanggal Jatuh Tempo :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tglJatuhTempo}"), txtJatuhTempo, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sinchronize-32.png"))); // NOI18N
        btnReset.setText("Reset");

        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-32.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode Gadai :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.kodeGadai}"), txtKodeGadai, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtKodeGadai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeGadaiActionPerformed(evt);
            }
        });

        jLabel3.setText("Nasabah :");

        jLabel4.setText("Berat Emas (gram) :");

        jLabel5.setText("Jumlah Karat (1-24) :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.beratEmas}"), txtBerat, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jmlKarat}"), txtJmlKarat, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        btnHitungTafsiran.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHitungTafsiran.setText("HITUNG");
        btnHitungTafsiran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungTafsiranActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), txtID, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI PEGADAIAN EMAS");

        jLabel13.setText("Cari :");

        btnCari.setText("Cari");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Nama Nasabah :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Jumlah Pinjaman :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Bunga :");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nasabah.namaNasabah}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jmlPinjaman}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.bunga}"), jTextField4, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Angsuran per Bulan :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Jumlah Tebusan :");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Tanggal Gadai :");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Tanggal Jatuh Tempo :");

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jmlAngsuran}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.totalTebusan}"), jTextField6, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tglGadai}"), jFormattedTextField2, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelGadai, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tglJatuhTempo}"), jFormattedTextField3, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print-icon (1).png"))); // NOI18N
        jButton1.setText("Cetak");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(168, 168, 168))
                                    .addComponent(txtKodeGadai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtBerat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJmlKarat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHitungTafsiran, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(127, 127, 127)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(53, 53, 53)
                                        .addComponent(txtLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(21, 21, 21)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtHargaEmas)
                                            .addComponent(txtJmlPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtBunga, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnHitungTebusan))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtJatuhTempo))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel9))
                                            .addGap(25, 25, 25)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtTglGadai)
                                                .addComponent(txtJmlAngsuran)
                                                .addComponent(txtJmlTebusan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel11))
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTextField1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCari))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(305, 305, 305)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKodeGadai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtJmlKarat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHitungTafsiran))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHargaEmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtJmlPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHitungTebusan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJmlTebusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtJmlAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTglGadai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtJatuhTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(btnCari)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtKodeGadaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeGadaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeGadaiActionPerformed

    private void btnHitungTafsiranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungTafsiranActionPerformed

        int berat = Integer.valueOf(txtBerat.getText());
        int karat = Integer.valueOf(txtJmlKarat.getText());
        
        try{
            if(karat == 1){
                double maxpinjam = berat*78000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 2){
                double maxpinjam = berat*101000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 3){
                double maxpinjam = berat*124000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 4){
                double maxpinjam = berat*147000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 5){
                double maxpinjam = berat*170000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 6){
                double maxpinjam = berat*193000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 7){
                double maxpinjam = berat*216000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 8){
                double maxpinjam = berat*239000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 9){
                double maxpinjam = berat*262000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 10){
                double maxpinjam = berat*285000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 11 ){
                double maxpinjam = berat*308000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 12){
                double maxpinjam = berat*331000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 13){
                double maxpinjam = berat*354000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 14){
                double maxpinjam = berat*377000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 15){
                double maxpinjam = berat*400000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 16){
                double maxpinjam = berat*423000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 17){
                double maxpinjam = berat*446000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 18){
                double maxpinjam = berat*469000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 19){
                double maxpinjam = berat*492000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 20){
                double maxpinjam = berat*515000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 21){
                double maxpinjam = berat*538000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 22){
                double maxpinjam = berat*561000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 23){
                double maxpinjam = berat*584000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else if(karat == 24){
                double maxpinjam = berat*607000;
                txtHargaEmas.setText(String.valueOf(maxpinjam));
                double pinjam = (maxpinjam*80)/100;
                txtJmlPinjam.setText(String.valueOf(pinjam));
            }else{
                JOptionPane.showMessageDialog(rootPane, "Isi Data Dengan Benar!");
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Data Belum Diisi");
        }
    }//GEN-LAST:event_btnHitungTafsiranActionPerformed

    private void btnHitungTebusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungTebusanActionPerformed
        int lama = Integer.valueOf(txtLamaAngsuran.getText());
        int bunga = Integer.valueOf(txtBunga.getText());
        double pinjam = Double.valueOf(txtJmlPinjam.getText());
        double tebus = pinjam + (pinjam*bunga)/100;
        txtJmlTebusan.setText(String.valueOf(tebus));
        double angsur = tebus/lama;
        txtJmlAngsuran.setText(String.valueOf(angsur));
        LocalDate tgl = LocalDate.now();
        txtTglGadai.setText(String.valueOf(tgl));
        LocalDate jatuhtempo = LocalDate.now().plusMonths(lama);
        txtJatuhTempo.setText(String.valueOf(jatuhtempo));
        
    }//GEN-LAST:event_btnHitungTebusanActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, Integer.valueOf(txtLamaAngsuran.getText()));
        Date lama = cal.getTime();
//        int lama = Integer.valueOf(txtLamaAngsuran.getText());
//        LocalDate jatuhtempo = LocalDate.now().plusMonths(lama);
        Gadai g = new Gadai();
        GadaiDAO gdao = new GadaiDAOimpl();
        NasabahDAO ndao = new NasabahDAOimpl();
        g.setKodeGadai(txtKodeGadai.getText());        
        g.setBeratEmas(Integer.parseInt(txtBerat.getText()));
        g.setJmlKarat(Integer.parseInt(txtJmlKarat.getText()));
        g.setHargaTafsiran(Double.parseDouble(txtHargaEmas.getText()));
        g.setJmlPinjaman(Double.parseDouble(txtJmlPinjam.getText()));
        g.setLamaAngsuran(Integer.parseInt(txtLamaAngsuran.getText()));
        g.setBunga(Integer.parseInt(txtBunga.getText()));
        g.setTotalTebusan(Double.parseDouble(txtJmlTebusan.getText()));
        g.setJmlAngsuran(Double.parseDouble(txtJmlAngsuran.getText()));
        g.setTglGadai(Date.from(Instant.now()));
        //g.setTglJatuhTempo(Date.from(Instant.MIN));
        g.setTglJatuhTempo(lama);
//        Calendar cal = dateTempo.getSelectedDate();
        g.setNasabah(ndao.getByNama(comboNasabah.getSelectedItem().toString()));
        gdao.insert(g);
        refreshTable();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        GadaiDAO gdao = new GadaiDAOimpl();
        Gadai g = gdao.getById(Long.parseLong(txtID.getText()));
        gdao.delete(g);
        refreshTable();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        GadaiDAO gdao = new GadaiDAOimpl();
        Gadai g = gdao.getById(Long.parseLong(txtID.getText()));
        g.setBeratEmas(Integer.parseInt(txtBunga.getText()));
        g.setJmlKarat(Integer.parseInt(txtJmlKarat.getText()));
        g.setHargaTafsiran(Double.parseDouble(txtHargaEmas.getText()));
        g.setJmlPinjaman(Double.parseDouble(txtJmlPinjam.getText()));
        g.setLamaAngsuran(Integer.parseInt(txtLamaAngsuran.getText()));
        g.setBunga(Integer.parseInt(txtBunga.getText()));
        g.setTotalTebusan(Double.parseDouble(txtJmlTebusan.getText()));
        g.setJmlAngsuran(Double.parseDouble(txtJmlAngsuran.getText()));        
        gdao.update(g);
        refreshTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(GadaiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GadaiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GadaiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GadaiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GadaiForm dialog = new GadaiForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager PegadaianPUEntityManager;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitungTafsiran;
    private javax.swing.JButton btnHitungTebusan;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox comboNasabah;
    private java.util.List<model.Gadai> gadaiList;
    private javax.persistence.Query gadaiQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tabelGadai;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtBunga;
    private javax.swing.JTextField txtHargaEmas;
    private javax.swing.JTextField txtID;
    private javax.swing.JFormattedTextField txtJatuhTempo;
    private javax.swing.JTextField txtJmlAngsuran;
    private javax.swing.JTextField txtJmlKarat;
    private javax.swing.JTextField txtJmlPinjam;
    private javax.swing.JTextField txtJmlTebusan;
    private javax.swing.JTextField txtKodeGadai;
    private javax.swing.JTextField txtLamaAngsuran;
    private javax.swing.JFormattedTextField txtTglGadai;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
