
package bookstoremanagement.model.Backend.QuanLyChiTietHoaDonNhap;

import bookstoremanagement.model.Backend.HoaDonNhap.QuanLyHoaDonNhapBUS;
import bookstoremanagement.model.Backend.Sach.QuanLySachBUS;
import bookstoremanagement.model.Backend.Sach.Sach;
import java.util.ArrayList;

public class QuanLyChiTietHoaDonNhapBUS {
    
    QuanLyChiTietHoaDonNhapDAO qlcthdnDAO = new QuanLyChiTietHoaDonNhapDAO();
    QuanLyHoaDonNhapBUS qlhdnBUS = new QuanLyHoaDonNhapBUS();
    QuanLySachBUS qlsBUS = new QuanLySachBUS();
    ArrayList<ChiTietHoaDonNhap> dscthdn = new ArrayList<>();
    
    public QuanLyChiTietHoaDonNhapBUS() {
        dscthdn = qlcthdnDAO.readDB();
    }

    public void readDB() {
        dscthdn = qlcthdnDAO.readDB();
    }
    
    public ArrayList<ChiTietHoaDonNhap> getDscthdn() {
        return this.dscthdn;
    }
    
    public ArrayList<ChiTietHoaDonNhap> search(String type, String value) {

        ArrayList<ChiTietHoaDonNhap> result = new ArrayList<>();
        dscthdn.forEach((cthdn) -> {
            if (type.equals("Tất cả")) {
                if (cthdn.getMaHDN().toLowerCase().contains(value.toLowerCase())
                        || cthdn.getMaSach().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(cthdn.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(cthdn);
                }
            } else {
                switch (type) {
                    case "Mã hoá đơn nhập":
                        if (cthdn.getMaHDN().toLowerCase().contains(value.toLowerCase())) {
                            result.add(cthdn);
                        }
                        break;
                    case "Mã sách":
                        if (cthdn.getMaSach().toLowerCase().contains(value.toLowerCase())) {
                            result.add(cthdn);
                        }
                        break;
                    case "Số lượng":
                        if (String.valueOf(cthdn.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(cthdn);
                        }
                        break;
                }
            }

        });

        return result;
    }
    
    
    
    
    public ChiTietHoaDonNhap getChiTiet(String _maHDN, String _maSach) {
        for (ChiTietHoaDonNhap ct : dscthdn) {
            if (ct.getMaSach().equals(_maSach) && ct.getMaHDN().equals(_maHDN)) {
                return ct;
            }
        }
        return null;
    }
    
    public ArrayList<ChiTietHoaDonNhap> getAllChiTiet(String _maHDN) {
        ArrayList<ChiTietHoaDonNhap> result = new ArrayList<>();
        for(ChiTietHoaDonNhap cthdn : dscthdn) {
            if(cthdn.getMaHDN().equals(_maHDN)) {
                result.add(cthdn);
            }
        }
        return result;
    }
    
    
    
    public Boolean add(ChiTietHoaDonNhap ct) {
        int soLuongChiTietMoi = ct.getSoLuong();

        // tìm các chi tiết cùng mã, và tính tổng số lượng
        ArrayList<ChiTietHoaDonNhap> toRemove = new ArrayList<>();
        int tongSoLuong = ct.getSoLuong();

        for (ChiTietHoaDonNhap cthdn : dscthdn) {
            if (cthdn.getMaHDN().equals(ct.getMaHDN()) && cthdn.getMaSach().equals(ct.getMaSach())) {
                tongSoLuong += cthdn.getSoLuong();
                toRemove.add(cthdn);
            }
        }
        // xóa chi tiết cũ cùng mã
        dscthdn.removeAll(toRemove);
        qlcthdnDAO.delete(ct.getMaHDN(), ct.getMaSach());

        // thêm chi tiết mới có số lượng = tổng số lượng tìm ở trên
        ct.setSoLuong(tongSoLuong);
        Boolean success = qlcthdnDAO.add(ct);
        if (success) {
            dscthdn.add(ct);
            updateSoLuongSach(ct.getMaSach(), soLuongChiTietMoi);
            updateTongTien(ct.getMaHDN());
            return true;
        }
        return false;
    }
    
    private Boolean updateSoLuongSach(String _maSach, int _soLuongThayDoi) {
        Boolean success = false;
        for (Sach sach : qlsBUS.getDSSach()) {
            if (sach.getMaSach().equals(_maSach)) {
                success = qlsBUS.updateSoLuong(_maSach, sach.getSoLuong() + _soLuongThayDoi);
            }
        }
        return success;
    }
    
    public boolean add(String _maHDN, String _maSach, int _soLuong, float _donGia) {
        ChiTietHoaDonNhap cthdn = new ChiTietHoaDonNhap(_maHDN, _maSach, _soLuong);
        return add(cthdn);
    }
    
    public boolean delete(String _maHDN) {
        Boolean ok = qlcthdnDAO.deleteAll(_maHDN);
        if (ok) {
            for (int i = (dscthdn.size() - 1); i >= 0; i--) {
                if (dscthdn.get(i).getMaHDN().equals(_maHDN)) {
                    dscthdn.remove(i);
                }
            }

        }
        return ok;
    }
    
    public Boolean update(String _maHDN, String _maSach, int _soLuong, float _donGia) {
        Boolean ok = qlcthdnDAO.update(_maHDN, _maSach, _soLuong, _donGia);
        if (ok) {
            dscthdn.forEach((cthdn) -> {
                if (cthdn.getMaHDN().equals(_maHDN) && cthdn.getMaSach().equals(_maSach)) {
                    ChiTietHoaDonNhap hdn = new ChiTietHoaDonNhap(_maHDN, _maSach, _soLuong);
                    dscthdn.add(hdn);
                }
            });
        }

        return ok;
    }
    
    private Boolean updateTongTien(String _maHDN) {
        float tong = 0;
        for (ChiTietHoaDonNhap ct : dscthdn) {
            if (ct.getMaHDN().equals(_maHDN)) {
                tong += ct.getSoLuong() * qlsBUS.getSach(ct.getMaSach()).getGiaNhap();
            }
        }
        Boolean success = qlhdnBUS.updateTongTien(_maHDN, tong);

        return success;
    }

    
    
    
}
