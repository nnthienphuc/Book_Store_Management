
package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.KhuyenMai.QuanLyKhuyenMaiBUS;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import bookstoremanagement.frames.addKM;
import bookstoremanagement.frames.editKM;


public class ThemSuaKhuyenMaiForm extends JFrame{
    static QuanLyKhuyenMaiBUS qlkhBUS = new QuanLyKhuyenMaiBUS();
    
    public static boolean btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            String makm = addKM.txtMaKM.getText();
            String tenkm = addKM.txtTenKM.getText();
            float dieukien = Float.parseFloat(addKM.txtDieuKienKM.getText());
            float phantram = Float.parseFloat(addKM.txtPhanTramKM.getText());
            LocalDate ngaybd = LocalDate.parse(addKM.txtNgayBD.getText());
            LocalDate ngaykt = LocalDate.parse(addKM.txtNgayKT.getText());

            if (qlkhBUS.add(makm, tenkm, dieukien, phantram, ngaybd, ngaykt)) {
                JOptionPane.showMessageDialog(addKM.txtNgayBD, "Thêm " + tenkm + " thành công!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String makm = editKM.txtMaKM.getText();
            String tenkm = editKM.txtTenKM.getText();
            float dieukien = Float.parseFloat(editKM.txtDieuKienKM.getText());
            float phantram = Float.parseFloat(editKM.txtPhanTramKM.getText());
            LocalDate ngaybd = LocalDate.parse(editKM.txtNgayBD.getText());
            LocalDate ngaykt = LocalDate.parse(editKM.txtNgayKT.getText());

            if (qlkhBUS.update(makm, tenkm, dieukien, phantram, ngaybd, ngaykt)) {
                JOptionPane.showMessageDialog(editKM.txtNgayBD, "Sửa " + makm + " thành công!");
                return true;
            }
        }
        return false;
    }

    private static Boolean checkEmptyAdd() {
        String makm = addKM.txtMaKM.getText();
        String tenkm = addKM.txtTenKM.getText();
        String dieukien = addKM.txtDieuKienKM.getText();
        String phantram = addKM.txtPhanTramKM.getText();
        String ngaybd = addKM.txtNgayBD.getText();
        String ngaykt = addKM.txtNgayKT.getText();

        if (makm.trim().equals("")) {
            return showErrorTx(addKM.txtMaKM, "Mã khuyến mãi không được để trống");

        } else if (tenkm.trim().equals("")) {
            return showErrorTx(addKM.txtTenKM, "Tên khuyến mãi không được để trống");

        } else if (dieukien.trim().equals("")) {
            return showErrorTx(addKM.txtTenKM, "Điều kiện khuyến mãi không được để trống");

        } else if (phantram.trim().equals("")) {
            return showErrorTx(addKM.txtTenKM, "Phần trăm khuyến mãi không được để trống");

        }
        else if (LocalDate.parse(ngaykt).isBefore(LocalDate.parse(ngaybd))) {
            return showErrorTx(addKM.txtTenKM, "Ngày kết thúc không được trước ngày bắt đầu");

        } else {
            try {
                Float.parseFloat(dieukien);
            } catch (NumberFormatException e) {
                return showErrorTx(addKM.txtDieuKienKM, "Điều kiện khuyến mãi là giá hóa đơn tối thiểu để được khuyến mãi, phải là số thực");
            }
            try {
                float fPhanTram = Float.parseFloat(phantram);
                if (fPhanTram > 100) {
                    return showErrorTx(addKM.txtPhanTramKM, "Phần trăm khuyến mãi phải là số thực < 100 (%)");
                }
            } catch (NumberFormatException e) {
                return showErrorTx(addKM.txtPhanTramKM, "Phần trăm khuyến mãi phải là số thực");
            }
            try {
                LocalDate.parse(ngaybd);
            } catch (Exception e) {
                return showErrorTx(addKM.txtNgayBD, "Ngày bắt đầu không hợp lệ");
            }
            try {
                LocalDate.parse(ngaykt);
            } catch (Exception e) {
                return showErrorTx(addKM.txtNgayKT, "Ngày kết thúc không hợp lệ");
            }
        }

        return true;
    }
    
    private static Boolean checkEmptyEdit() {
        String makm = editKM.txtMaKM.getText();
        String tenkm = editKM.txtTenKM.getText();
        String dieukien = editKM.txtDieuKienKM.getText();
        String phantram = editKM.txtPhanTramKM.getText();
        String ngaybd = editKM.txtNgayBD.getText();
        String ngaykt = editKM.txtNgayKT.getText();

        if (makm.trim().equals("")) {
            return showErrorTx(editKM.txtMaKM, "Mã khuyến mãi không được để trống");

        } else if (tenkm.trim().equals("")) {
            return showErrorTx(editKM.txtTenKM, "Tên khuyến mãi không được để trống");

        } else if (dieukien.trim().equals("")) {
            return showErrorTx(editKM.txtTenKM, "Điều kiện khuyến mãi không được để trống");

        } else if (phantram.trim().equals("")) {
            return showErrorTx(editKM.txtTenKM, "Phần trăm khuyến mãi không được để trống");

        } 
        else if (LocalDate.parse(ngaykt).isBefore(LocalDate.parse(ngaybd))) {
            return showErrorTx(editKM.txtTenKM, "Ngày kết thúc không được trước ngày bắt đầu");

        } 
        else {
            try {
                Float.parseFloat(dieukien);
            } catch (NumberFormatException e) {
                return showErrorTx(editKM.txtDieuKienKM, "Điều kiện khuyến mãi là giá hóa đơn tối thiểu để được khuyến mãi, phải là số thực");
            }
            try {
                float fPhanTram = Float.parseFloat(phantram);
                if (fPhanTram > 100) {
                    return showErrorTx(editKM.txtPhanTramKM, "Phần trăm khuyến mãi phải là số thực < 100 (%)");
                }
            } catch (NumberFormatException e) {
                return showErrorTx(editKM.txtPhanTramKM, "Phần trăm khuyến mãi phải là số thực");
            }
            try {
                LocalDate.parse(ngaybd);
            } catch (Exception e) {
                return showErrorTx(editKM.txtNgayBD, "Ngày bắt đầu không hợp lệ");
            }
            try {
                LocalDate.parse(ngaykt);
            } catch (Exception e) {
                return showErrorTx(editKM.txtNgayKT, "Ngày kết thúc không hợp lệ");
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
