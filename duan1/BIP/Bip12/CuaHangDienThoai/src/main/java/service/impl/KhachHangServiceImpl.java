/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import service.KhachHangService;
import viewmodel.KhachHangViewMD;
import repository.IKhachHangRepository;
import repository.impl.KhachHangRepository;

/**
 *
 * @author hoant
 */
public class KhachHangServiceImpl implements KhachHangService {

    KhachHangRepository khRep = new KhachHangRepository();
    List<KhachHangViewMD> listQL = new ArrayList<>();

    @Override
    public List<KhachHangViewMD> getAll() {
        return khRep.getAll();
    }

    @Override
    public String add(KhachHangViewMD x) {
        KhachHang md = new KhachHang();
        md.setMaKH(x.getMaKH());
        md.setDiaChi(x.getDiaChi());
        md.setDiemTichLuy(x.getDiemTichLuy());
        md.setEmail(x.getEmail());
        md.setGioiTinh(x.getGioiTinh());
        md.setId(x.getId());
        md.setNgaySinh(x.getNgaySinh());
        md.setHoTenKH(x.getHoTen());
        md.setSDT(x.getSDT());
        md.setGhiChu(x.getGhiChu());
        if (md.getDiaChi().isBlank()) {
            return "Địa chỉ Khách hàng trống";
        }
        if (md.getHoTenKH().isBlank()) {
            return "Tên Khách hàng trống";
        }
        if (md.getSDT().isBlank()) {
            return "Số điện thoại Khách hàng trống";
        }
        if (!md.getSDT().matches("(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})")) {
            return "SDT không hợp lệ";
        }
        if (!md.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            return "Mail không hợp lệ";
        }
        boolean add = khRep.add(md);

        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhachHangViewMD x, UUID id) {
        KhachHang md = new KhachHang();
        md.setId(x.getId());
        md.setMaKH(x.getMaKH());
        md.setDiaChi(x.getDiaChi());
        md.setDiemTichLuy(x.getDiemTichLuy());
        md.setEmail(x.getEmail());
        md.setGioiTinh(x.getGioiTinh());
        md.setNgaySinh(x.getNgaySinh());
        md.setHoTenKH(x.getHoTen());
        md.setSDT(x.getSDT());
        md.setGhiChu(x.getGhiChu());
        if (md.getDiaChi().isBlank()) {
            return "Địa chỉ Khách hàng trống";
        }
        if (md.getHoTenKH().isBlank()) {
            return "Tên Khách hàng trống";
        }
        if (md.getSDT().isBlank()) {
            return "Số điện thoại Khách hàng trống";
        }
        if (!md.getSDT().matches("(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})")) {
            return "SDT không hợp lệ";
        }
        if (!md.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            return "Mail không hợp lệ";
        }
        boolean update = khRep.update(md, id);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        boolean delete = khRep.delete(id);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

//    public static void main(String[] args) {
//        System.out.println(new KhachHangServiceImpl().update()));
//    }
    @Override
    public List<KhachHangViewMD> search(String CCCD) {
        List<KhachHang> list = khRep.search(CCCD);
        for (KhachHang x : list) {
            KhachHangViewMD md = new KhachHangViewMD();
            md.setMaKH(x.getMaKH());
            md.setDiaChi(x.getDiaChi());
            md.setDiemTichLuy(x.getDiemTichLuy());
            md.setEmail(x.getEmail());
            md.setGioiTinh(x.getGioiTinh());
            md.setId(x.getId());
            md.setGhiChu(x.getGhiChu());
            md.setHoTen(x.getHoTenKH());
            md.setSDT(x.getSDT());
            md.setGhiChu(x.getGhiChu());
            md.setNgaySinh(x.getNgaySinh());
            listQL.add(md);
        }
        return listQL;
    }
}
