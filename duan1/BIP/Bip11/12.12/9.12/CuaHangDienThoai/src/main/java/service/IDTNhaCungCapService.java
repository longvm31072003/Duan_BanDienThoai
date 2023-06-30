/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import viewmodel.QLDTNhaCungCap;
import java.util.List;

/**
 *
 * @author ongbi
 */
public interface IDTNhaCungCapService {
    List<QLDTNhaCungCap> getAll();

    String save(QLDTNhaCungCap qLDTNhaCungCap);
    
    String update(QLDTNhaCungCap qLDTNhaCungCap);

    String delete(QLDTNhaCungCap qLDTNhaCungCap);
}
