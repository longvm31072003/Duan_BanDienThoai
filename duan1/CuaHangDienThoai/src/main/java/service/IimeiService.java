/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import java.util.UUID;
import viewmodel.QLImei;

/**
 *
 * @author ongbi
 */
public interface IimeiService {

    List<QLImei> getAllDT(UUID id);

    List<QLImei> getAllPK(UUID id);

    String save(QLImei imei);

    String Xoa(QLImei imei);

    QLImei getOne(String ma);
    
    String genMaImei();
}
