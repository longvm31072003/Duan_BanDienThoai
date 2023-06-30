/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.ChucVu;

/**
 *
 * @author Admin
 */
public interface ChucVuService {
    
    List<ChucVu> getListChucVu();
    
    ChucVu getChucVuByMa(String ma);
    
    Boolean saveChucVu(ChucVu cv);
    
    Boolean updateChucVu(ChucVu cv);
    
    Boolean deleteChucVu(ChucVu cv);
    
}
