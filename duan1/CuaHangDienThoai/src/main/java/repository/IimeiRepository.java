/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.Imei;
import java.util.List;
import java.util.UUID;
import viewmodel.QLImei;

/**
 *
 * @author ongbi
 */
public interface IimeiRepository {

    List<QLImei> getAllDT(UUID id);

    List<QLImei> getAllPK(UUID id);

    boolean saveOrupdate(Imei imei);

    boolean xoa(Imei imei);

    Imei getOne(String ma);
     
    int genMaImei();
}
