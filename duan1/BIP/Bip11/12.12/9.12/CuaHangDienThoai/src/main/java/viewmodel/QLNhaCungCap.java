/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLNhaCungCap {

    private UUID id;
    private String ma;
    private String diaChi;
    private String ten;
    private String sdt;
    private String email;
    private int trangThai;

    public String convertTrangThai(int number) {
        if (number == 0) {
            return "Dang Hoat Dong";
        } else {
            return "Khong Hoat Dong";
        }
    }

}
