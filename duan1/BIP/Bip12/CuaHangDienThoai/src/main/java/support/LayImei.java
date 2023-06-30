/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package support;

import domainmodel.DienThoai;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.Imei;
import domainmodel.ImeiDaBan;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repository.impl.HoaDonChiTietRepository;
import static support.ShowProduct.dienThoai;
import static support.ShowProduct.hoaDon;
import swing.Home;

/**
 *
 * @author sktfk
 */
public class LayImei extends javax.swing.JFrame {

    /**
     * Creates new form LayImei
     */
    SPTuanAnh sp = new SPTuanAnh();
    List<Imei> listHC = new ArrayList<>();
    List<ImeiDaBan> l = new ArrayList<>();
    DefaultTableModel modelHC;
    DefaultTableModel modelThemVao;

    HoaDonChiTietRepository hoaDonChiTietRepo = new HoaDonChiTietRepository();
    static DienThoai dienThoai;
    static HoaDon hoaDon;
    static int soLuong;

    public LayImei() {
        initComponents();
        setLocationRelativeTo(null);
        modelHC = (DefaultTableModel) tblImeiHienCo.getModel();
        modelThemVao = (DefaultTableModel) tblBan.getModel();
        listHC = sp.getAlliImeis(dienThoai.getMaDienThoai());
        fillToTableHT(listHC);
    }
    public LayImei(DienThoai dt, HoaDon hd,String soLuong) {
        initComponents();
        setLocationRelativeTo(null);
        dienThoai = dt;
        hoaDon = hd;
        this.soLuong = Integer.parseInt(soLuong);
        lblTenSP.setText(dienThoai.getTenDienThoai());
        lblSoLuong.setText(soLuong);
        modelHC = (DefaultTableModel) tblImeiHienCo.getModel();
        modelThemVao = (DefaultTableModel) tblBan.getModel();
        listHC = sp.getAlliImeis(dienThoai.getMaDienThoai());
        fillToTableHT(listHC);
    }

    void fillToTableHT(List<Imei> l) {
        modelHC.setRowCount(0);
        for (Imei x : l) {
            modelHC.addRow(new Object[]{tblImeiHienCo.getRowCount() + 1, x});
        }
    }

    void fillToTableBan(List<ImeiDaBan> l) {
        modelThemVao.setRowCount(0);
        for (ImeiDaBan x : l) {
            modelThemVao.addRow(new Object[]{tblBan.getRowCount() + 1, x});
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBan = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblTenSP = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblImeiHienCo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btnLayImei = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tên Sản Phẩm");

        tblBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Imei"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBan);

        jButton1.setText("Lấy Imei");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Số lượng sản phẩm cần lấy Imei");

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSoLuong.setText("-");

        lblTenSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenSP.setText("-");

        jButton2.setText("Quay Lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Tiếp Tục");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblImeiHienCo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Imei"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblImeiHienCo);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Các Imei hiện có");

        jButton4.setText("Tìm kiếm");

        btnLayImei.setText("Lấy Imei");
        btnLayImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayImeiActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLayImei, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addGap(34, 34, 34)
                                .addComponent(jButton3)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(lblTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLayImei)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnXoa))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLayImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayImeiActionPerformed
        // TODO add your handling code here:
        int row = tblImeiHienCo.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn imei cần lấy cho điện thoại");
            return;
        }

        Imei imei = (Imei) tblImeiHienCo.getValueAt(row, 1);
        ImeiDaBan i = new ImeiDaBan(imei.getId(), imei.getMa(), 1, null);
        modelHC.removeRow(row);
        l.add(i);
        //
        listHC.remove(row);
        fillToTableHT(listHC);
        //
        fillToTableBan(l);
        JOptionPane.showMessageDialog(this, "Bạn đã thêm thành công");
    }//GEN-LAST:event_btnLayImeiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblBan.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn Imei cần xoá");
            return;
        }
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá Imei này khỏi imei bán không ? ", "Xoá Imei", JOptionPane.YES_NO_OPTION);
        if (check != JOptionPane.YES_OPTION) {
            return;
        }
        ImeiDaBan i = l.get(row);
        l.remove(row);
        Imei i1 = new Imei(i.getId(), i.getMa(), 0, null, null);
        listHC.add(i1);
        fillToTableHT(listHC);
        fillToTableBan(l);
        JOptionPane.showMessageDialog(this, "Bạn đã xoá thành công");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (soLuong>l.size()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa lấy đủ Imei để bán");
            return;
        }
        HoaDonChiTiet hdct = hoaDonChiTietRepo.getAllDT(hoaDon.getMaHD(), dienThoai.getMaDienThoai());
        if (hdct == null) {
            hdct = new HoaDonChiTiet();
            hdct.setDienThoai(dienThoai);
            hdct.setDonGia(dienThoai.getGiaBan());
            hdct.setSoLuong(soLuong);
            hdct.setHoaDon(hoaDon);
            hoaDonChiTietRepo.SaveOrUpdate(hdct);
            Home.fillToHDCT(hoaDon.getMaHD());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            hdct.setSoLuong(hdct.getSoLuong() + soLuong);
            hoaDonChiTietRepo.SaveOrUpdate(hdct);
            Home.fillToHDCT(hoaDon.getMaHD());
            JOptionPane.showMessageDialog(this, "Vì sản phẩm này đã có nên sửa lại số lượng");
        }
        hdct = hoaDonChiTietRepo.getAllDT(hoaDon.getMaHD(), dienThoai.getMaDienThoai());
//        for (ImeiDaBan x : l) {
//            x.setHdct(hdct);
//        }
        sp.themImei(l,hdct);
        sp.updateThanhBanRoi(l);
        DienThoai dienThoai = hoaDonChiTietRepo.getDienThoai(LayImei.dienThoai.getMaDienThoai());
        dienThoai.setSoLuongTon(dienThoai.getSoLuongTon()-soLuong);
        hoaDonChiTietRepo.updateDienThoai(dienThoai);
        BigDecimal tongTien = hoaDonChiTietRepo.sumMoney(hoaDon.getMaHD());
        Home.txtTongTien.setText(String.format("%.0f", tongTien) + " Đ");
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ShowProduct.getValues(dienThoai, hoaDon);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LayImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LayImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LayImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LayImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LayImei().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLayImei;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JTable tblBan;
    private javax.swing.JTable tblImeiHienCo;
    // End of variables declaration//GEN-END:variables
}