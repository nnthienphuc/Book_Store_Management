
package bookstoremanagement.model.Backend.HoaDonBan;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class QuanLyHoaDonBanBUS {
    ArrayList<HoaDonBan> dshdb = new ArrayList<>();
    private QuanLyHoaDonBanDAO qlhdbDAO = new QuanLyHoaDonBanDAO();

    public QuanLyHoaDonBanBUS() {
        dshdb = qlhdbDAO.readDB();
    }
    
    public ArrayList<HoaDonBan> getDshdb() {
        return this.dshdb;
    }
    
    public void readDB() {
        dshdb = qlhdbDAO.readDB();
    }
    
    public String[] getHeaders() {
        return new String[]{"Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã khuyến mãi", "Ngày lập", "Giờ lập", "Tổng tiền"};
    }
    
    public String getNextID() {
        return "HDB" + String.valueOf(this.dshdb.size() + 1);
    }
    
    public HoaDonBan getHoaDonBan(String mahdb) {
        for (HoaDonBan hdb : dshdb) {
            if (hdb.getMaHDB().equals(mahdb)) {
                return hdb;
            }
        }
        return null;
    }
    
    public Boolean add(HoaDonBan hdb) {
        Boolean success = qlhdbDAO.add(hdb);
        if (success) {
            dshdb.add(hdb);
            return true;
        }
        return false;
    }
    
    public Boolean add(String maHDB, String maKH, String maNV, String maKM, LocalDate ngayLap, LocalTime gioLap, float tongTien) {
        HoaDonBan hdb = new HoaDonBan(maHDB, maKH, maNV, maKM, ngayLap, gioLap, tongTien);
        return add(hdb);
    }
    
    public Boolean update(String maHDB, String maKH, String maNV, String maKM, LocalDate ngayLap, LocalTime gioLap, float tongTien) {
        HoaDonBan hdb = new HoaDonBan(maHDB, maKH, maNV, maKM, ngayLap, gioLap, tongTien);
        return update(hdb);
    }
    
    public Boolean update(HoaDonBan hdb) {
        Boolean success = qlhdbDAO.update(hdb);
        if (success) {
            for (HoaDonBan cthdb : dshdb) {
                if (cthdb.getMaHDB().equals(hdb.getMaHDB())) {
                    cthdb = hdb;
                }
            }
            return true;
        }
        return false;
    }
    
    public Boolean updateTongTien(String _mahdb, float _tongTien) {
        Boolean success = qlhdbDAO.updateTongTien(_mahdb, _tongTien);
        if (success) {
            for (HoaDonBan cthdb : dshdb) {
                if (cthdb.getMaHDB().equals(_mahdb)) {
                    cthdb.setTongTien(_tongTien);
                }
            }
            return true;
        }
        return false;
    }
    
    public Boolean delete(String maHDB) {
        Boolean success = qlhdbDAO.delete(maHDB);
        if (success) {
            for (HoaDonBan hdb : dshdb) {
                if (hdb.getMaHDB().equals(maHDB)) {
                    dshdb.remove(hdb);
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayList<HoaDonBan> search(String type, String keyword, LocalDate _ngay1, LocalDate _ngay2, int _tong1, int _tong2) {
        ArrayList<HoaDonBan> result = new ArrayList<>();

        dshdb.forEach((hdb) -> {
            switch (type) {
                case "Tất cả":
                    if (hdb.getMaHDB().toLowerCase().contains(keyword.toLowerCase())
                            || hdb.getMaNV().toLowerCase().contains(keyword.toLowerCase())
                            || hdb.getMaKH().toLowerCase().contains(keyword.toLowerCase())
                            || hdb.getMaKM().toLowerCase().contains(keyword.toLowerCase())
                            || hdb.getNgayLap().toString().toLowerCase().contains(keyword.toLowerCase())
                            || hdb.getGioLap().toString().toLowerCase().contains(keyword.toLowerCase())
                            || String.valueOf(hdb.getTongTien()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hdb);
                    }

                    break;

                case "Mã hóa đơn":
                    if (hdb.getMaHDB().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hdb);
                    }
                    break;
                    
                case "Mã khách hàng":
                    if (hdb.getMaKH().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hdb);
                    }
                    break;

                case "Mã nhân viên":
                    if (hdb.getMaNV().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hdb);
                    }
                    break;

                case "Mã khuyến mãi":
                    if (hdb.getMaKM().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hdb);
                    }
                    break;

                case "Ngày lập":
                    if (hdb.getNgayLap().toString().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hdb);
                    }
                    break;
                case "Giờ lập":
                    if (hdb.getGioLap().toString().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hdb);
                    }
                    break;
                case "Tổng tiền":
                    if (String.valueOf(hdb.getTongTien()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hdb);
                    }
            }
        });
    
        for (int i = result.size() - 1; i >= 0; i--) {
            HoaDonBan hdb = result.get(i);
            LocalDate ngaylap = hdb.getNgayLap();
            float tongtien = hdb.getTongTien();

            Boolean ngayKhongThoa = (_ngay1 != null && ngaylap.isBefore(_ngay1)) || (_ngay2 != null && ngaylap.isAfter(_ngay2));
            Boolean tienKhongThoa = (_tong1 != -1 && tongtien < _tong1) || (_tong2 != -1 && tongtien > _tong2);

            if (ngayKhongThoa || tienKhongThoa) {
                result.remove(hdb);
            }
        }

        return result;
    }
}
