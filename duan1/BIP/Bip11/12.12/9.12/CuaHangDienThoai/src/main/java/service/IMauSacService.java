/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.MauSac;
import java.util.List;
import viewmodel.QLMauSac;

/**
 *
 * @author lethi
 */
public interface IMauSacService {

    List<QLMauSac> getAll();

    String save(QLMauSac qlMauSac);

    String update(QLMauSac qLMauSac);

    MauSac getOne(String ten);

}
