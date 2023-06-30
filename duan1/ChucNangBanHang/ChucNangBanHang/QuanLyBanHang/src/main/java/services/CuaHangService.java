/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.CuaHang;

/**
 *
 * @author Admin
 */
public interface CuaHangService {
    
    List<CuaHang> getListCuaHang();
    
    CuaHang getCuaHangByMa(String ma);
    
    Boolean saveCuaHang(CuaHang ch);
    
    Boolean updateCuaHang(CuaHang ch);
    
    Boolean deleteCuaHang(CuaHang ch);
    
}
