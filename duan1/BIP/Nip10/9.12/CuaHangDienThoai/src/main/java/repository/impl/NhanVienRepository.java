/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernatUtil;
import repository.INhanVienRepository;
import viewmodel.QLNhanVien;

/**
 *
 * @author lethi
 */
public class NhanVienRepository implements INhanVienRepository {

    @Override
    public List<QLNhanVien> getAll() {
        List<QLNhanVien> list = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT new viewmodel.QLNhanVien(x.id, x.ma, x.hoTen, x.gioiTinh, x.namSinh, x.diaChi, x.cccd, x.email, x.sdt, x.trangThai, x.anh, x.qr, x.taiKhoan, x.chucVu) FROM domainmodel.NhanVien x ");
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

    @Override
    public boolean add(NhanVien nhanVien) {
        boolean check = false;
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    @Override
    public boolean update(NhanVien nhanVien, UUID id) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(String.valueOf(id), nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(UUID id) {
        boolean check = false;
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            NhanVien nhanVien = session.get(NhanVien.class, id);
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check;

    }

    @Override
    public List<QLNhanVien> search(String CCCD) {
        try ( Session sess = HibernatUtil.getFACTORY().openSession()) {
            Query qr = sess.createQuery("SELECT new viewmodel.QLNhanVien(x.id, x.ma, x.hoTen, x.gioiTinh, x.namSinh, x.diaChi, x.cccd, x.email, x.sdt, x.trangThai, x.anh, x.qr, x.taiKhoan, x.chucVu) FROM domainmodel.NhanVien x WHERE x.cccd LIKE CONCAT('%',:CCCD,'%') "
                    + "OR x.hoTen LIKE CONCAT('%',:ten,'%') "
                    + "OR x.diaChi LIKE CONCAT('%',:diaChi,'%') "
                    + "OR x.email LIKE CONCAT('%',:email,'%') "
                    + "OR x.ma LIKE CONCAT('%',:ma,'%') "
                    + "OR x.namSinh LIKE CONCAT('%',:namSinh,'%') "
                    + "OR x.sdt LIKE CONCAT('%',:sdt,'%')");
            qr.setParameter("CCCD", CCCD);
            qr.setParameter("ten", CCCD);
            qr.setParameter("diaChi", CCCD);
            qr.setParameter("email", CCCD);
            qr.setParameter("ma", CCCD);
            qr.setParameter("namSinh", CCCD);
            qr.setParameter("sdt", CCCD);
            List<QLNhanVien> list = qr.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<QLNhanVien> getNVDLV() {
        List<QLNhanVien> list = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT new viewmodel.QLNhanVien(x.id, x.ma, x.hoTen, x.gioiTinh, x.namSinh, x.diaChi, x.cccd, x.email, x.sdt, x.trangThai, x.anh, x.qr, x.taiKhoan, x.chucVu) FROM domainmodel.NhanVien x WHERE x.trangThai = 1");
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }
    
    @Override
    public List<QLNhanVien> getNVDNV() {
        List<QLNhanVien> list = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT new viewmodel.QLNhanVien(x.id, x.ma, x.hoTen, x.gioiTinh, x.namSinh, x.diaChi, x.cccd, x.email, x.sdt, x.trangThai, x.anh, x.qr, x.taiKhoan, x.chucVu) FROM domainmodel.NhanVien x WHERE x.trangThai = 0");
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

}
