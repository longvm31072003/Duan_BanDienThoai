/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public interface NhanVienService {

    List<NhanVien> getNhanVien();
    
    NhanVien getNhanVienByMa(String ma);
    
    Boolean saveNhanVien(NhanVien nv);
    
    Boolean updateNhanVien(NhanVien nv);
    
    Boolean deleteNhanVien(NhanVien nv);
    
}
