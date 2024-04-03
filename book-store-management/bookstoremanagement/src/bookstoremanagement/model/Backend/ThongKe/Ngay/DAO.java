/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.ThongKe.Ngay;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;

/**
 *
 * @author songnguyen
 */
public class DAO {
    ConnectionDB connection;
    public DAO(){
        
    }
    public ArrayList Thongkengayban(){
        connection = new ConnectionDB();
        ArrayList<Declare> ds = new ArrayList<>();
        try {
            String qry = "SELECT ngayLap, SUM(tongTien) AS tongTienBan FROM hoadonban GROUP BY ngayLap ORDER BY ngayLap ASC;";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    Declare d = new Declare();
                    
                    d.setNgayLap(rs.getDate(1).toLocalDate());
                   
                    d.setTongTien(rs.getFloat(2));
                    ds.add(d);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối tới Thống kê");
        } finally {
            connection.closeConnect();
        }
        return ds;
    }
    public ArrayList Thongkengaynhap(){
        connection = new ConnectionDB();
        ArrayList<Declare> ds = new ArrayList<>();
        try {
            String qry = "SELECT ngayLap, SUM(tongTien) AS tongTienNhap FROM hoadonnhap GROUP BY ngayLap ORDER BY ngayLap ASC;";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    Declare d = new Declare();
                    
                    d.setNgayLap(rs.getDate(1).toLocalDate());
                   
                    d.setTongTien(rs.getFloat(2));
                    ds.add(d);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối tới Thống kê");
        } finally {
            connection.closeConnect();
        }
        return ds;
    }
}
