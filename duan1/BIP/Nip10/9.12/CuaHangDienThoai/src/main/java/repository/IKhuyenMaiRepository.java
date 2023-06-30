/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.KhuyenMai;
import java.util.List;
import java.util.UUID;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author hoant
 */
public interface IKhuyenMaiRepository {

    List<KhuyenMaiViewModel> getAll() ;

    List<KhuyenMai> themKM();

    Boolean add(KhuyenMai km);

    Boolean update(KhuyenMai km, UUID id);

    Boolean delete(UUID id);
}
