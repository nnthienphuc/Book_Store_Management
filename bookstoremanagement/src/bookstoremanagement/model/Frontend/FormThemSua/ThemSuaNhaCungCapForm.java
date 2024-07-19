package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.frames.editNCC;
import bookstoremanagement.frames.addNCC;
import bookstoremanagement.model.Backend.NhaCungCap.NhaCungCap;
import bookstoremanagement.model.Backend.NhaCungCap.QuanLyNhaCungCapBUS;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThemSuaNhaCungCapForm extends JFrame {

    static QuanLyNhaCungCapBUS qlnccBUS = new QuanLyNhaCungCapBUS();

    public static boolean btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String maNCC = editNCC.txtMaNCC.getText();
            String tenNCC = editNCC.txtTenNCC.getText();
            String diaChi = editNCC.txtDiaChi.getText();
            String SDT = editNCC.txtSDT.getText();
            String Fax = editNCC.txtFax.getText();

            if (qlnccBUS.update(maNCC, tenNCC, diaChi, SDT, Fax)) {
                JOptionPane.showMessageDialog(editNCC.txtFax, "Sửa " + maNCC + " thành công!");
                return true;
            }
        }
        return false;
    }

    public static boolean btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            NhaCungCap ncc = new NhaCungCap(addNCC.txMaNCC.getText(), addNCC.txtTenNCC.getText(), addNCC.txtDiaChi.getText(), addNCC.txtSDT.getText(), addNCC.txtFax.getText());
            if (qlnccBUS.add(ncc)) {

                JOptionPane.showMessageDialog(addNCC.txtFax, "Thêm " + addNCC.txtTenNCC.getText() + " thành công!");
                return true;
            }

        }
        return false;
    }

    private static Boolean checkEmptyAdd() {
        String ma = addNCC.txMaNCC.getText();
        String ten = addNCC.txtTenNCC.getText();
        String diachi = addNCC.txtDiaChi.getText();
        String sdt = addNCC.txtSDT.getText();
        String fax = addNCC.txtFax.getText();
        if (ma.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp không được để trống");
            addNCC.txMaNCC.requestFocus();
            return false;
        } else if (ten.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không được để trống");
            addNCC.txtTenNCC.requestFocus();
            return false;
        } else if (diachi.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Địa chỉ nhà cung cấp không được để trống");
            addNCC.txtDiaChi.requestFocus();
            return false;

        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại nhà cung cấp không được để trống");
            addNCC.txtSDT.requestFocus();
            return false;

        } else if (!sdt.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Chuỗi SDT không hợp lệ.");
            addNCC.txtSDT.requestFocus();
            return false;

        } else if (sdt.trim().length() != 10 || sdt.trim().charAt(0) != '0') {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải có đúng 10 ký tự và kí tự đầu tiên phải là số 0");
            editNCC.txtSDT.requestFocus();
            return false;
        } else if (fax.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số fax nhà cung cấp không được để trống");
            addNCC.txtFax.requestFocus();
            return false;
        } else if (!fax.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Chuỗi fax không hợp lệ.");
            addNCC.txtFax.requestFocus();
            return false;
        } else if (fax.length() != 19) {
            System.out.println(sdt.length());
            JOptionPane.showMessageDialog(null, "Số fax cung cấp phải có 19 ký tự");
            editNCC.txtFax.requestFocus();
            return false;
        }
        return true;

    }

    private static Boolean checkEmptyEdit() {
        String ma = editNCC.txtMaNCC.getText();
        String ten = editNCC.txtTenNCC.getText();
        String diachi = editNCC.txtDiaChi.getText();
        String sdt = editNCC.txtSDT.getText();
        String fax = editNCC.txtFax.getText();
        if (ma.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp không được để trống");
            editNCC.txtMaNCC.requestFocus();
            return false;
        } else if (ten.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không được để trống");
            editNCC.txtTenNCC.requestFocus();
            return false;
        } else if (diachi.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Địa chỉ nhà cung cấp không được để trống");
            editNCC.txtDiaChi.requestFocus();
            return false;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại nhà cung cấp không được để trống");
            editNCC.txtSDT.requestFocus();
            return false;

        } else if (!sdt.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Chuỗi SDT không hợp lệ.");
            addNCC.txtSDT.requestFocus();
            return false;

        } else if (sdt.trim().length() != 10 || sdt.trim().charAt(0) != '0') {
            JOptionPane.showMessageDialog(null,"Số điện thoại phải có đúng 10 ký tự và kí tự đầu tiên phải là số 0");
            editNCC.txtSDT.requestFocus();
            return false;
        } else if (fax.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số fax nhà cung cấp không được để trống");
            editNCC.txtFax.requestFocus();
            return false;
        } else if (!fax.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Chuỗi fax không hợp lệ.");
            addNCC.txtFax.requestFocus();
            return false;
        } else if (fax.length() != 19) {
            System.out.println(sdt.length());
            JOptionPane.showMessageDialog(null, "Số fax cung cấp phải có 19 ký tự");
            editNCC.txtFax.requestFocus();
            return false;
        }
        return true;
    }
}
