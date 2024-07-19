package bookstoremanagement.model.Backend.NhanVien;

import java.time.LocalDate;
import java.util.ArrayList;

public class QuanLyNhanVienBUS {

    private ArrayList<QuanLyNhanVien> dsnv = new ArrayList<>();
    private QuanLyNhanVienDAO qlnvDAO = new QuanLyNhanVienDAO();

    public QuanLyNhanVienBUS() {
        dsnv = qlnvDAO.readDB();
    }

    public void readDB() {
        dsnv = qlnvDAO.readDB();
    }

    public String getNextID() {
        return "NV" + String.valueOf(this.dsnv.size() + 1);
    }

    public QuanLyNhanVien getNhanVien(String manv) {
        for (QuanLyNhanVien nv : dsnv) {
            if (nv.getMaNV().equals(manv)) {
                return nv;
            }
        }
        return null;
    }

    public ArrayList<QuanLyNhanVien> search(String value, String type, LocalDate _ngay1, LocalDate _ngay2) {
        ArrayList<QuanLyNhanVien> result = new ArrayList<>();

        dsnv.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (nv.getMaNV().toLowerCase().contains(value.toLowerCase())
                        || nv.getTenNV().toLowerCase().contains(value.toLowerCase())
                        || nv.getNgaySinh().toString().toLowerCase().contains(value.toLowerCase())
                        || nv.getDiaChi().toLowerCase().contains(value.toLowerCase())
                        || nv.getSDT().toLowerCase().contains(value.toLowerCase())) {
                    result.add(nv);
                }
            } else {
                switch (type) {
                    case "Mã nhân viên":
                        if (nv.getMaNV().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Tên nhân viên":
                        if (nv.getTenNV().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Ngày sinh":
                        if (nv.getNgaySinh().toString().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Địa chỉ":
                        if (nv.getDiaChi().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Số điện thoại":
                        if (nv.getSDT().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    
                }
            }
        });

        //Ngay sinh
        for (int i = result.size() - 1; i >= 0; i--) {
            QuanLyNhanVien nv = result.get(i);
            LocalDate ngaysinh = nv.getNgaySinh();

            Boolean ngayKhongThoa = (_ngay1 != null && ngaysinh.isBefore(_ngay1)) || (_ngay2 != null && ngaysinh.isAfter(_ngay2));

            if (ngayKhongThoa) {
                result.remove(nv);
            }
        }

        return result;
    }

    public Boolean add(QuanLyNhanVien nv) {
        Boolean ok = qlnvDAO.add(nv);

        if (ok) {
            dsnv.add(nv);
        }
        return ok;
    }

    public Boolean add(String manv, String tennv, LocalDate ngaysinh, String diachi, String sdt, int trangthai) {
        QuanLyNhanVien nv = new QuanLyNhanVien(manv, tennv, ngaysinh, diachi, sdt, trangthai);
        return add(nv);
    }

    public Boolean delete(String manv) {
        Boolean ok = qlnvDAO.delete(manv);

        if (ok) {
            for (int i = (dsnv.size() - 1); i >= 0; i--) {
                if (dsnv.get(i).getMaNV().equals(manv)) {
                    dsnv.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String manv, String tennv, LocalDate ngaysinh, String diachi, String sdt, int trangthai) {
        Boolean ok = qlnvDAO.update(manv, tennv, ngaysinh, diachi, sdt, trangthai);

        if (ok) {
            dsnv.forEach((nv) -> {
                if (nv.getMaNV().equals(manv)) {
                    nv.setTenNV(tennv);
                    nv.setNgaySinh(ngaysinh);
                    nv.setDiaChi(diachi);
                    nv.setSDT(sdt);
                }
            });
        }

        return ok;
    }

    

    public ArrayList<QuanLyNhanVien> getDsnv() {
        return dsnv;
    }
}
