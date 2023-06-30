/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author hoant
 */
public class XImage {

    public static Image getAppIcon() {
        URL url = XImage.class.getResource("/images/a-12.png");
        return new ImageIcon(url).getImage();
    }
    public static ImageIcon JOp() {
        ImageIcon im=new ImageIcon(XImage.class.getResource("/images/a-12.png"));
        return im;
    }
    
}
