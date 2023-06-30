/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.NhaSanXuat;

/**
 *
 * @author Admin
 */
public interface NhaSanXuatService {
 
    List<NhaSanXuat> getNhaSanXuat();
    
    NhaSanXuat getByMaNSX(String maNSX);
    
    Boolean saveNSX(NhaSanXuat nsx);
    
    Boolean updateNSX(NhaSanXuat nsx);
    
    Boolean deleteCTSPByNSX(NhaSanXuat nsx);
    
    Boolean deleteNSXByID(NhaSanXuat nsx);
    
}
