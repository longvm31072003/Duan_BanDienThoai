/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class ViewModelHoaDon implements Serializable {

    private UUID id;
    private NhanVien nhanVien;
    private String ma;
    private Date ngayTao;
    private int tinhTrang;

    public ViewModelHoaDon(NhanVien nhanVien, String ma, Date ngayTao, int tinhTrang) {
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public ViewModelHoaDon(UUID id, NhanVien nhanVien, String ma, Date ngayTao, int tinhTrang) {
        this.id = id;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public ViewModelHoaDon() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
