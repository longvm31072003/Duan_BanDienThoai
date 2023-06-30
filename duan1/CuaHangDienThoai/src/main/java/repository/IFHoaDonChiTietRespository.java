/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;
import domainmodel.HoaDonChiTiet;
import java.util.List;
//import viewmodel.QLHoaDonChiTiet;
/**
 *
 * @author Admin
 */
public interface IFHoaDonChiTietRespository {
    List<HoaDonChiTiet> getAll();
     List<HoaDonChiTiet> search(String Mahd);
}
