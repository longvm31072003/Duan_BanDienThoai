/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.NhaCungCap;
import java.util.ArrayList;
import java.util.List;
import repository.INhaCungCapRepository;
import repository.impl.NhaCungCapRepository;
import service.INhaCungCapService;
import viewmodel.QLNhaCungCap;

/**
 *
 * @author Admin
 */
public class NhaCungCapService implements INhaCungCapService {

    private INhaCungCapRepository nhaCungCapRep = new NhaCungCapRepository();

    @Override
    public List<QLNhaCungCap> getAll() {
       
        return nhaCungCapRep.getAll();
    }
    
    @Override
    public QLNhaCungCap getOne(String ma) {
        NhaCungCap ncc = nhaCungCapRep.getOne(ma);
        QLNhaCungCap newNcc = new QLNhaCungCap(ncc.getId(), ncc.getMa(), ncc.getDiaChi(), ncc.getTen(), ncc.getSdt(), ncc.getEmail(), ncc.getTrangThai());
        return newNcc;
    }
    
    @Override
    public String save(QLNhaCungCap ncc) {
        NhaCungCap newNcc = new NhaCungCap(null, ncc.getMa(), ncc.getDiaChi(), ncc.getTen(), ncc.getSdt(), ncc.getEmail(), ncc.getTrangThai(), null, null);
        if (nhaCungCapRep.save(newNcc)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String update(QLNhaCungCap ncc) {
        NhaCungCap newNcc = new NhaCungCap(ncc.getId(), ncc.getMa(), ncc.getDiaChi(), ncc.getTen(), ncc.getSdt(), ncc.getEmail(), ncc.getTrangThai(), null, null);
        if (nhaCungCapRep.update(newNcc)) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public String delete(QLNhaCungCap ncc) {
        NhaCungCap newNcc = new NhaCungCap(ncc.getId(), ncc.getMa(), ncc.getDiaChi(), ncc.getTen(), ncc.getSdt(), ncc.getEmail(), ncc.getTrangThai(), null, null);
        if (nhaCungCapRep.delete(newNcc)) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

    @Override
    public List<QLNhaCungCap> timKiem(String ma) {
     return nhaCungCapRep.timKiem(ma);
    }

}
