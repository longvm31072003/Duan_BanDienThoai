/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.SanPham;

/**
 *
 * @author Admin
 */
public interface SanPhamService {
    
    List<SanPham> getSanPham();
    
    SanPham getByMaSP(String maSP);
    
    Boolean saveSP(SanPham sp);
    
    Boolean updateSP(SanPham sp);
    
    Boolean deleteCTSPBySP(SanPham sp);
    
    Boolean deleteSPByID(SanPham sp);
    
}
