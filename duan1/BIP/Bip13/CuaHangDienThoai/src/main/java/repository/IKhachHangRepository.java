/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.KhachHang;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import viewmodel.KhachHangViewMD;

/**
 *
 * @author hoant
 */
public interface IKhachHangRepository {

    List<KhachHangViewMD> getAll();

    List<KhachHang> search(String CCCD);

    Boolean add(KhachHang kh);

    Boolean update(KhachHang kh, UUID id);

    Boolean delete(UUID id);
}
