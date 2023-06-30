/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import java.util.UUID;
import model.HoaDon;
import viewModel.ViewModelHoaDon;

/**
 *
 * @author Admin
 */
public interface HoaDonService {
    
    List<ViewModelHoaDon> getListHoaDon();
    
    ViewModelHoaDon getHoaDonById(UUID id);
    
    Boolean saveHoaDon(ViewModelHoaDon vmhd);
    
    Boolean updateHoaDon(ViewModelHoaDon vmhd);
    
    HoaDon getHoaDon(UUID id);
    
}
