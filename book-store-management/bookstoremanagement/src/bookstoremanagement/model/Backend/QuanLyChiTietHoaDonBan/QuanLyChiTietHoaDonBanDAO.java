
package bookstoremanagement.model.Backend.QuanLyChiTietHoaDonBan;

import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class QuanLyChiTietHoaDonBanDAO {
    
    ConnectionDB connection;

    public QuanLyChiTietHoaDonBanDAO() {
    
    }
    
    public ArrayList readDB() {
        connection = new ConnectionDB();
        ArrayList<ChiTietHoaDonBan> dshd = new ArrayList<>();
        try {
            String qry = "SELECT * FROM ChiTietHoaDonBan";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    ChiTietHoaDonBan hd = new ChiTietHoaDonBan(rs.getString(1),rs.getString(2), rs.getInt(3));
                    dshd.add(hd);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu !!");
        } finally {
            connection.closeConnect();
        }
        return dshd;
    }
    
    public Boolean add(ChiTietHoaDonBan hd) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("INSERT INTO ChiTietHoaDonBan(maHDB,maSach,soLuong) VALUES ('" 
                + hd.getMaHDB() + "','" 
                + hd.getMaSach() + "','" 
                + hd.getSoLuong() + "');");
        connection.closeConnect();
        return success;
    }
    
    public Boolean delete(String _mahdb, String _masach) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("DELETE FROM ChiTietHoaDonBan WHERE "
                + "maHDB='" + _mahdb
                + "' AND maSach='" + _masach + "';");
        connection.closeConnect();
        return success;
    }
    
    public Boolean deleteAll(String _mahdb) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("DELETE FROM ChiTietHoaDonBan WHERE maHDB='" + _mahdb + "';");
        connection.closeConnect();
        return success;
    }
    
    public Boolean update(ChiTietHoaDonBan _hdb) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE ChiTietHoaDonBan set "
                + "soLuong='" + _hdb.getSoLuong()
                + "' WHERE maHDB='" + _hdb.getMaHDB() + "' AND maSach='" + _hdb.getMaSach() + "';");
        connection.closeConnect();
        return success;
    }
    

    public void closeConnection() {
        connection.closeConnect();
    }
    
}
