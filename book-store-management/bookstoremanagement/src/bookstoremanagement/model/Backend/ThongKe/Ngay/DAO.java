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
    public ArrayList Thongkengay(){
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
            JOptionPane.showMessageDialog(null, "lỗi cc");
        } finally {
            connection.closeConnect();
        }
        return ds;
    }
}
