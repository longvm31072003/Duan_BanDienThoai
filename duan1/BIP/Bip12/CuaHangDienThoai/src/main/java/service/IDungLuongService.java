/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.DungLuong;
import java.util.List;
import viewmodel.QLDungLuong;

/**
 *
 * @author ongbi
 */
public interface IDungLuongService {

    List<QLDungLuong> getAll();

    String save(QLDungLuong qldungLuong);

    String update(QLDungLuong qldungLuong);

    DungLuong getOne(String ten);

}
