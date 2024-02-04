package bookstoremanagement.model.Backend.NhaCungCap;
import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author THUY NGAN
 */
public class QuanLyNhaCungCapDAO {

    ConnectionDB connection;

    public QuanLyNhaCungCapDAO() {
    }

    public ArrayList readDB() {
        connection = new ConnectionDB();
        ArrayList<NhaCungCap> dsqlncc = new ArrayList<>();
        try {
            String query = "SELECT * FROM nhacungcap";
            ResultSet rs = connection.sqlQuery(query);
            if (rs != null) {

                while (rs.next()) {
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.setMaNCC(rs.getString("maNCC"));
                    ncc.setTenNCC(rs.getString("tenNCC"));
                    ncc.setDiaChi(rs.getString("diaChi"));
                    ncc.setSDT(rs.getString("SDT"));
                    ncc.setFAX(rs.getString("FAX"));
                    dsqlncc.add(ncc);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu !!");
        } finally {
            connection.closeConnect();
        }
        return dsqlncc;
    }

    public Boolean add(NhaCungCap ncc) {
        connection = new ConnectionDB();
        String query = ("INSERT INTO NHACUNGCAP (maNCC, tenNCC, diaChi, SDT, FAX) VALUES ('"
                + ncc.getMaNCC() + "','"
                + ncc.getTenNCC() + "','"
                + ncc.getDiaChi()+ "','"
                + ncc.getSDT() + "','"
                + ncc.getFAX() + "');");
        Boolean okie = connection.sqlUpdate(query);
        System.out.println(query);

        connection.closeConnect();
        return okie;
        
    }

    public boolean delete(String maNCC) {
        connection = new ConnectionDB();
        String query = "DELETE FROM NHACUNGCAP WHERE maNCC ='" + maNCC + "';";
        boolean okie = connection.sqlUpdate(query);
        return okie;
    }

    public boolean update(NhaCungCap ncc) {
        connection = new ConnectionDB();
        String query = ("UPDATE nhacungcap SET "
                + "maNCC='" + ncc.getMaNCC()
                + "', tenNCC='" + ncc.getTenNCC()
                + "', diaChi='" + ncc.getDiaChi()
                + "', SDT='" + ncc.getSDT()
                + "', FAX='" + ncc.getFAX() + "'"
                + " Where maNCC = '"+ ncc.getMaNCC() +"';");
        boolean okie = connection.sqlUpdate(query);
        connection.closeConnect();
        return okie;

    }
     public NhaCungCap findByMaNCC(String maNCC) {
        NhaCungCap ncc = new NhaCungCap();
        try {
            connection = new ConnectionDB();
            String query = "SELECT * FROM nhacungcap where maNCC ='" + maNCC + "';";
            ResultSet rs = connection.sqlQuery(query);
            if (rs.next()) {
//                while (rs ! = null) {
                    ncc.setMaNCC(rs.getString(1));
                    ncc.setTenNCC(rs.getString(2));
                    ncc.setDiaChi(rs.getString(3));
                    ncc.setSDT(rs.getString(4));
                    ncc.setFAX(rs.getString(5));
//               }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu !!");
        } finally {
            connection.closeConnect();
        }

        return ncc;

    }
     
     public ArrayList<NhaCungCap> findByTenNCC(String tenNCC) {
        ArrayList<NhaCungCap> dsncc = new ArrayList<>();
        connection = new ConnectionDB();
        try {
            String query = "SELECT * FROM nhanvien Where tenNCC Like  '%" + tenNCC + "%'";
            ResultSet rs = connection.sqlQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    String mancc = rs.getString("maNCC");
                    String tenncc = rs.getString("tenNCC");
                    String diachi = rs.getString("diaChi");
                    String sdt = rs.getString("SDT");
                    String fax = rs.getString("FAX");
                    dsncc.add(new NhaCungCap(mancc, tenncc, diachi, sdt, fax));
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng nhân viên");
        } finally {
            connection.closeConnect();
        }
         System.out.println("dao:" +dsncc.size());
        return dsncc;

    }
}
