/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import java.util.UUID;
import viewmodel.QLNhanVien;

/**
 *
 * @author lethi
 */
public interface INhanVienService {
    List<QLNhanVien> getAll();
    String add(QLNhanVien qLNhanVien);
    String update(QLNhanVien qLNhanVien, UUID id);
    String delete(UUID id);
     List<QLNhanVien> search(String CCCD);
     List<QLNhanVien> getNVDLV();
    
    List<QLNhanVien> getNVDNV();
}
