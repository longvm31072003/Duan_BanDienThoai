/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.KhachHang;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IKhachHangRepository;
import util.HibernatUtil;
import viewmodel.KhachHangViewMD;

/**
 *
 * @author hoant
 */
public class KhachHangRepository implements IKhachHangRepository {

    @Override
    public List<KhachHangViewMD> getAll() {
        try (Session session = HibernatUtil.getFACTORY().openSession()) {//UUID id, String CCCD, String hoTen, String ghiChu, String SDT, String email, String diaChi, Integer diemTichLuy, Integer gioiTinh, Date ngayMua, Integer namSinh
            Query qr = session.createQuery("SELECT new viewmodel.KhachHangViewMD(kh.id,kh.maKH,kh.hoTenKH,kh.ghiChu,kh.SDT,kh.email,kh.diaChi,kh.diemTichLuy,kh.gioiTinh,kh.ngaySinh)FROM KhachHang kh");
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<KhachHang> getAll1() {
        try (Session session = HibernatUtil.getFACTORY().openSession()) {//UUID id, String CCCD, String hoTen, String ghiChu, String SDT, String email, String diaChi, Integer diemTichLuy, Integer gioiTinh, Date ngayMua, Integer namSinh
            Query qr = session.createQuery("From KhachHang");
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Boolean add(KhachHang kh) {
        Transaction tran = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.save(kh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean update(KhachHang kh, UUID id) {
        Transaction tran = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            KhachHang kh1 = session.get(KhachHang.class, id);
            kh1.setMaKH(kh.getMaKH());
            kh1.setDiaChi(kh.getDiaChi());
            kh1.setDiemTichLuy(kh.getDiemTichLuy());
            kh1.setEmail(kh.getEmail());
            kh1.setGhiChu(kh.getGhiChu());
            kh1.setGioiTinh(kh.getGioiTinh());
            kh1.setHoTenKH(kh.getHoTenKH());
            kh1.setNgaySinh(kh.getNgaySinh());
            kh1.setSDT(kh.getSDT());
            session.update(kh1);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(UUID id) {
        Transaction tran = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            KhachHang kh = session.find(KhachHang.class, id);
            session.delete(kh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangRepository().getAll());
    }

    @Override
    public List<KhachHang> search(String CCCD) {
        try (Session sess = HibernatUtil.getFACTORY().openSession()) {
            Query qr = sess.createQuery("SELECT k FROM KhachHang k WHERE k.maKH LIKE CONCAT('%',:CCCD,'%') OR k.hoTenKH LIKE CONCAT('%',:ten,'%') OR k.diaChi LIKE CONCAT('%',:diaChi,'%')");
            qr.setParameter("CCCD", CCCD);
            qr.setParameter("ten", CCCD);
            qr.setParameter("diaChi", CCCD);
            List<KhachHang> list = qr.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
