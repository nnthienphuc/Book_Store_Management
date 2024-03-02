
package bookstoremanagement.model.Frontend.FormThemSua;

import bookstoremanagement.model.Backend.Sach.QuanLySachBUS;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import bookstoremanagement.frames.addForm;
import bookstoremanagement.frames.editForm;
import static bookstoremanagement.MainPage.BHSPTable;

public class ThemSuaSachForm {
    static QuanLySachBUS qlsBUS = new QuanLySachBUS();
    public static void btnThemMouseClicked() {
      
        if (checkEmptyAdd()) {
            String maSach = addForm.txMasp.getText();
            String theLoai = addForm.txTheloai.getText();
            String ten = addForm.txTen.getText();            float giaNhap = Float.parseFloat(addForm.txGia.getText());
            float giaNhap = Float.parseFloat(addForm.txGiaNhap.getText());
            float giaBan = Float.parseFloat(addForm.txGiaBan.getText());
            int soLuong = Integer.parseInt(addForm.txSoLuong.getText());
            String tacGia = addForm.txTacgia.getText();
            String namXB = addForm.txNamXB.getText();
            short trangThai = (addForm.cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);
            if (qlsBUS.add(maSach, ten, theLoai, tacGia, namXB, soLuong, giaNhap, giaBan, trangThai)) {
                JOptionPane.showMessageDialog( addForm.txGia,"Thêm " + ten + " thành công!");
                
//                return true;
              
            }
        }

//        return false;
    }

    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String maSach = editForm.txMasp.getText();
            String theLoai = editForm.txTheloai.getText();
            String ten = editForm.txTen.getText();            float giaNhap = Float.parseFloat(editForm.txGia.getText());
            float giaNhap = Float.parseFloat(editForm.txGiaNhap.getText());
            float giaBan = Float.parseFloat(editForm.txGiaBan.getText());
            int soLuong = Integer.parseInt(editForm.txSoLuong.getText());
            String tacGia = editForm.txTacgia.getText();
            String namXB = editForm.txNamXB.getText();
            short trangThai = (editForm.cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);
            if (qlsBUS.update(maSach, ten, theLoai, tacGia, namXB, soLuong, giaNhap, giaBan, trangThai)) {
                JOptionPane.showMessageDialog(editForm.txGia, "Sửa " + maSach + " thành công!");
//                return true;
            }
        }
        

//        return false;
    }
    
    public static void btnXoaMouseClicked() {
        String masp = null;
        masp = (String) BHSPTable.getValueAt(BHSPTable.getSelectedRow(), 1);
        if (masp != null) {  
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn XÓA HOÀN TOÀN sản phẩm " + masp + " ?", 
                        "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    qlsBUS.delete(masp);
                   
                }
            

        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm nào để xóa");
        }
    }

//    private void btnChonLoaiMouseClicked() {
//        ChonLoaiSanPhamForm clsp = new ChonLoaiSanPhamForm(txMalsp); // truyền vào textfield
//    }
//
//    private void btnChonAnhMouseClicked() {
//        FileDialog fd = new FileDialog(this);
//        fd.setVisible(true);
//        String filename = fd.getFile();
//        if (filename != null) {
//            addForm.txHinhAnh.setText(filename);
//        }
//    }

    public static Boolean checkEmptyAdd() {
        String maSach = addForm.txMasp.getText();
        String theLoai = addForm.txTheloai.getText();
        String ten = addForm.txTen.getText();
        String giaNhap = Float.parseFloat(addForm.txGiaNhap.getText());
        String giaBan = Float.parseFloat(addForm.txGiaBan.getText());
        String soLuong = Integer.parseInt(addForm.txSoLuong.getText());
        String tacGia = addForm.txTacgia.getText();
        String namXB = addForm.txNamXB.getText();
        if (maSach.trim().equals("")) {
            return showErrorTx(addForm.txMasp, "Mã sp không được để trống");

        } else if (ten.trim().equals("")) {
            return showErrorTx(addForm.txTen, "Tên không được để trống");
            
        } else if (tacGia.trim().equals("")) {
            return showErrorTx(addForm.txTacgia, "Tên tác giả không được để trống");
            
        } else if (theLoai.trim().equals("")) {
            return showErrorTx(addForm.txTheloai, "Thể loại không được để trống");
            
        } else if (namXB.trim().equals("")) {
            return showErrorTx(addForm.txNamxb, "Năm xuất bản không được để trống"); 
            
        } else if (giaNhap.trim().equals("")) {
            return showErrorTx(addForm.txGiaNhap, "Đơn giá không được để trống");
        
        } else if (giaBan.trim().equals("")) {
            return showErrorTx(addForm.txGiaBan, "Đơn giá không được để trống");

        } else if (soLuong.trim().equals("")) {
            return showErrorTx(addForm.txSoLuong, "Số lượng không được để trống");

        } else {
            try {
                float dg = Float.parseFloat(giaNhap);
            } catch (NumberFormatException e) {
                return showErrorTx(addForm.txGiaNhap, "Giá nhập không hợp lệ (phải là số thực)");
            }
            
            try {
                float dg = Float.parseFloat(giaBan);
            } catch (NumberFormatException e) {
                return showErrorTx(addForm.txGiaBan, "Giá bán không hợp lệ (phải là số thực)");
            }

            try {
                int sl = Integer.parseInt(soLuong);
                if (sl < 0) {
                    return showErrorTx(addForm.txSoLuong, "Số lượng không hợp lệ (phải là số duơng)");
                }
            } catch (NumberFormatException e) {
                return showErrorTx(addForm.txSoLuong, "Số lượng không hợp lệ (phải là số nguyên)");
            }
        }
        return true;
    }

    
     public static Boolean checkEmptyEdit() {
        String maSach = addForm.txMasp.getText();
        String theLoai = addForm.txTheloai.getText();
        String ten = addForm.txTen.getText();
        String giaNhap = Float.parseFloat(addForm.txGiaNhap.getText());
        String giaBan = Float.parseFloat(addForm.txGiaBan.getText());
        String soLuong = Integer.parseInt(addForm.txSoLuong.getText());
        String tacGia = addForm.txTacgia.getText();
        String namXB = addForm.txNamXB.getText();

        if (mấch.trim().equals("")) {
            return showErrorTx(editForm.txMasp, "Mã sp không được để trống");

        } else if (ten.trim().equals("")) {
            return showErrorTx(editForm.txTen, "Tên không được để trống");
            
        } else if (tacGia.trim().equals("")) {
            return showErrorTx(editForm.txTacgia, "Tên tác giả không được để trống");
            
        } else if (theLoai.trim().equals("")) {
            return showErrorTx(editForm.txTheloai, "Thể loại không được để trống");
            
        } else if (namXB.trim().equals("")) {
            return showErrorTx(editForm.txNamxb, "Năm xuất bản không được để trống"); 
            
        } else if (giaNhap.trim().equals("")) {
            return showErrorTx(editForm.txGiaNhap, "Giá nhập không được để trống");
            
        } else if (giaBan.trim().equals("")) {
            return showErrorTx(editForm.txGiaBan, "Giá bán không được để trống");

        } else if (soLuong.trim().equals("")) {
            return showErrorTx(editForm.txSoLuong, "Số lượng không được để trống");

        } else {
            try {
                float dg = Float.parseFloat(giaNhap);
            } catch (NumberFormatException e) {
                return showErrorTx(editForm.txGiaNhap, "Giá nhập không hợp lệ (phải là số thực)");
            }
            
            try {
                float dg = Float.parseFloat(giaBan);
            } catch (NumberFormatException e) {
                return showErrorTx(editForm.txGiaBan, "Giá bán không hợp lệ (phải là số thực)");
            }

            try {
                int sl = Integer.parseInt(soLuong);
                if (sl < 0) {
                    return showErrorTx(editForm.txSoLuong, "Số lượng không hợp lệ (phải là số duơng)");
                }
            } catch (NumberFormatException e) {
                return showErrorTx(editForm.txSoLuong, "Số lượng không hợp lệ (phải là số nguyên)");
            }
        }
        return true;
    }
    
    public static Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
