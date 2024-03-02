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
            String username = addTK.txUsername.getText();
            String pass = addTK.txPassword.getText();
            String manv = addTK.txMaNV.getText();
            String maquyen = addTK.txMaQuyen.getText();

            if (qltkBUS.add(username, pass, manv, maquyen)) {
                JOptionPane.showMessageDialog(addTK.txPassword, "Thêm " + username + " thành công!");
                
            }
        }
    }

    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String username = editTK.txUsername.getText();
            String pass = editTK.txPassword.getText();
            String manv = editTK.txMaNV.getText();
            String maquyen = editTK.txMaQuyen.getText();

            if (qltkBUS.update(username, pass, manv, maquyen)) {
                JOptionPane.showMessageDialog(editTK.txPassword, "Sửa " + username + " thành công!");
               
            }
        }
    }

    private static Boolean checkEmptyAdd() {
        String username = addTK.txUsername.getText();
        String pass = addTK.txPassword.getText();
        String manv = addTK.txMaNV.getText();
        String maquyen = addTK.txMaQuyen.getText();

        if (username.trim().equals("")) {
            return showErrorTx(addTK.txUsername, "Tên đăng nhập không được để trống");

        } else if (pass.equals("")) {
            return showErrorTx(addTK.txPassword, "Mật khẩu không được để trống");

        } else if (manv.trim().equals("")) {
            return showErrorTx(addTK.txMaNV, "Mã nhân viên không được để trống");

        } else if (maquyen.trim().equals("")) {
            return showErrorTx(addTK.txMaQuyen, "Mã quyền không được để trống");
        }

        return true;
    }

      private static Boolean checkEmptyEdit() {
        String username = editTK.txUsername.getText();
        String pass = editTK.txPassword.getText();
        String manv = editTK.txMaNV.getText();
        String maquyen = editTK.txMaQuyen.getText();

        if (username.trim().equals("")) {
            return showErrorTx(editTK.txUsername, "Tên đăng nhập không được để trống");

        } else if (pass.equals("")) {
            return showErrorTx(editTK.txPassword, "Mật khẩu không được để trống");

        } else if (manv.trim().equals("")) {
            return showErrorTx(editTK.txMaNV, "Mã nhân viên không được để trống");

        } else if (maquyen.trim().equals("")) {
            return showErrorTx(editTK.txMaQuyen, "Mã quyền không được để trống");
        }

        return true;
    }
    
    private static Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
