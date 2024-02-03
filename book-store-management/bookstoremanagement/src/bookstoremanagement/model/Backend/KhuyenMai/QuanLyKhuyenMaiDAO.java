/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.KhuyenMai;

import bookstoremanagement.model.BackEnd.ConnectDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nnthienphuc
 */

public class QuanLyKhuyenMaiDAO {
    ConnectionDB qlkmConnection;

    public QuanLyKhuyenMaiDAO() {
    }

    public ArrayList<KhuyenMai> readDB() {
        qlkmConnection = new ConnectionDB();
        ArrayList<KhuyenMai> dskm = new ArrayList<>();
        try {
            String qry = "SELECT * FROM khuyenmai";
            ResultSet resultSet = qlkmConnection.sqlQuery(qry);
            if (resultSet != null) {
                while (r.next()) {
                    String maKM = resultSet.getString("maKM");
                    String tenKM = resultSet.getString("tenKM");
                    float dieuKienKM = resultSet.getFloat("dieuKienKM");
                    float phantramKM = resultSet.getFloat("phanTramKM");
                    LocalDate ngayBD = resultSet.getDate("ngayBD").toLocalDate();
                    LocalDate ngayKT = resultSet.getDate("ngayKT").toLocalDate();
                    dskm.add(new KhuyenMai(maKM, tenKM, dieuKienKM, phantramKM, ngayBD, ngayKT));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Khuyến Mãi");
        } finally {
            qlkmConnection.closeConnect();
        }
        return dskm;
    }

    public ArrayList<KhuyenMai> search(String columnName, String value) {
        qlkmConnection = new ConnectionDB();
        ArrayList<KhuyenMai> dskm = new ArrayList<>();

        try {
            String qry = "SELECT * FROM khuyenmai WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet resultSet = qlkmConnection.sqlQuery(qry);
            if (resultSet != null) {
                while (resultSet.next()) {
                    String maKM = resultSet.getString("maKM");
                    String tenKM = resultSet.getString("tenKM");
                    float dieuKienKM = resultSet.getFloat("dieuKienKM");
                    float phanTramKM = resultSet.getFloat("phanTramKM");
                    LocalDate ngayBD = resultSet.getDate("ngayBD").toLocalDate();
                    LocalDate ngayKT = resultSet.getDate("ngayKT").toLocalDate();
                    dskm.add(new KhuyenMai(maKM, tenKM, dieuKienKM, phanTramKM, ngayBD, ngayKT));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng Khuyến Mãi");
        } finally {
            qlkmConnection.closeConnect();
        }

        return dskm;
    }

    public Boolean add(KhuyenMai km) {
        qlkmConnection = new ConnectionDB();
        Boolean queryBoolean = qlkmConnection.sqlUpdate("INSERT INTO `khuyenmai` (`maKM`, `tenKM`, `dieuKienKM`, `phanTramKM`, `ngayBD`, `ngayKT`) VALUES ('"
                + km.getMaKM()+ "', '"
                + km.getTenKM() + "', '"
                + km.getDieuKienKM() + "', '"
                + km.getPhanTramKM() + "', '"
                + km.getNgayBD() + "', '"
                + km.getNgayKT() + "');");
        qlkmConnection.closeConnect();
        return queryBoolean;
    }

    public Boolean delete(String maKM) {
        qlkmConnection = new ConnectionDB();
        Boolean queryBoolean = qlkmConnection.sqlUpdate("DELETE FROM `khuyenmai` WHERE `khuyenmai`.`maKM` = '" + maKM + "'");
        qlkmConnection.closeConnect();
        return queryBoolean;
    }

    public Boolean update(String maKM, String tenKM, float dieuKienKM, float phanTramKM, LocalDate ngayBD, LocalDate ngayKT) {
        qlkmConnection = new ConnectionDB();
        Boolean queyBoolean = qlkmConnection.sqlUpdate("Update KhuyenMai Set "
                + "tenKM='" + tenkm
                + "', dieuKienKM='" + dieuKienKM
                + "', phanTramKM='" + phanTramKM
                + "', ngayBD='" + ngayBD
                + "', ngayKT='" + ngayKT
                + "' where maKM='" + maKM + "'");
        qlkmConnection.closeConnect();
        return queyBoolean;
    }

    public void close() {
        qlkmConnection.closeConnect();
    }
}