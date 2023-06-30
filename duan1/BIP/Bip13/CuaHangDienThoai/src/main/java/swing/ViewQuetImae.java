/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package swing;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.IDienThoaiService;
import service.IPhuKienService;
import service.IimeiService;
import service.impl.DienThoaiService;
import service.impl.ImeiService;
import service.impl.PhuKienService;
import viewmodel.QLDTNhaCungCap;
import viewmodel.QLDienThoai;
import viewmodel.QLImei;
import viewmodel.QLPhuKien;
import viewmodel.QLPhuKienNCC;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ongbi
 */
public class ViewQuetImae extends javax.swing.JFrame implements Runnable, ThreadFactory {

    /**
     * Creates new form ViewQuetImae
     */
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private IimeiService iimeiService = new ImeiService();
    private List<QLImei> lImeisDT = new ArrayList<>();
    private List<QLImei> lImeisChua = new ArrayList<>();
    private List<QLImei> lImeisChuaPK = new ArrayList<>();
    private DefaultTableModel dtmNhap;
    private List<QLImei> lImeisPK = new ArrayList<>();
    private List<QLDTNhaCungCap> listDTNcc1;
    private List<QLPhuKienNCC> listPKNcc1;
    private QLPhuKienNCC qLPhuKienNCC;
    private QLDTNhaCungCap qLDTNhaCungCap1;
    private IDienThoaiService iDienThoaiService = new DienThoaiService();
    private IPhuKienService iPhuKienService = new PhuKienService();

    public ViewQuetImae(java.awt.Frame parent, boolean modal, List<QLDTNhaCungCap> listDT, List<QLPhuKienNCC> listPK, QLDTNhaCungCap qLDTNhaCungCap, QLPhuKienNCC qLPhuKienNCC, List<QLImei> lImeisChua, DefaultTableModel dtm) {
        initComponents();
        setLocationRelativeTo(null);
        this.qLPhuKienNCC = qLPhuKienNCC;
        this.qLDTNhaCungCap1 = qLDTNhaCungCap;
        this.listDTNcc1 = listDT;
        this.listPKNcc1 = listPK;
        this.dtmNhap = dtm;
        if (listPKNcc1 == null) {
            QLDienThoai qlDT = iDienThoaiService.getOne(this.qLDTNhaCungCap1.getMadienThoai());
            lbTenDt.setText(qlDT.getTenDienThoai());
            this.lImeisChua = lImeisChua;

        } else {
            QLPhuKien qLPhuKien = iPhuKienService.getOne(this.qLPhuKienNCC.getMaphuKien());
            lbTenDt.setText(qLPhuKien.getTen());
            this.lImeisChuaPK = lImeisChua;

        }

        initWebcam();
        header();

    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);

    }

    private void header() {
        tbList.getTableHeader().setBackground(new Color(71, 120, 197));
        tbList.getTableHeader().setForeground(Color.WHITE);
        tbList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        ((DefaultTableCellRenderer) tbList.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

    }

    private void loadTable(List<QLImei> list) {
        int STT = 1;
        DefaultTableModel dtm = (DefaultTableModel) tbList.getModel();
        dtm.setRowCount(0);

        for (QLImei qLImei : list) {
            Object[] toRowData = {
                STT++,
                qLImei.getMa(),};
            dtm.addRow(toRowData);
        }
    }

    private void loadTablePK(List<QLImei> list) {
        int STT = 1;
        DefaultTableModel dtm = (DefaultTableModel) tbList.getModel();
        dtm.setRowCount(0);
        for (QLImei qLImei : list) {
            Object[] toRowData = {
                STT++,
                qLImei.getMa(),};
            dtm.addRow(toRowData);
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

        jPanel1 = new javax.swing.JPanel();
        lbTenDt = new javax.swing.JLabel();
        txtImae = new javax.swing.JTextField();
        btnTroLai = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnFake = new javax.swing.JButton();
        btnTiepTuc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbTenDt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenDt.setText("--");

        txtImae.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtImae.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(71, 120, 197)));

        btnTroLai.setBackground(new java.awt.Color(71, 120, 197));
        btnTroLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quayLai.png"))); // NOI18N
        btnTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLaiActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(71, 120, 197));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Multiply_25px.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnFake.setBackground(new java.awt.Color(71, 120, 197));
        btnFake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/project.png"))); // NOI18N
        btnFake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFakeActionPerformed(evt);
            }
        });

        btnTiepTuc.setBackground(new java.awt.Color(71, 120, 197));
        btnTiepTuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tiepTuc.png"))); // NOI18N
        btnTiepTuc.setEnabled(false);
        btnTiepTuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiepTucActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(71, 120, 197)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbList.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tbList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Imei"
            }
        ));
        tbList.setRowHeight(25);
        tbList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtImae, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTroLai)
                    .addComponent(btnFake)
                    .addComponent(btnTiepTuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 414, Short.MAX_VALUE)
                .addComponent(lbTenDt, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbTenDt)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtImae, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btnTroLai)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFake)
                                .addGap(18, 18, 18)
                                .addComponent(btnTiepTuc))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTiepTucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiepTucActionPerformed
        webcam.close();
        if (listPKNcc1 == null) {
            for (QLImei qLImei : lImeisDT) {
                lImeisChua.add(qLImei);
            }
            qLDTNhaCungCap1.setTrangThai(1);
            showDataTableChuaDt(listDTNcc1);
            System.out.println(lImeisChua);
        } else {
            for (QLImei qLImei : lImeisPK) {
                lImeisChuaPK.add(qLImei);
            }
            qLPhuKienNCC.setTrangThai(1);
            showDataTableChuaPk(listPKNcc1);
            System.out.println(lImeisChuaPK);
        }

        dispose();
    }//GEN-LAST:event_btnTiepTucActionPerformed
    public void showDataTableChuaDt(List<QLDTNhaCungCap> list) {
        dtmNhap.setRowCount(0);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy");
        for (QLDTNhaCungCap x : list) {
            dtmNhap.addRow(new Object[]{x.getMadienThoai(), x.getManhaCungCap(), x.getSoLuongNhap(), x.getGiaNhap(), formatter.format(x.getNgayNhap()), x.getTrangThai() == 0 ? "Chưa có imei" : "Đã có imei"});
        }
    }

    public void showDataTableChuaPk(List<QLPhuKienNCC> list) {
        dtmNhap.setRowCount(0);
          SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy");
        for (QLPhuKienNCC x : list) {
            dtmNhap.addRow(new Object[]{x.getMaphuKien(), x.getManhaCungCap(), x.getSoLuongNhap(), x.getGiaNhap(), formatter.format(x.getNgayNhap()), x.getTrangThai() == 0 ? "Chưa có imei" : "Đã có imei"});
        }
    }
    private void btnTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLaiActionPerformed
        webcam.close();
        dispose();
    }//GEN-LAST:event_btnTroLaiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tbList.getSelectedRow();
        if (row <= -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn để xóa");
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa", "Xóa", JOptionPane.YES_NO_OPTION);
        if (chon != JOptionPane.YES_OPTION) {
            return;
        }
        System.out.println(row);
        if (listPKNcc1 == null) {
//            lImeisDT = iimeiService.getAllDT(qLDTNhaCungCap1.getIdienThoai());
            QLImei imei = lImeisDT.get(row);
            lImeisDT.remove(imei);
            loadTable(lImeisDT);
        } else {
            QLImei imei = lImeisPK.get(row);
            lImeisPK.remove(imei);
            loadTable(lImeisPK);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnFakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFakeActionPerformed
        if (qLPhuKienNCC == null) {
            int soLuongCo = lImeisDT.size();
            for (int i = 0; i < (qLDTNhaCungCap1.getSoLuongNhap() - soLuongCo); i++) {
                QLImei imei = new QLImei(null, genMa(), 0, this.qLDTNhaCungCap1.getIdienThoai(), null, this.qLDTNhaCungCap1.getInhaCungCap(), this.qLDTNhaCungCap1.getId(), null);
                lImeisDT.add(imei);
            }
            loadTable(lImeisDT);
            if (qLDTNhaCungCap1.getSoLuongNhap() == lImeisDT.size()) {
                btnTiepTuc.setEnabled(true);
            }

        } else {
            int soLuongCo = lImeisPK.size();
            for (int i = 0; i < (qLPhuKienNCC.getSoLuongNhap() - soLuongCo); i++) {
                QLImei imei = new QLImei(null, genMa(), 0, null, this.qLPhuKienNCC.getIphuKien(), this.qLPhuKienNCC.getInhaCungCap(), null, this.qLPhuKienNCC.getId());

                lImeisPK.add(imei);
            }
            loadTable(lImeisPK);
            if (qLPhuKienNCC.getSoLuongNhap() == lImeisPK.size()) {
                btnTiepTuc.setEnabled(true);
            }
        }

    }//GEN-LAST:event_btnFakeActionPerformed

    private String genMa() {
        long random = (long) (Math.random() * 10000000000000000L);
        String ma = String.valueOf(random);

        return ma;
    }
    private void tbListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListMouseClicked
        int row = tbList.getSelectedRow();
        System.out.println(row);
    }//GEN-LAST:event_tbListMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFake;
    private javax.swing.JButton btnTiepTuc;
    private javax.swing.JButton btnTroLai;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTenDt;
    private javax.swing.JTable tbList;
    private javax.swing.JTextField txtImae;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                if (this.qLPhuKienNCC == null) {
                    if (iimeiService.getOne(result.getText()) != null) {
                        JOptionPane.showMessageDialog(this, "Imei đã tồn tại");
                        return;
                    }
                    int flag = 0;
                    for (QLImei qLImei : lImeisDT) {
                        if (qLImei.getMa().equals(result.getText())) {
                            JOptionPane.showMessageDialog(this, "Imei đã tồn tại");
                            flag = 1;

                        }

                    }
                    for (QLImei qLImei2 : lImeisChua) {
                        if (qLImei2.getMa().equals(result.getText())) {
                            JOptionPane.showMessageDialog(this, "Imei đã tồn tại");
                            flag = 1;

                        }
                    }

                    int tong = qLDTNhaCungCap1.getSoLuongNhap();

                    txtImae.setText(result.getText());
                    QLImei imei = new QLImei(null, result.getText(), 0, this.qLDTNhaCungCap1.getIdienThoai(), null, this.qLDTNhaCungCap1.getInhaCungCap(), this.qLDTNhaCungCap1.getId(), null);
                    System.out.println(imei.getIdDienThoaiNCC());
                    if (flag == 0 && tong > lImeisDT.size()) {
                        lImeisDT.add(imei);
                    } else {
                        JOptionPane.showMessageDialog(this, "Imei không được vượt quá số lượng nhập");
                        return;
                    }

                    System.out.println(tong);//            
                    System.out.println(lImeisDT.size());
                    if (tong == lImeisDT.size()) {
                        btnTiepTuc.setEnabled(true);
                    }

//                    iimeiService.save(imei);
                    result = null;
                    loadTable(lImeisDT);

                } else {
                    if (iimeiService.getOne(result.getText()) != null) {
                        JOptionPane.showMessageDialog(this, "Imei đã tồn tại");
                        return;
                    }
                    int flag = 0;
                    for (QLImei qLImei : lImeisPK) {
                        if (qLImei.getMa().equals(result.getText())) {
                            JOptionPane.showMessageDialog(this, "Imei đã tồn tại");
                            flag = 1;

                        }

                    }
                    for (QLImei qLImei2 : lImeisChuaPK) {
                        if (qLImei2.getMa().equals(result.getText())) {
                            JOptionPane.showMessageDialog(this, "Imei đã tồn tại");
                            flag = 1;

                        }
                    }
                    int tong = qLPhuKienNCC.getSoLuongNhap();
//                    for (QLPhuKienNCC x : listPKNcc1) {
//                        if (x.getId().equals(this.qLPhuKienNCC.getId())) {
//
//                            tong += x.getSoLuongNhap();
//
//                        }
//                    }

                    txtImae.setText(result.getText());
                    QLImei imei = new QLImei(null, result.getText(), 0, null, this.qLPhuKienNCC.getIphuKien(), this.qLPhuKienNCC.getInhaCungCap(), null, this.qLPhuKienNCC.getId());
                    if (flag == 0 && lImeisPK.size() < tong) {
                        lImeisPK.add(imei);
                    }
                    for (QLImei qLImei : lImeisPK) {
                        System.out.println(qLImei);
                    }

                    System.out.println(tong);
                    System.out.println(lImeisPK.size());
                    if (tong == lImeisPK.size()) {
                        btnTiepTuc.setEnabled(true);
                    }
                    result = null;
                    loadTablePK(lImeisPK);
                }

//                DienThoai dienThoai = this.dienThoai.getOne(result.getText());
//                ShowProduct.getValues(dienThoai,hd1);
//                webcam.close();
//                dispose();
            }

        } while (true);

    }
//    private String genMa(){
//       String genMaImei = "";
//       String s1 = "#";
//        for (int i = 0; i < 10; i++) {
//            
//        }
//    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
