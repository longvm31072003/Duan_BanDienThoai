/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import domainmodel.PhuKien;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PhuKienNCC")
public class PhuKienNCC implements Serializable {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "IdPKNCC", columnDefinition = "varchar(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdNCC")
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name = "IdPK")
    private PhuKien phuKien;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "SoLuongNhap")
    private int soLuongNhap;

    @Column(name = "ngayNhap")
    private Date ngayNhap;
    
    @Column(name = "TrangThai")
    private int trangThai;

}
