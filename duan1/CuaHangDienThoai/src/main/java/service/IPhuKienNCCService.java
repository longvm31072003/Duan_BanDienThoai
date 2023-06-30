/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLPhuKienNCC;

/**
 *
 * @author Admin
 */
public interface IPhuKienNCCService {
    
    List<QLPhuKienNCC> getAll();
    
    String save(QLPhuKienNCC pkNcc);
    
    String update(QLPhuKienNCC pkNcc);
    
    String delete(QLPhuKienNCC pkNcc);
    
}
