/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.ThongKe.ThangNam;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;

/**
 *
 * @author songnguyen
 */
public class DAOThangNam {
    ConnectionDB connection;
    public DAOThangNam(){
        
    }
    public ArrayList ThongkeThangNam(){
        connection = new ConnectionDB();
        ArrayList<Declare> ds = new ArrayList<>();
        try {
            String qry = "SELECT EXTRACT(MONTH FROM ngayLap) AS thang, YEAR(ngayLap) AS nam, SUM(tongTien) AS tongTienBan FROM hoadonban GROUP BY EXTRACT(MONTH FROM ngayLap), YEAR(ngayLap) ORDER BY nam ASC, thang ASC;";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    Declare d = new Declare();
                    
                    d.setThang(rs.getInt(1));
                    d.setNam(rs.getInt(2));
                    d.setTongTien(rs.getFloat(3));
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
