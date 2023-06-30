/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
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
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "HoVaTen", length = 15)
    private String hoTenKH;
    @Column(name = "CCCD", length = 15, nullable = false)
    private String maKH;
    @Column(name = "NgaySinh", nullable = false)
    private Date ngaySinh;
    @Column(name = "Sdt", length = 30)
    private String SDT;
    @Column(name = "Email", length = 30)
    private String email;
    @Column(name = "DiaChi", length = 100, nullable = false)
    private String diaChi;
    @Column(name = "DiemTichLuy", nullable = true)
    private Integer diemTichLuy;
    @Column(name = "GioiTinh")
    private Integer gioiTinh;
    @Column(name = "GhiChu")
    private String ghiChu;
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;

    @Override
    public String toString() {
        return hoTenKH;
    }
}
