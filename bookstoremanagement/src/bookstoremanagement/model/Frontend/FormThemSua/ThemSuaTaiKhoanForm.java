package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.TaiKhoan.QuanLyTaiKhoanBUS;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import bookstoremanagement.frames.addTK;
import bookstoremanagement.frames.editTK;

public class ThemSuaTaiKhoanForm extends JFrame {

   
    static QuanLyTaiKhoanBUS qltkBUS = new QuanLyTaiKhoanBUS();
   

    public static void btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            String username = addTK.txtTenTK.getText();
            String pass = addTK.txtMatKhau.getText();
            String manv = addTK.txtMaNV.getText();
            String maquyen = addTK.txtMaQuyen.getText();

            if (qltkBUS.add(username, pass, manv, maquyen)) {
                JOptionPane.showMessageDialog(addTK.txtMatKhau, "Thêm " + username + " thành công!");
                
            }
        }
    }

    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String username = editTK.txtTenTK.getText();
            String pass = editTK.txtMatKhau.getText();
            String manv = editTK.txtMaNV.getText();
            String maquyen = editTK.txtMaQuyen.getText();

            if (qltkBUS.update(username, pass, manv, maquyen)) {
                JOptionPane.showMessageDialog(editTK.txtMatKhau, "Sửa " + username + " thành công!");
               
            }
        }
    }

    private static Boolean checkEmptyAdd() {
        String username = addTK.txtTenTK.getText();
        String pass = addTK.txtMatKhau.getText();
        String manv = addTK.txtMaNV.getText();
        String maquyen = addTK.txtMaQuyen.getText();

        if (username.trim().equals("")) {
            return showErrorTx(addTK.txtTenTK, "Tên đăng nhập không được để trống");

        } else if (pass.equals("")) {
            return showErrorTx(addTK.txtMatKhau, "Mật khẩu không được để trống");

        } else if (manv.trim().equals("")) {
            return showErrorTx(addTK.txtMaNV, "Mã nhân viên không được để trống");

        } else if (maquyen.trim().equals("")) {
            return showErrorTx(addTK.txtMaQuyen, "Mã quyền không được để trống");
        }

        return true;
    }

      private static Boolean checkEmptyEdit() {
        String username = editTK.txtTenTK.getText();
        String pass = editTK.txtMatKhau.getText();
        String manv = editTK.txtMaNV.getText();
        String maquyen = editTK.txtMaQuyen.getText();

        if (username.trim().equals("")) {
            return showErrorTx(editTK.txtTenTK, "Tên đăng nhập không được để trống");

        } else if (pass.equals("")) {
            return showErrorTx(editTK.txtMatKhau, "Mật khẩu không được để trống");

        } else if (manv.trim().equals("")) {
            return showErrorTx(editTK.txtMaNV, "Mã nhân viên không được để trống");

        } else if (maquyen.trim().equals("")) {
            return showErrorTx(editTK.txtMaQuyen, "Mã quyền không được để trống");
        }

        return true;
    }
    
    private static Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
