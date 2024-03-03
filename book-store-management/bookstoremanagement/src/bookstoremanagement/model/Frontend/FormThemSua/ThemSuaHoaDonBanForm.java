
package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.HoaDonBan.QuanLyHoaDonBanBUS;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ThemSuaHoaDonBanForm extends JFrame{
    QuanLyHoaDonBanBUS qlhdBUS = new QuanLyHoaDonBanBUS();
 
   

//    private void btnThemMouseClicked() {
//        if (checkEmpty()) {
//            String mahd = addForm.txtMaHd.getText();
//            String manv = addForm.txtMaNv.getText();
//            String makh = addForm.txtMaKh.getText();
//            String makm = addForm.txtMaKm.getText();
//            LocalDate ngayLap = LocalDate.now();
//            LocalTime gioLap = LocalTime.now();
//            float tongTien = 0;
//
//            this.addForm.txtNgayLap.setText(String.valueOf(ngayLap));
//            this.addForm.txtGioLap.setText(String.valueOf(gioLap));
//            this.addForm.txtTongTien.setText(String.valueOf(tongTien));
//
//            if (qlhdBUS.add(mahd, manv, makh, makm, ngayLap, gioLap, tongTien)) {
//                JOptionPane.showMessageDialog(this, "Thêm hóa đơn " + mahd + " thành công!");
//                this.dispose();
//            }
//        }
//    }

//    private void btnSuaMouseClicked() {
//        if (checkEmpty()) {
//            String mahd = addForm.txtMaHd.getText();
//            String manv = addForm.txtMaNv.getText();
//            String makh = addForm.txtMaKh.getText();
//            String makm = addForm.txtMaKm.getText();
//            System.out.println(makm);
//            LocalDate ngayLap = java.time.LocalDate.parse(addForm.txtNgayLap.getText());
//            LocalTime gioLap = java.time.LocalTime.parse(addForm.txtGioLap.getText());
//            float tongTien = Float.parseFloat(addForm.txtTongTien.getText());
//
//            if (qlhdBUS.update(mahd, manv, makh, makm, ngayLap, gioLap, tongTien)) {
//                JOptionPane.showMessageDialog(this, "Sửa " + mahd + " thành công!");
//                this.dispose();
//            }
//        }
//    }
//
//    
//    private Boolean checkEmpty() {
//        String mahd = addForm.txtMaHd.getText();
//        String manv = addForm.xtMaNv.getText();
//        String makh = addForm.txtMaKh.getText();
//        String makm = addForm.txtMaKm.getText();
//        String ngayLap = addForm.txtNgayLap.getText();
//        String gioLap = addForm.txtGioLap.getText();
//
//        if (mahd.trim().equals("")) {
//            return showErrorTx(addForm.txtMaHd, "Mã hóa đơn không được để trống");
//
//        } else if (manv.trim().equals("")) {
//            return showErrorTx(addForm.txtMaNv, "Mã nhân viên không được để trống");
//
//        } else if (makh.trim().equals("")) {
//            return showErrorTx(addForm.txtMaKh, "Mã khách hàng không được để trống");
//
//        } else if (makm.trim().equals("")) {
//            return showErrorTx(addForm.txtMaKh, "Mã khuyến mãi không được để trống");
//
//        } else if (ngayLap.trim().equals("")) {
//            return showErrorTx(addForm.txtNgayLap, "Ngày lập không được để trống");
//
//        } else if (gioLap.trim().equals("")) {
//            return showErrorTx(addForm.txtGioLap, "Giờ lập không được để trống");
//
//        } else {
//            try {
//                LocalDate ngay = java.time.LocalDate.parse(ngayLap);
//            } catch (DateTimeParseException e) {
//                return showErrorTx(addForm.txtNgayLap, "Ngày lập không hợp lệ yyyy-mm-dd ( ví dụ: 2018-12-31)");
//            }
//
//            try {
//                LocalTime gio = java.time.LocalTime.parse(gioLap);
//            } catch (DateTimeParseException e) {
//                return showErrorTx(addForm.txtGioLap, "Giờ lập không hợp lệ hh:mm (ví dụ: 18:25)");
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
