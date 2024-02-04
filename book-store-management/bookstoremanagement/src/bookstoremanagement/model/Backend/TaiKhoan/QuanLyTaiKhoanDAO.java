package bookstoremanagement.model.Backend.TaiKhoan;

import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class QuanLyTaiKhoanDAO {
    ConnectionDB qltkConnectiion;

    public QuanLyTaiKhoanDAO() {

    }

    public ArrayList<TaiKhoan> readDB() {
        qltkConnectiion = new ConnectionDB();
        ArrayList<TaiKhoan> dstk = new ArrayList<>();
        try {
            String qry = "SELECT * FROM TaiKhoan";
            ResultSet r = qltkConnectiion.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String ten = r.getString("tenTaiKhoan");
                    String matkhau = r.getString("matKhau");
                    String manv = r.getString("maNV");
                    String maquyen = r.getString("maQuyen");
                    
                    dstk.add(new TaiKhoan(ten, matkhau, manv, maquyen));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng tài khoản");
        } finally {
            qltkConnectiion.closeConnect();
        }
        return dstk;
    }

    public Boolean add(TaiKhoan tk) {
        qltkConnectiion = new ConnectionDB();
        Boolean ok = qltkConnectiion.sqlUpdate("INSERT INTO `TaiKhoan` (`tenTaiKhoan`, `matKhau`, `maNV`, `maQuyen`) VALUES ('"
                + tk.getTenDangNhap()+ "', '" + tk.getMatKhau() + "', '" + tk.getMaNV() + "', '" + tk.getMaQuyen() + "');");
        qltkConnectiion.closeConnect();
        return ok;
    }

    public Boolean delete(String tendangnhap) {
        qltkConnectiion = new ConnectionDB();
        Boolean ok = qltkConnectiion.sqlUpdate("DELETE FROM `TaiKhoan` WHERE `TaiKhoan`.`tenTaiKhoan` = '" + tendangnhap + "'");
        qltkConnectiion.closeConnect();
        return ok;
    }

    public Boolean update(String tendangnhap, String matkhau, String maNV, String maQuyen) {
        qltkConnectiion = new ConnectionDB();
        Boolean ok = qltkConnectiion.sqlUpdate("Update TaiKhoan Set matKhau='" + matkhau + "',maNV='" + maNV
                + "',maQuyen='" + maQuyen + "' where tenTaiKhoan='" + tendangnhap + "'");
        qltkConnectiion.closeConnect();
        return ok;
    }

    public void close() {
        qltkConnectiion.closeConnect();
    }
}
