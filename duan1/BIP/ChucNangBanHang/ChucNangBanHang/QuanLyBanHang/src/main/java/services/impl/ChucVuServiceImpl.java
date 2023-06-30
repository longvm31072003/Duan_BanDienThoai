/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.ChucVu;
import repository.ChucVuRep;
import services.ChucVuService;

/**
 *
 * @author Admin
 */
public class ChucVuServiceImpl implements ChucVuService{

    private ChucVuRep chucVuRep = new ChucVuRep();
    
    @Override
    public List<ChucVu> getListChucVu() {
        return chucVuRep.getListChucVu();
    }

    @Override
    public ChucVu getChucVuByMa(String ma) {
        return chucVuRep.getChucVuByMa(ma);
    }

    @Override
    public Boolean saveChucVu(ChucVu cv) {
        return chucVuRep.saveChucVu(cv);
    }

    @Override
    public Boolean updateChucVu(ChucVu cv) {
        return chucVuRep.updateChucVu(cv);
    }

    @Override
    public Boolean deleteChucVu(ChucVu cv) {
        return chucVuRep.deleteChucVu(cv);
    }
    public static void main(String[] args) {
        System.out.println("ch");
    }
}
