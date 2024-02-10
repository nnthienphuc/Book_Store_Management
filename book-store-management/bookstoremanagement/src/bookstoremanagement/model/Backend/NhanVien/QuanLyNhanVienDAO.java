package bookstoremanagement.model.Backend.NhanVien;

import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class QuanLyNhanVienDAO {

    ConnectionDB qlnvConnection;

    public QuanLyNhanVienDAO() {

    }

    public ArrayList<QuanLyNhanVien> readDB() {
        ArrayList<QuanLyNhanVien> dsnv = new ArrayList<>();
        qlnvConnection = new ConnectionDB();
        try {
            String qry = "SELECT * FROM NhanVien";
            ResultSet r = qlnvConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String manv = r.getString(1);
                    String tennv = r.getString(2);
                    LocalDate ngaysinh = r.getDate(3).toLocalDate();
                    String diachi = r.getString(4);
                    String sdt = r.getString(5);
                    int trangthai = r.getInt(6);
                    dsnv.add(new QuanLyNhanVien(manv, tennv, ngaysinh, diachi, sdt, trangthai));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng nhân viên");
        } finally {
            qlnvConnection.closeConnect();
        }
        return dsnv;
    }

    public ArrayList<QuanLyNhanVien> search(String columnName, String value) {
        qlnvConnection = new ConnectionDB();
        ArrayList<QuanLyNhanVien> dsnv = new ArrayList<>();

        try {
            String qry = "SELECT * FROM NhanVien WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet r = qlnvConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String manv = r.getString(1);
                    String tennv = r.getString(1);
                    LocalDate ngaysinh = r.getDate(3).toLocalDate();
                    String diachi = r.getString(4);
                    String sdt = r.getString(5);
                    int trangthai = r.getInt(6);
                    dsnv.add(new QuanLyNhanVien(manv, tennv, ngaysinh, diachi, sdt, trangthai));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng nhân viên");
        } finally {
            qlnvConnection.closeConnect();
        }

        return dsnv;
    }

    public Boolean add(QuanLyNhanVien nv) {
        qlnvConnection = new ConnectionDB();
        Boolean ok = qlnvConnection.sqlUpdate("INSERT INTO `NhanVien` (`maNV`, `tenNV`, `ngaySinh`, `diaChi`, `SDT`, `trangThai`) VALUES ('"
                + nv.getMaNV() + "', '"
                + nv.getTenNV() + "', '" 
                + nv.getNgaySinh() + "', '" 
                + nv.getDiaChi() + "', '"
                + nv.getSDT() + "', '"
                + nv.getTrangThai() +"');");
        qlnvConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String manv) {
        qlnvConnection = new ConnectionDB();
        Boolean ok = qlnvConnection.sqlUpdate("DELETE FROM `NhanVien` WHERE `NhanVien`.`maNV` = '" + manv + "'");
        qlnvConnection.closeConnect();
        return ok;
    }

    public Boolean update(String MaNV, String TenNV, LocalDate NgaySinh, String DiaChi, String SDT, int TrangThai) {
        qlnvConnection = new ConnectionDB();
        Boolean ok = qlnvConnection.sqlUpdate("Update NhanVien Set "
                + "tenNV='" + TenNV
                + "',ngaySinh='" + NgaySinh 
                + "',diaChi='" + DiaChi 
                + "',SDT='" + SDT               
                + "',trangThai='" + TrangThai 
                + "' where maNV='" + MaNV + "'");
        qlnvConnection.closeConnect();
        return ok;
    }
    
    

    public void close() {
        qlnvConnection.closeConnect();
    }
}
