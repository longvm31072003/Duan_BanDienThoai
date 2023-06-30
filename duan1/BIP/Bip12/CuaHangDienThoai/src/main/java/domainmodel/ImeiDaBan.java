
package domainmodel;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ImeiDaBan")
public class ImeiDaBan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdImei")
    private UUID id;
    
    @Column(name = "MaImei")
    private String ma;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @ManyToOne
    @JoinColumn(name = "IdHDCT")
    private HoaDonChiTiet hdct;

    @Override
    public String toString() {
        return ma;
    }
    
}