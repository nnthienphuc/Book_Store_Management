/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.Sach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;

/**
 *
 * @author nnthienphuc
 */
public class QuanLySachDAO {
    ConnectionDB qlsachConnection;
    
    public QuanLySachDAO()
    {
    }

    public ArrayList<Sach> readDB() {
        qlsachConnection = new ConnectionDB();
        ArrayList<Sach> dsSach = new ArrayList<>();
        try {
            String qry = "SELECT * FROM sach";
            ResultSet resultSet = qlsachConnection.sqlQuery(qry);
            if (resultSet != null) {
                while (resultSet.next()) {
                    String maSach = resultSet.getString("maSach");
                    String tenSach = resultSet.getString("tenSach");
                    String theLoai = resultSet.getString("theLoai");
                    String tacGia = resultSet.getString("tacGia");
                    String namXB = resultSet.getString("namXB");
                    int soLuong = resultSet.getInt("soLuong");
                    float giaBan = resultSet.getFloat("giaBan");
                    float giaNhap = resultSet.getFloat("giaNhap");
                    short trangThai = resultSet.getShort("trangThai");
                    dsSach.add(new Sach(maSach, tenSach, theLoai, tacGia, namXB, soLuong, giaBan, giaNhap, trangThai));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng Sách");
        } finally {
            qlsachConnection.closeConnect();
        }
        return dsSach;
    }
    
    public ArrayList<Sach> search(String columnName, String value) {
        qlsachConnection = new ConnectionDB();
        ArrayList<Sach> dsSach = new ArrayList<>();

        try {
            String qry = "SELECT * FROM sach WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet resultSet = qlsachConnection.sqlQuery(qry);
            if (resultSet != null) {
                while (resultSet.next()) {
                    String maSach = resultSet.getString("maSach");
                    String tenSach = resultSet.getString("tenSach");
                    String theLoai = resultSet.getString("theLoai");
                    String tacGia = resultSet.getString("tacGia");
                    String namXB = resultSet.getString("namXB");
                    int soLuong = resultSet.getInt("soLuong");
                    float giaBan = resultSet.getFloat("giaBan");
                    float giaNhap = resultSet.getFloat("giaNhap");
                    short trangThai = resultSet.getShort("trangThai");
                    dsSach.add(new Sach(maSach, tenSach, theLoai, tacGia, namXB, soLuong, giaBan, giaNhap, trangThai));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng Sách");
        } finally {
            qlsachConnection.closeConnect();
        }
        return dsSach;
    }
    
    public Boolean add(Sach sach) {
        qlsachConnection = new ConnectionDB();
        Boolean queryBoolean = qlsachConnection.sqlUpdate("INSERT INTO `sach` (`maSach`, `tenSach`, `theLoai`, `tacGia`, `namXB`, `soLuong`, `giaNhap`, `giaBan`, `trangThai`) VALUES ('"
                + sach.getMaSach() + "', '"
                + sach.getTenSach() + "', '"
                + sach.getTheLoai() + "', '"
                + sach.getTacGia() + "', '"
                + sach.getNamXB() + "', '"
                + sach.getSoLuong() + "', '"
                + sach.getGiaNhap() + "', '"
                + sach.getGiaBan() + "', '"
                + sach.getTrangThai() + "');");
        qlsachConnection.closeConnect();
        return queryBoolean;
    }
    
    public Boolean delete(String masach) {
        qlsachConnection = new ConnectionDB();
        Boolean queryBoolean = qlsachConnection.sqlUpdate("DELETE FROM `sach` WHERE `sach`.`maSach` = '" + masach + "'");
        qlsachConnection.closeConnect();
        return queryBoolean;
    }
    
    public Boolean update(String maSach, String tenSach, String theLoai, String tacGia, String namXB, int soLuong, float giaNhap, float giaBan, short trangThai) {
        qlsachConnection = new ConnectionDB();
        Boolean query = qlsachConnection.sqlUpdate("Update sach Set "
                + "tenSach='" + tenSach
                + "', theLoai='" + theLoai
                + "', tacGia='" + tacGia
                + "', namXB='" + namXB
                + "', soLuong='" + soLuong
                + "', giaNhap='" + giaNhap
                + "', giaBan='" + giaBan
                + "', trangThai='" + trangThai
                + "' where maSach='" + maSach + "';");
        qlsachConnection.closeConnect();
        return query;
    }
    
    public Boolean updateSoLuong(String maSach, int soLuong) {
        qlsachConnection = new ConnectionDB();
        Boolean query = qlsachConnection.sqlUpdate("Update sach Set "
                + "soLuong='" + soLuong
                + "' where maSach='" + maSach + "'");
        qlsachConnection.closeConnect();
        return query;
    }

    public Boolean updateTrangThai(String maSach, int trangThai) {
        qlsachConnection = new ConnectionDB();
        Boolean ok = qlsachConnection.sqlUpdate("Update sach Set "
                + "trangThai='" + trangThai
                + "' where maSach='" + maSach + "'");
        qlsachConnection.closeConnect();
        return ok;
    }

    public void close() {
        qlsachConnection.closeConnect();
    }
}
