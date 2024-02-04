
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
                    hdb.setMaHDB(rs.getString(1));
                    hdb.setMaNV(rs.getString(2));
                    hdb.setMaKH(rs.getString(3));
                    hdb.setMaKM(rs.getString(4));
                    hdb.setNgayLap(rs.getDate(5).toLocalDate());
                    hdb.setGioLap(rs.getTime(6).toLocalTime());
                    hdb.setTongTien(rs.getFloat(7));
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
        Boolean success = connection.sqlUpdate("INSERT INTO HoaDonBan(maHDB,maNV,maKH,maKM,ngayLap,gioLap,tongTien) VALUES ('" 
                + hdb.getMaHDB()+ "','" 
                + hdb.getMaNV()+ "','" 
                + hdb.getMaKH()+ "','" 
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
                + "MaNV='" + hdb.getMaNV()
                + "', MaKH='" + hdb.getMaKH()
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
