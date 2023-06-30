/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hoant
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "Ma", unique = true)
    private String maKM;
    @Column(name = "Ten", nullable = false)
    private String tenKM;
    @Column(name = "MucKhuyenMai")
    private BigDecimal mucKhuyenMai;
    @Column(name = "HinhThucKhuyenMai")
    private Integer hinhThucKhuyenMai;
    @Column(name = "NgayBatDau", nullable = false)
    private Date ngayBatDau;
    @Column(name = "NgayKetThuc", nullable = false)
    private Date ngayKT;
    @Column(name = "TrangThai", nullable = false)
    private Integer trangThai;
    @Column(name = "moTa")
    private String moTa;
    @OneToMany(mappedBy = "khuyenMai",fetch = FetchType.EAGER)
    private List<ChiTietKhuyenMai> list;
//String maKM, String tenKM, BigDecimal mucKhuyenMai, String hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa

    public KhuyenMai(String maKM, String tenKM, BigDecimal mucKhuyenMai, Integer hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.mucKhuyenMai = mucKhuyenMai;
        this.hinhThucKhuyenMai = hinhThucKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public KhuyenMai(UUID id, String maKM, String tenKM, BigDecimal mucKhuyenMai, Integer hinhThucKhuyenMai, Date ngayBatDau, Date ngayKT, Integer trangThai, String moTa) {
        this.id = id;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.mucKhuyenMai = mucKhuyenMai;
        this.hinhThucKhuyenMai = hinhThucKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }
    @Override
    public String toString() {
        return maKM;
    }

    public String getHT(){
        return hinhThucKhuyenMai==1?"Số tiền":"%";
    }
    public String getTT(){
        return trangThai==1?"Đang hoạt động":"Ngừng giảm giá";
    }
    public String getHD(){
        return ngayKT.before(new Date())?"Ngừng giảm giá":"Đang hoạt động";
    }
}
