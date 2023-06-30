/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
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
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        List<HoaDon> list;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From HoaDon Order by ngayTao DESC");
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

    public static HoaDon getOne(String maHD) {
        String hql = "FROM HoaDon WHERE MaHD =:ma";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ma", maHD);
            HoaDon hd = (HoaDon) q.getSingleResult();
            return hd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<HoaDon> getHoaDons(int trangThai) {
        String hql = "FROM HoaDon h WHERE h.trangThai =:trangthai";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("trangthai", trangThai);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        HoaDonChiTiet hdct  = getOne("HD05").getList().get(0);
        System.out.println(hdct);
    }
    public void SaveOrUpdate(HoaDon hd) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

    public void delete(HoaDon hd) {
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
        }
    }

//    public static void main(String[] args) {
//        HoaDon hd = getOne("HD1");
//        System.out.println(hd);
//    }
}
