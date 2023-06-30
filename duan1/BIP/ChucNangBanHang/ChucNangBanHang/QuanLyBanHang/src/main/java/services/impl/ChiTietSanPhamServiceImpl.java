/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.ArrayList;
import java.util.List;  
import java.util.UUID;
import model.ChiTietSanPham;
import repository.ChiTietSanPhamRep;
import services.ChiTietSanPhamService;
import viewModel.ViewModelSanPham;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    private ChiTietSanPhamRep CTSPRep = new ChiTietSanPhamRep();
    private List<ViewModelSanPham> listViewModelSanPhams = new ArrayList<>();

    @Override
    public List<ViewModelSanPham> getListCTSP() {
        listViewModelSanPhams = new ArrayList<>();
        List<ChiTietSanPham> list = CTSPRep.getListCTSP();
        for (ChiTietSanPham x : list) {
            listViewModelSanPhams.add(new ViewModelSanPham(x.getIdCTSP(), x.getSanPham(), x.getNhaSanXuat(),
                    x.getMauSac(), x.getDongSanPham(), x.getNamBH(),
                    x.getMoTa(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan()));
        }
        return listViewModelSanPhams;
    }

    @Override
    public Boolean saveCTSP(ViewModelSanPham sp) {
        ChiTietSanPham ctsp = new ChiTietSanPham(sp.getSanPham(), sp.getNhaSanXuat(), sp.getMauSac(),
                sp.getDongSanPham(), sp.getNamBH(), sp.getMoTa(),
                sp.getSoLuongTon(), sp.getGiaNhap(), sp.getGiaBan());
        return CTSPRep.saveCTSP(ctsp);
    }

    @Override
    public Boolean deleteCTSP(ViewModelSanPham sp) {
        ChiTietSanPham ctsp = CTSPRep.getCTSPById(sp.getIdCTSP());
        return CTSPRep.deleteCTSP(ctsp);
    }

    @Override
    public Boolean updateCTSP(ViewModelSanPham sp) {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        List<ChiTietSanPham> list = CTSPRep.getListCTSP();
        for (ChiTietSanPham x : list) {
            if (x.getIdCTSP().equals(sp.getIdCTSP())) {
                ctsp = x;
                break;
            }
        }
        ctsp.setSanPham(sp.getSanPham());
        ctsp.setDongSanPham(sp.getDongSanPham());
        ctsp.setMauSac(sp.getMauSac());
        ctsp.setNhaSanXuat(sp.getNhaSanXuat());
        ctsp.setNamBH(sp.getNamBH());
        ctsp.setMoTa(sp.getMoTa());
        ctsp.setSoLuongTon(sp.getSoLuongTon());
        ctsp.setGiaBan(sp.getGiaBan());
        ctsp.setGiaNhap(sp.getGiaNhap());
        return CTSPRep.updateCTSP(ctsp);
    }

    @Override
    public ViewModelSanPham getById(UUID id) {
        ChiTietSanPham ctsp = CTSPRep.getCTSPById(id);
        ViewModelSanPham viewModelSanPham = new ViewModelSanPham(ctsp.getIdCTSP(), ctsp.getSanPham(), ctsp.getNhaSanXuat(),
                ctsp.getMauSac(), ctsp.getDongSanPham(), ctsp.getNamBH(),
                ctsp.getMoTa(), ctsp.getSoLuongTon(), ctsp.getGiaNhap(), ctsp.getGiaBan());
        return viewModelSanPham;
    }

    @Override
    public ChiTietSanPham getChiTietSanPham(UUID id) {
        return CTSPRep.getCTSPById(id);
    }

    @Override
    public List<ViewModelSanPham> getCTSPByNamBaoHanh(int namBaoHanh) {
//        List<ViewModelSanPham> listSearch = new ArrayList<>();
//        List<ChiTietSanPham> list = CTSPRep.getListCTSP();
//        for (ChiTietSanPham x : list) {
//            if (x.getNamBH() == namBaoHanh) {
//                listSearch.add(new ViewModelSanPham(x.getIdCTSP(), x.getSanPham(), x.getNhaSanXuat(),
//                        x.getMauSac(), x.getDongSanPham(), x.getNamBH(),
//                        x.getMoTa(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan()));
//            }
//        }
//        return listSearch;
        List<ViewModelSanPham> listSearch = new ArrayList<>();
        List<ChiTietSanPham> list = CTSPRep.getCTSPByNamBaoHanh(namBaoHanh);
        for (ChiTietSanPham x : list) {
                listSearch.add(new ViewModelSanPham(x.getIdCTSP(), x.getSanPham(), x.getNhaSanXuat(),
                        x.getMauSac(), x.getDongSanPham(), x.getNamBH(),
                        x.getMoTa(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan()));
        }
        return listSearch;
    }

}
