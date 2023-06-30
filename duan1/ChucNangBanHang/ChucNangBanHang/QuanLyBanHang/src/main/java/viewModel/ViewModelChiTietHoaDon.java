/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import model.ChiTietSanPham;
import model.HoaDon;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class ViewModelChiTietHoaDon implements Serializable {

    private HoaDon hoaDon;
    private ChiTietSanPham chiTietSanPham;
    private int soLuong;
    private BigDecimal donGia;

    public ViewModelChiTietHoaDon() {
    }

    public ViewModelChiTietHoaDon(HoaDon hoaDon, ChiTietSanPham chiTietSanPham, int soLuong, BigDecimal donGia) {
        this.hoaDon = hoaDon;
        this.chiTietSanPham = chiTietSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal thanhTien(int soLuong, BigDecimal donGia) {
        BigDecimal tong = donGia.multiply(BigDecimal.valueOf(soLuong));
        return tong;
    }

}
