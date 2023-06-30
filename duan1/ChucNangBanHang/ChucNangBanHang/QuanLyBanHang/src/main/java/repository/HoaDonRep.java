/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class HoaDonRep {

    private Session session;

    public List<HoaDon> getHoaDon() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From HoaDon"
                    + " order by ma");
            List<HoaDon> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDon getHoaDonById(UUID id) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From HoaDon "
                    + "where id = :id");
            q.setParameter("id", id);
            HoaDon hd = (HoaDon) q.getSingleResult();
            return hd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveHoaDon(HoaDon hd) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean updateHoaDon(HoaDon hd) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
//        HoaDon hd = new HoaDon();
//        hd.setMa("HD02");
//        hd.setNgayTao(new Date());
//        System.out.println(hd.getNgayTao());
//        Boolean savBoolean = new HoaDonRep().saveHoaDon(hd);
        HoaDon hd = new HoaDonRep().getHoaDonById(UUID.fromString("b27cf6be-6b0c-45dd-98f3-1ecfd1c10a87"));
        System.out.println(hd);
    }

}
