/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookstoremanagement;

import bookstoremanagement.frames.LoginForm;
/**
 *
 * @author ADMIN
 */
public class Bookstoremanagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.setProperty("sun.java2d.uiScale", "1.0");
       new LoginForm().setVisible(true);
    }
    
}
