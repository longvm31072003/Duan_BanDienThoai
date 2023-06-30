/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import model.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class NhanVienRep {

    Session session;

    public List<NhanVien> getNhanVien() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From NhanVien");
            List<NhanVien> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public NhanVien getNhanVienByMa(String ma) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(" From NhanVien "
                    + " where ma = :ma");
            q.setParameter("ma", ma);
            NhanVien nv = (NhanVien) q.getSingleResult();
            return nv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean saveNhanVien(NhanVien nv) {
        Transaction tran = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.save(nv);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    
    public Boolean updateNhanVien(NhanVien nv) {
        Transaction tran = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.update(nv);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    
    public Boolean deleteNhanVien(NhanVien nv) {
        Transaction tran = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(nv);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        nv.setMa("NV04");
        nv.setTen("ALOHA");
        new NhanVienRep().saveNhanVien(nv);
//        System.out.println(new NhanVienRep().getNhanVien().toString());
    }

}
