/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Ram;
import java.util.List;
import viewmodel.QLRam;

/**
 *
 * @author lethi
 */
public interface IRamService {

    List<QLRam> getAll();

    String save(QLRam qlRam);

    String update(QLRam qlRam);

    Ram getOne(String ten);

}
