/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.ChucVu;
import domainmodel.TaiKhoan;
import java.util.UUID;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lethi
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLNhanVien {
    
    private UUID id;
    private String ma;
    private String hoTen;
    private Integer gioiTinh;
    private Integer namSinh;
    private String diaChi;
    private String cccd;
    private String email;
    private String sdt;
    private Integer trangThai;
    private byte[] anh;
    private String qr;
    private TaiKhoan taiKhoan;
    private ChucVu chucVu;

    public Object[] toDataRow(){
        return new Object[]{ma, hoTen, gioiTinh == 1 ? "Nam" : "Nữ", namSinh, diaChi, cccd, email, sdt, trangThai == 1 ? "Đang làm việc" : "Đã nghỉ việc"};
    }

    @Override
    public String toString() {
        return "QLNhanVien{" + "id=" + id + ", ma=" + ma + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", namSinh=" + namSinh + ", diaChi=" + diaChi + ", cccd=" + cccd + ", email=" + email + ", sdt=" + sdt + ", trangThai=" + trangThai + ", anh=" + anh + ", qr=" + qr + '}';
    }
    
}
