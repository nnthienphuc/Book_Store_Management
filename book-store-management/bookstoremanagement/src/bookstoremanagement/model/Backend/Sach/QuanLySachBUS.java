/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.Sach;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bookstoremanagement.model.Backend.Price.PriceFormat;

/**
 *
 * @author nnthienphuc
 */

public class QuanLySachBUS {
    private ArrayList<Sach> dsSach = new ArrayList<>();
    QuanLySachDAO qlsachDAO = new QuanLySachDAO();

    public QuanLySachBUS() {
        dsSach = qlsachDAO.readDB();
    }
    
    public void showConsole() {
        dsSach.forEach((sach) -> {
            System.out.print(sach.getMaSach() + " ");
            System.out.print(sach.getTenSach() + " ");
            System.out.println(sach.getTheLoai() + " ");
            System.out.println(sach.getTacGia() + " ");
            System.out.println(sach.getNamXB() + " ");
            System.out.println(sach.getSoLuong() + " ");
            System.out.println(sach.getGiaNhap() + " ");
            System.out.println(sach.getGiaBan() + " ");
            System.out.println(sach.getTrangThai());
        });
    }
    
    public void readDB() {
        dsSach = qlsachDAO.readDB();
    }

    public String getNextID() {
        return "MS" + String.valueOf(this.dsSach.size() + 1);
    }

    public Sach getSach(String maSach) {
        for (Sach sach : dsSach) {
            if (sach.getMaSach().equals(maSach)) {
                return sach;
            }
        }

        return null;
    }
    
    public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }

    public static void AddTable(ArrayList<Sach> data,JTable table){
        for (Sach sach : data) {
            AddRowToTable(new Object[]{sach.getMaSach(),
                sach.getTenSach(), 
                sach.getTheLoai(),
                sach.getTacGia(),
                sach.getNamXB(),
                String.valueOf(sach.getSoLuong()),
                PriceFormat.format(sach.getGiaNhap()),
                PriceFormat.format(sach.getGiaBan()),
                String.valueOf((sach.getTrangThai() == 0 ? "Hiện" : "Ẩn"))
                }, table);
        }
    }

    public ArrayList<Sach> search(String value, String type) {
        ArrayList<Sach> result = new ArrayList<>();

        dsSach.forEach((sach) -> {
            if (type.equals("Tất cả")) {
                if (sach.getMaSach().toLowerCase().contains(value.toLowerCase())
                        || sach.getTenSach().toLowerCase().contains(value.toLowerCase())
                        || sach.getTheLoai().toLowerCase().contains(value.toLowerCase())
                        || sach.getTacGia().toLowerCase().contains(value.toLowerCase())
                        || sach.getNamXB().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(sach.getSoLuong()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(sach.getGiaNhap()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(sach.getGiaBan()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf((sach.getTrangThai() == 1 ? "Ẩn" : "Hiện")).toLowerCase().contains(value.toLowerCase()))
                {
                    result.add(sach);
                }
            } else {
                switch (type) {
                    case "Mã sách":
                        if (sach.getMaSach().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sach);
                        }
                        break;
                    case "Tên Sách":
                        if (sach.getTenSach().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sach);
                        }
                        break;
                    case "Thể Loại":
                        if (sach.getTheLoai().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sach);
                        }
                        break;
                    case "Tác Giả":
                        if (sach.getTacGia().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sach);
                        }
                        break;
                    case "Năm XB":
                    if (sach.getNamXB().toLowerCase().contains(value.toLowerCase())) {
                        result.add(sach);
                    }
                    break;
                    case "Số Lượng":
                    if (String.valueOf(sach.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(sach);
                    }
                    break;
                    case "Giá Nhập":
                        if (String.valueOf(sach.getGiaNhap()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sach);
                        }
                        break;
                    case "Giá Bán":
                        if (String.valueOf(sach.getGiaBan()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sach);
                        }
                        break;
                    case "Trạng thái":
                        String tt = (sach.getTrangThai() == 1 ? "Ẩn" : "Hiện");
                        if (String.valueOf(tt).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sach);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        
//        for (int sachCounter = result.size() - 1; sachCounter >= 0; sachCounter--) {
//            Sach sach = result.get(sachCounter);
//            int soLuong = sach.getSoLuong();
//            float giaNhap = sach.getGiaNhap();
//            float giaBan = sach.getGiaBan();
//            Boolean soLuongKhongThoa = (soLuong1 != -1 && soLuong < soLuong1) || (soLuong2 != -1 && soLuong > soLuong2);
//            Boolean giaNhapKhongThoa = (giaNhap1 != -1 && giaNhap < giaNhap1) || (giaNhap2 != -1 && giaNhap > giaNhap2);
//            Boolean giaBanKhongThoa = (giaBan1 != -1 && giaBan < giaBan1) || (giaBan2 != -1 && giaBan > giaBan2);
//
//            if (soLuongKhongThoa || giaNhapKhongThoa || giaBanKhongThoa) {
//                result.remove(sachCounter);
//            }
//        }

        return result;
    }
    
//    public ArrayList<Sach> search(String value, String type, int soLuong1, int soLuong2, float giaNhap1, float giaNhap2, float giaBan1, float giaBan2, int trangThai) {
//        ArrayList<Sach> result = new ArrayList<>();
//
//        dsSach.forEach((sach) -> {
//            if (type.equals("Tất cả")) {
//                if (sach.getMaSach().toLowerCase().contains(value.toLowerCase())
//                        || sach.getTenSach().toLowerCase().contains(value.toLowerCase())
//                        || sach.getTheLoai().toLowerCase().contains(value.toLowerCase())
//                        || sach.getTacGia().toLowerCase().contains(value.toLowerCase())
//                        || sach.getNamXB().toLowerCase().contains(value.toLowerCase())
//                        || String.valueOf(sach.getSoLuong()).toLowerCase().contains(value.toLowerCase())
//                        || String.valueOf(sach.getGiaNhap()).toLowerCase().contains(value.toLowerCase())
//                        || String.valueOf(sach.getGiaBan()).toLowerCase().contains(value.toLowerCase())
//                        || String.valueOf((sach.getTrangThai() == 1 ? "Ẩn" : "Hiện")).toLowerCase().contains(value.toLowerCase()))
//                {
//                    result.add(sach);
//                }
//            } else {
//                switch (type) {
//                    case "Mã sách":
//                        if (sach.getMaSach().toLowerCase().contains(value.toLowerCase())) {
//                            result.add(sach);
//                        }
//                        break;
//                    case "Tên Sách":
//                        if (sach.getTenSach().toLowerCase().contains(value.toLowerCase())) {
//                            result.add(sach);
//                        }
//                        break;
//                    case "Thể Loại":
//                        if (sach.getTheLoai().toLowerCase().contains(value.toLowerCase())) {
//                            result.add(sach);
//                        }
//                        break;
//                    case "Tác Giả":
//                        if (sach.getTacGia().toLowerCase().contains(value.toLowerCase())) {
//                            result.add(sach);
//                        }
//                        break;
//                    case "Năm XB":
//                    if (sach.getNamXB().toLowerCase().contains(value.toLowerCase())) {
//                        result.add(sach);
//                    }
//                    break;
//                    case "Số Lượng":
//                    if (String.valueOf(sach.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
//                        result.add(sach);
//                    }
//                    break;
//                    case "Giá Nhập":
//                        if (String.valueOf(sach.getGiaNhap()).toLowerCase().contains(value.toLowerCase())) {
//                            result.add(sach);
//                        }
//                        break;
//                    case "Giá Bán":
//                        if (String.valueOf(sach.getGiaBan()).toLowerCase().contains(value.toLowerCase())) {
//                            result.add(sach);
//                        }
//                        break;
//                    case "Trạng thái":
//                        String tt = (sach.getTrangThai() == 1 ? "Ẩn" : "Hiện");
//                        if (String.valueOf(tt).toLowerCase().contains(value.toLowerCase())) {
//                            result.add(sach);
//                        }
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
//        
//        for (int sachCounter = result.size() - 1; sachCounter >= 0; sachCounter--) {
//            Sach sach = result.get(sachCounter);
//            int soLuong = sach.getSoLuong();
//            float giaNhap = sach.getGiaNhap();
//            float giaBan = sach.getGiaBan();
//            Boolean soLuongKhongThoa = (soLuong1 != -1 && soLuong < soLuong1) || (soLuong2 != -1 && soLuong > soLuong2);
//            Boolean giaNhapKhongThoa = (giaNhap1 != -1 && giaNhap < giaNhap1) || (giaNhap2 != -1 && giaNhap > giaNhap2);
//            Boolean giaBanKhongThoa = (giaBan1 != -1 && giaBan < giaBan1) || (giaBan2 != -1 && giaBan > giaBan2);
//
//            if (soLuongKhongThoa || giaNhapKhongThoa || giaBanKhongThoa) {
//                result.remove(sachCounter);
//            }
//        }
//
//        return result;
//    }

    public Boolean add(Sach sach) {
        Boolean queryBoolean = qlsachDAO.add(sach);

        if (queryBoolean) {
            dsSach.add(sach);
        }
        return queryBoolean;
    }

    public Boolean add(String maSach, String tenSach, String theLoai, String tacGia, String namXB, int soLuong, float giaNhap, float giaBan, int trangThai) {
        Sach sach = new Sach(maSach, tenSach, theLoai, tacGia, namXB, soLuong, giaNhap, giaBan, trangThai);
        return add(sach);
    }

    public Boolean delete(String maSach) {
        Boolean queryBoolean = qlsachDAO.delete(maSach);

        if (queryBoolean) {
            for (int sachCounter = (dsSach.size() - 1); sachCounter >= 0; sachCounter--) {
                if (dsSach.get(sachCounter).getMaSach().equals(maSach)) {
                    dsSach.remove(sachCounter);
                }
            }
        }
        return queryBoolean;
    }

    public Boolean update(String maSach, String tenSach, String theLoai, String tacGia, String namXB, int soLuong, float giaNhap, float giaBan, int trangThai) {
        Boolean queryBoolean = qlsachDAO.update(maSach, tenSach, theLoai, tacGia, namXB, soLuong, giaNhap, giaBan, trangThai);

        if (queryBoolean) {
            dsSach.forEach((sach) -> {
                if (sach.getMaSach().equals(maSach)) {
                    sach.setTenSach(tenSach);
                    sach.setTheLoai(theLoai);
                    sach.setTacGia(tacGia);
                    sach.setNamXB(namXB);
                    sach.setSoLuong(soLuong);
                    sach.setGiaNhap(giaNhap);
                    sach.setGiaBan(giaBan);
                    sach.setTrangThai(trangThai);
                }
            });
        }

        return queryBoolean;
    }

    public Boolean updateSoLuong(String maSach, int soLuong) {
        Boolean queryBoolean = qlsachDAO.updateSoLuong(maSach, soLuong);

        if (queryBoolean) {
            dsSach.forEach((sach) -> {
                if (sach.getMaSach().equals(maSach)) {
                    sach.setSoLuong(soLuong);
                }
            });
        }

        return queryBoolean;
    }

    public Boolean updateTrangThai(String maSach, int trangThai) {
        Boolean queryBoolean = qlsachDAO.updateTrangThai(maSach, trangThai);

        if (queryBoolean) {
            dsSach.forEach((sach) -> {
                if (sach.getMaSach().equals(maSach)) {
                    sach.setTrangThai(trangThai);
                }
            });
        }

        return queryBoolean;
    }

    public ArrayList<Sach> getDSSach() {
        return dsSach;
    }
}
