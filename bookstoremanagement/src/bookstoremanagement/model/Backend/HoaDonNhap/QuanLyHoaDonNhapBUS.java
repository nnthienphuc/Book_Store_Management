package bookstoremanagement.model.Backend.HoaDonNhap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class QuanLyHoaDonNhapBUS {
    ArrayList<HoaDonNhap> dshdn = new ArrayList<>();
    QuanLyHoaDonNhapDAO qlhdnDAO = new QuanLyHoaDonNhapDAO();
    
    public QuanLyHoaDonNhapBUS() {
        dshdn = qlhdnDAO.readDB();
    }

    public void readDB() {
        dshdn = qlhdnDAO.readDB();
    }
    
    public String getNextID() {
        return "HDN" + (dshdn.size() + 1);
    }
    
    public HoaDonNhap getHoaDonNhap(String mahdn){
        for (HoaDonNhap hdn : dshdn) {
            if (hdn.getMaHDN().equals(mahdn)) {
                return hdn;
            }
        }
        return null;
    }
    
    public ArrayList<HoaDonNhap> getDshdn() {
        return this.dshdn;
    }
    
    public ArrayList<HoaDonNhap> search(String type, String value, LocalDate _ngay1, LocalDate _ngay2, int _tong1, int _tong2) {
        ArrayList<HoaDonNhap> result = new ArrayList<>();

        dshdn.forEach((hdn) -> {
            if (type.equals("Tất cả")) {
                if (hdn.getMaHDN().toLowerCase().contains(value.toLowerCase())
                        || hdn.getMaNCC().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(hdn.getMaNV()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(hdn.getNgayLap()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(hdn.getGioLap()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(hdn.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(hdn);
                }
            } else {
                switch (type) {
                    case "Mã phiếu nhập":
                        if (hdn.getMaHDN().toLowerCase().contains(value.toLowerCase())) {
                            result.add(hdn);
                        }
                        break;
                    case "Mã nhà cung cấp":
                        if (hdn.getMaNCC().toLowerCase().contains(value.toLowerCase())) {
                            result.add(hdn);
                        }
                        break;
                    case "Mã nhân viên":
                        if (String.valueOf(hdn.getMaNV()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(hdn);
                        }
                        break;
                    case "Ngày nhập":
                        if (String.valueOf(hdn.getNgayLap()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(hdn);
                        }
                        break;
                    case "Giờ nhập":
                        if (String.valueOf(hdn.getGioLap()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(hdn);
                        }
                        break;
                    case "Tổng tiền":
                        if (String.valueOf(hdn.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(hdn);
                        }
                        break;
                }
            }

        });
        
        for (int i = result.size() - 1; i >= 0; i--) {
            HoaDonNhap hdn = result.get(i);
            LocalDate ngaylap = hdn.getNgayLap();
            float tongtien = hdn.getTongTien();

            Boolean ngayKhongThoa = (_ngay1 != null && ngaylap.isBefore(_ngay1)) || (_ngay2 != null && ngaylap.isAfter(_ngay2));
            Boolean tienKhongThoa = (_tong1 != -1 && tongtien < _tong1) || (_tong2 != -1 && tongtien > _tong2);

            if (ngayKhongThoa || tienKhongThoa) {
                result.remove(hdn);
            }
        }

        return result;
    }
    
    public boolean add(HoaDonNhap hdn) {
        Boolean ok = qlhdnDAO.add(hdn);
        if (ok) {
            dshdn.add(hdn);
        }
        return ok;
    }

    public Boolean update(String maHDN, String maNCC, String maNV, LocalDate ngayLap, LocalTime gioLap, float tongTien) {
        HoaDonNhap hdn = new HoaDonNhap(maHDN, maNCC, maNV, ngayLap, gioLap, tongTien);
        return update(hdn);
    }

    public Boolean update(HoaDonNhap hdn) {
        Boolean success = qlhdnDAO.update(hdn);
        if (success) {
            for (HoaDonNhap cthdn : dshdn) {
                if (cthdn.getMaHDN().equals(hdn.getMaHDN())) {
                    cthdn = hdn;
                }
            }
            return true;
        }
        return false;
    }

    public Boolean updateTongTien(String _mahdn, float _tongTien) {
        Boolean success = qlhdnDAO.updateTongTien(_mahdn, _tongTien);
        if (success) {
            for (HoaDonNhap hdn : dshdn) {
                if (hdn.getMaHDN().equals(_mahdn)) {
                    hdn.setTongTien(_tongTien);
                }
            }
            return true;
        }
        return false;
    }

    public boolean add(String maHDN, String maNCC, String maNV, LocalDate ngayLap, LocalTime gioLap, float tongTien) {
        HoaDonNhap hdn = new HoaDonNhap(maHDN, maNCC, maNV, ngayLap, gioLap, tongTien);
        return add(hdn);
    }

    public boolean delete(String mahdn) {
        Boolean ok = qlhdnDAO.delete(mahdn);
        if (ok) {
            for (int i = (dshdn.size() - 1); i >= 0; i--) {
                if (dshdn.get(i).getMaHDN().equals(mahdn)) {
                    dshdn.remove(i);
                }
            }

        }
        return ok;
    }
}
