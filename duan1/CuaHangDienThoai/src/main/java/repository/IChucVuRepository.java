/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.ChucVu;
import java.util.List;
import viewmodel.QlChucVu;


/**
 *
 * @author ongbi
 */
public interface IChucVuRepository {
    List<QlChucVu> getAll();

    
    boolean SaveOrUpdate(ChucVu cv);
      
    boolean khoiPhuc(ChucVu cv);
    
    boolean delete(ChucVu cv);

    
    ChucVu getOne(String ten);
}
