/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.PhuKien;
import java.util.List;
import java.util.UUID;
import viewmodel.QLPhuKien;

/**
 *
 * @author Admin
 */
public interface IPhuKienRepository {
    PhuKien getOne(String ma);
    List<QLPhuKien> getAll();
    boolean add(PhuKien phuKien);
    boolean update(PhuKien phuKien, UUID id);
    boolean delete(UUID id);
    List<PhuKien> getAll1();
    List<QLPhuKien> search(String ten);
    List<QLPhuKien> getPKDB();
    List<QLPhuKien> getPKNB();
}
