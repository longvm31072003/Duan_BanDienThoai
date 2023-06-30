/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.Hang;
import java.util.ArrayList;
import java.util.List;
import repository.IHangRepository;
import repository.impl.HangRepository;
import service.IHangService;
import viewmodel.QLHang;

/**
 *
 * @author Admin
 */
public class HangService implements IHangService {

    private IHangRepository hangRe = new HangRepository();

    @Override
    public List<QLHang> getHHD() {
        List<QLHang> listHang = new ArrayList<>();
        for (Hang x : hangRe.getHHD()) {
            QLHang hang = new QLHang(x.getId(), x.getMa(), x.getTen(), x.getTrangThai());
            listHang.add(hang);
        }
        return listHang;
    }

    @Override
    public String save(QLHang hang) {
        Hang newHang = new Hang(null, hang.getMa(), hang.getTen(), hang.getTrangThai(), null, null);
        if (hangRe.save(newHang)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String update(QLHang hang) {
        Hang newHang = new Hang(hang.getId(), hang.getMa(), hang.getTen(), hang.getTrangThai(), null, null);
        if (hangRe.update(newHang)) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public String delete(QLHang hang) {
        Hang newHang = new Hang(hang.getId(), hang.getMa(), hang.getTen(), hang.getTrangThai(), null, null);
        if (hangRe.delete(newHang)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public List<QLHang> getHNHD() {
        List<QLHang> listHang = new ArrayList<>();
        for (Hang x : hangRe.getHNHD()) {
            QLHang hang = new QLHang(x.getId(), x.getMa(), x.getTen(), x.getTrangThai());
            listHang.add(hang);
        }
        return listHang;
    }

    @Override
    public List<QLHang> timKiem(String chuoi, int number) {
        List<QLHang> listSearch = new ArrayList<>();
        for (Hang x : hangRe.timKiem(chuoi, number)) {
            QLHang hang = new QLHang(x.getId(), x.getMa(), x.getTen(), x.getTrangThai());
            listSearch.add(hang);
        }
        return listSearch;
    }

    @Override
    public Hang getOne(String ten) {
        return hangRe.getOne(ten);
    }
}
