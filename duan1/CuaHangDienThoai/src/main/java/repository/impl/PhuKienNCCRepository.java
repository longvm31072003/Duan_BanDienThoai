/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.PhuKienNCC;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IPhuKienNCCRepository;
import util.HibernatUtil;
import viewmodel.QLPhuKienNCC;

/**
 *
 * @author Admin
 */
public class PhuKienNCCRepository implements IPhuKienNCCRepository {

    @Override
    public List<QLPhuKienNCC> getAll() {
  
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT NEW viewmodel.QLPhuKienNCC(x.id, x.nhaCungCap.id, x.phuKien.id, x.nhaCungCap.ma, x.phuKien.ma, x.giaNhap, x.soLuongNhap, x.ngayNhap, x.trangThai) FROM domainmodel.PhuKienNCC x");
           return q.getResultList();
           
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(new PhuKienNCCRepository().getAll());
    }
    @Override
    public boolean save(PhuKienNCC pkNcc) {
        Transaction tran = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.save(pkNcc);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.rollback();
            return false;
        }
    }

    @Override
    public boolean update(PhuKienNCC pkNcc) {
        Transaction tran = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.update(pkNcc);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(PhuKienNCC pkNcc) {
        Transaction tran = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(pkNcc);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.rollback();
            return false;
        }
    }

}
