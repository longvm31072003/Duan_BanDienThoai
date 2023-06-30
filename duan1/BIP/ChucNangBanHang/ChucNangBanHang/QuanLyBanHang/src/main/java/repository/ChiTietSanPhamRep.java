/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import model.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamRep {

    private Session session;

    public List<ChiTietSanPham> getListCTSP() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("Select ctsp From ChiTietSanPham ctsp Order by ctsp.soLuongTon desc");
            //lay top 3
//            q.setFirstResult(0);
//            q.setMaxResults(3);
            List<ChiTietSanPham> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ChiTietSanPham getCTSPById(UUID id) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From ChiTietSanPham"
                    + " Where idCTSP = :idCTSP");
            q.setParameter("idCTSP", id);
            ChiTietSanPham ctsp = (ChiTietSanPham) q.getSingleResult();
            return ctsp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<ChiTietSanPham> getCTSPByNamBaoHanh(int namBaoHanh) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From ChiTietSanPham"
                    + " Where namBH = :namBH");
            q.setParameter("namBH", namBaoHanh);
            List<ChiTietSanPham> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean deleteCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean updateCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        ChiTietSanPham ctsp = new ChiTietSanPhamRep().getCTSPById(UUID.fromString("55cc8eed-c58c-40c1-a151-f35224d1f3ef"));
        System.out.println(ctsp);
//        List<ChiTietSanPham> lists = new ChiTietSanPhamRep().getListCTSP();
//        for (ChiTietSanPham list : lists) {
//            System.out.println(list.toString());
//        }
    }

}
