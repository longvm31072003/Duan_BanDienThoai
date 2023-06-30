/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.DongSanPham;

/**
 *
 * @author Admin
 */
public interface DongSanPhamService {
    
    List<DongSanPham> getDongSanPham();
    
    DongSanPham getByMaDSP(String maDSP);
    
    Boolean saveDSP(DongSanPham dsp);
    
    Boolean updateDSP(DongSanPham dsp);
    
    Boolean deleteCTSPByDSP(DongSanPham dsp);
    
    Boolean deleteDSPByID(DongSanPham dsp);
    
}
