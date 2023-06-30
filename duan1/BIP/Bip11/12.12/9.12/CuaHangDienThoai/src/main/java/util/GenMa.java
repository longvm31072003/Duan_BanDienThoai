/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import domainmodel.GenDB;
import java.math.BigDecimal;
import javax.persistence.Query;
import javax.swing.JTextField;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sktfk
 */
public class GenMa {

    public static Long getMa() {
        Session session = HibernatUtil.getFACTORY().openSession();
        Query q = session.createQuery("select COUNT(k.id) FROM KhachHang k",
                 Long.class);
        Long getSum = (Long) q.getSingleResult();
        return getSum;
    }
    public static Long getMaKM() {
        Session session = HibernatUtil.getFACTORY().openSession();
        Query q = session.createQuery("select COUNT(k.id) FROM KhuyenMai k",
                 Long.class);
        Long getSum = (Long) q.getSingleResult();
        return getSum;
    }
    public static String getValues(JTextField txtField){
        return txtField.getText().trim();
    }
    public static void main(String[] args) {
        System.out.println(getMaKM());
    }
}
