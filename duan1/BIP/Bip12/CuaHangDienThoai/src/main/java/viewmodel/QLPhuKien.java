/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.Hang;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLPhuKien {
    
    private UUID id;
    private String ma;
    private String ten;
    private int soLuong;
    private BigDecimal giaBan;
    private byte[] anh;
    private int thoiGianBaoHanh;
    private String moTa;
    private int trangThai;
    private Hang hang;
    
    public Object[] toDataRow(){
        return new Object[]{ten, soLuong, giaBan, thoiGianBaoHanh, moTa, trangThai == 1 ? "Đang bán" : "Ngừng bán"};
    }

    public QLPhuKien(UUID id, String ma) {
        this.id = id;
        this.ma = ma;
    }

    @Override
    public String toString() {
        return "QLPhuKien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", anh=" + anh + ", thoiGianBaoHanh=" + thoiGianBaoHanh + ", moTa=" + moTa + ", trangThai=" + trangThai + ", hang=" + hang + '}';
    }

}
