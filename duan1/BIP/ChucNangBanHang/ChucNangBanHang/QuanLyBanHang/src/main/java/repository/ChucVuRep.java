/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class ChucVuRep {
    
    Session session;

    public List<ChucVu> getListChucVu() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From ChucVu");
            List<ChucVu> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ChucVu getChucVuByMa(String ma) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From ChucVu"
                    + " Where ma = :ma");
            q.setParameter("ma", ma);
            ChucVu cv = (ChucVu) q.getSingleResult();
            return cv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveChucVu(ChucVu cv) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(cv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean updateChucVu(ChucVu cv) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(cv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean deleteChucVu(ChucVu cv) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE ChucVu WHERE id = :id";
            Query q = session.createQuery(hql);
            q.setParameter("id", cv.getId());
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    
}
