/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import model.ChiTietSanPham;
import model.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietRep {
    
    private Session session;
    
//    public List<HoaDonChiTiet> getList(){
//        try(Session session = HibernateUtil.getFACTORY().openSession()){
//            Query q = session.createQuery(" From HoaDonChiTiet ");
//            List<HoaDonChiTiet> list = q.getResultList();
//            return list;
//        }catch(Exception e){
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
    
    public Boolean save(HoaDonChiTiet hdct){
        Transaction tran = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            tran = session.beginTransaction();
            session.save(hdct);
            session.flush();
            tran.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return false;
    }
    
}
