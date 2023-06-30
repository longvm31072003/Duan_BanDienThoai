/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import viewmodel.QLHoaDonChiTiet;
import viewmodel.QLHoaDon;
import viewmodel.QLDienThoai;
import viewmodel.QLPhuKien;
import viewmodel.KhuyenMaiViewModel;
import domainmodel.HoaDonChiTiet;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import repository.IFHoaDonChiTietRespository;
import viewmodel.ChiTietKhuyenMaiViewModel;

/**
 *
 * @author Admin
 */
public class FHoaDonChiTietService implements service.IFHoaDonChiTietService {

    private IFHoaDonChiTietRespository hdct;
    private List<QLHoaDonChiTiet> lsthdct;

    public FHoaDonChiTietService() {
        hdct = new repository.impl.FHoaDonChiTietRespository();
        lsthdct = new ArrayList<>();
    }

    @Override
    public List<QLHoaDonChiTiet> getAll() {
        lsthdct.clear();
        lsthdct = new ArrayList<>();
        for (HoaDonChiTiet hoadonchitiet : hdct.getAll()) {
       QLHoaDon IdHD = new QLHoaDon(hoadonchitiet.getHoaDon().getIdHD(),hoadonchitiet.getHoaDon().getMaHD(),hoadonchitiet.getHoaDon().getNgayThanhToan());
       QLPhuKien IdPK = new QLPhuKien(hoadonchitiet.getPhuKien()== null ?  null : hoadonchitiet.getPhuKien().getId(), hoadonchitiet.getPhuKien()== null ?  null : hoadonchitiet.getPhuKien().getMa());
     QLDienThoai IdDienThoai = new QLDienThoai(hoadonchitiet.getDienThoai()== null ?  null : hoadonchitiet.getDienThoai().getIdDienThoai()       , hoadonchitiet.getDienThoai()== null ?  null : hoadonchitiet.getDienThoai().getMaDienThoai());
//     ChiTietKhuyenMaiViewModel IdCTKM = new ChiTietKhuyenMaiViewModel(hoadonchitiet.getCtkm().getId());
ChiTietKhuyenMaiViewModel IdCTKM = new ChiTietKhuyenMaiViewModel(hoadonchitiet.getCtkm()== null ?  null : hoadonchitiet.getCtkm().getId());
     QLHoaDonChiTiet qlhdct = new QLHoaDonChiTiet(hoadonchitiet.getId(), IdHD, IdPK,IdCTKM, IdDienThoai,hoadonchitiet.getSoLuong(),hoadonchitiet.getDonGia());
//QLHoaDonChiTiet qlhdct = new QLHoaDonChiTiet(hoadonchitiet.getId(), IdHD, IdPK, IdCTKM, IdDienThoai, 0, BigDecimal.ONE);
lsthdct.add(qlhdct);
        }

        return lsthdct;
    }

}
