/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.HoaDon;
import repository.HoaDonRep;
import services.HoaDonService;
import viewModel.ViewModelHoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonServiceImpl implements HoaDonService{

    private HoaDonRep hoaDonRep = new HoaDonRep();
    private List<ViewModelHoaDon> listViewModelHoaDon = new ArrayList<>();
    
    @Override
    public List<ViewModelHoaDon> getListHoaDon() {
        listViewModelHoaDon = new ArrayList<>();
        List<HoaDon> list = hoaDonRep.getHoaDon();
        for (HoaDon hd : list) {
            listViewModelHoaDon.add(new ViewModelHoaDon(hd.getId(), hd.getNhanVien(), hd.getMa(), 
                    hd.getNgayTao(), hd.getTinhTrang()));
        }
        return listViewModelHoaDon;
    }

    @Override
    public ViewModelHoaDon getHoaDonById(UUID id) {
        HoaDon hd = hoaDonRep.getHoaDonById(id);
        ViewModelHoaDon viewModelHoaDon = new ViewModelHoaDon(hd.getNhanVien(), hd.getMa(), 
                hd.getNgayTao(), hd.getTinhTrang());
        return viewModelHoaDon;
    }

    @Override
    public Boolean saveHoaDon(ViewModelHoaDon vmhd) {
        HoaDon hd = new HoaDon(vmhd.getNhanVien(), vmhd.getMa(), vmhd.getNgayTao(), vmhd.getTinhTrang());
        return hoaDonRep.saveHoaDon(hd);
    }

    @Override
    public Boolean updateHoaDon(ViewModelHoaDon vmhd) {
        HoaDon hd = new HoaDon();
        List<HoaDon> list = hoaDonRep.getHoaDon();
        for (HoaDon hoaDon : list) {
            if(vmhd.getId().equals(hoaDon.getId())){
                hd = hoaDon; 
            }
        }
        hd.setNhanVien(vmhd.getNhanVien());
        hd.setTinhTrang(vmhd.getTinhTrang());
        return hoaDonRep.updateHoaDon(hd);
    }

    @Override
    public HoaDon getHoaDon(UUID id) {
        return hoaDonRep.getHoaDonById(id);
    }


    
}
