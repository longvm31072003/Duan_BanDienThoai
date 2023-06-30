/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.KhachHang;
import java.util.List;
import java.util.UUID;
import viewmodel.KhachHangViewMD;

/**
 *
 * @author hoant
 */
public interface KhachHangService {

    List<KhachHangViewMD> getAll();

    String add(KhachHangViewMD kh);

    String update(KhachHangViewMD kh, UUID id);

    String delete(UUID id);

    List<KhachHangViewMD> search(String CCCD);
}
