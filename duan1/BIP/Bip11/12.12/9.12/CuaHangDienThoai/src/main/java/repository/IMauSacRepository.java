/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.MauSac;
import java.util.List;
import viewmodel.QLMauSac;

/**
 *
 * @author lethi
 */
public interface IMauSacRepository {

    List<QLMauSac> getAll();

    boolean saveOrupdate(MauSac mauSac);
    
    MauSac getOne(String ten);
    
}
