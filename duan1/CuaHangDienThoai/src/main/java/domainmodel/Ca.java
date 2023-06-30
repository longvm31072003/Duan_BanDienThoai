/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity

public class Ca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCong")
    private UUID id;
    
    @Column(name = "BatDauLam")
    private Date batDauLam;
    
     @Column(name = "KetThucLam")
    private Date ketThucLam;
    
     @OneToMany(mappedBy = "Ca" , fetch = FetchType.LAZY)
     private List<Cong> congs;
     
}
