/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
import org.hibernate.annotations.Type;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "NSX")
public class NhaSanXuat implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    
    @Column(name = "Ma", unique = true)
    private String maNSX;
    
    @Column(name = "Ten")
    private String tenNSX;
    
    @OneToMany(mappedBy = "nhaSanXuat", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> listCTSP;

    public NhaSanXuat(String maNSX, String tenNSX) {
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
    }

    public NhaSanXuat() {
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    @Override
    public String toString() {
        return "NhaSanXuat{" + "id=" + id + ", maNSX=" + maNSX + ", tenNSX=" + tenNSX + '}';
    }
  
}
