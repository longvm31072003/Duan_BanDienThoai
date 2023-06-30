/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 *
 * @author Admin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ChiTietSP") //ChiTietSP
public class ChiTietSanPham implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID idCTSP;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSanPham dongSanPham;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa" , nullable = true)
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;
    
    @OneToMany(mappedBy = "chiTietSanPham", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHoaDonChiTiet;

    

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "idCTSP=" + idCTSP + ", sanPham=" + sanPham + ", nhaSanXuat=" + nhaSanXuat + ", mauSac=" + mauSac + ", dongSanPham=" + dongSanPham + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

}
