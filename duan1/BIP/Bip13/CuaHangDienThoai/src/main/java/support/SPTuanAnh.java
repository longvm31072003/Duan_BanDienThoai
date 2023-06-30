/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package support;

import domainmodel.ChiTietKhuyenMai;
import domainmodel.DienThoai;
import domainmodel.HoaDonChiTiet;
import domainmodel.Imei;
import domainmodel.ImeiDaBan;
import domainmodel.KhuyenMai;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernatUtil;

/**
 *
 * @author sktfk
 */
public class SPTuanAnh {
    
    public static List<Imei> getAlliImeis(String maDienThoai) {
        try ( Session sess = HibernatUtil.getFACTORY().openSession()) {
            Query qr = sess.createNativeQuery("SELECT i.IdImei,i.MaImei,i.TrangThai,i.IdDienThoaiNCC,i.IdPhuKienNCC"
                    + " FROM dbo.Imei i JOIN dbo.DienThoaiNCC ON DienThoaiNCC.IdDTNCC = "
                    + "i.IdDienThoaiNCC JOIN dbo.DienThoai ON DienThoai.IdDienThoai = DienThoaiNCC.IdDT"
                    + " WHERE dbo.DienThoai.MaDienThoai =:la and i.TrangThai = 0", Imei.class);
            qr.setParameter("la", maDienThoai);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public void updateThanhBanRoi(List<ImeiDaBan> l) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            for (ImeiDaBan x : l) {
                Imei i = getOne(x.getMa());
                i.setTrangThai(1);
                session.update(i);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }
    
    public void themImei(List<ImeiDaBan> l, HoaDonChiTiet hdct) {
        for (ImeiDaBan x : l) {
            System.out.println(x.getMa());
            Transaction transaction = null;
            try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
                transaction = session.beginTransaction();
                x.setHdct(hdct);
                session.save(x);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace(System.out);
                transaction.rollback();
            }
        }
    }
    
    

//    public static void main(String[] args) {
//        System.out.println(getChiTietKhuyenMai("DT05"));
//    }
    
    public static Imei getOne(String id) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Imei i WHERE i.ma =:so");
            query.setParameter("so", id);
            return (Imei) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
