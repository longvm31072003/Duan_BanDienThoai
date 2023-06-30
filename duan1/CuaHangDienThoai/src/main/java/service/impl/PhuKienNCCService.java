/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.NhaCungCap;
import domainmodel.PhuKien;
import domainmodel.PhuKienNCC;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import repository.IPhuKienNCCRepository;
import repository.impl.PhuKienNCCRepository;
import service.IPhuKienNCCService;
import viewmodel.QLNhaCungCap;
import viewmodel.QLPhuKien;
import viewmodel.QLPhuKienNCC;

/**
 *
 * @author Admin
 */
public class PhuKienNCCService implements IPhuKienNCCService {

    private IPhuKienNCCRepository phuKienNCCRep = new PhuKienNCCRepository();
    private Map<String, Object> map = new HashMap<>();

    @Override
    public List<QLPhuKienNCC> getAll() {
        return phuKienNCCRep.getAll();
    }

    public static void main(String[] args) {
        System.out.println(new PhuKienNCCService().getAll());
    }

    @Override
    public String save(QLPhuKienNCC pkNcc) {
        PhuKien phuKien = new PhuKien(pkNcc.getIphuKien(), pkNcc.getMaphuKien());
        NhaCungCap nhaCungCap = new NhaCungCap(pkNcc.getInhaCungCap(), pkNcc.getManhaCungCap());
        PhuKienNCC newPkNcc = new PhuKienNCC(pkNcc.getId(), nhaCungCap, phuKien, pkNcc.getGiaNhap(), pkNcc.getSoLuongNhap(), pkNcc.getNgayNhap(),pkNcc.getTrangThai());
        if (phuKienNCCRep.save(newPkNcc)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String update(QLPhuKienNCC pkNcc) {
//          PhuKien phuKien = new PhuKien();
//        if (map.containsKey(pkNcc.getPhuKien().getMa())) {
//            phuKien = (PhuKien) map.get(pkNcc.getPhuKien().getMa());
//        }
//        NhaCungCap nhaCungCap = new NhaCungCap();
//        if (map.containsKey(pkNcc.getNhaCungCap().getMa())) {
//            nhaCungCap = (NhaCungCap) map.get(pkNcc.getNhaCungCap().getMa());
//        }
        PhuKien phuKien = new PhuKien(pkNcc.getId(), pkNcc.getMaphuKien());
        NhaCungCap ncc = new NhaCungCap(pkNcc.getId(), pkNcc.getManhaCungCap());
        PhuKienNCC newPkNcc = new PhuKienNCC(pkNcc.getId(), ncc, phuKien, pkNcc.getGiaNhap(), pkNcc.getSoLuongNhap(), pkNcc.getNgayNhap(),pkNcc.getTrangThai());
        if (phuKienNCCRep.update(newPkNcc)) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public String delete(QLPhuKienNCC pkNcc) {
//    PhuKien phuKien = new PhuKien();
//        if (map.containsKey(pkNcc.getPhuKien().getMa())) {
//            phuKien = (PhuKien) map.get(pkNcc.getPhuKien().getMa());
//        }
//        NhaCungCap nhaCungCap = new NhaCungCap();
//        if (map.containsKey(pkNcc.getNhaCungCap().getMa())) {
//            nhaCungCap = (NhaCungCap) map.get(pkNcc.getNhaCungCap().getMa());
//        }
        PhuKien phuKien = new PhuKien(pkNcc.getId(), pkNcc.getMaphuKien());
        NhaCungCap ncc = new NhaCungCap(pkNcc.getId(), pkNcc.getManhaCungCap());
        PhuKienNCC newPkNcc = new PhuKienNCC(pkNcc.getId(), ncc, phuKien, pkNcc.getGiaNhap(), pkNcc.getSoLuongNhap(), pkNcc.getNgayNhap(),pkNcc.getTrangThai());
        if (phuKienNCCRep.delete(newPkNcc)) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

}
