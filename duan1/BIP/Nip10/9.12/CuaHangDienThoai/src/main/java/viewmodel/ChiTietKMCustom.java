/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hoant
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChiTietKMCustom {

    private UUID id;
    private String maKM;
    private String tenKM;
    private BigDecimal mucKhuyenMai;
    private int hinhThucKhuyenMai;
    private Date ngayBatDau;
    private Date ngayKT;
    private Integer trangThai;
    private String moTa;
    private String sanPham;

    public Object[] toDataRow() {

//        Date today = new Date(System.currentTimeMillis()); 
        int stt = 1;
        return new Object[]{maKM, tenKM, hinhThucKhuyenMai, mucKhuyenMai, ngayBatDau, ngayKT, trangThai == 1 ? "Đang hoạt động" : "Hết hiệu lực", moTa};
    }
//ctkm.id,ctkm.khuyenMai.maKM, ctkm.khuyenMai.tenKM,ctkm.khuyenMai.ngayBatDau,ctkm.khuyenMai.ngayKT,ctkm.khuyenMai.hinhThucKhuyenMai,dt.maDienThoai)
  

    
}
