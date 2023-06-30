/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.ChiTietKhuyenMai;
import java.util.List;
import repository.IChiTietKhuyenMaiRepository;
import repository.impl.ChiTietKhuyenMaiRepository;
import service.CTKMService;
import viewmodel.ChiTietKMCustom;

/**
 *
 * @author hoant
 */
public class CTKMServiceImpl implements CTKMService{
    IChiTietKhuyenMaiRepository ctRep=new ChiTietKhuyenMaiRepository();
    @Override
    public List<ChiTietKMCustom> getAll() {
        return ctRep.getAll();
         }
    
}
