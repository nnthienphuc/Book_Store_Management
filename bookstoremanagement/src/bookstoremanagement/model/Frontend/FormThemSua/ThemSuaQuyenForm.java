package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.Quyen.QuanLyQuyenBUS;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import bookstoremanagement.frames.addQuyen;
import bookstoremanagement.frames.editQuyen;

public class ThemSuaQuyenForm extends JFrame {

    
    static QuanLyQuyenBUS qlqBUS = new QuanLyQuyenBUS();
   

    public static void btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            String maquyen = addQuyen.txMaQuyen.getText();
            String tenquyen = addQuyen.txTenQuyen.getText();
            String chitietquyen = addQuyen.ChiTietQuyen();

            if (qlqBUS.add(maquyen, tenquyen, chitietquyen)) {
                JOptionPane.showMessageDialog(addQuyen.txMaQuyen, "Thêm " + maquyen + " thành công!");
              
            }
        }
    }

    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String maquyen = editQuyen.txMaQuyen.getText();
            String tenquyen = editQuyen.txTenQuyen.getText();
            String chitietquyen = editQuyen.ChiTietQuyen();
            System.out.println(chitietquyen);

            if (qlqBUS.update(maquyen, tenquyen, chitietquyen)) {
                JOptionPane.showMessageDialog(editQuyen.txMaQuyen, "Sửa " + maquyen + " thành công!");
               
            }
        }
    }

    private static Boolean checkEmptyAdd() {
        String maquyen = addQuyen.txMaQuyen.getText();
        String tenquyen = addQuyen.txTenQuyen.getText();
        String chitietquyen = addQuyen.ChiTietQuyen();

        if (maquyen.trim().equals("")) {
            return showErrorTx(addQuyen.txMaQuyen, "Mã quyền không được để trống");

        } else if (tenquyen.trim().equals("")) {
            return showErrorTx(addQuyen.txMaQuyen, "Tên quyền không được để trống");

        } else if (chitietquyen.trim().equals("")) {
            return showErrorTx(addQuyen.txMaQuyen, "Bạn chưa chọn quyền nào cả !!");
        }

        return true;
    }
    
      private static Boolean checkEmptyEdit() {
        String maquyen = editQuyen.txMaQuyen.getText();
        String tenquyen = editQuyen.txTenQuyen.getText();
        String chitietquyen = editQuyen.ChiTietQuyen();

        if (maquyen.trim().equals("")) {
            return showErrorTx(editQuyen.txMaQuyen, "Mã quyền không được để trống");

        } else if (tenquyen.trim().equals("")) {
            return showErrorTx(editQuyen.txMaQuyen, "Tên quyền không được để trống");

        } else if (chitietquyen.trim().equals("")) {
            return showErrorTx(editQuyen.txMaQuyen, "Bạn chưa chọn quyền nào cả !!");
        }

        return true;
    }

    private static Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}



   
