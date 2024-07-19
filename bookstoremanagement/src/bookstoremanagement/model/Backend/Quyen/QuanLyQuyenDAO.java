package bookstoremanagement.model.Backend.Quyen;

import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class QuanLyQuyenDAO {
    ConnectionDB qlqConnection;

    public QuanLyQuyenDAO() {

    }

    public ArrayList<QuanLyQuyen> readDB() {
        qlqConnection = new ConnectionDB();
        ArrayList<QuanLyQuyen> dsq = new ArrayList<>();
        try {
            String qry = "SELECT * FROM phanquyen";
            ResultSet r = qlqConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String maq = r.getString("maQuyen");
                    String tenq = r.getString("tenQuyen");
                    String chitietq = r.getString("chiTietQuyen");
                    
                    dsq.add(new QuanLyQuyen(maq, tenq, chitietq));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng phân quyền");
        } finally {
            qlqConnection.closeConnect();
        }
        return dsq;
    }

    public ArrayList<QuanLyQuyen> search(String columnName, String value) {
        qlqConnection = new ConnectionDB();
        ArrayList<QuanLyQuyen> dsq = new ArrayList<>();

        try {
            String qry = "SELECT * FROM phanquyen WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet r = qlqConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String maq = r.getString("maQuyen");
                    String tenq = r.getString("tenQuyen");
                    String chitietq = r.getString("chiTietQuyen");
                    
                    dsq.add(new QuanLyQuyen(maq, tenq, chitietq));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng phân quyền");
        } finally {
            qlqConnection.closeConnect();
        }

        return dsq;
    }

    public Boolean add(QuanLyQuyen q) {
        qlqConnection = new ConnectionDB();
        Boolean ok = qlqConnection.sqlUpdate("INSERT INTO `PhanQuyen` (`maQuyen`, `tenQuyen`, `chiTietQuyen`) VALUES ('"
                + q.getMaQuyen()+ "', '" 
                + q.getTenQuyen()+ "', '" 
                + q.getChiTietQuyen()+ "');");
        qlqConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String maq) {
        qlqConnection = new ConnectionDB();
        Boolean ok = qlqConnection.sqlUpdate("DELETE FROM `PhanQuyen` WHERE `phanquyen`.`maQuyen` = '" + maq + "'");
        qlqConnection.closeConnect();
        return ok;
    }

    public Boolean update(String maq, String tenquyen, String chitietquyen) {
        qlqConnection = new ConnectionDB();
        Boolean ok = qlqConnection.sqlUpdate("Update PhanQuyen Set "
                + "tenQuyen='" + tenquyen 
                + "',chiTietQuyen='" + chitietquyen 
                + "' where maQuyen='" + maq + "';");
        qlqConnection.closeConnect();
        return ok;
    }

    public void close() {
        qlqConnection.closeConnect();
    }
}
