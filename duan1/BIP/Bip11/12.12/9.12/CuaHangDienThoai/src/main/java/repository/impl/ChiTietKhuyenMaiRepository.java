/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.ChiTietKhuyenMai;
import domainmodel.KhuyenMai;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IChiTietKhuyenMaiRepository;
import util.HibernatUtil;
import viewmodel.ChiTietKMCustom;

/**
 *
 * @author hoant
 */
public class ChiTietKhuyenMaiRepository implements IChiTietKhuyenMaiRepository {

    @Override
    public List<ChiTietKMCustom> getAll() {
        try (Session sess = HibernatUtil.getFACTORY().openSession()) {//String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa, String sanPham
            Query qr = sess.createQuery("SELECT new viewmodel.ChiTietKMCustom()  From ChiTietKhuyenMai ctkm LEFT JOIN ctkm.dienThoai dt");
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static List<KhuyenMai> getAll1(){
        try (Session sess = HibernatUtil.getFACTORY().openSession()) {//String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa, String sanPham
            Query qr = sess.createQuery("From KhuyenMai");
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static List<KhuyenMai> getAll(String timKiem){
        try (Session sess = HibernatUtil.getFACTORY().openSession()) {//String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa, String sanPham
            Query qr = sess.createQuery("From KhuyenMai k WHERE k.maKM like :a or k.tenKM like :a");
             qr.setParameter("a", "%"+timKiem+"%");
             List<KhuyenMai> l =  qr.getResultList();
            if (l.isEmpty()) {
                return null;
            }
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static List<KhuyenMai> Loc(String dau){
        try (Session sess = HibernatUtil.getFACTORY().openSession()) {//String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa, String sanPham
            Query qr = sess.createQuery("From KhuyenMai k WHERE k.ngayKT "+dau+" getdate()");
         //    qr.setParameter("dau", ">");
             List<KhuyenMai> l =  qr.getResultList();
            if (l.isEmpty()) {
                return null;
            }
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static KhuyenMai getOne(String maKM){
        try (Session sess = HibernatUtil.getFACTORY().openSession()) {//String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa, String sanPham
            Query qr = sess.createQuery("From KhuyenMai k where k.maKM =:makm");
            qr.setParameter("makm", maKM);
            return (KhuyenMai) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void SaveOrUpdate(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(km);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }
}
