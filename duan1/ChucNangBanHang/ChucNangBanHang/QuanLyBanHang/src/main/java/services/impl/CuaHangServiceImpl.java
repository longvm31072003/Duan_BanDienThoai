/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.CuaHang;
import repository.CuaHangRep;
import services.CuaHangService;

/**
 *
 * @author Admin
 */
public class CuaHangServiceImpl implements CuaHangService {

    private CuaHangRep cuaHangRep = new CuaHangRep();

    @Override
    public List<CuaHang> getListCuaHang() {
        return cuaHangRep.getListCuaHang();
    }

    @Override
    public CuaHang getCuaHangByMa(String ma) {
        return cuaHangRep.getCuaHangByMa(ma);
    }

    @Override
    public Boolean saveCuaHang(CuaHang ch) {
        return cuaHangRep.saveCuaHang(ch);
    }

    @Override
    public Boolean updateCuaHang(CuaHang ch) {
        return cuaHangRep.updateCuaHang(ch);
    }

    @Override
    public Boolean deleteCuaHang(CuaHang ch) {
        return cuaHangRep.deleteCuaHang(ch);
    }

}
