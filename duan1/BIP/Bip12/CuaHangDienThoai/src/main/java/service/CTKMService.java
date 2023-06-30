/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.ChiTietKhuyenMai;
import java.util.List;
import viewmodel.ChiTietKMCustom;

/**
 *
 * @author hoant
 */
public interface CTKMService {

    List<ChiTietKMCustom> getAll();
}
