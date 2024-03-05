package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.NhanVien.QuanLyNhanVienBUS;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import bookstoremanagement.frames.addNV;
import bookstoremanagement.frames.editNV;

public class ThemSuaNhanVienForm extends JFrame {

    
    static QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
   
   
       
    
    public static void btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            String manv = addNV.txMaNV.getText();
            String tennv = addNV.txTenNV.getText();
            LocalDate ngaysinh = LocalDate.parse(addNV.txNgaySinh.getText());
            String diachi = addNV.txDiaChi.getText();
            String sdt = addNV.txSDT.getText();
            int trangthai = (addNV.cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);

            if (qlnvBUS.add(manv, tennv, ngaysinh, diachi, sdt, trangthai)) {
                JOptionPane.showMessageDialog(addNV.txSDT, "Thêm " + tennv + " thành công!");
                
            }
        }
    }

    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String manv = editNV.txMaNV.getText();
            String tennv = editNV.txTenNV.getText();
            LocalDate ngaysinh = LocalDate.parse(editNV.txNgaySinh.getText());
            String diachi = editNV.txDiaChi.getText();
            String sdt = editNV.txSDT.getText();
            int trangthai = (editNV.cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);

            if (qlnvBUS.update(manv, tennv, ngaysinh, diachi, sdt, trangthai)) {
                JOptionPane.showMessageDialog(editNV.txSDT, "Sửa " + manv + " thành công!");
                
            }
        }
    }

    private static Boolean checkEmptyAdd() {
        String manv = addNV.txMaNV.getText();
        String tennv = addNV.txTenNV.getText();
        String ngaysinh = addNV.txNgaySinh.getText();
        String diachi = addNV.txDiaChi.getText();
        String sdt = addNV.txSDT.getText();

        if (manv.trim().equals("")) {
            return showErrorTx(addNV.txMaNV, "Mã nhân viên không được để trống");

        } else if (tennv.trim().equals("")) {
            return showErrorTx(addNV.txTenNV, "Tên nhân viên không được để trống");

        } else if (ngaysinh.trim().equals("")) {
            return showErrorTx(addNV.txTenNV, "Ngày sinh không được để trống");

        } else if (diachi.trim().equals("")) {
            return showErrorTx(addNV.txTenNV, "Địa chỉ không được để trống");

        } else if (sdt.trim().equals("")) {
            return showErrorTx(addNV.txTenNV, "Số điện thoại không được để trống");

        } else {
            try {
                LocalDate.parse(ngaysinh);
            } catch (Exception e) {
                return showErrorTx(addNV.txTenNV, "Ngày sinh không hợp lệ");
            }
        }

        return true;
    }

    private static Boolean checkEmptyEdit() {
        String manv = editNV.txMaNV.getText();
        String tennv = editNV.txTenNV.getText();
        String ngaysinh = editNV.txNgaySinh.getText();
        String diachi = editNV.txDiaChi.getText();
        String sdt = editNV.txSDT.getText();

        if (manv.trim().equals("")) {
            return showErrorTx(editNV.txMaNV, "Mã nhân viên không được để trống");

        } else if (tennv.trim().equals("")) {
            return showErrorTx(editNV.txTenNV, "Tên nhân viên không được để trống");

        } else if (ngaysinh.trim().equals("")) {
            return showErrorTx(editNV.txTenNV, "Ngày sinh không được để trống");

        } else if (diachi.trim().equals("")) {
            return showErrorTx(editNV.txTenNV, "Địa chỉ không được để trống");

        } else if (sdt.trim().equals("")) {
            return showErrorTx(editNV.txTenNV, "Số điện thoại không được để trống");

        } else {
            try {
                LocalDate.parse(ngaysinh);
            } catch (Exception e) {
                return showErrorTx(editNV.txTenNV, "Ngày sinh không hợp lệ");
            }
        }

        return true;
    }

    
    private static Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
