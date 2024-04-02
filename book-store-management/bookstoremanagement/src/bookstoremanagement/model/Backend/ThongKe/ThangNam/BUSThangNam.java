/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.ThongKe.ThangNam;

import java.util.ArrayList;

/**
 *
 * @author songnguyen
 */
public class BUSThangNam {
    ArrayList<Declare> ds = new ArrayList<>();
    private DAOThangNam dsDAO = new DAOThangNam();
    public BUSThangNam(){
        ds = dsDAO.ThongkeThangNam();
    }
    public ArrayList<Declare> getDS() {
        return this.ds;
    }
}
