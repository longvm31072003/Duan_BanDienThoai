/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.TaiKhoan;
import java.util.List;
import java.util.UUID;
import viewmodel.QLTaiKhoan;

/**
 *
 * @author dungp
 */
public interface ITaiKhoanService {

    TaiKhoan getOne(String taiKhoan, String matKhau);

    List<QLTaiKhoan> getAll();

    List<QLTaiKhoan> timKiem(String tenTK);

    String add(QLTaiKhoan qlTaiKhoan);

    String update(QLTaiKhoan qlTaiKhoan);

    String delete(UUID idTaiKhoan);

    TaiKhoan getOne2(String taiKhoan, String matKhau);

    TaiKhoan getOne3(String taiKhoan);
}
