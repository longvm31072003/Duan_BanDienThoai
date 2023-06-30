/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

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
public class QLImei {

    private UUID id;
    private String ma;
    private int trangThai;
    private UUID idDienThoai;
    private UUID idPhuKien;
    private UUID idNhaCungCap;
    private UUID idDienThoaiNCC;
    private UUID idPhuKienNCC;

    public QLImei(UUID id, String ma, int trangThai, UUID idDienThoaiNCC, UUID idPhuKienNCC) {
        this.id = id;
        this.ma = ma;
        this.trangThai = trangThai;
        this.idDienThoaiNCC = idDienThoaiNCC;
        this.idPhuKienNCC = idPhuKienNCC;
    }

    public QLImei(UUID id, String ma, int trangThai, UUID idDienThoai, UUID idNhaCungCap, UUID idDienThoaiNCC) {
        this.id = id;
        this.ma = ma;
        this.trangThai = trangThai;
        this.idDienThoai = idDienThoai;
        this.idNhaCungCap = idNhaCungCap;
        this.idDienThoaiNCC = idDienThoaiNCC;
    }
    
    
}
