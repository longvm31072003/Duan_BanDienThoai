/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.PhuKienNCC;
import java.util.List;
import viewmodel.QLPhuKienNCC;

/**
 *
 * @author Admin
 */
public interface IPhuKienNCCRepository {
 
    List<QLPhuKienNCC> getAll();
    
    boolean save(PhuKienNCC pkNcc);
    
    boolean update(PhuKienNCC pkNcc);
    
    boolean delete(PhuKienNCC pkNcc);
    
}
