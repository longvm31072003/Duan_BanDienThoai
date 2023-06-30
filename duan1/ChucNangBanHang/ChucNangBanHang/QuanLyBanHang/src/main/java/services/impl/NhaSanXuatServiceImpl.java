/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.NhaSanXuat;
import repository.NhaSanXuatRep;
import services.NhaSanXuatService;

/**
 *
 * @author Admin
 */
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    private NhaSanXuatRep nhaSanXuatRep = new NhaSanXuatRep();

    @Override
    public List<NhaSanXuat> getNhaSanXuat() {
        return nhaSanXuatRep.getNhaSanXuat();
    }

    @Override
    public NhaSanXuat getByMaNSX(String maNSX) {
        return nhaSanXuatRep.getByMa(maNSX);
    }

    @Override
    public Boolean saveNSX(NhaSanXuat nsx) {
        return nhaSanXuatRep.saveNSX(nsx);
    }

    @Override
    public Boolean updateNSX(NhaSanXuat nsx) {
        return nhaSanXuatRep.updateNSX(nsx);
    }

    @Override
    public Boolean deleteCTSPByNSX(NhaSanXuat nsx) {
        return nhaSanXuatRep.deleteCTSPByNSX(nsx);
    }

    @Override
    public Boolean deleteNSXByID(NhaSanXuat nsx) {
        return nhaSanXuatRep.deleteSPByID(nsx);
    }

}
