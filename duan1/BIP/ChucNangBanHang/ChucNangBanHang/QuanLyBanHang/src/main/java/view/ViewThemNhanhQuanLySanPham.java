/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DongSanPham;
import model.MauSac;
import model.NhaSanXuat;
import model.SanPham;
import services.DongSanPhamService;
import services.MauSacService;
import services.NhaSanXuatService;
import services.SanPhamService;
import services.impl.DongSanPhamServiceImpl;
import services.impl.MauSacServiceImpl;
import services.impl.NhaSanXuatServiceImpl;
import services.impl.SanPhamServiceImpl;

/**
 *
 * @author Admin
 */
public class ViewThemNhanhQuanLySanPham extends javax.swing.JFrame {

    private DefaultTableModel modelSanPham = new DefaultTableModel();
    private DefaultTableModel modelMauSac = new DefaultTableModel();
    private DefaultTableModel modelDSP = new DefaultTableModel();
    private DefaultTableModel modelNSX = new DefaultTableModel();
    private List<SanPham> listSanPham = new ArrayList<>();
    private List<MauSac> listMauSac = new ArrayList<>();
    private List<NhaSanXuat> listNSX = new ArrayList<>();
    private List<DongSanPham> listDSP = new ArrayList<>();
    private SanPhamService sps = new SanPhamServiceImpl();
    private DongSanPhamService dsps = new DongSanPhamServiceImpl();
    private NhaSanXuatService nsxs = new NhaSanXuatServiceImpl();
    private MauSacService mss = new MauSacServiceImpl();
    private int STT;
    private int row;

    public ViewThemNhanhQuanLySanPham() {
        initComponents();
        tbSanPham.setModel(modelSanPham);
        tbDSP.setModel(modelDSP);
        tbMauSac.setModel(modelMauSac);
        tbNSX.setModel(modelNSX);
        listSanPham = sps.getSanPham();
        listMauSac = mss.getMauSac();
        listDSP = dsps.getDongSanPham();
        listNSX = nsxs.getNhaSanXuat();
        String[] headerSanPham = {"STT", "Ma San Pham", "Ten San Pham"};
        String[] headerMauSac = {"STT", "Ma Mau Sac", "Ten Mau Sac"};
        String[] headerDSP = {"STT", "Ma DSP", "Ten DSP"};
        String[] headerNSX = {"STT", "Ma NSX", "Ten NSX"};
        modelSanPham.setColumnIdentifiers(headerSanPham);
        modelDSP.setColumnIdentifiers(headerDSP);
        modelMauSac.setColumnIdentifiers(headerMauSac);
        modelNSX.setColumnIdentifiers(headerNSX);
        showDataTableDSP(listDSP);
        showDataTableMS(listMauSac);
        showDataTableNSX(listNSX);
        showDataTableSP(listSanPham);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelSanPham = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        btnThemSanPham = new javax.swing.JButton();
        btnSuaSanPham = new javax.swing.JButton();
        btnQuayLaiSanPham = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        btnDeleteSanPham = new javax.swing.JButton();
        PanelMauSac = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaMS = new javax.swing.JTextField();
        txtTenMS = new javax.swing.JTextField();
        btnThemMauSac = new javax.swing.JButton();
        btnSuaMauSac = new javax.swing.JButton();
        btnQuayLaiMauSac = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbMauSac = new javax.swing.JTable();
        btnDeleteMauSac = new javax.swing.JButton();
        PanelDongSanPham = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaDSP = new javax.swing.JTextField();
        txtTenDSP = new javax.swing.JTextField();
        btnThemDSP = new javax.swing.JButton();
        btnSuaDSP = new javax.swing.JButton();
        btnQuayLaiDSP = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbDSP = new javax.swing.JTable();
        btnDeleteDongSanPham = new javax.swing.JButton();
        PanelNhaSanXuat = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaNSX = new javax.swing.JTextField();
        txtTenNSX = new javax.swing.JTextField();
        btnThemNSX = new javax.swing.JButton();
        btnSuaNSX = new javax.swing.JButton();
        btnQuayLaiNSX = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbNSX = new javax.swing.JTable();
        btnDeleteNhaSanXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ma SP");

        jLabel2.setText("Ten SP");

        btnThemSanPham.setText("Them");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        btnSuaSanPham.setText("Sua");
        btnSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamActionPerformed(evt);
            }
        });

        btnQuayLaiSanPham.setText("Quay lai");
        btnQuayLaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiSanPhamActionPerformed(evt);
            }
        });

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

        btnDeleteSanPham.setText("Xoa");
        btnDeleteSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSanPhamLayout = new javax.swing.GroupLayout(PanelSanPham);
        PanelSanPham.setLayout(PanelSanPhamLayout);
        PanelSanPhamLayout.setHorizontalGroup(
            PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSanPhamLayout.createSequentialGroup()
                .addGroup(PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSanPhamLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(55, 55, 55)
                        .addGroup(PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaSP)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                    .addGroup(PanelSanPhamLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuayLaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        PanelSanPhamLayout.setVerticalGroup(
            PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSanPhamLayout.createSequentialGroup()
                .addGroup(PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelSanPhamLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnDeleteSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnQuayLaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SanPham", PanelSanPham);

        jLabel9.setText("Ma MS");

        jLabel10.setText("Ten MS");

        btnThemMauSac.setText("Them");
        btnThemMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauSacActionPerformed(evt);
            }
        });

        btnSuaMauSac.setText("Sua");
        btnSuaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMauSacActionPerformed(evt);
            }
        });

        btnQuayLaiMauSac.setText("Quay lai");
        btnQuayLaiMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiMauSacActionPerformed(evt);
            }
        });

        tbMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMauSacMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbMauSac);

        btnDeleteMauSac.setText("Xoa");
        btnDeleteMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMauSacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMauSacLayout = new javax.swing.GroupLayout(PanelMauSac);
        PanelMauSac.setLayout(PanelMauSacLayout);
        PanelMauSacLayout.setHorizontalGroup(
            PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMauSacLayout.createSequentialGroup()
                .addGroup(PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMauSacLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(55, 55, 55)
                        .addGroup(PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaMS)
                            .addComponent(txtTenMS, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                    .addGroup(PanelMauSacLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSuaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuayLaiMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        PanelMauSacLayout.setVerticalGroup(
            PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMauSacLayout.createSequentialGroup()
                .addGroup(PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelMauSacLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelMauSacLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtMaMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTenMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnQuayLaiMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MauSac", PanelMauSac);

        jLabel11.setText("Ma DSP");

        jLabel12.setText("Ten DSP");

        btnThemDSP.setText("Them");
        btnThemDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDSPActionPerformed(evt);
            }
        });

        btnSuaDSP.setText("Sua");
        btnSuaDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDSPActionPerformed(evt);
            }
        });

        btnQuayLaiDSP.setText("Quay lai");
        btnQuayLaiDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiDSPActionPerformed(evt);
            }
        });

        tbDSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDSPMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbDSP);

        btnDeleteDongSanPham.setText("Xoa");
        btnDeleteDongSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDongSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDongSanPhamLayout = new javax.swing.GroupLayout(PanelDongSanPham);
        PanelDongSanPham.setLayout(PanelDongSanPhamLayout);
        PanelDongSanPhamLayout.setHorizontalGroup(
            PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDongSanPhamLayout.createSequentialGroup()
                .addGroup(PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDongSanPhamLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(55, 55, 55)
                        .addGroup(PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaDSP)
                            .addComponent(txtTenDSP, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                    .addGroup(PanelDongSanPhamLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSuaDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuayLaiDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        PanelDongSanPhamLayout.setVerticalGroup(
            PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDongSanPhamLayout.createSequentialGroup()
                .addGroup(PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDongSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelDongSanPhamLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMaDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelDongSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtTenDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnQuayLaiDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DongSanPham", PanelDongSanPham);

        jLabel13.setText("Ma NSX");

        jLabel14.setText("Ten NSX");

        btnThemNSX.setText("Them");
        btnThemNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNSXActionPerformed(evt);
            }
        });

        btnSuaNSX.setText("Sua");
        btnSuaNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNSXActionPerformed(evt);
            }
        });

        btnQuayLaiNSX.setText("Quay lai");
        btnQuayLaiNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiNSXActionPerformed(evt);
            }
        });

        tbNSX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNSXMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbNSX);

        btnDeleteNhaSanXuat.setText("Xoa");
        btnDeleteNhaSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNhaSanXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelNhaSanXuatLayout = new javax.swing.GroupLayout(PanelNhaSanXuat);
        PanelNhaSanXuat.setLayout(PanelNhaSanXuatLayout);
        PanelNhaSanXuatLayout.setHorizontalGroup(
            PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNhaSanXuatLayout.createSequentialGroup()
                .addGroup(PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNhaSanXuatLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(55, 55, 55)
                        .addGroup(PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNSX)
                            .addComponent(txtTenNSX, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                    .addGroup(PanelNhaSanXuatLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSuaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuayLaiNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        PanelNhaSanXuatLayout.setVerticalGroup(
            PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNhaSanXuatLayout.createSequentialGroup()
                .addGroup(PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelNhaSanXuatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelNhaSanXuatLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelNhaSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtTenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnQuayLaiNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("NhaSanXuat", PanelNhaSanXuat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        SanPham sp = new SanPham();
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sps.saveSP(sp);
        listSanPham = sps.getSanPham();
        showDataTableSP(listSanPham);
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamActionPerformed
        row = tbSanPham.getSelectedRow();
        SanPham sp = listSanPham.get(row);
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sps.updateSP(sp);
        listSanPham = sps.getSanPham();
        showDataTableSP(listSanPham);
    }//GEN-LAST:event_btnSuaSanPhamActionPerformed

    private void btnThemMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauSacActionPerformed
        MauSac ms = new MauSac();
        ms.setMaMauSac(txtMaMS.getText());
        ms.setTenMauSac(txtTenMS.getText());
        mss.saveMS(ms);
        listMauSac = mss.getMauSac();
        showDataTableMS(listMauSac);
    }//GEN-LAST:event_btnThemMauSacActionPerformed

    private void btnSuaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMauSacActionPerformed
        row = tbMauSac.getSelectedRow();
        MauSac ms = listMauSac.get(row);
        ms.setMaMauSac(txtMaMS.getText());
        ms.setTenMauSac(txtTenMS.getText());
        mss.updateMS(ms);
        listMauSac = mss.getMauSac();
        showDataTableMS(listMauSac);
    }//GEN-LAST:event_btnSuaMauSacActionPerformed

    private void btnThemDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDSPActionPerformed
        DongSanPham dsp = new DongSanPham();
        dsp.setMaDongSP(txtMaDSP.getText());
        dsp.setTenDongSP(txtTenDSP.getText());
        dsps.saveDSP(dsp);
        listDSP = dsps.getDongSanPham();
        showDataTableDSP(listDSP);
    }//GEN-LAST:event_btnThemDSPActionPerformed

    private void btnSuaDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDSPActionPerformed
        row = tbDSP.getSelectedRow();
        DongSanPham dsp = listDSP.get(row);
        dsp.setMaDongSP(txtMaDSP.getText());
        dsp.setTenDongSP(txtTenDSP.getText());
        dsps.updateDSP(dsp);
        listDSP = dsps.getDongSanPham();
        showDataTableDSP(listDSP);
    }//GEN-LAST:event_btnSuaDSPActionPerformed

    private void btnThemNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNSXActionPerformed
        NhaSanXuat nsx = new NhaSanXuat();
        nsx.setMaNSX(txtMaNSX.getText());
        nsx.setTenNSX(txtTenNSX.getText());
        nsxs.saveNSX(nsx);
        listNSX = nsxs.getNhaSanXuat();
        showDataTableNSX(listNSX);
    }//GEN-LAST:event_btnThemNSXActionPerformed

    private void btnSuaNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNSXActionPerformed
        row = tbNSX.getSelectedRow();
        NhaSanXuat nsx = listNSX.get(row);
        nsx.setMaNSX(txtMaNSX.getText());
        nsx.setTenNSX(txtTenNSX.getText());
        nsxs.updateNSX(nsx);
        listNSX = nsxs.getNhaSanXuat();
        showDataTableNSX(listNSX);
    }//GEN-LAST:event_btnSuaNSXActionPerformed

    private void btnQuayLaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiSanPhamActionPerformed
        ViewQuanLySanPham vqlsp = new ViewQuanLySanPham();
        vqlsp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiSanPhamActionPerformed

    private void btnQuayLaiMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiMauSacActionPerformed
        ViewQuanLySanPham vqlsp = new ViewQuanLySanPham();
        vqlsp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiMauSacActionPerformed

    private void btnQuayLaiDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiDSPActionPerformed
        ViewQuanLySanPham vqlsp = new ViewQuanLySanPham();
        vqlsp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiDSPActionPerformed

    private void btnQuayLaiNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiNSXActionPerformed
        ViewQuanLySanPham vqlsp = new ViewQuanLySanPham();
        vqlsp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiNSXActionPerformed

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        row = tbSanPham.getSelectedRow();
        fillDataSanPham(row);
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void tbMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMauSacMouseClicked
        row = tbMauSac.getSelectedRow();
        fillDataMauSac(row);
    }//GEN-LAST:event_tbMauSacMouseClicked

    private void tbDSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDSPMouseClicked
        row = tbDSP.getSelectedRow();
        fillDataDongSanPham(row);
    }//GEN-LAST:event_tbDSPMouseClicked

    private void tbNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNSXMouseClicked
        row = tbNSX.getSelectedRow();
        fillDataNhaSanXuat(row);
    }//GEN-LAST:event_tbNSXMouseClicked

    private void btnDeleteSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSanPhamActionPerformed
        SanPham sp = sps.getByMaSP(txtMaSP.getText());
        sps.deleteCTSPBySP(sp);
        sps.deleteSPByID(sp);
        listSanPham = sps.getSanPham();
        showDataTableSP(listSanPham);
    }//GEN-LAST:event_btnDeleteSanPhamActionPerformed

    private void btnDeleteMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMauSacActionPerformed
        MauSac ms = mss.getByMaMauSac(txtMaMS.getText());
        mss.deleteCTSPByMS(ms);
        mss.deleteMSByID(ms);
        listMauSac = mss.getMauSac();
        showDataTableMS(listMauSac);
    }//GEN-LAST:event_btnDeleteMauSacActionPerformed

    private void btnDeleteDongSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDongSanPhamActionPerformed
        DongSanPham dsp = dsps.getByMaDSP(txtMaDSP.getText());
        dsps.deleteCTSPByDSP(dsp);
        dsps.deleteDSPByID(dsp);
        listDSP = dsps.getDongSanPham();
        showDataTableDSP(listDSP);
    }//GEN-LAST:event_btnDeleteDongSanPhamActionPerformed

    private void btnDeleteNhaSanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNhaSanXuatActionPerformed
        NhaSanXuat nsx = nsxs.getByMaNSX(txtMaNSX.getText());
        nsxs.deleteCTSPByNSX(nsx);
        nsxs.deleteNSXByID(nsx);
        listNSX = nsxs.getNhaSanXuat();
        showDataTableNSX(listNSX);
    }//GEN-LAST:event_btnDeleteNhaSanXuatActionPerformed

    private void showDataTableSP(List<SanPham> lists) {
        STT = 1;
        modelSanPham.setRowCount(0);
        for (SanPham sp : lists) {
            modelSanPham.addRow(new Object[]{STT++, sp.getMaSP(), sp.getTenSP()});
        }
    }

    private void showDataTableDSP(List<DongSanPham> lists) {
        STT = 1;
        modelDSP.setRowCount(0);
        for (DongSanPham dsp : lists) {
            modelDSP.addRow(new Object[]{STT++, dsp.getMaDongSP(), dsp.getTenDongSP()});
        }
    }

    private void showDataTableNSX(List<NhaSanXuat> lists) {
        STT = 1;
        modelNSX.setRowCount(0);
        for (NhaSanXuat nsx : lists) {
            modelNSX.addRow(new Object[]{STT++, nsx.getMaNSX(), nsx.getTenNSX()});
        }
    }

    private void showDataTableMS(List<MauSac> lists) {
        STT = 1;
        modelMauSac.setRowCount(0);
        for (MauSac ms : lists) {
            modelMauSac.addRow(new Object[]{STT++, ms.getMaMauSac(), ms.getTenMauSac()});
        }
    }
    
    private void fillDataSanPham(int index){
        SanPham sp = listSanPham.get(index);
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
    }
    
    private void fillDataDongSanPham(int index){
        DongSanPham dsp = listDSP.get(index);
        txtMaDSP.setText(dsp.getMaDongSP());
        txtTenDSP.setText(dsp.getTenDongSP());
    }
    
    private void fillDataNhaSanXuat(int index){
        NhaSanXuat nsx = listNSX.get(index);
        txtMaNSX.setText(nsx.getMaNSX());
        txtTenNSX.setText(nsx.getTenNSX());
    }
    
    private void fillDataMauSac(int index){
        MauSac ms = listMauSac.get(index);
        txtMaMS.setText(ms.getMaMauSac());
        txtTenMS.setText(ms.getTenMauSac());
    }

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
            java.util.logging.Logger.getLogger(ViewThemNhanhQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanhQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanhQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanhQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThemNhanhQuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDongSanPham;
    private javax.swing.JPanel PanelMauSac;
    private javax.swing.JPanel PanelNhaSanXuat;
    private javax.swing.JPanel PanelSanPham;
    private javax.swing.JButton btnDeleteDongSanPham;
    private javax.swing.JButton btnDeleteMauSac;
    private javax.swing.JButton btnDeleteNhaSanXuat;
    private javax.swing.JButton btnDeleteSanPham;
    private javax.swing.JButton btnQuayLaiDSP;
    private javax.swing.JButton btnQuayLaiMauSac;
    private javax.swing.JButton btnQuayLaiNSX;
    private javax.swing.JButton btnQuayLaiSanPham;
    private javax.swing.JButton btnSuaDSP;
    private javax.swing.JButton btnSuaMauSac;
    private javax.swing.JButton btnSuaNSX;
    private javax.swing.JButton btnSuaSanPham;
    private javax.swing.JButton btnThemDSP;
    private javax.swing.JButton btnThemMauSac;
    private javax.swing.JButton btnThemNSX;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbDSP;
    private javax.swing.JTable tbMauSac;
    private javax.swing.JTable tbNSX;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtMaDSP;
    private javax.swing.JTextField txtMaMS;
    private javax.swing.JTextField txtMaNSX;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenDSP;
    private javax.swing.JTextField txtTenMS;
    private javax.swing.JTextField txtTenNSX;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
