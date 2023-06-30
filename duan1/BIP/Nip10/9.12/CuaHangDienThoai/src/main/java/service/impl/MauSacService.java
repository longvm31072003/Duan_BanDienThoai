/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.MauSac;
import java.util.List;
import repository.IMauSacRepository;
import repository.impl.MauSacRepository;
import service.IMauSacService;
import viewmodel.QLMauSac;

/**
 *
 * @author lethi
 */
public class MauSacService implements IMauSacService {

    private IMauSacRepository mauSacRe = new MauSacRepository();

    @Override
    public List<QLMauSac> getAll() {
        return mauSacRe.getAll();
    }

    @Override
    public String save(QLMauSac qlMauSac) {
        MauSac mauSac = new MauSac(null, qlMauSac.getMa(), qlMauSac.getTen(), qlMauSac.getTrangThai(), null);
        if (mauSacRe.saveOrupdate(mauSac)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Không Thành Công";
        }
    }

    @Override
    public String update(QLMauSac qLMauSac) {
        MauSac mauSac = new MauSac(qLMauSac.getIdMauSac(), qLMauSac.getMa(), qLMauSac.getTen(), qLMauSac.getTrangThai(), null);
        if (mauSacRe.saveOrupdate(mauSac)) {
            return "Đổi Thành Công";
        } else {
            return "Đổi Không Thành Công";
        }
    }

    @Override
    public MauSac getOne(String ten) {
        return mauSacRe.getOne(ten);
    }

}
