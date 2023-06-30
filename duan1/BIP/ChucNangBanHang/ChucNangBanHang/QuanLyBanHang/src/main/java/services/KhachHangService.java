/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public interface KhachHangService {
    
    List<KhachHang> getListKhachHang();
    
    KhachHang getKhachHangByMa(String ma);
    
    Boolean saveKhachHang(KhachHang kh);
    
    Boolean updateKhachHang(KhachHang kh);
    
    Boolean deleteKhachHang(KhachHang kh);
    
}
