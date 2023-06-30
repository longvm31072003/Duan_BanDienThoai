/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.KhachHang;
import repository.KhachHangRep;
import services.KhachHangService;

/**
 *
 * @author Admin
 */
public class KhachHangServiceImpl implements KhachHangService{

    private KhachHangRep khachHangRep = new KhachHangRep();
    
    @Override
    public List<KhachHang> getListKhachHang() {
       return khachHangRep.getListKhachHang();
    }

    @Override
    public KhachHang getKhachHangByMa(String ma) {
        return khachHangRep.getKhachHangByMa(ma);
    }

    @Override
    public Boolean saveKhachHang(KhachHang kh) {
        return khachHangRep.saveKhachHang(kh);
    }

    @Override
    public Boolean updateKhachHang(KhachHang kh) {
        return khachHangRep.updateKhachHang(kh);
    }

    @Override
    public Boolean deleteKhachHang(KhachHang kh) {
        return khachHangRep.deleteKhachHang(kh);
    }
    
}
