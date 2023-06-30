/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.ChucVu;
import domainmodel.NhanVien;
import domainmodel.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.INhanVienRepository;
import repository.impl.NhanVienRepository;
import service.INhanVienService;
import viewmodel.QLNhanVien;

/**
 *
 * @author lethi
 */
public class NhanVienService implements INhanVienService {

    private INhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<QLNhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public String add(QLNhanVien qlnv) {
        TaiKhoan tk = new TaiKhoan(qlnv.getTaiKhoan().getId(), qlnv.getTaiKhoan().getTenTaiKhoan(), qlnv.getTaiKhoan().getMatKhau());
        ChucVu cv = new ChucVu(qlnv.getChucVu().getId(), qlnv.getChucVu().getMa(), qlnv.getChucVu().getTen(), qlnv.getChucVu().getLuong(), qlnv.getChucVu().getQuyen(), null);
        NhanVien nhanVien = new NhanVien(null, qlnv.getMa(), qlnv.getHoTen(), qlnv.getGioiTinh(), qlnv.getNamSinh(), qlnv.getDiaChi(), qlnv.getCccd(), qlnv.getEmail(), qlnv.getSdt(), qlnv.getTrangThai(), qlnv.getAnh(), null, tk, cv, null);
        boolean add = nhanVienRepository.add(nhanVien);
        if (add) {
            return "Add thành công";
        } else {
            return "Add không thành công";
        }
    }

    @Override
    public String update(QLNhanVien qlnv, UUID id) {
        TaiKhoan tk = new TaiKhoan(qlnv.getTaiKhoan().getId(), qlnv.getTaiKhoan().getTenTaiKhoan(), qlnv.getTaiKhoan().getMatKhau());
        ChucVu cv = new ChucVu(qlnv.getChucVu().getId(), qlnv.getChucVu().getMa(), qlnv.getChucVu().getTen(), qlnv.getChucVu().getLuong(), qlnv.getChucVu().getQuyen(), null);
        NhanVien nhanVien = new NhanVien(qlnv.getId(), qlnv.getMa(), qlnv.getHoTen(), qlnv.getGioiTinh(), qlnv.getNamSinh(), qlnv.getDiaChi(), qlnv.getCccd(), qlnv.getEmail(), qlnv.getSdt(), qlnv.getTrangThai(), qlnv.getAnh(), null, tk, cv, null);
        boolean update = nhanVienRepository.update(nhanVien, id);
        if (update) {
            return "Update thành công";
        } else {
            return "Update không thành công";
        }
    }

    @Override
    public String delete(UUID id) {
        boolean delete = nhanVienRepository.delete(id);
        if (delete) {
            return "Delete thành công";
        } else {
            return "Delete không thành công";
        }
    }

    @Override
    public List<QLNhanVien> search(String CCCD) {
        return nhanVienRepository.search(CCCD);
    }

    @Override
    public List<QLNhanVien> getNVDLV() {
        return nhanVienRepository.getNVDLV();
    }

    @Override
    public List<QLNhanVien> getNVDNV() {
        return nhanVienRepository.getNVDNV();
    }
    
}
