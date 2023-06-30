/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import model.DongSanPham;
import model.MauSac;
import model.NhaSanXuat;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class ViewModelSanPham implements Serializable {

    private UUID idCTSP;
    private SanPham sanPham;
    private NhaSanXuat nhaSanXuat;
    private MauSac mauSac;
    private DongSanPham dongSanPham;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public ViewModelSanPham() {
    }

    public ViewModelSanPham(SanPham sanPham, NhaSanXuat nhaSanXuat, MauSac mauSac, DongSanPham dongSanPham, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.sanPham = sanPham;
        this.nhaSanXuat = nhaSanXuat;
        this.mauSac = mauSac;
        this.dongSanPham = dongSanPham;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ViewModelSanPham(UUID idCTSP, SanPham sanPham, NhaSanXuat nhaSanXuat, MauSac mauSac, DongSanPham dongSanPham, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.idCTSP = idCTSP;
        this.sanPham = sanPham;
        this.nhaSanXuat = nhaSanXuat;
        this.mauSac = mauSac;
        this.dongSanPham = dongSanPham;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public UUID getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(UUID idCTSP) {
        this.idCTSP = idCTSP;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NhaSanXuat getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSanPham getDongSanPham() {
        return dongSanPham;
    }

    public void setDongSanPham(DongSanPham dongSanPham) {
        this.dongSanPham = dongSanPham;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    @Override
    public String toString() {
        return "ViewModelSanPham{" + "idCTSP=" + idCTSP + ", sanPham=" + sanPham + ", nhaSanXuat=" + nhaSanXuat + ", mauSac=" + mauSac + ", dongSanPham=" + dongSanPham + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

}
