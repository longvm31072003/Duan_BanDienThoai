/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author DELL
 */
public class RandomCode {

    static int min = 100001, max = 999999;

    public static void main(String[] args) {
        int code = getCode();
        System.out.println(code);
    }

    public static int getCode() {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
