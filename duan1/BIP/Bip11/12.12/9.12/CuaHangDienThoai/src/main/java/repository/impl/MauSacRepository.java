/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.MauSac;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IMauSacRepository;
import util.HibernatUtil;
import viewmodel.QLMauSac;

/**
 *
 * @author lethi
 */
public class MauSacRepository implements IMauSacRepository{

    @Override
    public List<QLMauSac> getAll() {
         String hql = "SELECT NEW viewmodel.QLMauSac(ms.idMauSac, ms.ma, ms.ten, ms.trangThai) FROM domainmodel.MauSac ms";
         try (Session session = HibernatUtil.getFACTORY().openSession()) {
             Query q = session.createQuery(hql);
             return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }

    @Override
    public boolean saveOrupdate(MauSac mauSac) {
        boolean check;
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()){
             transaction = session.beginTransaction();
             session.saveOrUpdate(mauSac);
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
    public MauSac getOne(String ten) {
try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac where ten like :ten");
            query.setParameter("ten", ten);
            MauSac mauSac = (MauSac) query.getSingleResult();
            return mauSac;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }
    
}
