/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.Ram;
import java.util.List;
import viewmodel.QLRam;

/**
 *
 * @author lethi
 */
public interface IRamRepository {
    List<QLRam> getAll();

    boolean saveOrupdate(Ram ram);
    
    Ram getOne(String ten);
    
}
