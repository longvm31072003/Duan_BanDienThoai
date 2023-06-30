/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import java.util.UUID;
import model.ChiTietSanPham;
import viewModel.ViewModelSanPham;

/**
 *
 * @author Admin
 */
public interface ChiTietSanPhamService {
 
    List<ViewModelSanPham> getListCTSP();
    
    Boolean saveCTSP(ViewModelSanPham vmsp);
    
    Boolean deleteCTSP(ViewModelSanPham vmsp);
    
    Boolean updateCTSP(ViewModelSanPham vmsp);
    
    ViewModelSanPham getById(UUID id);
    
    ChiTietSanPham getChiTietSanPham(UUID id);
    
    List<ViewModelSanPham> getCTSPByNamBaoHanh(int namBaoHanh);
    
}
