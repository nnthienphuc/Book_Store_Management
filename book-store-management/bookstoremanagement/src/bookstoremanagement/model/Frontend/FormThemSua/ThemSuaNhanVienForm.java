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
   
   
       
    
    public static boolean btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            String manv = addNV.txMaNV.getText();
            String tennv = addNV.txTenNV.getText();
            LocalDate ngaysinh = LocalDate.parse(addNV.txNgaySinh.getText());
            String diachi = addNV.txDiaChi.getText();
            String sdt = addNV.txSDT.getText();
            int trangthai = (addNV.cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);

            if (qlnvBUS.add(manv, tennv, ngaysinh, diachi, sdt, trangthai)) {
                JOptionPane.showMessageDialog(addNV.txSDT, "Thêm " + tennv + " thành công!");
                return true;
                
            }
        }
        return false;
    }

    public static boolean btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String manv = editNV.txMaNV.getText();
            String tennv = editNV.txTenNV.getText();
            LocalDate ngaysinh = LocalDate.parse(editNV.txNgaySinh.getText());
            String diachi = editNV.txDiaChi.getText();
            String sdt = editNV.txSDT.getText();
            int trangthai = (editNV.cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);

            if (qlnvBUS.update(manv, tennv, ngaysinh, diachi, sdt, trangthai)) {
                JOptionPane.showMessageDialog(editNV.txSDT, "Sửa " + manv + " thành công!");
                return true;
                
            }
        }
        return false;
    }

    private static Boolean checkEmptyAdd() {
        String manv = addNV.txMaNV.getText();
        String tennv = addNV.txTenNV.getText();
        String ngaysinh = addNV.txNgaySinh.getText();
        String diachi = addNV.txDiaChi.getText();
        String sdt = addNV.txSDT.getText();

        if (manv.trim().equals("")) {
            JOptionPane.showMessageDialog(addNV.txMaNV, "Mã nhân viên không được để trống");
            return false;

        } else if (tennv.trim().equals("")) {
            JOptionPane.showMessageDialog(addNV.txTenNV, "Tên nhân viên không được để trống");
            return false;
        } else if (ngaysinh.trim().equals("")) {
            JOptionPane.showMessageDialog(addNV.txTenNV, "Ngày sinh không được để trống");
            return false;
        } else if (diachi.trim().equals("")) {
            JOptionPane.showMessageDialog(addNV.txTenNV, "Địa chỉ không được để trống");
            return false;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(addNV.txTenNV, "Số điện thoại không được để trống");
            return false;
        } else if (sdt.length() != 10 || !(sdt.matches("\\d+"))) {
            JOptionPane.showMessageDialog(addNV.txSDT, "SĐT không hợp lệ");
            return false;
        } else {
            try {
                LocalDate.parse(ngaysinh);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(addNV.txTenNV, "Ngày sinh không hợp lệ");
                return false;
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
            JOptionPane.showMessageDialog(editNV.txMaNV, "Mã nhân viên không được để trống");
            return false;

        } else if (tennv.trim().equals("")) {
            JOptionPane.showMessageDialog(editNV.txTenNV, "Tên nhân viên không được để trống");
            return false;
        } else if (ngaysinh.trim().equals("")) {
            JOptionPane.showMessageDialog(editNV.txTenNV, "Ngày sinh không được để trống");
            return false;
        } else if (diachi.trim().equals("")) {
            JOptionPane.showMessageDialog(editNV.txTenNV, "Địa chỉ không được để trống");
            return false;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(editNV.txTenNV, "Số điện thoại không được để trống");
            return false;
        } else if (sdt.length() != 10 || !(sdt.matches("\\d+"))) {
            JOptionPane.showMessageDialog(editNV.txSDT, "SĐT không hợp lệ");
            return false;
        }
        
        else {
            try {
                LocalDate.parse(ngaysinh);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(editNV.txTenNV, "Ngày sinh không hợp lệ");
                return false;
            }
        }

        return true;
    }

    
}
