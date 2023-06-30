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

/**
 *
 * @author ongbi
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QlChucVu {
 private UUID id;
 private String Ma;
 private String Ten;
 private BigDecimal Luong;
 private int QuyenSD;
 
 
}
