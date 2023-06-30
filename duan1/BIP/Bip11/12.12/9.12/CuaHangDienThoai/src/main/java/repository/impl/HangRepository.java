/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Hang;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IHangRepository;
import util.HibernatUtil;

/**
 *
 * @author Admin
 */
public class HangRepository implements IHangRepository {

    @Override
    public List<Hang> getHHD() {
        List<Hang> list = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM Hang WHERE trangThai = 0");
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

    @Override
    public List<Hang> timKiem(String chuoi, int number) {
        List<Hang> list;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM Hang WHERE ma like :t and trangThai = :tt");
            String chuois = "%" + chuoi + "%";
            q.setParameter("t", chuois);
            q.setParameter("tt", number);
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

    public static void main(String[] args) {
//        List<Hang> list = new HangRepository();
//        for (Hang x : list) {
//            System.out.println(x);
//        }
//        Hang hang = new HangRepository().getOne("H005");
//        System.out.println(hang);
    }

    @Override
    public boolean save(Hang hang) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Hang hang) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Hang hang) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public List<Hang> getHNHD() {
        List<Hang> list = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM Hang WHERE trangThai = 1");
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

    @Override
    public Hang getOne(String ten) {
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Hang where ten like :ten");
            query.setParameter("ten", ten);
            Hang hang = (Hang) query.getSingleResult();
            return hang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
