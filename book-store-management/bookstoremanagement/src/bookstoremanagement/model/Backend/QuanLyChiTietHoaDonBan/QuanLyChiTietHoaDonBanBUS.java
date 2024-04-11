
package bookstoremanagement.model.Backend.QuanLyChiTietHoaDonBan;

import bookstoremanagement.model.Backend.HoaDonBan.QuanLyHoaDonBanBUS;
import bookstoremanagement.model.Backend.Sach.QuanLySachBUS;
import bookstoremanagement.model.Backend.Sach.Sach;
import java.util.ArrayList;

public class QuanLyChiTietHoaDonBanBUS {
   
    ArrayList<ChiTietHoaDonBan> dscthd = new ArrayList<>();
    private QuanLyChiTietHoaDonBanDAO qlcthdDAO = new QuanLyChiTietHoaDonBanDAO();
    private QuanLyHoaDonBanBUS qlhdBUS = new QuanLyHoaDonBanBUS();
    private QuanLySachBUS qlsBUS = new QuanLySachBUS();
    
    public QuanLyChiTietHoaDonBanBUS() {
        dscthd = qlcthdDAO.readDB();
    }

    public ArrayList<ChiTietHoaDonBan> getDscthd() {
        return this.dscthd;
    }

    public void readDB() {
        dscthd = qlcthdDAO.readDB();
    }

    public ChiTietHoaDonBan getChiTiet(String mahdb, String masach) {
        for (ChiTietHoaDonBan ct : dscthd) {
            if (ct.getMaSach().equals(masach) && ct.getMaHDB().equals(mahdb)) {
                return ct;
            }
        }
        return null;
    }
    
    public ArrayList<ChiTietHoaDonBan> getAllChiTiet(String mahdb) {
        ArrayList<ChiTietHoaDonBan> result = new ArrayList<>();
        for (ChiTietHoaDonBan ct : dscthd) {
            if (ct.getMaHDB().equals(mahdb)) {
                result.add(ct);
            }
        }
        return result;
    }
    
    public Boolean add(ChiTietHoaDonBan ct) {
        int soLuongChiTietMoi = ct.getSoLuong();

        // tìm các chi tiết cùng mã, và tính tổng số lượng
        ArrayList<ChiTietHoaDonBan> toRemove = new ArrayList<>();
        int tongSoLuong = ct.getSoLuong();

        for (ChiTietHoaDonBan cthd : dscthd) {
            if (cthd.getMaHDB().equals(ct.getMaHDB()) && cthd.getMaSach().equals(ct.getMaSach())) {
                tongSoLuong += cthd.getSoLuong();
                toRemove.add(cthd);
            }
        }
        // xóa chi tiết cũ cùng mã
        dscthd.removeAll(toRemove);
        qlcthdDAO.delete(ct.getMaHDB(), ct.getMaSach());

        // thêm chi tiết mới có số lượng = tổng số lượng tìm ở trên
        ct.setSoLuong(tongSoLuong);
        Boolean success = qlcthdDAO.add(ct);
        if (success) {
            dscthd.add(ct);
            // update số lượng bên bảng sach
            updateSoLuongSach(ct.getMaSach(), -soLuongChiTietMoi);
            
            // update tổng tiền hóa đơn
            //updateTongTien(ct.getMaHDB());
           
            return true;
        }
        return false;
    }
    
    public Boolean add(String mahdb, String masach, int soluong) {
        ChiTietHoaDonBan hd = new ChiTietHoaDonBan(mahdb, masach, soluong);
        return add(hd);
    }

//    public Boolean update(String mahdb, String masach, int soluong) {
//        ChiTietHoaDonBan hd = new ChiTietHoaDonBan(mahdb, masach, soluong);
//        return update(hd);
//    }
//    
//    public Boolean update(ChiTietHoaDonBan hd) {
//        Boolean success = qlcthdDAO.update(hd);
//        if (success) {
//            for (ChiTietHoaDonBan cthd : dscthd) {
//                if (cthd.getMaHDB().equals(hd.getMaHDB())) {
//                    cthd = hd;
//                }
//            }
//            updateTongTien(hd.getMaHDB());
//        }
//
//        return success;
//    }
    
//    private Boolean updateTongTien(String _mahd) {
//        float tong = 0;
//        for (ChiTietHoaDonBan ct : dscthd) {
//            if (ct.getMaHDB().equals(_mahd)) {
//                tong += ct.getSoLuong() * qlsBUS.getSach(ct.getMaSach()).getGiaBan();
//            }
//        }
//        Boolean success = qlhdBUS.updateTongTien(_mahd, tong);
//        return success;
//    }
    
    private Boolean updateSoLuongSach(String _masach, int _soLuongThayDoi) {
        for (Sach sach : qlsBUS.getDSSach()) {
            if (sach.getMaSach().equals(_masach)) {
                return qlsBUS.updateSoLuong(_masach, sach.getSoLuong() + _soLuongThayDoi);
            }
        }
        return false;
    }


    public ArrayList<ChiTietHoaDonBan> search(String type, String keyword, int soLuong1, int soLuong2, float thanhTien1, float thanhTien2) {
        ArrayList<ChiTietHoaDonBan> result = new ArrayList<>();

        dscthd.forEach((hd) -> {
            switch (type) {
                case "Tất cả":
                    if (hd.getMaHDB().toLowerCase().contains(keyword.toLowerCase())
                            || hd.getMaSach().toLowerCase().contains(keyword.toLowerCase())
                            || String.valueOf(hd.getSoLuong()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }

                    break;

                case "Mã hóa đơn":
                    if (hd.getMaHDB().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;

                case "Mã sách":
                    if (hd.getMaSach().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;

                case "Số lượng":
                    if (String.valueOf(hd.getSoLuong()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;

                
            }
        });

        for (int i = result.size() - 1; i >= 0; i--) {
            ChiTietHoaDonBan ct = result.get(i);
            int sl = ct.getSoLuong();
            float tt = qlsBUS.getSach(ct.getMaSach()).getGiaBan() * sl;

            Boolean soLuongKhongThoa = (soLuong1 != -1 && sl < soLuong1) || (soLuong2 != -1 && sl > soLuong2);
            Boolean donGiaKhongThoa = (thanhTien1 != -1 && tt < thanhTien1) || (thanhTien2 != -1 && tt > thanhTien2);

            if (soLuongKhongThoa || donGiaKhongThoa) {
                result.remove(ct);
            }
        }
        return result;
    }
}
