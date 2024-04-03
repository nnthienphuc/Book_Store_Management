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
    ArrayList<Declare> dsb = new ArrayList<>();
    ArrayList<Declare> dsn = new ArrayList<>();
    private DAOThangNam dsDAO = new DAOThangNam();
    public BUSThangNam(){
        dsb = dsDAO.ThongkeThangNamBan();
        dsn = dsDAO.ThongkeThangNamNhap();
    }
    public ArrayList<Declare> getDSB() {
        return this.dsb;
    }
    public ArrayList<Declare> getDSN() {
        return this.dsn;
    }
}
