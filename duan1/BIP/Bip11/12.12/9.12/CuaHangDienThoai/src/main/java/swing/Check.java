/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import java.awt.Frame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author sktfk
 */
public class Check extends Frame{
    public static void main(String[] args) {
        JMenuBar menuBar = new JMenuBar();
    JMenuItem saveItem, saveAllItem;

    // Menu
    JMenu fileMenu = new JMenu("File");

    // Menu Item (Drop down menus)
    saveItem = new JMenuItem("Save");
    saveAllItem = new JMenuItem("Save All");

    // Adding menu items to menu
    fileMenu.add(saveItem);
    fileMenu.add(saveAllItem);

    // adding menu to menu bar
    menuBar.add(fileMenu);

    // setting menubar at top of the window.

    // if you create a object of JFrame in class then code to set JMenuBar to JFrame will be:
    // jframe.setJMenuBar(menuBar);
    // if class is extending JFrame then it will be like this:
    setJMenuBar(menuBar);
    }

    private static void setJMenuBar(JMenuBar menuBar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
