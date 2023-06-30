/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class MauSacRep {

    Session session;

    public List<MauSac> getMauSac() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From MauSac"
                    + " Order by maMauSac");
            List<MauSac> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public MauSac getByMa(String maMS) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From MauSac"
                    + " Where maMauSac = :maMauSac");
            q.setParameter("maMauSac", maMS);
            MauSac ms = (MauSac) q.getSingleResult();
            return ms;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveMS(MauSac ms) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean updateMS(MauSac ms) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean deleteCTSPByMS(MauSac ms){
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE ChiTietSanPham ctsp WHERE ctsp.mauSac.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", ms.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean deleteMSByID(MauSac ms){
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE MauSac ms WHERE ms.id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", ms.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
