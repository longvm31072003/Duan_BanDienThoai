/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;


import domainmodel.Hang;
import java.util.List;
import viewmodel.QLHang;

/**
 *
 * @author Admin
 */
public interface IHangService {
    
    List<QLHang> getHHD();
    
    List<QLHang> getHNHD();
    
    List<QLHang> timKiem(String chuoi, int number);
    
    String save(QLHang hang);
    
    String update(QLHang hang);
    
    String delete(QLHang hang);
    
    Hang getOne(String ten);
    
}
