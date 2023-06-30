/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Imei;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import repository.IimeiRepository;
import util.HibernatUtil;
import viewmodel.QLImei;

/**
 *
 * @author ongbi
 */
public class ImeiRepository implements IimeiRepository {

    @Override
    public List<QLImei> getAllDT(UUID id) {
        String hql = "SELECT NEW viewmodel.QLImei(i.id, i.ma, i.trangThai,i.dtNcc.id, i.pkNcc.id) FROM domainmodel.Imei i WHERE i.dtNcc.id = :id";
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("id", id);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<QLImei> getAllPK(UUID id) {
        String hql = "SELECT NEW viewmodel.QLImei(i.id, i.ma, i.trangThai,i.dtNcc.id, i.pkNcc.id) FROM domainmodel.Imei i WHERE i.pkNcc.id  = :id";
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("id", id);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveOrupdate(Imei imei) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(imei);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public Imei getOne(String ma) {
        String hql = "From Imei WHERE ma = :ma";
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ma", ma);
            List<Imei> list = q.getResultList();
            if (list.isEmpty()) {
                return null;
            }
            Imei imei = (Imei) q.getSingleResult();
            return imei;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        System.out.println(new ImeiRepository().getAllPK(UUID.fromString("3caffc39-e34e-ea40-8395-1cb7c31383a5")));
    }

    @Override
    public boolean xoa(Imei imei) {
            boolean check;
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(imei);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public int genMaImei() {
     String maAC = "";
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(MaImei,16,100))) from Imei ";
            NativeQuery query = session.createNativeQuery(hql);
            maAC = query.getSingleResult().toString();
        } catch (Exception e) {
       
        }
        if(maAC == ""){
            maAC = "1";
            int ma = Integer.valueOf(maAC);
            return  ma;
        }
        int ma = Integer.valueOf(maAC);
        return  ++ma;
    }
}
