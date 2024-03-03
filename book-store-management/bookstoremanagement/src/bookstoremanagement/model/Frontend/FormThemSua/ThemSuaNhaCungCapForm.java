
package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.NhaCungCap.NhaCungCap;
import bookstoremanagement.model.Backend.NhaCungCap.QuanLyNhaCungCapBUS;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class ThemSuaNhaCungCapForm extends JFrame {

    static QuanLyNhaCungCapBUS qlnccBUS = new QuanLyNhaCungCapBUS();


    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String maNCC = editNCC.txMaNCC.getText();
            String tenNCC = editNCC.txTenNCC.getText();
            String diaChi = editNCC.txDiaChi.getText();
            String SDT = editNCC.txSDT.getText();
            String Fax = editNCC.txFax.getText();

            if (qlnccBUS.update(maNCC, tenNCC, diaChi, SDT, Fax)) {
                JOptionPane.showMessageDialog(editNCC.txFax, "Sửa " + maNCC + " thành công!");
                
            }
        }
    }

    public static void btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            NhaCungCap ncc = new NhaCungCap(addNCC.txMaNCC.getText(), addNCC.txTenNCC.getText(), addNCC.txDiaChi.getText(), addNCC.txSDT.getText(), addNCC.txFax.getText());
            if (qlnccBUS.add(ncc)) {
                JOptionPane.showMessageDialog(addNCC.txFax, "Thêm " + addNCC.txTenNCC.getText() + " thành công!");
              
            }
        }
    }

    private static Boolean checkEmptyAdd() {
        String ma = addNCC.txMaNCC.getText();
        String ten = addNCC.txTenNCC.getText();
        String diachi = addNCC.txDiaChi.getText();
        String sdt = addNCC.txSDT.getText();
        String fax = addNCC.txFax.getText();
        if (ma.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp không được để trống");
            addNCC.txMaNCC.requestFocus();
            return false;
        } else if (ten.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không được để trống");
            addNCC.txTenNCC.requestFocus();
            return false;
        } else if (diachi.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Địa chỉ nhà cung cấp không được để trống");
            addNCC.txDiaChi.requestFocus();
            return false;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại nhà cung cấp không được để trống");
            addNCC.txSDT.requestFocus();
            return false;
        } else if (fax.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số fax nhà cung cấp không được để trống");
            addNCC.txFax.requestFocus();
            return false;
        }
        return true;
    }
    
    private static Boolean checkEmptyEdit() {
        String ma = editNCC.txMaNCC.getText();
        String ten = editNCC.txTenNCC.getText();
        String diachi = editNCC.txDiaChi.getText();
        String sdt = editNCC.txSDT.getText();
        String fax = editNCC.txFax.getText();
        if (ma.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp không được để trống");
            editNCC.txMaNCC.requestFocus();
            return false;
        } else if (ten.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không được để trống");
            editNCC.txTenNCC.requestFocus();
            return false;
        } else if (diachi.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Địa chỉ nhà cung cấp không được để trống");
            editNCC.txDiaChi.requestFocus();
            return false;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại nhà cung cấp không được để trống");
            editNCC.txSDT.requestFocus();
            return false;
        } else if (fax.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Số fax nhà cung cấp không được để trống");
            editNCC.txFax.requestFocus();
            return false;
        }
        return true;
    }
}
