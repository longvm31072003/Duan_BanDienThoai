/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.TaiKhoan;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernatUtil;
import repository.ITaiKhoanRepository;

/**
 *
 * @author dungp
 */
public class TaiKhoanRepository implements ITaiKhoanRepository {

    @Override
    public TaiKhoan getOne(String taiKhoan, String matKhau) {
        String hql = "FROM TaiKhoan WHERE tenTaiKhoan =:ten AND matKhau =:mk";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ten", taiKhoan);
            q.setParameter("mk", matKhau);
            TaiKhoan tk = (TaiKhoan) q.getSingleResult();
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TaiKhoan> getAll() {
        List<TaiKhoan> listTK;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM TaiKhoan");
            listTK = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return listTK;
    }

    @Override
    public boolean add(TaiKhoan taiKhoan) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(taiKhoan);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(TaiKhoan taiKhoan) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(taiKhoan);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(UUID IDTaiKhoan) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            TaiKhoan tk = session.get(TaiKhoan.class, IDTaiKhoan);
            session.delete(tk);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public List<TaiKhoan> timKiem(String tenTaiKhoan) {
        List<TaiKhoan> ListTimKiem;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM TaiKhoan WHERE TenTaiKhoan = :tk");
            String chuoi = "%" + tenTaiKhoan + "%";
            q.setParameter("tk", chuoi);
            ListTimKiem = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return ListTimKiem;
    }

    public static TaiKhoan getOne1(String taiKhoan, String matKhau) {
        String hql = "FROM TaiKhoan WHERE tenTaiKhoan =:ten AND matKhau =:mk";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ten", taiKhoan);
            q.setParameter("mk", matKhau);
            TaiKhoan tk = (TaiKhoan) q.getSingleResult();
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaiKhoan getOne2(String taiKhoan, String matKhau) {
        String hql = "FROM TaiKhoan WHERE tenTaiKhoan =:ten AND matKhau =:mk";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ten", taiKhoan);
            q.setParameter("mk", matKhau);
            List<TaiKhoan> tk = q.getResultList();
            if (tk.isEmpty()) {
                return null;
            }
            return tk.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaiKhoan getOne3(String taiKhoan) {
        String hql = "FROM TaiKhoan WHERE tenTaiKhoan =:ten";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ten", taiKhoan);
            List<TaiKhoan> tk = q.getResultList();
            if (tk.isEmpty()) {
                return null;
            }
            return tk.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TaiKhoan tj = getOne1("anhltvph25818", "123");
        System.out.println(tj);
    }
}
