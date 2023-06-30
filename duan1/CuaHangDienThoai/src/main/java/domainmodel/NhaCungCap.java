/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author Admin
 */

import java.io.Serializable;
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
import org.hibernate.annotations.Type;


@Table(name = "NhaCungCap")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class NhaCungCap implements Serializable {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "IdNCC")
    private UUID id;

    @Column(name = "MaNCC", unique = true)
    private String ma;

    @Column(name = "DiaChi", columnDefinition = "nvarchar(Max)")
    private String diaChi;

    @Column(name = "TenNhaCC", columnDefinition = "nvarchar(Max)")
    private String ten;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "Email")
    private String email;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private List<DienThoaiNCC> listDienThoaiNCC;
    
    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private List<PhuKienNCC> listPhuKienNCC;
       public NhaCungCap(UUID id, String ma) {
        this.id = id;
        this.ma = ma;
       
    }


}
