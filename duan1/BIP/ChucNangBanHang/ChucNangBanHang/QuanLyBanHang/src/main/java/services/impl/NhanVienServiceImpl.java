/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import java.util.UUID;
import model.NhanVien;
import repository.NhanVienRep;
import services.NhanVienService;

/**
 *
 * @author Admin
 */
public class NhanVienServiceImpl implements NhanVienService{

    private NhanVienRep nhanVienRep = new NhanVienRep();
    
    @Override
    public List<NhanVien> getNhanVien() {
        return nhanVienRep.getNhanVien();
    }

    @Override
    public NhanVien getNhanVienByMa(String ma) {
        return nhanVienRep.getNhanVienByMa(ma);
    }

    @Override
    public Boolean saveNhanVien(NhanVien nv) {
        return nhanVienRep.saveNhanVien(nv);
    }

    @Override
    public Boolean updateNhanVien(NhanVien nv) {
        return nhanVienRep.updateNhanVien(nv);
    }

    @Override
    public Boolean deleteNhanVien(NhanVien nv) {
       return nhanVienRep.deleteNhanVien(nv);
    }
    
}
