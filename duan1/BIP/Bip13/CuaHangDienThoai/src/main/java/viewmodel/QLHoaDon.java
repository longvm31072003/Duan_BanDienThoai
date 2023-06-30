/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.KhachHang;
import domainmodel.NhanVien;
import java.time.LocalDateTime;
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
public class QLHoaDon {

    private UUID idHD;
    private String MaHD;
    private LocalDateTime ngayTao;
    private LocalDateTime NgayThanhToan;
    private Integer DiemTichLuy;
    private Integer trangThai;
    private KhachHang makhachHang;
    private NhanVien manhanVien;

    public Object getTrangThaiStr() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public QLHoaDon(UUID idHD, String MaHD, LocalDateTime ngayTao) {
        this.idHD = idHD;
        this.MaHD = MaHD;
        this.ngayTao = ngayTao;
    }
    
}
