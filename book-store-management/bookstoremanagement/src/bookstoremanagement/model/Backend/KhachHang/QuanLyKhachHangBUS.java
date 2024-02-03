/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.KhachHang;

import java.util.ArrayList;

/**
 *
 * @author nnthienphuc
 */

public class QuanLyKhachHangBUS {
    private ArrayList<KhachHang> dskh = new ArrayList<>();
    private QuanLyKhachHangDAO qlkhDAO = new QuanLyKhachHangDAO();

    public QuanLyKhachHangBUS() {
        dskh = qlkhDAO.readDB();
    }

    public void showConsole() {
        dskh.forEach((kh) -> {
            System.out.print(kh.getMaKH() + " ");
            System.out.println(kh.getTenKH() + " ");
            System.out.println(kh.getDiaChi() + " ");
            System.out.println(kh.getSDT());
        });
    }

    // headers của bảng sản phẩm
    public String[] getHeaders() {
        return new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "SĐT"};
    }

    public void readDB() {
        dskh = qlkhDAO.readDB();
    }
    
    public String getNextID() {
        return "KH" + String.valueOf(this.dskh.size() + 1);
    }
    
    public KhachHang getKhachHang(String maKH) {
        for (KhachHang kh : dskh) {
            if (kh.getMaKH().equals(maKH)) {
                return kh;
            }
        }

        return null;
    }

    public ArrayList<KhachHang> search(String value, String type) {
        ArrayList<KhachHang> result = new ArrayList<>();

        dskh.forEach((kh) -> {
            if (type.equals("Tất cả")) {
                if (kh.getMaKH().toLowerCase().contains(value.toLowerCase())
                        || kh.getTenKH().toLowerCase().contains(value.toLowerCase())
                        || kh.getDiaChi().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(kh.getSDT()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(kh);
                }
            } else {
                switch (type) {
                    case "Mã khách hàng":
                        if (kh.getMaKH().toLowerCase().contains(value.toLowerCase())) {
                            result.add(kh);
                        }
                        break;
                    case "Tên khách hàng":
                        if (kh.getTenKH().toLowerCase().contains(value.toLowerCase())) {
                            result.add(kh);
                        }
                        break;
                    case "Địa chỉ":
                        if (kh.getDiaChi().toLowerCase().contains(value.toLowerCase())) {
                            result.add(kh);
                        }
                        break;
                    case "Số điện thoại":
                        if (kh.getSDT().toLowerCase().contains(value.toLowerCase())) {
                            result.add(kh);
                        }
                        break;  
                    default:
                        break;
                }
            }
        });

        return result;
    }

    public Boolean add(KhachHang kh) {
        Boolean queryBoolean = qlkhDAO.add(kh);

        if (queryBoolean) {
            dskh.add(kh);
        }

        return queryBoolean;
    }

    public Boolean add(String maKH, String tenKH, String diaChi, String SDT) {
        KhachHang kh = new KhachHang(maKH, tenKH, diaChi, SDT);
        return add(kh);
    }

    public Boolean delete(String maKH) {
        Boolean queryBoolean = qlkhDAO.delete(maKH);

        if (queryBoolean) {
            for (int khCounter = (dskh.size() - 1); khCounter >= 0; khCounter--) {
                if (dskh.get(khCounter).getMaKH().equals(maKH)) {
                    dskh.remove(khCounter);
                }
            }
        }

        return queryBoolean;
    }

    public Boolean update(String maKH, String tenKH, String diaChi, String SDT) {
        Boolean queryBoolean = qlkhDAO.update(maKH, tenKH, diaChi, SDT);

        if (queryBoolean) {
            dskh.forEach((kh) -> {
                if (kh.getMaKH().equals(maKH)) {
                    kh.setTenKH(tenKH);
                    kh.setDiaChi(diaChi);
                    kh.setSDT(SDT);
                }
            });
        }

        return queryBoolean;
    }

    public ArrayList<KhachHang> getDskh() {
        return dskh;
    }
}
