/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class SanPhamRep {

    Session session;

    public List<SanPham> getSanPham() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From SanPham"
                    + " Order by maSP");
            List<SanPham> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public SanPham getByMa(String maSP) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From SanPham"
                    + " Where maSP = :maSP");
            q.setParameter("maSP", maSP);
            SanPham sp = (SanPham) q.getSingleResult();
            return sp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveSP(SanPham sp) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean updateSP(SanPham sp) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean deleteCTSPBySP(SanPham sp){
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE ChiTietSanPham ctsp WHERE ctsp.sanPham.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", sp.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean deleteSPByID(SanPham sp){
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE SanPham sp WHERE sp.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", sp.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
