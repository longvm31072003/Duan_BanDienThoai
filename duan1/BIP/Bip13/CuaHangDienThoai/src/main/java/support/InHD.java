/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package support;

import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.KhachHang;
import java.awt.print.PrinterException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import repository.impl.HoaDonChiTietRepository;
import repository.impl.HoaDonRepository;
import swing.Home;
import static swing.Home.lblTenKhachHang;
import static swing.Home.txtTongTien;

/**
 *
 * @author sktfk
 */
public class InHD extends javax.swing.JFrame {

    /**
     * Creates new form InHD
     */
    JTable tblHoaDon ;
    JTable tblHoaDonChiTiet;
    HoaDonRepository hoaDonRepo = new HoaDonRepository();
    KhachHang khachHangMua ;
    HoaDonChiTietRepository hoaDonChiTietRepo = new HoaDonChiTietRepository();
    public InHD() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public InHD(JTable tblHoaDon, JTable tblHoaDonChiTiet, JLabel lblManV, JLabel lblMaHD, JTextField txtTienKhachDua, JTextField txtTienTraKhach,KhachHang khachHangMua) {
        initComponents();
        setLocationRelativeTo(null);
        this.tblHoaDon = tblHoaDon;
        this.khachHangMua = khachHangMua;
        int rowIndex = tblHoaDon.getSelectedRow();
//       ImageIcon icon=new ImageIcon("D:\\Thongke\\4647241.png"); 


            bill.setText("<<<N2>>>Cửa hàng bán điện thoại       \t PHIẾU THANH TOÁN \n");
            bill.setText(bill.getText() + " Đc:fpt poly ,Hà Nội ");
// bill.setText(bill.getText() +icon.getImage());

            DefaultTableModel dfk = (DefaultTableModel) tblHoaDon.getModel();

//                for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
            String namek = dfk.getValueAt(rowIndex, 2).toString();

            bill.setText(bill.getText() + "\t  \t Ngày Tạo : " + namek + "\n");
//                bill.setText(bill.getText() + name+ "\n");

//            }
            bill.setText(bill.getText() + "  \n");
            bill.setText(bill.getText() + "Họ tên Khách hàng :" + lblTenKhachHang.getText() + "\n");
            bill.setText(bill.getText() + "Nhân viên bán hàng :" + lblManV.getText());
//            bill.setText(bill.getText() + "SDT :..... .......................");
            bill.setText(bill.getText() + "\t \t \t Mã số:" + lblMaHD.getText() + "\n");
//            bill.setText(bill.getText() + "Tên sản Phẩm \t SL \tđơn giá \t Thành tiền \n");
            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
            bill.setText(bill.getText() + "  Item \t\t\t\tQty \tPrice" + "\n");
            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
//              lấy table

            DefaultTableModel df = (DefaultTableModel) tblHoaDonChiTiet.getModel();

            for (int i = 0; i < tblHoaDonChiTiet.getRowCount(); i++) {
                String name = df.getValueAt(i, 0).toString();
                String qt = df.getValueAt(i, 1).toString();
                String prc = df.getValueAt(i, 2).toString();
                bill.setText(bill.getText() + "  " + name + "\t\t" + qt + "\t" + prc + "\n");

            }

            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
//       bill.setText(bill.getText() + "Số tiền giảm :" + jTextField97.getText() + "\n");
            bill.setText(bill.getText() + "Tổng tiền :" + txtTongTien.getText() + "\n");
            bill.setText(bill.getText() + "Tiền khách đưa :" + txtTienKhachDua.getText() + "\n");
            bill.setText(bill.getText() + "Tiền trả khách :" + txtTienTraKhach.getText() + "\n");
            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
            bill.setText(bill.getText() + "                     Thanks For Your Business...!" + "\n");
            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
    }

    public void bill_print(JTable tblHoaDon, JTable tblHoaDonChiTiet, JLabel lblManV, JLabel lblMaHD, JLabel txtTienKhachDua, JLabel txtTienTraKhach) {
        int rowIndex = tblHoaDon.getSelectedRow();
//       ImageIcon icon=new ImageIcon("D:\\Thongke\\4647241.png"); 

        try {

            bill.setText("<<<N2>>>Cửa hàng bán điện thoại       \t PHIẾU THANH TOÁN \n");
            bill.setText(bill.getText() + " Đc:fpt poly ,Hà Nội ");
// bill.setText(bill.getText() +icon.getImage());

            DefaultTableModel dfk = (DefaultTableModel) tblHoaDon.getModel();

//                for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
            String namek = dfk.getValueAt(rowIndex, 2).toString();

            bill.setText(bill.getText() + "\t  \t Ngày Tạo : " + namek + "\n");
//                bill.setText(bill.getText() + name+ "\n");

//            }
            bill.setText(bill.getText() + "  \n");
            bill.setText(bill.getText() + "Họ tên Khách hàng :" + lblTenKhachHang.getText() + "\n");
            bill.setText(bill.getText() + "Nhân viên bán hàng :" + lblManV.getText());
//            bill.setText(bill.getText() + "SDT :..... .......................");
            bill.setText(bill.getText() + "\t \t \t Mã số:" + lblMaHD.getText() + "\n");
//            bill.setText(bill.getText() + "Tên sản Phẩm \t SL \tđơn giá \t Thành tiền \n");
            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
            bill.setText(bill.getText() + "  Item \t\t\t\tQty \tPrice" + "\n");
            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
//              lấy table

            DefaultTableModel df = (DefaultTableModel) tblHoaDonChiTiet.getModel();

            for (int i = 0; i < tblHoaDonChiTiet.getRowCount(); i++) {
                String name = df.getValueAt(i, 0).toString();
                String qt = df.getValueAt(i, 1).toString();
                String prc = df.getValueAt(i, 2).toString();
                bill.setText(bill.getText() + "  " + name + "\t\t" + qt + "\t" + prc + "\n");

            }

            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
//       bill.setText(bill.getText() + "Số tiền giảm :" + jTextField97.getText() + "\n");
            bill.setText(bill.getText() + "Tổng tiền :" + txtTongTien.getText() + "\n");
            bill.setText(bill.getText() + "Tiền khách đưa :" + txtTienKhachDua.getText() + "\n");
            bill.setText(bill.getText() + "Tiền trả khách :" + txtTienTraKhach.getText() + "\n");
            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
            bill.setText(bill.getText() + "                     Thanks For Your Business...!" + "\n");
            bill.setText(bill.getText() + "---------------------------------------------------------------------\n");
            bill.print();
        } catch (PrinterException ex) {
            System.out.println("Lỗi");
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

        pnlIn = new javax.swing.JPanel();
        abc = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlIn.setBackground(new java.awt.Color(255, 255, 255));
        pnlIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlInMouseClicked(evt);
            }
        });

        bill.setEditable(false);
        bill.setColumns(20);
        bill.setRows(5);
        abc.setViewportView(bill);

        jButton1.setText("Xác nhận");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Huỷ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInLayout = new javax.swing.GroupLayout(pnlIn);
        pnlIn.setLayout(pnlInLayout);
        pnlInLayout.setHorizontalGroup(
            pnlInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(pnlInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abc)
                .addContainerGap())
        );
        pnlInLayout.setVerticalGroup(
            pnlInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(abc, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlInMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlInMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            bill.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
        
        String maHd = tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString();
        HoaDon hd = hoaDonRepo.getOne(maHd);
        List<HoaDonChiTiet> hdct = HoaDonChiTietRepository.getAll(maHd);
        if (hdct.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa thêm sản phẩm cần thanh toán");
        } else {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
//            if (chkDiemTichLuy.isSelected()) {
//                hd.setDiemTichLuy(Integer.parseInt(txtDiem.getText()));
//                KhachHangRepository kh = new KhachHangRepository();
//                khachHangMua.setDiemTichLuy(0);
//                kh.update(khachHangMua, khachHangMua.getId());
//            }
            hd.setList(hdct);
            hd.setTrangThai(1);
            hd.setKhachHang(khachHangMua);
            hoaDonRepo.SaveOrUpdate(hd);
            Home.fillToHoaDon1(hoaDonRepo.getHoaDons(0));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(InHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InHD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane abc;
    private javax.swing.JTextArea bill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel pnlIn;
    // End of variables declaration//GEN-END:variables
}
