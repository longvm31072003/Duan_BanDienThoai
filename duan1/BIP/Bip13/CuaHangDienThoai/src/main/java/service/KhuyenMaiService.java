/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.KhuyenMai;
import java.util.List;
import java.util.UUID;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author hoant
 */
public interface KhuyenMaiService {

    List<KhuyenMaiViewModel> getAll();

    String add(KhuyenMaiViewModel x);

    String update(KhuyenMaiViewModel x, UUID id);

    String delete(UUID id);
}
