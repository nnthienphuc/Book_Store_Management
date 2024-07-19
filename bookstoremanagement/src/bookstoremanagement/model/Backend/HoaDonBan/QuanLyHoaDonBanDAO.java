
package bookstoremanagement.model.Backend.HoaDonBan;


import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class QuanLyHoaDonBanDAO {
    ConnectionDB connection;
    
    public QuanLyHoaDonBanDAO() {
    }
    
    public ArrayList readDB() {
        connection = new ConnectionDB();
        ArrayList<HoaDonBan> dshdb = new ArrayList<>();
        try {
            String qry = "SELECT * FROM HoaDonBan";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    HoaDonBan hdb = new HoaDonBan();
                    hdb.setMaHDB(rs.getString("maHDB"));
                    hdb.setMaKH(rs.getString("maKH"));
                    hdb.setMaNV(rs.getString("maNV"));
                    hdb.setMaKM(rs.getString("maKM"));
                    hdb.setNgayLap(rs.getDate("ngayLap").toLocalDate());
                    hdb.setGioLap(rs.getTime("gioLap").toLocalTime());
                    hdb.setTongTien(rs.getFloat("tongTien"));
                    dshdb.add(hdb);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu bảng hóa đơn !!");
        } finally {
            connection.closeConnect();
        }
        return dshdb;
    }
    
    public Boolean add(HoaDonBan hdb) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("INSERT INTO HoaDonBan(maHDB,maKH,maNV,maKM,ngayLap,gioLap,tongTien) VALUES ('" 
                + hdb.getMaHDB()+ "','"
                + hdb.getMaKH()+ "','" 
                + hdb.getMaNV()+ "','" 
                + hdb.getMaKM()+ "','" 
                + hdb.getNgayLap()+ "','" 
                + hdb.getGioLap() + "','" 
                + hdb.getTongTien() + "');");
        connection.closeConnect();
        return success;
    }
    
    public Boolean delete(String mahdb) {
        connection = new ConnectionDB();
        if (!connection.sqlUpdate("DELETE FROM HoaDonBan WHERE maHDB='" + mahdb + "';")) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua hoa don truoc !!!");
            connection.closeConnect();
            return false;
        }
        connection.closeConnect();
        return true;
    }
    
    public Boolean update(HoaDonBan hdb) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE HoaDonBan SET "
                + "'MaKH='" + hdb.getMaKH()
                + ", MaNV='" + hdb.getMaNV()
                + "', MaKM='" + hdb.getMaKM()
                + "', NgayLap='" + hdb.getNgayLap() 
                + "', GioLap='" + hdb.getGioLap() 
                + "', TongTien='" + hdb.getTongTien() 
                + "' WHERE MaHD='" + hdb.getMaHDB()+ "';");
        connection.closeConnect();
        return success;
    }
    
    public Boolean updateTongTien(String _mahd,float _tongTien){
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE HoaDonBan SET tongTien='" + _tongTien + "' WHERE maHDB='" +_mahd + "';");
        connection.closeConnect();
        return success;
    }
    
//    public Boolean update(String maHDB, String maNV, String maKH, String maKM, LocalDate ngayLap, LocalTime gioLap, float tongTien) {
//        HoaDonBan hdb = new HoaDonBan();
//        hdb.setMaHDB(maHDB);
//        hdb.setMaNV(maNV);
//        hdb.setMaKH(maKH);
//        hdb.setMaKM(maKM);
//        hdb.setNgayLap(ngayLap);
//        hdb.setGioLap(gioLap);
//        hdb.setTongTien(tongTien);
//        return update(hdb);
//    }
    
}
