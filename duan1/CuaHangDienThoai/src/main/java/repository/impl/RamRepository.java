/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Ram;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IRamRepository;
import util.HibernatUtil;
import viewmodel.QLRam;

/**
 *
 * @author lethi
 */
public class RamRepository implements IRamRepository{

    @Override
    public List<QLRam> getAll() {
        String hql = "SELECT NEW viewmodel.QLRam(r.idRam, r.ma, r.ten, r.trangThai) FROM domainmodel.Ram r";
         try (Session session = HibernatUtil.getFACTORY().openSession()) {
             Query q = session.createQuery(hql);
             return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }

    @Override
    public boolean saveOrupdate(Ram ram) {
        boolean check;
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()){
             transaction = session.beginTransaction();
             session.saveOrUpdate(ram);
             check = true;
             transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public Ram getOne(String ten) {
try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ram where ten like :ten");
            query.setParameter("ten", ten);
            Ram ram = (Ram) query.getSingleResult();
            return ram;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }
    
}
