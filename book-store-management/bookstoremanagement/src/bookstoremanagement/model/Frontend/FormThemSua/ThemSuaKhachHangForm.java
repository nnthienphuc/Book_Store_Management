package bookstoremanagement.model.Frontend.FormThemSua;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import bookstoremanagement.frames.addKH;
import bookstoremanagement.frames.editKH;
import bookstoremanagement.model.Backend.KhachHang.QuanLyKhachHangBUS;

public class ThemSuaKhachHangForm extends JFrame {

    static QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();

    public static void btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            String makh = addKH.txtMaKH.getText();
            String tenkh = addKH.txtTenKH.getText();
            String diachi = addKH.txtDiaChi.getText();
            String sdt = addKH.txtSDT.getText();
            if (qlkhBUS.add(makh, tenkh, diachi, sdt)) {
                JOptionPane.showMessageDialog(null, "Thêm " + tenkh + " thành công!");

            }
        }
    }

    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String makh = editKH.txtMaKH.getText();
            String tenkh = editKH.txtTenKH.getText();
            String diachi = editKH.txtDiaChi.getText();
            String sdt = editKH.txtSDT.getText();

            if (qlkhBUS.update(makh, tenkh, diachi, sdt)) {
                JOptionPane.showMessageDialog(null, "Sửa " + makh + " thành công!");

            }
        }
    }

    private static Boolean checkEmptyAdd() {
        String makh = addKH.txtMaKH.getText();
        String tenkh = addKH.txtTenKH.getText();
        String diachi = addKH.txtDiaChi.getText();
        String sdt = addKH.txtSDT.getText();

        if (makh.trim().equals("")) {
            return showErrorTx(addKH.txtMaKH, "Mã khách hàng không được để trống");

        } else if (tenkh.trim().equals("")) {
            return showErrorTx(addKH.txtTenKH, "Tên khách hàng không được để trống");

        } else if (diachi.trim().equals("")) {
            return showErrorTx(addKH.txtDiaChi, "Địa chỉ không được để trống");

        } else if (sdt.trim().equals("")) {
            return showErrorTx(addKH.txtSDT, "Số điện thoại không được để trống");
        } else if (sdt.trim().length() != 10 || sdt.trim().charAt(0) != '0') {
            return showErrorTx(editKH.txtSDT, "Số điện thoại phải có đúng 10 ký tự và kí tự đầu tiên phải là số 0");
        }

        return true;
    }

    private static Boolean checkEmptyEdit() {
        String makh = editKH.txtTenKH.getText();
        String tenkh = editKH.txtTenKH.getText();
        String diachi = editKH.txtDiaChi.getText();
        String sdt = editKH.txtSDT.getText();

        if (makh.trim().equals("")) {
            return showErrorTx(editKH.txtTenKH, "Mã khách hàng không được để trống");

        } else if (tenkh.trim().equals("")) {
            return showErrorTx(editKH.txtTenKH, "Tên khách hàng không được để trống");

        } else if (diachi.trim().equals("")) {
            return showErrorTx(editKH.txtDiaChi, "Địa chỉ không được để trống");

        } else if (sdt.trim().length() != 10 || sdt.trim().charAt(0) != '0') {
            return showErrorTx(editKH.txtSDT, "Số điện thoại phải có đúng 10 ký tự và kí tự đầu tiên phải là số 0");
        }

        return true;
    }

    private static Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
