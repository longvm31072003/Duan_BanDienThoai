/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import model.DongSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class DongSanPhamRep {

    Session session;

    public List<DongSanPham> getDongSanPham() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From DongSanPham"
                    + " Order by maDongSP");
            List<DongSanPham> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public DongSanPham getByMa(String maDongSP) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From DongSanPham"
                    + " Where maDongSP = :maDongSP");
            q.setParameter("maDongSP", maDongSP);
            DongSanPham dsp = (DongSanPham) q.getSingleResult();
            return dsp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveDSP(DongSanPham dsp) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean updateDSP(DongSanPham dsp) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(dsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean deleteCTSPByDSP(DongSanPham dsp){
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE ChiTietSanPham ctsp WHERE ctsp.dongSanPham.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", dsp.getIdDongSP());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean deleteDSPByID(DongSanPham dsp){
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE DongSanPham dsp WHERE dsp.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", dsp.getIdDongSP());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
