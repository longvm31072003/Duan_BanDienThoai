/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.DongSanPham;
import repository.DongSanPhamRep;
import services.DongSanPhamService;

/**
 *
 * @author Admin
 */
public class DongSanPhamServiceImpl implements DongSanPhamService {

    DongSanPhamRep dongSanPhamRep = new DongSanPhamRep();

    @Override
    public List<DongSanPham> getDongSanPham() {
        return dongSanPhamRep.getDongSanPham();
    }

    @Override
    public DongSanPham getByMaDSP(String maDSP) {
        return dongSanPhamRep.getByMa(maDSP);
    }

    @Override
    public Boolean saveDSP(DongSanPham dsp) {
        return dongSanPhamRep.saveDSP(dsp);
    }

    @Override
    public Boolean updateDSP(DongSanPham dsp) {
        return dongSanPhamRep.updateDSP(dsp);
    }

    @Override
    public Boolean deleteCTSPByDSP(DongSanPham dsp) {
        return dongSanPhamRep.deleteCTSPByDSP(dsp);
    }

    @Override
    public Boolean deleteDSPByID(DongSanPham dsp) {
        return dongSanPhamRep.deleteDSPByID(dsp);
    }

}
