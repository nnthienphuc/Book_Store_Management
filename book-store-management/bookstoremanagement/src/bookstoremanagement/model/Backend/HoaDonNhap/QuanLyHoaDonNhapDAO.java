package bookstoremanagement.model.Backend.HoaDonNhap;
import bookstoremanagement.model.Backend.ConnectDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class QuanLyHoaDonNhapDAO {
    ConnectionDB connection;

    public QuanLyHoaDonNhapDAO() {
    }

    public ArrayList readDB() {
        connection = new ConnectionDB();
        ArrayList<HoaDonNhap> dshdn = new ArrayList<>();
        try {
            String qry = "SELECT * FROM HoaDonNhap";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {

                while (rs.next()) {
                    HoaDonNhap hdn = new HoaDonNhap();
                    hdn.setMaHDN(rs.getString(1));
                    hdn.setMaNCC(rs.getString(2));
                    hdn.setMaNV(rs.getString(3));
                    hdn.setNgayLap(rs.getDate(4).toLocalDate());
                    hdn.setGioLap(rs.getTime(5).toLocalTime());
                    hdn.setTongTien(rs.getFloat(6));
                    dshdn.add(hdn);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu !!");
        } finally {
            connection.closeConnect();
        }
        return dshdn;
    }
    
    public Boolean add(HoaDonNhap hdn) {
        connection = new ConnectionDB();
        Boolean ok = connection.sqlUpdate("INSERT INTO HoaDonNhap(maHDN,maNCC,maNV,ngayLap,gioLap,tongTien) VALUES ('"
                + hdn.getMaHDN() + "','"
                + hdn.getMaNCC() + "','"
                + hdn.getMaNV() + "','"
                + hdn.getNgayLap() + "','"
                + hdn.getGioLap() + "','"
                + hdn.getTongTien() + "');");
        connection.closeConnect();
        return ok;
    }
    
    public Boolean delete(String mahdn) {
        connection = new ConnectionDB();
        if (!connection.sqlUpdate("DELETE FROM HoaDonNhap WHERE maHDN='" + mahdn + "';")) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua phiếu nhập truoc !!!");
            connection.closeConnect();
            return false;
        }
        connection.closeConnect();
        return false;
    }
    
    public Boolean update(HoaDonNhap hdn) {
        connection = new ConnectionDB();
        Boolean ok = connection.sqlUpdate("UPDATE HoaDonNhap SET "
                + "maNCC='" + hdn.getMaNCC()
                + "', maNV='" + hdn.getMaNV()
                + "', ngayLap='" + hdn.getNgayLap()
                + "', gioLap='" + hdn.getGioLap()
                + "', tongTien='" + hdn.getTongTien()
                + "' WHERE maHDN='" + hdn.getMaHDN()+ "';");
        connection.closeConnect();
        return ok;
    }
    
    public Boolean updateTongTien(String _mahdn, float _tongTien) {
        connection = new ConnectionDB();
        Boolean ok = connection.sqlUpdate("UPDATE HoaDonNhap SET tongTien='" + _tongTien + "' WHERE maHDN='" + _mahdn + "';");
        connection.closeConnect();
        return ok;
    }
    
//    public Boolean update(String maHDN, String maNCC, String maNV, LocalDate ngayLap, LocalTime gioLap, float tongTien) {
//        HoaDonNhap hdn = new HoaDonNhap();
//        hdn.setMaHDN(maHDN);
//        hdn.setMaNCC(maNCC);
//        hdn.setMaNV(maNV);
//        hdn.setNgayLap(ngayLap);
//        hdn.setGioLap(gioLap);
//        hdn.setTongTien(tongTien);
//        return update(hdn);
//    }
    

}
