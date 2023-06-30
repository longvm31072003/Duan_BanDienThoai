/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.DienThoaiNCC;
import java.util.List;
import viewmodel.QLDTNhaCungCap;

/**
 *
 * @author ongbi
 */
public interface IDTNhaCungCapRepository {

    List<QLDTNhaCungCap> getAll();

    boolean SaveOrUpdate(DienThoaiNCC dienThoaiNCC);

    boolean delete(DienThoaiNCC dienThoaiNCC);
    
}
