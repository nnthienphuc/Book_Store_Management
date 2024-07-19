
package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.HoaDonNhap.QuanLyHoaDonNhapBUS;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ThemSuaHoaDonNhapForm extends JFrame{
     QuanLyHoaDonNhapBUS qlpnBUS = new QuanLyHoaDonNhapBUS();
  
    

//    private void btnThemMouseClicked() {
//        if (checkEmpty()) {
//            String mapn = addForm.txtMaPN.getText();
//            String mancc = addForm.txtMaNCC.getText();
//            String manv = addForm.txtMaNV.getText();
//            LocalDate ngayNhap = java.time.LocalDate.now();
//            LocalTime gioNhap = java.time.LocalTime.now();
//            float tongTien = 0;
//
//            this.addForm.txtNgayNhap.setText(String.valueOf(ngayNhap));
//            this.addForm.txtGioNhap.setText(String.valueOf(gioNhap));
//            this.addForm.txtTongTien.setText(String.valueOf(tongTien));
//
//            if (qlpnBUS.add(mapn, mancc, manv, ngayNhap, gioNhap, tongTien)) {
//                JOptionPane.showMessageDialog(this, "Thêm phiếu nhập " + mapn + " thành công!");
//                this.dispose();
//            }
//        }
//    }
//
//    private void btnSuaMouseClicked() {
//        if (checkEmpty()) {
//            String mapn = addForm.txtMaPN.getText();
//            String mancc = addForm.txtMaNCC.getText();
//            String manv = addForm.txtMaNV.getText();
//            LocalDate ngayNhap = java.time.LocalDate.parse(addForm.txtNgayNhap.getText());
//            LocalTime gioNhap = java.time.LocalTime.parse(addForm.txtGioNhap.getText());
//            float tongTien = Float.parseFloat(addForm.txtTongTien.getText());
//
//            if (qlpnBUS.update(mapn, mancc, manv, ngayNhap, gioNhap, tongTien)) {
//                JOptionPane.showMessageDialog(this, "Sửa " + mapn + " thành công!");
//                this.dispose();
//            }
//        }
//    }
//    private Boolean checkEmpty() {
//        String mapn = addForm.txtMaPN.getText();
//        String mancc = addForm.txtMaNCC.getText();
//        String maNV = addForm.txtMaNV.getText();
//        String ngayNhap = addForm.txtNgayNhap.getText();
//        String gioNhap = addForm.txtGioNhap.getText();
//
//        if (mapn.trim().equals("")) {
//            return showErrorTx(addForm.xtMaPN, "Mã phiếu nhập không được để trống");
//
//        } else if (mancc.trim().equals("")) {
//            return showErrorTx(addForm.txtMaNCC, "Mã phiếu nhập không được để trống");
//
//        } else if (maNV.trim().equals("")) {
//            return showErrorTx(addForm.txtMaNV, "Mã phiếu nhập không được để trống");
//
//        } else if (ngayNhap.trim().equals("")) {
//            return showErrorTx(addForm.txtNgayNhap, "Ngày nhập không được để trống");
//
//        } else if (gioNhap.trim().equals("")) {
//            return showErrorTx(addForm.txtGioNhap, "Giờ nhập không được để trống");
//
//        } else {
//            try {
//                LocalDate ngay = java.time.LocalDate.parse(ngayNhap);
//            } catch (DateTimeParseException e) {
//                return showErrorTx(addForm.txtNgayNhap, "Ngày lập không hợp lệ yyyy-mm-dd ( ví dụ: 2018-12-31)");
//            }
//
//            try {
//                LocalTime gio = java.time.LocalTime.parse(gioNhap);
//            } catch (DateTimeParseException e) {
//                return showErrorTx(addForm.txtGioNhap, "Giờ lập không hợp lệ hh:mm (ví dụ: 18:25)");
//            }
//        }
//        return true;
//    }
//
//    private Boolean showErrorTx(JTextField tx, String errorInfo) {
//        JOptionPane.showMessageDialog(tx, errorInfo);
//        tx.requestFocus();
//        return false;
//    }
}
