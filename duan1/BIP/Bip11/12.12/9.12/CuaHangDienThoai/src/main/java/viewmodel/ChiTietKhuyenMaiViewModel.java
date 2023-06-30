/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Admin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChiTietKhuyenMaiViewModel {
      private UUID IdCTKM;
        private KhuyenMaiViewModel  IdKM;
        private QLPhuKien IdPK ;
        private QLDienThoai  IdDienThoai;
                private BigDecimal SoTienGiam;

    public ChiTietKhuyenMaiViewModel(UUID IdCTKM) {
        this.IdCTKM = IdCTKM;
    }

  
   
}
