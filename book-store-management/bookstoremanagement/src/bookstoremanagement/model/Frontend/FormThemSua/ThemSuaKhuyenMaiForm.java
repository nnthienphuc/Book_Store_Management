
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
    
    public static void btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            String makm = addKM.txMaKM.getText();
            String tenkm = addKM.txTenKM.getText();
            float dieukien = Float.parseFloat(addKM.txDieuKienKM.getText());
            float phantram = Float.parseFloat(addKM.txPhanTramKM.getText());
            LocalDate ngaybd = LocalDate.parse(addKM.txNgayBD.getText());
            LocalDate ngaykt = LocalDate.parse(addKM.txNgayKT.getText());

            if (qlkhBUS.add(makm, tenkm, dieukien, phantram, ngaybd, ngaykt)) {
                JOptionPane.showMessageDialog(addKM.txNgayBD, "Thêm " + tenkm + " thành công!");
                
            }
        }
    }
    
    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String makm = editKM.txMaKM.getText();
            String tenkm = editKM.txTenKM.getText();
            float dieukien = Float.parseFloat(editKM.txDieuKienKM.getText());
            float phantram = Float.parseFloat(editKM.txPhanTramKM.getText());
            LocalDate ngaybd = LocalDate.parse(editKM.txNgayBD.getText());
            LocalDate ngaykt = LocalDate.parse(editKM.txNgayKT.getText());

            if (qlkhBUS.update(makm, tenkm, dieukien, phantram, ngaybd, ngaykt)) {
                JOptionPane.showMessageDialog(editKM.txNgayBD, "Sửa " + makm + " thành công!");
                
            }
        }
    }

    private static Boolean checkEmptyAdd() {
        String makm = addKM.txMaKM.getText();
        String tenkm = addKM.txTenKM.getText();
        String dieukien = addKM.txDieuKienKM.getText();
        String phantram = addKM.txPhanTramKM.getText();
        String ngaybd = addKM.txNgayBD.getText();
        String ngaykt = addKM.txNgayKT.getText();

        if (makm.trim().equals("")) {
            return showErrorTx(addKM.txMaKM, "Mã khuyến mãi không được để trống");

        } else if (tenkm.trim().equals("")) {
            return showErrorTx(addKM.txTenKM, "Tên khuyến mãi không được để trống");

        } else if (dieukien.trim().equals("")) {
            return showErrorTx(addKM.txTenKM, "Điều kiện khuyến mãi không được để trống");

        } else if (phantram.trim().equals("")) {
            return showErrorTx(addKM.txTenKM, "Phần trăm khuyến mãi không được để trống");

        } else {
            try {
                Float.parseFloat(dieukien);
            } catch (NumberFormatException e) {
                return showErrorTx(addKM.txDieuKienKM, "Điều kiện khuyến mãi là giá hóa đơn tối thiểu để được khuyến mãi, phải là số thực");
            }
            try {
                float fPhanTram = Float.parseFloat(phantram);
                if (fPhanTram > 100) {
                    return showErrorTx(addKM.txPhanTramKM, "Phần trăm khuyến mãi phải là số thực < 100 (%)");
                }
            } catch (NumberFormatException e) {
                return showErrorTx(addKM.txPhanTramKM, "Phần trăm khuyến mãi phải là số thực");
            }
            try {
                LocalDate.parse(ngaybd);
            } catch (Exception e) {
                return showErrorTx(addKM.txNgayBD, "Ngày bắt đầu không hợp lệ");
            }
            try {
                LocalDate.parse(ngaykt);
            } catch (Exception e) {
                return showErrorTx(addKM.txNgayKT, "Ngày kết thúc không hợp lệ");
            }
        }

        return true;
    }
    
    private static Boolean checkEmptyEdit() {
        String makm = editKM.txMaKM.getText();
        String tenkm = editKM.txTenKM.getText();
        String dieukien = editKM.txDieuKienKM.getText();
        String phantram = editKM.txPhanTramKM.getText();
        String ngaybd = editKM.txNgayBD.getText();
        String ngaykt = editKM.txNgayKT.getText();

        if (makm.trim().equals("")) {
            return showErrorTx(editKM.txMaKM, "Mã khuyến mãi không được để trống");

        } else if (tenkm.trim().equals("")) {
            return showErrorTx(editKM.txTenKM, "Tên khuyến mãi không được để trống");

        } else if (dieukien.trim().equals("")) {
            return showErrorTx(editKM.txTenKM, "Điều kiện khuyến mãi không được để trống");

        } else if (phantram.trim().equals("")) {
            return showErrorTx(editKM.txTenKM, "Phần trăm khuyến mãi không được để trống");

        } else {
            try {
                Float.parseFloat(dieukien);
            } catch (NumberFormatException e) {
                return showErrorTx(editKM.txDieuKienKM, "Điều kiện khuyến mãi là giá hóa đơn tối thiểu để được khuyến mãi, phải là số thực");
            }
            try {
                float fPhanTram = Float.parseFloat(phantram);
                if (fPhanTram > 100) {
                    return showErrorTx(editKM.txPhanTramKM, "Phần trăm khuyến mãi phải là số thực < 100 (%)");
                }
            } catch (NumberFormatException e) {
                return showErrorTx(editKM.txPhanTramKM, "Phần trăm khuyến mãi phải là số thực");
            }
            try {
                LocalDate.parse(ngaybd);
            } catch (Exception e) {
                return showErrorTx(editKM.txNgayBD, "Ngày bắt đầu không hợp lệ");
            }
            try {
                LocalDate.parse(ngaykt);
            } catch (Exception e) {
                return showErrorTx(editKM.txNgayKT, "Ngày kết thúc không hợp lệ");
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
