/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.TaiKhoan;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author dungp
 */
public interface ITaiKhoanRepository {

    TaiKhoan getOne(String taiKhoan, String matKhau);

    List<TaiKhoan> getAll();

    boolean add(TaiKhoan taiKhoan);

    boolean update(TaiKhoan taiKhoan);

    boolean delete(UUID IDTaiKhoan);

    List<TaiKhoan> timKiem(String tenTaiKhoan);

    TaiKhoan getOne2(String taiKhoan, String matKhau);

    TaiKhoan getOne3(String taiKhoan);
}
