/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.DungLuong;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IDungLuongRepository;
import viewmodel.QLDungLuong;
import util.HibernatUtil;

/**
 *
 * @author ongbi
 */
public class DungLuongRepository implements IDungLuongRepository{

    @Override
    public List<QLDungLuong> getAll() {
         String hql = "SELECT NEW viewmodel.QLDungLuong(dl.idDungLuong, dl.ma,dl.ten, dl.trangThai) FROM domainmodel.DungLuong dl";
         try (Session session = HibernatUtil.getFACTORY().openSession()) {
             Query q = session.createQuery(hql);
             return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }
    

    @Override
    public boolean saveOrupdate(DungLuong dungLuong) {
        boolean check;
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()){
             transaction = session.beginTransaction();
             session.saveOrUpdate(dungLuong);
             check = true;
             transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }
    public static void main(String[] args) {
        System.out.println(new DungLuongRepository().getAll());
    }

    @Override
    public DungLuong getOne(String ten) {
try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DungLuong where ten like :ten");
            query.setParameter("ten", ten);
            DungLuong rom = (DungLuong) query.getSingleResult();
            return rom;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }
    
}
