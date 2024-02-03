/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;

/**
 *
 * @author nnthienphuc
 */
public class QuanLyKhachHangDAO {
    ConnectionDB qlkhConnection;

    public QuanLyKhachHangDAO() {
    }

    public ArrayList<KhachHang> readDB() {
        qlkhConnection = new ConnectionDB();
        ArrayList<KhachHang> dskh = new ArrayList<>();

        try {
            String qry = "SELECT * FROM khachhang";
            ResultSet resultSet = qlkhConnection.sqlQuery(qry);
            if (resultSet != null) {
                while (r.next()) {
                    String maKH = resultSet.getString("maKH");
                    String tenKH = resultSet.getString("tenKH");
                    String diaChi = resultSet.getString("diaChi");
                    String SDT = resultSet.getString("SDT");
                    dskh.add(new KhachHang(maKH, tenKH, diaChi, SDT));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Khách Hàng!");
        } finally {
            qlkhConnection.closeConnect();
        }

        return dskh;
    }

    public ArrayList<KhachHang> search(String columnName, String value) {
        qlkhConnection = new ConnectionDB();
        ArrayList<KhachHang> dskh = new ArrayList<>();

        try {
            String qry = "SELECT * FROM khachhang WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet resultSet = qlkhConnection.sqlQuery(qry);
            if (r != null) {
                while (resultSet.next()) {
                    String maKH = resultSet.getString("maKH");
                    String tenKH = resultSet.getString("tenKH");
                    String diaChi = resultSet.getString("diaChi");
                    String SDT = resultSet.getString("SDT");
                    dskh.add(new KhachHang(maKH, tenKH, diaChi, SDT));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng Khách Hàng!");
        } finally {
            qlkhConnection.closeConnect();
        }

        return dskh;
    }

    public Boolean add(KhachHang kh) {
        qlkhConnection = new ConnectionDB();
        Boolean queryBoolean = qlkhConnection.sqlUpdate("INSERT INTO `khachhang` (`maKH`, `tenKH`, `diaChi`, `SDT`) VALUES ('"
                + kh.getMaKH() + "', '"
                + kh.getTenKH() + "', '"
                + kh.getDiaChi() + "','"
                + kh.getSDT() + "');");
        qlkhConnection.closeConnect();
        return queryBoolean;
    }

    public Boolean delete(String maKH) {
        qlkhConnection = new ConnectionDB();
        Boolean queryBoolean = qlkhConnection.sqlUpdate("DELETE FROM `khachhang` WHERE `khachhang`.`maKH` = '" + maKH + "'");
        qlkhConnection.closeConnect();
        return queryBoolean;
    }

    public Boolean update(String maKH, String tenKH, String diaChi, String SDT) {
        qlkhConnection = new ConnectionDB();
        Boolean queryBoolean = qlkhConnection.sqlUpdate("Update KhachHang Set "
                + "TenKH='" + tenKH
                + "', DiaChi='" + diaChi 
                + "', SDT='" + SDT
                + "' where MaKH='" + maKH + "'");
        qlkhConnection.closeConnect();
        return queryBoolean;
    }

    public void close() {
        qlkhConnection.closeConnect();
    }
}
