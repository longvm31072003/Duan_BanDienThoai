/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;


import java.util.List;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "HoaDonChiTiet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdHDCT")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdDienThoai")
    private DienThoai dienThoai;

    @ManyToOne
    @JoinColumn(name = "IdHD")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "IdPK")
    private PhuKien phuKien;

    @OneToOne
    @JoinColumn(name = "IdCTKM")
    private ChiTietKhuyenMai ctkm;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;



    @Override
    public String toString() {
        return dienThoai==null?phuKien.getTen():dienThoai.getTenDienThoai();
    }
    public BigDecimal getGia() {
        return donGia.multiply(BigDecimal.valueOf(soLuong));
    }
}
