/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhuyenMai;
import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import repository.IKhuyenMaiRepository;
import repository.impl.KhuyenMaiRepository;
import service.KhuyenMaiService;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author hoant
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private IKhuyenMaiRepository kmRep = new KhuyenMaiRepository();
    private List<KhuyenMaiViewModel> listQL = new ArrayList<>();

    @Override
    public List<KhuyenMaiViewModel> getAll() {
        return kmRep.getAll();
    }

    @Override
    public String add(KhuyenMaiViewModel x) {
//        KhuyenMai km = new KhuyenMai(x.getMaKM(), x.getTenKM(), x.getMucKhuyenMai(), x.getHinhThucKhuyenMai(), x.getNgayBatDau(), x.getNgayKT(), x.getTrangThai(), x.getMoTa());
//        if (km.getTenKM().isBlank()) {
//            return "Thiếu tên khuyến mãi";
//        }
//        if (km.getMucKhuyenMai()==null) {
//            return "Thiếu mức khuyến mãi khuyến mãi";
//        }
//        if (km.getNgayKT().before(km.getNgayBatDau())) {
//            return "Ngày kết thúc phải chọn ở sau ngày bắt đầu";
//        }
//        if (km.getNgayKT().after(new Date())) {
//            return "Ngày kết thúc phải phải ở hiện tại hoặc tương lai";
//        }
//        boolean add = kmRep.add(km);
//        if (add) {
//            return "Thêm thành công";
//        } else {
//            return "Thêm thất bại";
//        }
        return "";
    }

    @Override
    public String update(KhuyenMaiViewModel x, UUID id) {
//        KhuyenMai km = new KhuyenMai(x.getMaKM(), x.getTenKM(), x.getMucKhuyenMai(), x.getHinhThucKhuyenMai(), x.getNgayBatDau(), x.getNgayKT(), x.getTrangThai(), x.getMoTa());
//        boolean sua = kmRep.update(km, id);
//        if (sua) {
//            return "Sửa thành công";
//        } else {
//            return "Sửa thất bại";
//        }
        return "";
    }

    @Override
    public String delete(UUID id) {
        boolean delete = kmRep.delete(id);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    public static void main(String[] args) {
        System.out.println(new KhuyenMaiServiceImpl().getAll());
    }

}
