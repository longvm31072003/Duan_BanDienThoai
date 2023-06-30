/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.DienThoaiNCC;
import domainmodel.NhaCungCap;
import repository.impl.DTNhaCungCapRepository;
import service.IDTNhaCungCapService;
import viewmodel.QLDTNhaCungCap;
import viewmodel.QLNhaCungCap;
import domainmodel.DienThoai;
import repository.IDienThoaiRepository;
import repository.INhaCungCapRepository;
import repository.impl.DienThoaiRepository;
import repository.impl.NhaCungCapRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import repository.IDTNhaCungCapRepository;
import viewmodel.QLDienThoai;

/**
 *
 * @author ongbi
 */
public class DTNhaCungCapService implements IDTNhaCungCapService {

    private IDTNhaCungCapRepository dTNhaCungCap = new DTNhaCungCapRepository();
    private List<QLDTNhaCungCap> listDTNCC = new ArrayList<>();
    private INhaCungCapRepository iNhaCungCapRepository = new NhaCungCapRepository();
    private IDienThoaiRepository idtR = new DienThoaiRepository();
    private Map<String, Object> map = new HashMap<>();

    @Override
    public List<QLDTNhaCungCap> getAll() {

//        List<NhaCungCap> listNCC = iNhaCungCapRepository.getAll();
//        List<DienThoai> listDT = idtR.getAll();
//        listDTNCC.clear();

//        for (DienThoai dienThoai : listDT) {
//            map.put(dienThoai.getMaDienThoai(), dienThoai);
//        }
//        for (NhaCungCap nhaCungCap : listNCC) {
//            map.put(nhaCungCap.getMa(), nhaCungCap);
//        }
//        for (DienThoaiNCC dienThoaiNCC : dTNhaCungCap.getAll()) {
//            QLDTNhaCungCap qLDTNhaCungCap = new QLDTNhaCungCap(dienThoaiNCC.getId(), dienThoaiNCC.getNhaCungCap().getMa(), dienThoaiNCC.getDienThoai().getMaDienThoai(), dienThoaiNCC.getGiaNhap(), dienThoaiNCC.getSoLuongNhap(), dienThoaiNCC.getNgayNhap());
//            listDTNCC.add(qLDTNhaCungCap);
//        }

        return dTNhaCungCap.getAll();
    }

    @Override
    public String save(QLDTNhaCungCap qLDTNhaCungCap) {
        NhaCungCap idNCC = new NhaCungCap(qLDTNhaCungCap.getInhaCungCap(), qLDTNhaCungCap.getManhaCungCap());
        DienThoai idDT = new DienThoai(qLDTNhaCungCap.getIdienThoai(), qLDTNhaCungCap.getMadienThoai());
        DienThoaiNCC dienThoaiNCC = new DienThoaiNCC(qLDTNhaCungCap.getId(), idNCC, idDT, qLDTNhaCungCap.getGiaNhap(), qLDTNhaCungCap.getSoLuongNhap(), qLDTNhaCungCap.getNgayNhap(),qLDTNhaCungCap.getTrangThai());
         if(dTNhaCungCap.SaveOrUpdate(dienThoaiNCC)){
         return "Save Compelte";
         }
         else{
             return "Save Fail";
         }

//        DienThoai dienThoai = new DienThoai();
//        if (map.containsKey(qLDTNhaCungCap.getMaDT())) {
//            dienThoai = (DienThoai) map.get(qLDTNhaCungCap.getMaDT());
//        }
//        NhaCungCap nhaCungCap = new NhaCungCap();
//        if (map.containsKey(qLDTNhaCungCap.getMaNCC())) {
//            nhaCungCap = (NhaCungCap) map.get(qLDTNhaCungCap.getMaNCC());
//        }
//        DienThoaiNCC dtncc = new DienThoaiNCC(null, nhaCungCap, dienThoai, qLDTNhaCungCap.getGiaNhap(), qLDTNhaCungCap.getSoLuongNhap(), qLDTNhaCungCap.getNgayNhap());
//        if (dTNhaCungCap.SaveOrUpdate(dtncc)) {
//            return "Save Compelte";
//        } else {
//            return "Save Fail";
//        }
    }

    @Override
    public String update(QLDTNhaCungCap qLDTNhaCungCap) {
//        DienThoai dienThoai = new DienThoai();
//        if (map.containsKey(qLDTNhaCungCap.getDienThoai().getMaDienThoai())) {
//            dienThoai = (DienThoai) map.get(qLDTNhaCungCap.getDienThoai().getMaDienThoai());
//
//        }
//        NhaCungCap nhaCungCap = new NhaCungCap();
//        if (map.containsKey(qLDTNhaCungCap.getNhaCungCap().getMa())) {
//            nhaCungCap = (NhaCungCap) map.get(qLDTNhaCungCap.getNhaCungCap().getMa());
//        }
 NhaCungCap idNCC = new NhaCungCap(qLDTNhaCungCap.getInhaCungCap(), qLDTNhaCungCap.getManhaCungCap());
        DienThoai idDT = new DienThoai(qLDTNhaCungCap.getIdienThoai(), qLDTNhaCungCap.getMadienThoai());
        DienThoaiNCC dtncc = new DienThoaiNCC(qLDTNhaCungCap.getId(), idNCC, idDT, qLDTNhaCungCap.getGiaNhap(), qLDTNhaCungCap.getSoLuongNhap(), qLDTNhaCungCap.getNgayNhap(),qLDTNhaCungCap.getTrangThai());
        if (dTNhaCungCap.SaveOrUpdate(dtncc)) {
            return "Update Compelte";
        } else {
            return "Update Fail";
        }
    }

    @Override
    public String delete(QLDTNhaCungCap qLDTNhaCungCap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        System.out.println(new DTNhaCungCapService().getAll());
    }
}
