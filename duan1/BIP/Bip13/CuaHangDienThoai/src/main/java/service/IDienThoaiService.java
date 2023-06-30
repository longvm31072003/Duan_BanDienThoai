/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.DienThoai;
import java.util.List;
import java.util.UUID;
import viewmodel.QLDienThoai;

/**
 *
 * @author dungp
 */
public interface IDienThoaiService {

     List<QLDienThoai> getAll();

    String them(QLDienThoai QLDienThoai);

    String sua(QLDienThoai QLDienThoai, UUID idDienThoai);

    String xoa(UUID idDienThoai);
    QLDienThoai getOne(String ma);
    List<QLDienThoai> timKiem(String maDienThoai,String tenDienThoai);
    
    List<QLDienThoai> dtDangBan();
    
    List<QLDienThoai> dtNgungBan();

    List<QLDienThoai> getSP(String ten);
    QLDienThoai validateTonTai(String ten, String dungLuong, String Ram, String mauSac); 
}
