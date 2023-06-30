/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import repository.IDienThoaiRepository;
import domainmodel.DienThoai;
import org.hibernate.Transaction;
import util.HibernatUtil;
import viewmodel.QLDienThoai;

/**
 *
 * @author dungp
 */
public class DienThoaiRepository implements IDienThoaiRepository {

    @Override
    public List<DienThoai> getAll1() {
        List<DienThoai> listDienThoai;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("From DienThoai d");
            listDienThoai = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return listDienThoai;
    }
    public List<DienThoai> getAll2() {
        List<DienThoai> listDienThoai;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT (DISTINCT d.tenDienThoai) From DienThoai d");
            listDienThoai = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return listDienThoai;
    }

    public static void main(String[] args) {
        System.out.println(new DienThoaiRepository().getAll());
    }

    @Override
    public DienThoai getOne(String ma) {
        String hql = "FROM DienThoai WHERE maDienThoai =:ma";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("ma", ma);
            DienThoai dt = (DienThoai) q.getSingleResult();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
// Code Dung

    @Override
    public boolean save(DienThoai dienThoai) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dienThoai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(DienThoai dienThoai, UUID idDienThoai) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(String.valueOf(idDienThoai), dienThoai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(UUID idDienThoai) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            DienThoai dienThoai = session.get(DienThoai.class, idDienThoai);
            session.delete(dienThoai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return false;
        }
    }

//    public static void main(String[] args) {
//        List<DienThoai> l = new DienThoaiRepository().getAll();
//        for (DienThoai dienThoai : l) {
//            System.out.println(dienThoai);
//        }
//    }
    @Override
    public List<QLDienThoai> timKiem(String maDienThoai, String tenDienThoai) {
        List<QLDienThoai> listTimKiem;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT new viewmodel.QLDienThoai "
                    + "(dt.idDienThoai, dt.maDienThoai, dt.tenDienThoai, dt.soLuongTon, dt.CPU, dt.RAM, dt.ROM, dt.manHinh, dt.mauSac, dt.pin, dt.camera, dt.heDieuHanh, dt.anh, dt.giaBan, dt.thoiGianBaoHanh, dt.moTa, dt.trangThai, dt.hang, dt.mauSac, dt.ram, dt.dungLuong)"
                    + " FROM domainmodel.DienThoai dt WHERE MaDienThoai LIKE :mDT OR TenDienThoai LIKE :tDT");
            String chuoi1 = "%" + maDienThoai + "%";
            q.setParameter("mDT", chuoi1);
            String chuoi2 = "%" + tenDienThoai + "%";
            q.setParameter("tDT", chuoi2);
            listTimKiem = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return listTimKiem;
    }

    @Override
    public List<QLDienThoai> getAll() {
        List<QLDienThoai> listDienThoai;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT new viewmodel.QLDienThoai "
                    + "(dt.idDienThoai, dt.maDienThoai, dt.tenDienThoai, dt.soLuongTon, dt.CPU, dt.manHinh, dt.pin, dt.camera, dt.heDieuHanh, dt.anh, dt.giaBan, dt.thoiGianBaoHanh, dt.moTa, dt.trangThai, dt.hang, dt.mauSac, dt.ram, dt.dungLuong)"
                    + " FROM domainmodel.DienThoai dt");
            listDienThoai = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return listDienThoai;
    }

    @Override
    public List<QLDienThoai> dtDangBan() {
        List<QLDienThoai> listDienThoai;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT new viewmodel.QLDienThoai "
                    + "(dt.idDienThoai, dt.maDienThoai, dt.tenDienThoai, dt.soLuongTon, dt.CPU, dt.manHinh, dt.pin, dt.camera, dt.heDieuHanh, dt.anh, dt.giaBan, dt.thoiGianBaoHanh, dt.moTa, dt.trangThai, dt.hang, dt.mauSac, dt.ram, dt.dungLuong)"
                    + " FROM domainmodel.DienThoai dt WHERE dt.trangThai = 1");
            listDienThoai = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return listDienThoai;
    }

    @Override
    public List<QLDienThoai> dtNgungBan() {
        List<QLDienThoai> listDienThoai;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT new viewmodel.QLDienThoai "
                    + "(dt.idDienThoai, dt.maDienThoai, dt.tenDienThoai, dt.soLuongTon, dt.CPU, dt.manHinh, dt.pin, dt.camera, dt.heDieuHanh, dt.anh, dt.giaBan, dt.thoiGianBaoHanh, dt.moTa, dt.trangThai, dt.hang, dt.mauSac, dt.ram, dt.dungLuong)"
                    + " FROM domainmodel.DienThoai dt WHERE dt.trangThai = 0");
            listDienThoai = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return listDienThoai;
    }

    @Override
    public List<DienThoai> getSP(String ten) {
        List<DienThoai> listDienThoai;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query q = session.createQuery("SELECT dt From DienThoai dt where dt.maDienThoai=:ten");
            q.setParameter("ten", ten);
            listDienThoai = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return listDienThoai;
    }
    @Override
       public DienThoai validateTonTai(String ten, String dungLuong, String Ram, String mauSac) {
        String hql = "FROM DienThoai d WHERE d.dungLuong.ten = :dungLuong and d.ram.ten = :ram and d.mauSac.ten = :mauSac and d.tenDienThoai = :ten";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            q.setParameter("dungLuong", dungLuong);
            q.setParameter("ram", Ram);
            q.setParameter("mauSac", mauSac);
            q.setParameter("ten", ten);
            List<DienThoai> listDt = q.getResultList();
            if(listDt.isEmpty()){
                return null;
            }
            DienThoai dt = (DienThoai) q.getSingleResult();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//iPhone 14 Pro Max
    }
}
