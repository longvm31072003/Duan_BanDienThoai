/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.NhaCungCap;
import java.util.List;
import viewmodel.QLNhaCungCap;

/**
 *
 * @author Admin
 */
public interface INhaCungCapRepository {
     NhaCungCap getOne(String ma);
    List<QLNhaCungCap> getAll();
    
    boolean save(NhaCungCap nhaCungCap);
    
    boolean update(NhaCungCap nhaCungCap);
    
    boolean delete(NhaCungCap nhaCungCap);
    
        List<QLNhaCungCap> timKiem(String Ma);
}
