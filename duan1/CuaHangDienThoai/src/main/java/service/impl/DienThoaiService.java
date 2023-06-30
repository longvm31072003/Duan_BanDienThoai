/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.DienThoai;
import domainmodel.MauSac;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.IDienThoaiRepository;
import repository.impl.DienThoaiRepository;
import service.IDienThoaiService;
import viewmodel.QLDienThoai;

/**
 *
 * @author dungp
 */
public class DienThoaiService implements IDienThoaiService {
// Dũng Code

    IDienThoaiRepository dienThoaiRepository = new DienThoaiRepository();

    @Override
    public List<QLDienThoai> getAll() {
        return dienThoaiRepository.getAll();
    }

    @Override
    public String them(QLDienThoai QLDienThoai) {
        DienThoai dienThoai = new DienThoai(null, QLDienThoai.getMaDienThoai(), QLDienThoai.getTenDienThoai(), QLDienThoai.getSoLuongTon(), QLDienThoai.getCPU(), QLDienThoai.getManHinh(), QLDienThoai.getPin(), QLDienThoai.getCamera(), QLDienThoai.getHeDieuHanh(), QLDienThoai.getAnh(), QLDienThoai.getGiaBan(), QLDienThoai.getThoiGianBaoHanh(), QLDienThoai.getMota(), QLDienThoai.getTrangThai(), QLDienThoai.getHang(), QLDienThoai.getMauSac(), QLDienThoai.getRam(), QLDienThoai.getDungLuong(), null, null);
        if (dienThoaiRepository.save(dienThoai)) {
            return "Thêm Thành Công Điện Thoại Có Mã Là: " + QLDienThoai.getMaDienThoai();
        } else {
            return "Thêm Điện Thoại Thất Bại.";
        }
    }

    @Override
    public String sua(QLDienThoai QLDienThoai, UUID idDienThoai) {
        DienThoai dienThoai = new DienThoai(QLDienThoai.getIdDienThoai(), QLDienThoai.getMaDienThoai(), QLDienThoai.getTenDienThoai(), QLDienThoai.getSoLuongTon(), QLDienThoai.getCPU(), QLDienThoai.getManHinh(), QLDienThoai.getPin(), QLDienThoai.getCamera(), QLDienThoai.getHeDieuHanh(), QLDienThoai.getAnh(), QLDienThoai.getGiaBan(), QLDienThoai.getThoiGianBaoHanh(), QLDienThoai.getMota(), QLDienThoai.getTrangThai(), QLDienThoai.getHang(), QLDienThoai.getMauSac(), QLDienThoai.getRam(), QLDienThoai.getDungLuong(), null, null);
        if (dienThoaiRepository.update(dienThoai, idDienThoai)) {
            return "Sửa Thành Công Điện Thoại Có Mã Là: " + QLDienThoai.getMaDienThoai();
        } else {
            return "Sửa Thất Bại Điện Thoại có Mã Là: " + QLDienThoai.getMaDienThoai();
        }
    }

    @Override
    public String xoa(UUID idDienThoai) {
        boolean xoa = dienThoaiRepository.delete(idDienThoai);
        if (xoa) {
            return "Xoa Thanh Cong";
        } else {
            return "Xoa That Bai";
        }
    }

    @Override
    public List<QLDienThoai> timKiem(String maDienThoai, String tenDienThoai) {
        return dienThoaiRepository.timKiem(maDienThoai, tenDienThoai);
    }

    @Override
    public List<QLDienThoai> dtDangBan() {
        return dienThoaiRepository.dtDangBan();
    }

    @Override
    public List<QLDienThoai> dtNgungBan() {
        return dienThoaiRepository.dtNgungBan();
    }

    @Override
    public List<QLDienThoai> getSP(String ten) {
        List<QLDienThoai> listDT1 = new ArrayList<>();
        for (DienThoai dienThoai : dienThoaiRepository.getSP(ten)) {
            QLDienThoai qlDienThoai = new QLDienThoai(dienThoai.getIdDienThoai(), dienThoai.getMaDienThoai(), dienThoai.getTenDienThoai(), dienThoai.getSoLuongTon(), dienThoai.getCPU(), dienThoai.getManHinh(), dienThoai.getPin(), dienThoai.getCamera(), dienThoai.getHeDieuHanh(), dienThoai.getAnh(), dienThoai.getGiaBan(), dienThoai.getThoiGianBaoHanh(), dienThoai.getMoTa(), dienThoai.getTrangThai(), dienThoai.getHang(), dienThoai.getMauSac(), dienThoai.getRam(), dienThoai.getDungLuong());
            listDT1.add(qlDienThoai);
        }
        return listDT1;
    }

    @Override
    public QLDienThoai getOne(String ma) {
        DienThoai dt = dienThoaiRepository.getOne(ma);
        if (dt == null) {
            return null;
        }
        QLDienThoai getDt = new QLDienThoai(dt.getIdDienThoai(), dt.getMaDienThoai(), dt.getTenDienThoai(), dt.getSoLuongTon(), dt.getCPU(), dt.getManHinh(), dt.getPin(), dt.getCamera(), dt.getHeDieuHanh(), dt.getAnh(), dt.getGiaBan(), dt.getThoiGianBaoHanh(), dt.getMoTa(), dt.getTrangThai(), dt.getHang(), dt.getMauSac(), dt.getRam(), dt.getDungLuong());
        return getDt;

    }

    @Override
    public QLDienThoai validateTonTai(String ten, String dungLuong, String Ram, String mauSac) {
        DienThoai dt = dienThoaiRepository.validateTonTai(ten, dungLuong, Ram, mauSac);
        if (dt == null) {
            return null;
        }
        QLDienThoai getDt = new QLDienThoai(dt.getIdDienThoai(), dt.getMaDienThoai(), dt.getTenDienThoai(), dt.getSoLuongTon(), dt.getCPU(), dt.getManHinh(), dt.getPin(), dt.getCamera(), dt.getHeDieuHanh(), dt.getAnh(), dt.getGiaBan(), dt.getThoiGianBaoHanh(), dt.getMoTa(), dt.getTrangThai(), dt.getHang(), dt.getMauSac(), dt.getRam(), dt.getDungLuong());
        return getDt;
    }
}
