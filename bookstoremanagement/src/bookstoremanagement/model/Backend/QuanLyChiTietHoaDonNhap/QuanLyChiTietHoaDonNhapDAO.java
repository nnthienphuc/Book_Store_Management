
package bookstoremanagement.model.Backend.QuanLyChiTietHoaDonNhap;

import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class QuanLyChiTietHoaDonNhapDAO {
    
    ConnectionDB qlcthdnConnection;
    
    public ArrayList<ChiTietHoaDonNhap> readDB() {
        ArrayList<ChiTietHoaDonNhap> dscthdn = new ArrayList<>();
        qlcthdnConnection = new ConnectionDB();
        try {

            String query = "SELECT * FROM ChiTietHoaDonNhap";
            ResultSet r = qlcthdnConnection.sqlQuery(query);
            if (r != null) {
                while (r.next()) {
                    ChiTietHoaDonNhap cthdn = new ChiTietHoaDonNhap(r.getString(1), r.getString(2), r.getInt(3));
                    dscthdn.add(cthdn);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thấy data cần tìm trong ResultSet");

        } finally {
            qlcthdnConnection.closeConnect();
        }
        return dscthdn;

    }
    
    public ArrayList<ChiTietHoaDonNhap> search(String columName, String value) {
        ArrayList<ChiTietHoaDonNhap> dscthdn = new ArrayList<>();
        qlcthdnConnection = new ConnectionDB();
        try {

            String query = "SELECT * FROM ChiTietHoaDonNhap WHERE" + columName + "LIKE '%" + value + "%'";
            ResultSet r = qlcthdnConnection.sqlQuery(query);
            if (r != null) {
                while (r.next()) {
                    ChiTietHoaDonNhap cthdn = new ChiTietHoaDonNhap(r.getString(1), r.getString(2), r.getInt(3));
                    dscthdn.add(cthdn);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thấy data cần tìm trong ResultSet");

        } finally {
            qlcthdnConnection.closeConnect();
        }
        return dscthdn;

    }
    
    public boolean add(ChiTietHoaDonNhap cthdn) {
        qlcthdnConnection = new ConnectionDB();
        Boolean ok = qlcthdnConnection.sqlUpdate("INSERT INTO `ChiTietHoaDonNhap`(`maHDN`,`maSach`,`soLuong`) VALUE('"
                + cthdn.getMaHDN() + "', '" + cthdn.getMaSach() + "','" + cthdn.getSoLuong()  + "')");
        qlcthdnConnection.closeConnect();
        return ok;
    }
    
    public Boolean deleteAll(String _mahdn) {
        qlcthdnConnection = new ConnectionDB();
        Boolean success = qlcthdnConnection.sqlUpdate("DELETE FROM ChiTietHoaDonNhap WHERE maHDN='" + _mahdn + "';");
        qlcthdnConnection.closeConnect();
        return success;
    }
    
    public Boolean delete(String _mahdn, String _masach) {
        qlcthdnConnection = new ConnectionDB();
        Boolean success = qlcthdnConnection.sqlUpdate("DELETE FROM ChiTietHoaDonNhap WHERE maHDN='" + _mahdn + "' AND maSach='" + _masach + "';");
        qlcthdnConnection.closeConnect();
        return success;
    }
    
    public boolean update(String _mahdn, String _masach, int _soluong, float _dongia) {
        qlcthdnConnection = new ConnectionDB();
        Boolean ok = qlcthdnConnection.sqlUpdate("UPDATE `ChiTietHoaDonNhap` SET "
                + "soLuong='" + _soluong
                + "' WHERE maHDN='" + _mahdn + "' AND maSach='" + _masach + "';");
        qlcthdnConnection.closeConnect();
        return ok;
    }

    
}
