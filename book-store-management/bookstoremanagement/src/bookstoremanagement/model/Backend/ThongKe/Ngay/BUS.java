/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.ThongKe.Ngay;

import java.util.ArrayList;

/**
 *
 * @author songnguyen
 */
public class BUS {
    ArrayList<Declare> ds = new ArrayList<>();
    private DAO dsDAO = new DAO();
    public BUS(){
        ds = dsDAO.Thongkengay();
    }
    public ArrayList<Declare> getDS() {
        return this.ds;
    }
}
