/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLNhaCungCap;

/**
 *
 * @author Admin
 */
public interface INhaCungCapService {
    QLNhaCungCap getOne(String ma);
    List<QLNhaCungCap> getAll();
    
    String save(QLNhaCungCap ncc);
    
    String update(QLNhaCungCap ncc);
    
    String delete(QLNhaCungCap ncc);
    
    List<QLNhaCungCap> timKiem(String ma);
}
