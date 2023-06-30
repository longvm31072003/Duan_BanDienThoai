/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.Ram;
import java.util.List;
import repository.IRamRepository;
import repository.impl.RamRepository;
import service.IRamService;
import viewmodel.QLRam;

/**
 *
 * @author lethi
 */
public class RamService implements IRamService {

    private IRamRepository ramRe = new RamRepository();

    @Override
    public List<QLRam> getAll() {
        return ramRe.getAll();
    }

    @Override
    public String save(QLRam qlRam) {
        Ram ram = new Ram(null, qlRam.getMa(), qlRam.getTen(), qlRam.getTrangThai(), null);
        if (ramRe.saveOrupdate(ram)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Không Thành Công";
        }
    }

    @Override
    public String update(QLRam qlRam) {
        Ram ram = new Ram(qlRam.getIdRam(), qlRam.getMa(), qlRam.getTen(), qlRam.getTrangThai(), null);
        if (ramRe.saveOrupdate(ram)) {
            return "Đổi Thành Công";
        } else {
            return "Đổi Không Thành Công";
        }
    }

    @Override
    public Ram getOne(String ten) {
        return ramRe.getOne(ten);
    }

}
