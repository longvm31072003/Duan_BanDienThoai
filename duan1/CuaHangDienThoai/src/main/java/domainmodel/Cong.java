/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Cong {
  @ManyToOne
  @JoinColumn(name = "IDCong")
  private Ca idCong;
  
  @ManyToOne
  @JoinColumn(name = "IDNhanVien")
  private NhanVien idNhanVien;
  
  @Column(name = "TrangThai")
  private int trangThai;
  
  @Column(name = "TangCa")
  private int tangCa;
  
  @Column(name = "GioTre")
  private  int gioTre;
    
  
}
