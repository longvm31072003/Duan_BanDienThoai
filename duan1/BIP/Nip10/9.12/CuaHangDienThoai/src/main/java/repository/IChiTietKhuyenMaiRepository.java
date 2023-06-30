/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.ChiTietKhuyenMai;
import java.util.List;
import viewmodel.ChiTietKMCustom;

/**
 *
 * @author hoant
 */
public interface IChiTietKhuyenMaiRepository {

    List<ChiTietKMCustom> getAll();
}
