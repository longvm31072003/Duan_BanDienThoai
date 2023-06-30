/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IKhuyenMaiRepository;
import util.HibernatUtil;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author hoant
 */
public class KhuyenMaiRepository implements IKhuyenMaiRepository {

    @Override
    public List<KhuyenMaiViewModel> getAll() {
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT new viewmodel.KhuyenMaiViewModel(km.id,km.maKM,km.tenKM,km.mucKhuyenMai,km.hinhThucKhuyenMai,km.ngayBatDau,km.ngayKT,km.trangThai,km.moTa) FROM domainmodel.KhuyenMai km");
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Boolean add(KhuyenMai km) {
        Transaction tran = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.save(km);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean update(KhuyenMai km, UUID id) {
        Transaction tran = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            KhuyenMai kh1 = session.get(KhuyenMai.class, id);
//            kh1.setChietKhau(km.getChietKhau());
            kh1.setMaKM(km.getMaKM());
            kh1.setNgayBatDau(km.getNgayBatDau());
            kh1.setNgayKT(km.getNgayKT());
//            kh1.setSoTienGiam(km.getSoTienGiam());
            kh1.setTenKM(km.getTenKM());
            kh1.setTrangThai(km.getTrangThai());
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
            KhuyenMai km = session.find(KhuyenMai.class, id);
            session.delete(km);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new KhuyenMaiRepository().themKM());
    }

    @Override
    public List<KhuyenMai> themKM() {
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            //String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa
//            Query qr = session.createQuery("SELECT new viewmodel.KhuyenMaiViewModel(km.id,km.maKM,km.tenKM,km.mucKhuyenMai,km.hinhThucKhuyenMai,km.ngayBatDau,km.ngayKT,km.trangThai,km.moTa) FROM domainmodel.KhuyenMai km");
            Query qr = session.createQuery("SELECT km.id, km.maKM,km.tenKM,km.mucKhuyenMai,km.hinhThucKhuyenMai,km.hinhThucKhuyenMai,km.ngayBatDau,km.ngayKT,km.trangThai,km.moTa FROM KhuyenMai km LEFT JOIN km.id ctkm ");
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
