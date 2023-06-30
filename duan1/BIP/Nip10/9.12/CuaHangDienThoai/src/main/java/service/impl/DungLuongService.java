/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.DungLuong;
import java.util.List;
import repository.IDungLuongRepository;
import repository.impl.DungLuongRepository;
import service.IDungLuongService;
import viewmodel.QLDungLuong;

/**
 *
 * @author ongbi
 */
public class DungLuongService implements IDungLuongService {

    private IDungLuongRepository iDungLuongRepository;

    public DungLuongService() {
        iDungLuongRepository = new DungLuongRepository();
    }

    @Override
    public List<QLDungLuong> getAll() {
        return this.iDungLuongRepository.getAll();
    }

    @Override
    public String save(QLDungLuong qldungLuong) {
        DungLuong dungLuong = new DungLuong(null, qldungLuong.getMa(), qldungLuong.getTen(), qldungLuong.getTrangThai(), null);
        if (iDungLuongRepository.saveOrupdate(dungLuong)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Không Thành Công";
        }
    }

    @Override
    public String update(QLDungLuong qldungLuong) {
        DungLuong dungLuong = new DungLuong(qldungLuong.getIdDungLuong(), qldungLuong.getMa(), qldungLuong.getTen(), qldungLuong.getTrangThai(), null);
        if (iDungLuongRepository.saveOrupdate(dungLuong)) {
            return "Đổi Thành Công";
        } else {
            return "Đổi Không Thành Công";
        }
    }

    public static void main(String[] args) {
        System.out.println(new DungLuongService().getAll());
    }

    @Override
    public DungLuong getOne(String ten) {
        return iDungLuongRepository.getOne(ten);
    }

}
