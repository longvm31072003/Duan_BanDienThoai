/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.NhaSanXuat;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class NhaSanXuatRep {

    Session session;

    public List<NhaSanXuat> getNhaSanXuat() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From NhaSanXuat"
                    + " Order by maNSX");
            List<NhaSanXuat> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public NhaSanXuat getByMa(String maNSX) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From NhaSanXuat"
                    + " Where maNSX = :maNSX");
            q.setParameter("maNSX", maNSX);
            NhaSanXuat nsx = (NhaSanXuat) q.getSingleResult();
            return nsx;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveNSX(NhaSanXuat nsx) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean updateNSX(NhaSanXuat nsx) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean deleteCTSPByNSX(NhaSanXuat nsx) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE ChiTietSanPham ctsp WHERE ctsp.nhaSanXuat.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", nsx.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean deleteSPByID(NhaSanXuat nsx) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE NhaSanXuat nsx WHERE nsx.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", nsx.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
