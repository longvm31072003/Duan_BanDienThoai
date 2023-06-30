/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.MauSac;

/**
 *
 * @author Admin
 */
public interface MauSacService{
    
    List<MauSac> getMauSac();
    
    MauSac getByMaMauSac(String maMauSac);
    
    Boolean saveMS(MauSac ms);
    
    Boolean updateMS(MauSac ms);
    
    Boolean deleteCTSPByMS(MauSac ms);
    
    Boolean deleteMSByID(MauSac ms);
    
}
