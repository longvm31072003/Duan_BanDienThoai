/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import viewmodel.QLHoaDon;
import repository.impl.FHoaDonRespository;
import viewmodel.QLHoaDon;
import domainmodel.HoaDon;
import java.time.LocalDateTime;
import viewmodel.KhachHangViewMD;
import viewmodel.QLNhanVien;
import repository.IFHoaDonRespository;

/**
 *
 * @author sktfk
 */
public class FHoaDonService implements service.IFHoaDonService {

    private FHoaDonRespository hd = new FHoaDonRespository();


    @Override
    public List<QLHoaDon> getAll() {


        List<QLHoaDon> lsthd = hd.getAll();
        return lsthd;
    }

    @Override
    public List<QLHoaDon> search(String Mahd) {
        List<QLHoaDon> lsthd = hd.search(Mahd);
        return  lsthd;
    }

//    @Override
//    public List<QLHoaDon> searchtk(String CCCD) {
// List<QLHoaDon> lsthd = new ArrayList<>();
//        for (HoaDon hoadon : hd.searchtk(CCCD)) {
////             for (HoaDon hoadon : hd.getAll()) {
//            KhachHangViewMD IdKH = new KhachHangViewMD(hoadon.getKhachhang().getId(), hoadon.getKhachhang().getHoTenKH());
//
//            QLNhanVien IdNhanVien = new QLNhanVien(hoadon.getNhanvien().getId(), hoadon.getNhanvien().getMa());
////      QLHoaDon qlhd = new QLHoaDon(hoadon.getIdHD(), IdKH, IdNhanVien,hoadon.getMaHD(),hoadon.getNgayTao(),hoadon.getNgayThanhToan(),hoadon.getDiemTichLuy(),hoadon.getTrangThai());
////            QLHoaDon qlhd = new QLHoaDon(hoadon.getIdHD(), IdKH, IdNhanVien, hoadon.getMaHD(), hoadon.getNgayTao(), hoadon.getNgayThanhToan(), hoadon.getDiemTichLuy(), hoadon.getTrangThai());
//QLHoaDon qlhd = new QLHoaDon(hoadon.getIdHD(), IdKH, IdNhanVien,hoadon.getMaHD(),hoadon.getNgayTao(),hoadon.getNgayThanhToan(),hoadon.getDiemTichLuy(),hoadon.getTrangThai());
//            lsthd.add(qlhd);
//        
//    }
// return lsthd;
//}

    @Override
    public List<QLHoaDon> searchtk(String CCCD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<QLHoaDon> searchtheoNgay(LocalDateTime TT, LocalDateTime HH) {
         List<QLHoaDon> lsthd = hd.searchtheoNgay(TT,HH);
        return  lsthd;
    }
}
