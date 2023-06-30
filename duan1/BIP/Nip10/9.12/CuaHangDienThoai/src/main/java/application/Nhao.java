/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import support.ViewKhachHang;
import swing.Home;

/**
 *
 * @author hoant
 */
public class Nhao {

    public static void main(String[] args) {
//        new Home().setVisible(true);
//        new ViewKhachHang().setVisible(true);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String s = formatter.format(new Date());
        System.out.println(s);
    }
}
