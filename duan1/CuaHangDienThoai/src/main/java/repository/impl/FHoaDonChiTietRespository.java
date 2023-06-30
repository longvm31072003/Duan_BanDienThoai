/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;
import domainmodel.HoaDonChiTiet;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernatUtil;

/**
 *
 * @author Admin
 */
public class FHoaDonChiTietRespository implements repository.IFHoaDonChiTietRespository{

    @Override
   public List<HoaDonChiTiet> getAll() {
 String hql = "from HoaDonChiTiet ";
        try ( Session session = HibernatUtil.getFACTORY().openSession()){
           Query q = session.createQuery(hql);
           return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<HoaDonChiTiet> search(String Mahd) {
         try (Session sess = HibernatUtil.getFACTORY().openSession()) {
            Query qr = sess.createQuery(" FROM HoaDonChiTiet  WHERE MaHD =:ma");
            qr.setParameter("MaHD", Mahd);
//            List<HoaDonChiTiet> list = qr.getResultList();
HoaDonChiTiet hdct = (HoaDonChiTiet) qr.getSingleResult();
            return (List<HoaDonChiTiet>) hdct;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

//        public static void main(String[] args) {
//        HoaDonChiTiet hdct = search("HD1");
//        System.out.println(hdct);
//    }
    
    }
 
    
    

