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
    ArrayList<Declare> dsb = new ArrayList<>();
    ArrayList<Declare> dsn = new ArrayList<>();
    private DAO dsDAO = new DAO();
    public BUS(){
        dsb = dsDAO.Thongkengayban();
        dsn = dsDAO.Thongkengaynhap();
    }
    public ArrayList<Declare> getDSB() {
        return this.dsb;
    }
    public ArrayList<Declare> getDSN() {
        return this.dsn;
    }
}
