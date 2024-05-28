
package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.Sach.QuanLySachBUS;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import bookstoremanagement.frames.addForm;
import bookstoremanagement.frames.editForm;
import java.time.LocalDate;

public class ThemSuaSachForm {
    static QuanLySachBUS qlsBUS = new QuanLySachBUS();
    public static boolean btnThemMouseClicked() {
        if (checkEmptyAdd()) {
            String maSach = addForm.txtMaSach.getText();
            String theLoai = addForm.txtTheLoai.getText();
            String ten = addForm.txtTenSach.getText();
            float giaNhap = Float.parseFloat(addForm.txtGiaNhap.getText());
            float giaBan = Float.parseFloat(addForm.txtGiaBan.getText());
            int soLuong = Integer.parseInt(addForm.txtSoLuong.getText());
            String tacGia = addForm.txtTacGia.getText();
            String namXB = addForm.txtNamXB.getText();
            int trangThai = (addForm.cboTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);
            if (qlsBUS.add(maSach, ten, theLoai, tacGia, namXB, soLuong, giaNhap, giaBan, trangThai)) {
                JOptionPane.showMessageDialog( addForm.txtGiaNhap,"Thêm " + ten + " thành công!");
            return true;
            }
        }
        return false;
    }

    public static boolean btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String maSach = editForm.txtMaSach.getText();
            String theLoai = editForm.txtTheLoai.getText();
            String ten = editForm.txtTenSach.getText();       
           
            float giaNhap = Float.parseFloat(editForm.txtGiaNhap.getText());
            float giaBan = Float.parseFloat(editForm.txtGiaBan.getText());
            int soLuong = Integer.parseInt(editForm.txtSoLuong.getText());
            String tacGia = editForm.txtTacGia.getText();
            String namXB = editForm.txtNamXB.getText();
            short trangThai = (short) (editForm.cboTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);
            if (qlsBUS.update(maSach, ten, theLoai, tacGia, namXB, soLuong, giaNhap, giaBan, trangThai)) {
                JOptionPane.showMessageDialog(editForm.txtSoLuong, "Sửa " + maSach + " thành công!");
            return true;
            }
        }
        return false;
    }
    

    public static Boolean checkEmptyAdd() {
        String theLoai = addForm.txtTheLoai.getText();
        String ten = addForm.txtTenSach.getText();
        String giaNhap = addForm.txtGiaNhap.getText();
        String giaBan = addForm.txtGiaBan.getText();
        String soLuong = addForm.txtSoLuong.getText();
        String tacGia = addForm.txtTacGia.getText();
        String namXB = addForm.txtNamXB.getText();
        
        if (ten.trim().equals("")) {
            return showErrortxt(addForm.txtTenSach, "Tên sách không được để trống");
        } 
        
        else if (tacGia.trim().equals("")) {
            return showErrortxt(addForm.txtTacGia, "Tên tác giả không được để trống");
        } 
        else if (!tacGia.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
            addForm.txtTacGia.setText("");
            return showErrortxt(addForm.txtTacGia, "Tên tác giả chỉ chứa các chữ cái");
        }
        
        else if (theLoai.trim().equals("")) {
            return showErrortxt(addForm.txtTheLoai, "Thể loại không được để trống");
        }
        else if (!theLoai.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
            addForm.txtTheLoai.setText("");
            return showErrortxt(addForm.txtTheLoai, "Thể loại chỉ chứa các chữ cái");
        }
        
        else if (namXB.trim().equals("")) {
            return showErrortxt(addForm.txtNamXB, "Năm xuất bản không được để trống"); 
        }
        else if (!namXB.matches("\\d+")) {
            addForm.txtNamXB.setText("");
            return showErrortxt(addForm.txtNamXB, "Năm xuất bản chỉ chứa số"); 
        }
        else if ((Integer.parseInt(namXB) <= 1000) || (Integer.parseInt(namXB) > (LocalDate.now().getYear()))) {
            addForm.txtNamXB.setText("");
            return showErrortxt(addForm.txtNamXB, "Năm xuất bản phải nằm trong khoảng (1001, " + LocalDate.now().getYear() + ")");
        }
        
        else if (giaNhap.trim().equals("")) {
            return showErrortxt(addForm.txtGiaNhap, "Giá nhập không được để trống");
        }
        else if (Integer.parseInt(giaNhap) < 0) {
            addForm.txtGiaNhap.setText("");
            return showErrortxt(addForm.txtGiaNhap, "Giá nhập phải > 0");
        }
        
        else if (giaBan.trim().equals("")) {
            return showErrortxt(addForm.txtGiaBan, "Giá bán không được để trống");
        }
        else if (Integer.parseInt(giaBan) < 0) {
            addForm.txtGiaBan.setText("");
            return showErrortxt(addForm.txtGiaBan, "Giá bán phải > 0");
        }
        
        else if (soLuong.trim().equals("")) {
            return showErrortxt(addForm.txtSoLuong, "Số lượng không được để trống");
        } 
        else {
            try {
                float dg = Float.parseFloat(giaNhap);
            } catch (NumberFormatException e) {
                return showErrortxt(addForm.txtGiaNhap, "Giá nhập không hợp lệ (phải là số thực)");
            }

            try {
                float dg = Float.parseFloat(giaBan);
            } catch (NumberFormatException e) {
                return showErrortxt(addForm.txtGiaBan, "Giá bán không hợp lệ (phải là số thực)");
            }

            try {
                int sl = Integer.parseInt(soLuong);
                if (sl < 0) {
                    return showErrortxt(addForm.txtSoLuong, "Số lượng không hợp lệ (phải là số duơng)");
                }
            } catch (NumberFormatException e) {
                return showErrortxt(addForm.txtSoLuong, "Số lượng không hợp lệ (phải là số nguyên)");
            }
        }
        return true;
    }

    
     public static Boolean checkEmptyEdit() {
        String theLoai = editForm.txtTheLoai.getText();
        String ten = editForm.txtTenSach.getText();
        String giaNhap = editForm.txtGiaNhap.getText();
        String giaBan = editForm.txtGiaBan.getText();
        String soLuong = editForm.txtSoLuong.getText();
        String tacGia = editForm.txtTacGia.getText();
        String namXB = editForm.txtNamXB.getText();
        
        if (ten.trim().equals("")) {
            return showErrortxt(editForm.txtTenSach, "Tên sách không được để trống");
        } 
        
        else if (tacGia.trim().equals("")) {
            return showErrortxt(editForm.txtTacGia, "Tên tác giả không được để trống");
        } 
        else if (!tacGia.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
            editForm.txtTacGia.setText("");
            return showErrortxt(editForm.txtTacGia, "Tên tác giả chỉ chứa các chữ cái");
        }
        
        else if (theLoai.trim().equals("")) {
            return showErrortxt(editForm.txtTheLoai, "Thể loại không được để trống");
        }
        else if (!theLoai.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
            editForm.txtTheLoai.setText("");
            return showErrortxt(editForm.txtTheLoai, "Thể loại chỉ chứa các chữ cái");
        }
        
        else if (namXB.trim().equals("")) {
            return showErrortxt(editForm.txtNamXB, "Năm xuất bản không được để trống"); 
        }
        else if (!namXB.matches("\\d+")) {
            editForm.txtNamXB.setText("");
            return showErrortxt(editForm.txtNamXB, "Năm xuất bản chỉ chứa số"); 
        }
        else if ((Integer.parseInt(namXB) <= 1000) || (Integer.parseInt(namXB) > (LocalDate.now().getYear()))) {
            editForm.txtNamXB.setText("");
            return showErrortxt(editForm.txtNamXB, "Năm xuất bản phải nằm trong khoảng (1001, " + LocalDate.now().getYear() + ")");
        }
        
        else if (giaNhap.trim().equals("")) {
            return showErrortxt(editForm.txtGiaNhap, "Giá nhập không được để trống");
        }
//        else if (Integer.parseInt(giaNhap) < 0) {
//            editForm.txtGiaNhap.setText("");
//            return showErrortxt(editForm.txtGiaNhap, "Giá nhập phải > 0");
//        }
        
        else if (giaBan.trim().equals("")) {
            return showErrortxt(editForm.txtGiaBan, "Giá bán không được để trống");
        }
//        else if (Integer.parseInt(giaBan) < 0) {
//            editForm.txtGiaBan.setText("");
//            return showErrortxt(editForm.txtGiaBan, "Giá bán phải > 0");
//        }
        
        else if (soLuong.trim().equals("")) {
            return showErrortxt(editForm.txtSoLuong, "Số lượng không được để trống");
        } 
        else {
            try {
                float dg = Float.parseFloat(giaNhap);
            } catch (NumberFormatException e) {
                return showErrortxt(editForm.txtGiaNhap, "Giá nhập không hợp lệ (phải là số thực)");
            }

            try {
                float dg = Float.parseFloat(giaBan);
            } catch (NumberFormatException e) {
                return showErrortxt(editForm.txtGiaBan, "Giá bán không hợp lệ (phải là số thực)");
            }

            try {
                int sl = Integer.parseInt(soLuong);
                if (sl < 0) {
                    return showErrortxt(editForm.txtSoLuong, "Số lượng không hợp lệ (phải là số duơng)");
                }
            } catch (NumberFormatException e) {
                return showErrortxt(editForm.txtSoLuong, "Số lượng không hợp lệ (phải là số nguyên)");
            }
        }
        return true;
    }
//    
    public static Boolean showErrortxt(JTextField txt, String errorInfo) {
        JOptionPane.showMessageDialog(txt, errorInfo);
        txt.requestFocus();
        return false;
    }
}
