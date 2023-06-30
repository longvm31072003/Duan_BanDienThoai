/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.HoaDon;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import viewmodel.QLHoaDon;
/**
 *
 * @author Admin
 */
public interface IFHoaDonRespository {
     List<QLHoaDon> getAll();

        List<QLHoaDon> search(String Mahd);
        List<QLHoaDon> searchtheoNgay(LocalDateTime TT ,LocalDateTime HH);
}
