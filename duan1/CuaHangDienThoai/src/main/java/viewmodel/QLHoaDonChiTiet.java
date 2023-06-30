/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.HoaDon;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLHoaDonChiTiet {

    private UUID IdHDCT;
    private QLHoaDon IdHD;
    private QLPhuKien IdPK;
    private ChiTietKhuyenMaiViewModel IdCTKM;
    private QLDienThoai IdDienThoai;
    private int soluong;
    private BigDecimal donGia;


   public BigDecimal getTongTien(int soLuong){
        BigDecimal convertSoLuong = new BigDecimal(soLuong);
        BigDecimal tongTien = donGia.multiply(convertSoLuong);
        return tongTien;
    }
   
}
