/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.DienThoai;
import domainmodel.DienThoaiNCC;
import domainmodel.Imei;
import domainmodel.NhaCungCap;
import domainmodel.PhuKien;
import domainmodel.PhuKienNCC;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import repository.IimeiRepository;
import repository.impl.ImeiRepository;
import service.IimeiService;
import viewmodel.QLDienThoai;
import viewmodel.QLImei;

/**
 *
 * @author ongbi
 */
public class ImeiService implements IimeiService {

    IimeiRepository iimeiRepository;

    public ImeiService() {
        iimeiRepository = new ImeiRepository();
    }

   

    @Override
    public String save(QLImei imei) {
        if (imei.getIdPhuKienNCC() == null) {
            DienThoai dienThoai = new DienThoai(imei.getIdDienThoai(), null);
            NhaCungCap nhaCungCap = new NhaCungCap(imei.getIdNhaCungCap(), null);
            DienThoaiNCC dienThoaiNCC = new DienThoaiNCC(imei.getIdDienThoaiNCC(), nhaCungCap, dienThoai, null, 0, null,0);
            Imei imei1 = new Imei(null, imei.getMa(), imei.getTrangThai(), dienThoaiNCC, null);

            if (iimeiRepository.saveOrupdate(imei1)) {
                return "Thêm Thành Công";
            } else {
                return "Thêm Không Thành Công";
            }

        } else {
            PhuKien phuKien = new PhuKien(imei.getIdPhuKien(), null);
            NhaCungCap nhaCungCap = new NhaCungCap(imei.getIdNhaCungCap(), null);
            PhuKienNCC phuKienNCC = new PhuKienNCC(imei.getIdPhuKienNCC(), nhaCungCap, phuKien, null, 0, null,0);
            Imei imei1 = new Imei(null, imei.getMa(), imei.getTrangThai(), null, phuKienNCC);

            if (iimeiRepository.saveOrupdate(imei1)) {
                return "Thêm Thành Công";
            } else {
                return "Thêm Không Thành Công";
            }

        }

    }

    @Override
    public QLImei getOne(String ma) {
        Imei imei = iimeiRepository.getOne(ma);
        if (imei == null) {
            return null;
        }
        QLImei qLImei = new QLImei(imei.getId(), imei.getMa(), imei.getTrangThai(), imei.getDtNcc() == null ? null : imei.getDtNcc().getId(), imei.getPkNcc() == null ? null : imei.getPkNcc().getId());
        return qLImei;
    }

    @Override
    public String Xoa(QLImei imei) {
        DienThoai dienThoai = new DienThoai(imei.getIdDienThoai(), null);
        NhaCungCap nhaCungCap = new NhaCungCap(imei.getIdNhaCungCap(), null);
        DienThoaiNCC dienThoaiNCC = new DienThoaiNCC(imei.getIdDienThoaiNCC(), nhaCungCap, dienThoai, null, 0, null,0);
        Imei imei1 = new Imei(imei.getId(), imei.getMa(), imei.getTrangThai(), dienThoaiNCC, null);

        if (iimeiRepository.xoa(imei1)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Không Thành Công";
        }
    }

    @Override
    public List<QLImei> getAllDT(UUID id) {
    return iimeiRepository.getAllDT(id);
    }

    @Override
    public List<QLImei> getAllPK(UUID id) {
     return iimeiRepository.getAllPK(id);
    }
 
    public static void main(String[] args) {

    }

    @Override
    public String genMaImei() {
        return "IMEI00"+iimeiRepository.genMaImei();
    }
      
}
