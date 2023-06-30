/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import model.HoaDonChiTiet;
import repository.HoaDonChiTietRep;
import services.HoaDonChiTietService;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    private HoaDonChiTietRep hoaDonChiTietRep = new HoaDonChiTietRep();

    @Override
    public Boolean save(HoaDonChiTiet hdct) {
        return hoaDonChiTietRep.save(hdct);
    }



}
