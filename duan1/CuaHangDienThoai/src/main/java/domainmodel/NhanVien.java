/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lethi
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDNhanVien")
    private UUID id;
    @Column(name = "MaNhanVien")
    private String ma;
    @Column(name = "HoTen")
    private String hoTen;
    @Column(name = "GioiTinh")
    private Integer gioiTinh;
    @Column(name = "NamSinh")
    private Integer namSinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "CCCD")
    private String cccd;
    @Column(name = "Email")
    private String email;
    @Column(name = "SoDienThoai")
    private String sdt;
    @Column(name = "TrangThai")
    private Integer trangThai;
    @Column(name = "Anh")
    private byte[] anh;
    @Column(name = "QR")
    private String qr;

//    public NhanVien(String ma, String hoTen, Integer gioiTinh, Integer namSinh, String diaChi, String cccd, String email, String sdt, Integer trangThai) {
//        this.ma = ma;
//        this.hoTen = hoTen;
//        this.gioiTinh = gioiTinh;
//        this.namSinh = namSinh;
//        this.diaChi = diaChi;
//        this.cccd = cccd;
//        this.email = email;
//        this.sdt = sdt;
//        this.trangThai = trangThai;
//    }
   @OneToOne
    @JoinColumn(name = "IDTaiKhoan")
    private TaiKhoan taiKhoan;
    @ManyToOne
    @JoinColumn(name = "IDChucVu")
    private ChucVu chucVu;
    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", ma=" + ma + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", namSinh=" + namSinh + ", diaChi=" + diaChi + ", cccd=" + cccd + ", email=" + email + ", sdt=" + sdt + ", trangThai=" + trangThai + ", anh=" + anh + ", qr=" + qr + '}';
    }

}
