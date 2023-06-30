/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.DongSanPham;
import model.MauSac;
import repository.MauSacRep;
import services.MauSacService;

/**
 *
 * @author Admin
 */
public class MauSacServiceImpl implements MauSacService{

    private MauSacRep mauSacRep = new MauSacRep();
    
    @Override
    public List<MauSac> getMauSac() {
        return mauSacRep.getMauSac();
    }

    @Override
    public MauSac getByMaMauSac(String maMauSac) {
        return mauSacRep.getByMa(maMauSac);
    }

    @Override
    public Boolean saveMS(MauSac ms) {
        return mauSacRep.saveMS(ms);
    }

    @Override
    public Boolean updateMS(MauSac ms) {
        return mauSacRep.updateMS(ms);
    }

    @Override
    public Boolean deleteCTSPByMS(MauSac ms) {
        return mauSacRep.deleteCTSPByMS(ms);
    }

    @Override
    public Boolean deleteMSByID(MauSac ms) {
        return mauSacRep.deleteMSByID(ms);
    }
    
}
