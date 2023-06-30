/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lethi
 */
@Table(name = "MauSac")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class MauSac implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdMauSac")
    private UUID idMauSac;
    
    @Column(name = "Ma", unique = true)
    private String ma;
    
    @Column(name = "Ten",  columnDefinition = "nvarchar(Max)")
    private String ten;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @OneToMany(mappedBy = "mauSac", fetch = FetchType.LAZY)
    private List<DienThoai> ldienThoai;
}
