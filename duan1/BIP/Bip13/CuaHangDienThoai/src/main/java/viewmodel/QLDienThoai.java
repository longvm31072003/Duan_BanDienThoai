/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.DungLuong;
import domainmodel.Hang;
import domainmodel.MauSac;
import domainmodel.Ram;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dungp
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLDienThoai {
// Dũng Code

    private UUID idDienThoai;
    private String maDienThoai;
    private String tenDienThoai;
    private Integer soLuongTon;
    private String CPU;
    private String manHinh;

    private String pin;
    private String camera;
    private String heDieuHanh;
    private byte[] anh;
    private BigDecimal giaBan;
    private int thoiGianBaoHanh;
    private String mota;
    private int trangThai;
    private Hang hang;
    private MauSac mauSac;
    private Ram ram;
    private DungLuong dungLuong;

//    public QLDienThoai(String tenDienThoai, int soLuongTon, String RAM, String ROM, String manHinh, String mauSac, BigDecimal giaBan, int thoiGianBaoHanh, int trangThai) {
//        this.tenDienThoai = tenDienThoai;
//        this.soLuongTon= soLuongTon;
//        this.RAM = RAM;
//        this.ROM = ROM;
//        this.manHinh = manHinh;
//        this.mauSac = mauSac;
//        this.giaBan = giaBan;
//        this.thoiGianBaoHanh = thoiGianBaoHanh;
//        this.trangThai = trangThai;
//    }

    public QLDienThoai(UUID idDienThoai, String maDienThoai) {
        this.idDienThoai = idDienThoai;
        this.maDienThoai = maDienThoai;
    }

    public QLDienThoai(UUID idDienThoai, String maDienThoai, String tenDienThoai, Integer soLuongTon, String CPU,  String manHinh, String pin, String camera, String heDieuHanh, byte[] anh, BigDecimal giaBan, int thoiGianBaoHanh, String mota, int trangThai) {
        this.idDienThoai = idDienThoai;
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.soLuongTon = soLuongTon;
        this.CPU = CPU;

 
        this.manHinh = manHinh;
        this.pin = pin;
        this.camera = camera;
        this.heDieuHanh = heDieuHanh;
        this.anh = anh;
        this.giaBan = giaBan;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.mota = mota;
        this.trangThai = trangThai;
    }
    

 
}
