/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class KhachHangRep {

    Session session;

    public List<KhachHang> getListKhachHang() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From KhachHang");
            List<KhachHang> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public KhachHang getKhachHangByMa(String ma) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From KhachHang"
                    + " Where ma = :ma");
            q.setParameter("ma", ma);
            KhachHang sp = (KhachHang) q.getSingleResult();
            return sp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveKhachHang(KhachHang kh) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean updateKhachHang(KhachHang kh) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean deleteKhachHang(KhachHang kh) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE KhachHang WHERE id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", kh.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

}
