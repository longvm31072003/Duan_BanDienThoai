/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import java.util.UUID;
import domainmodel.DienThoai;
import viewmodel.QLDienThoai;

/**
 *
 * @author dungp
 */
public interface IDienThoaiRepository {

    List<DienThoai> getAll1();

    List<QLDienThoai> getAll();

    List<DienThoai> getSP(String ten);

    DienThoai getOne(String ma);

    boolean save(DienThoai dienThoai);
//Dung Sua Code

    boolean update(DienThoai dienThoai, UUID idDienThoai);

    boolean delete(UUID idDienThoai);

    //Dung Code
    List<QLDienThoai> timKiem(String maDienThoai, String tenDienThoai);

    List<QLDienThoai> dtDangBan();

    List<QLDienThoai> dtNgungBan();

    DienThoai validateTonTai(String ten, String dungLuong, String Ram, String mauSac);

}
