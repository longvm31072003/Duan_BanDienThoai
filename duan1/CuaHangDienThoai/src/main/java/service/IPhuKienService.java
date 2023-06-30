/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.PhuKien;
import java.util.List;
import java.util.UUID;
import viewmodel.QLPhuKien;

/**
 *
 * @author Admin
 */
public interface IPhuKienService {
QLPhuKien getOne(String ma);
    List<QLPhuKien> getAll();
    List<PhuKien> getAll1();
    String add(QLPhuKien qLPhuKien);
    String update(QLPhuKien qLPhuKien, UUID id);
    String delete(UUID id);
    List<QLPhuKien> search(String ten);
    List<QLPhuKien> getPKDB();
    List<QLPhuKien> getPKNB();  
}
