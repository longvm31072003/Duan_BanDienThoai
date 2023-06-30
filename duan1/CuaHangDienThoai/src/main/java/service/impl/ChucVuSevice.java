/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import repository.IChucVuRepository;
import repository.impl.ChucVuRepository;
import service.IChucVuService;
import java.util.ArrayList;
import java.util.List;
import viewmodel.QlChucVu;
import java.util.HashMap;
import java.util.Map;
import domainmodel.ChucVu;
import java.math.BigDecimal;

/**
 *
 * @author ongbi
 */
public class ChucVuSevice implements IChucVuService {

    private IChucVuRepository iChucVuRepository;
    private List<QlChucVu> listCV;
    private Map<String, Object> map = new HashMap();

    public ChucVuSevice() {
        iChucVuRepository = new ChucVuRepository();
        listCV = new ArrayList<>();
    }

    @Override
    public List<QlChucVu> getAll() {

//        listCV.clear();
//        listCV = new ArrayList<>();
//        for (ChucVu cv : iChucVuRepository.getAll()) {
//            QlChucVu chucVu = new QlChucVu(cv.getId(), cv.getMa(), cv.getTen(), cv.getLuong(),cv.getTrangThai());
//            listCV.add(chucVu);
//        }
//        return listCV;
    return iChucVuRepository.getAll();
      
     

    }

    @Override
    public String save(QlChucVu qLCv) {

        ChucVu chucVu = new ChucVu(null, qLCv.getMa(), qLCv.getTen(), qLCv.getLuong(),qLCv.getQuyenSD(),null);


        if (iChucVuRepository.SaveOrUpdate(chucVu)) {
            return "Save complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String update(QlChucVu qLCv) {
       ChucVu chucVu = new ChucVu(qLCv.getId(), qLCv.getMa(), qLCv.getTen(), qLCv.getLuong(),qLCv.getQuyenSD(), null);
        if (iChucVuRepository.SaveOrUpdate(chucVu)) {
            return "Update Complete";
        } else {
            return "Update Fail";
        }
    }

    @Override
    public String delete(QlChucVu qLCv) {
    ChucVu chucVu = new ChucVu(null, qLCv.getMa(), qLCv.getTen(), qLCv.getLuong(),qLCv.getQuyenSD(), null);
        if (iChucVuRepository.delete(chucVu)) {
            return "Delete Complete";

        } else {

            return "Delete Complete";
        }
    }

    public static void main(String[] args) {
        System.out.println(new ChucVuSevice().getAll());
    }


    @Override
    public ChucVu getOne(String ten) {
        return iChucVuRepository.getOne(ten);
    }

}
