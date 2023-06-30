/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.DienThoaiNCC;
import repository.IDTNhaCungCapRepository;
import util.HibernatUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import viewmodel.QLDTNhaCungCap;

/**
 *
 * @author ongbi
 */
public class DTNhaCungCapRepository implements IDTNhaCungCapRepository {

    @Override
    public List<QLDTNhaCungCap> getAll() {
        String hql = "SELECT NEW viewmodel.QLDTNhaCungCap(x.id, x.nhaCungCap.id, x.dienThoai.idDienThoai, x.nhaCungCap.ma, x.dienThoai.maDienThoai, x.giaNhap, x.soLuongNhap, x.ngayNhap,x.trangThai) FROM domainmodel.DienThoaiNCC x  ";
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean SaveOrUpdate(DienThoaiNCC dienThoaiNCC) {
        boolean check;
//            String hql = "Insert Into DienThoaiNCC IdNCC =:, IdDT =:, GiaNhap =:, SoLuongNhap = =:, NgayNhap =: Values(:,:,:,:,:) ";
        Transaction transaction = null;
        try ( Session session = new HibernatUtil().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(dienThoaiNCC);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
        }
        return check;
    }

    @Override
    public boolean delete(DienThoaiNCC dienThoaiNCC) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        System.out.println(new DTNhaCungCapRepository().getAll());
    }
}
