/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Hang;
import domainmodel.HoaDon;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import util.HibernatUtil;
import viewmodel.QLHoaDon;

/**
 *
 * @author Admin
 */
public class FHoaDonRespository implements repository.IFHoaDonRespository {

    /**
     *
     * @return
     */
    @Override
    public List<QLHoaDon> getAll() {
        List<QLHoaDon> lsthd = new ArrayList<>();

        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select new viewmodel.QLHoaDon(x.idHD,"
                    + "x.MaHD "
                    + " ,x.ngayTao  "
                    + ",x.NgayThanhToan,"
                    + "x.DiemTichLuy,"
                    + "x.trangThai,"
                    + "x.khachHang,"
                    + "x.nhanVien ) "
                    + "from domainmodel.HoaDon x");

            lsthd = query.getResultList();
            return lsthd;

        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
    @Override
    public List<QLHoaDon> search(String Mahd) {
        List<QLHoaDon> list;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {

            Query query = session.createQuery("select new viewmodel.QLHoaDon(x.idHD,"
                    + "x.MaHD "
                    + " ,x.ngayTao  "
                    + ",x.NgayThanhToan,"
                    + "x.DiemTichLuy,"
                    + "x.trangThai,"
                    + "x.khachHang,"
                    + "x.nhanVien ) "
                    + "from domainmodel.HoaDon x WHERE x.MaHD LIKE '%' + :t + '%' ");

            query.setParameter("t", Mahd);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }
//    public static void main(String[] args) {
//        List<QLHoaDon> list = new FHoaDonRespository().search("HD03");
//        for (QLHoaDon x : list) {
//            System.out.println(x);
//        }
////        Hang hang = new HangRepository().getOne("H005");
////        System.out.println(hang);
//    }
    public static void main(String[] args) {
        LocalDateTime  l = LocalDateTime.of(2022,01,01,00,00);
//        l.
        LocalDateTime  l1 = LocalDateTime.of(2022,01,01,00,00);
        List<QLHoaDon> list = new FHoaDonRespository().searchtheoNgay(l,l1);
        for (QLHoaDon x : list) {
            System.out.println(x);
        }
    
}
// public static void main(String[] args) {
//        System.out.println(new FHoaDonRespository().getAll());
//    }



  

  

    @Override
    public List<QLHoaDon> searchtheoNgay(LocalDateTime TT ,LocalDateTime HH) {
              List<QLHoaDon> list;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            HoaDon hd = new HoaDon();
            Query query = session.createQuery("select new viewmodel.QLHoaDon("
                    + "x.idHD,"
                    + "x.MaHD "
                    + " ,x.ngayTao  "
                    + ",x.NgayThanhToan,"
                    + "x.DiemTichLuy,"
                    + "x.trangThai,"
                    + "x.khachHang,"
                    + "x.nhanVien ) "
                    + "from domainmodel.HoaDon x where x.ngayTao >=  :t  and ngayTao <= :tt ");

            query.setParameter("t", TT);
            query.setParameter("tt", HH);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }


  
}
    





