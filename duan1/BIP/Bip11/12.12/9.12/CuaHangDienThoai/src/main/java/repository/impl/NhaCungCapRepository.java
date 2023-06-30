/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.NhaCungCap;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.INhaCungCapRepository;
import util.HibernatUtil;
import viewmodel.QLNhaCungCap;

/**
 *
 * @author Admin
 */
public class NhaCungCapRepository implements INhaCungCapRepository {

    @Override
    public List<QLNhaCungCap> getAll() {
        List<QLNhaCungCap> list;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT NEW viewmodel.QLNhaCungCap(x.id, x.ma, x.diaChi, x.ten, x.sdt, x.email, x.trangThai)  FROM domainmodel.NhaCungCap x");
            list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
    
    @Override
    public NhaCungCap getOne(String ma) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM NhaCungCap where ma = :ma");
            q.setParameter("ma", ma);
            NhaCungCap ncc = (NhaCungCap) q.getSingleResult();
            return ncc;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(new NhaCungCapRepository().getAll());
    }
    @Override
    public boolean save(NhaCungCap nhaCungCap) {
        Transaction tran = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.save(nhaCungCap);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.rollback();
            return false;
        }
    }

    @Override
    public boolean update(NhaCungCap nhaCungCap) {
        Transaction tran = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.update(nhaCungCap);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(NhaCungCap nhaCungCap) {
        Transaction tran = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(nhaCungCap);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.rollback();
            return false;
        }
    }
      @Override
    public List<QLNhaCungCap> timKiem(String Ma) {
      List<QLNhaCungCap> list;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT NEW viewmodel.QLNhaCungCap(x.id, x.ma, x.diaChi, x.ten, x.sdt, x.email, x.trangThai)  FROM domainmodel.NhaCungCap x Where x.ma Like CONCAT('%',:ma,'%')");
            q.setParameter("ma", Ma);
              
            list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

}
