/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.DungLuong;
import java.util.List;
import viewmodel.QLDungLuong;

/**
 *
 * @author ongbi
 */
public interface IDungLuongRepository {
    List<QLDungLuong> getAll();
    
    boolean saveOrupdate(DungLuong dungLuong);
    
    DungLuong getOne(String ten);
    
}
