/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.SanPham;
import repository.SanPhamRep;
import services.SanPhamService;

/**
 *
 * @author Admin
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRep sanPhamRep = new SanPhamRep();

    @Override
    public List<SanPham> getSanPham() {
        return sanPhamRep.getSanPham();
    }

    @Override
    public SanPham getByMaSP(String maSP) {
        return sanPhamRep.getByMa(maSP);
    }

    @Override
    public Boolean saveSP(SanPham sp) {
        return sanPhamRep.saveSP(sp);
    }

    @Override
    public Boolean updateSP(SanPham sp) {
        return sanPhamRep.updateSP(sp);
    }

    @Override
    public Boolean deleteCTSPBySP(SanPham sp) {
        return sanPhamRep.deleteCTSPBySP(sp);
    }

    @Override
    public Boolean deleteSPByID(SanPham sp) {
        return sanPhamRep.deleteSPByID(sp);
    }

}
