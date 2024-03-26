
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
                
//                return true;
              
            }
        }

//        return false;
    }

    public static void btnSuaMouseClicked() {
        if (checkEmptyEdit()) {
            String maSach = editForm.txtMaSach.getText();
            String theLoai = editForm.txtTheloai.getText();
            String ten = editForm.txtTen.getText();            float giaNhap = Float.parseFloat(editForm.txtGia.getText());
            float giaNhap = Float.parseFloat(editForm.txtGiaNhap.getText());
            float giaBan = Float.parseFloat(editForm.txtGiaBan.getText());
            int soLuong = Integer.parseInt(editForm.txtSoLuong.getText());
            String tacGia = editForm.txtTacgia.getText();
            String namXB = editForm.txtNamXB.getText();
            short trangThai = (editForm.cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);
            if (qlsBUS.update(maSach, ten, theLoai, tacGia, namXB, soLuong, giaNhap, giaBan, trangThai)) {
                JOptionPane.showMessageDialog(editForm.txtGia, "Sửa " + maSach + " thành công!");
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
//        ChonLoaiSanPhamForm clsp = new ChonLoaiSanPhamForm(txtMalsp); // truyền vào textfield
//    }
//
//    private void btnChonAnhMouseClicked() {
//        FileDialog fd = new FileDialog(this);
//        fd.setVisible(true);
//        String filename = fd.getFile();
//        if (filename != null) {
//            addForm.txtHinhAnh.setText(filename);
//        }
//    }

    public static Boolean checkEmptyAdd() {
        String maSach = addForm.txtMasp.getText();
        String theLoai = addForm.txtTheloai.getText();
        String ten = addForm.txtTen.getText();
        String giaNhap = Float.parseFloat(addForm.txtGiaNhap.getText());
        String giaBan = Float.parseFloat(addForm.txtGiaBan.getText());
        String soLuong = Integer.parseInt(addForm.txtSoLuong.getText());
        String tacGia = addForm.txtTacgia.getText();
        String namXB = addForm.txtNamXB.getText();
        if (maSach.trim().equals("")) {
            return showErrortxt(addForm.txtMasp, "Mã sp không được để trống");

        } else if (ten.trim().equals("")) {
            return showErrortxt(addForm.txtTen, "Tên không được để trống");
            
        } else if (tacGia.trim().equals("")) {
            return showErrortxt(addForm.txtTacgia, "Tên tác giả không được để trống");
            
        } else if (theLoai.trim().equals("")) {
            return showErrortxt(addForm.txtTheloai, "Thể loại không được để trống");
            
        } else if (namXB.trim().equals("")) {
            return showErrortxt(addForm.txtNamxb, "Năm xuất bản không được để trống"); 
            
        } else if (giaNhap.trim().equals("")) {
            return showErrortxt(addForm.txtGiaNhap, "Đơn giá không được để trống");
        
        } else if (giaBan.trim().equals("")) {
            return showErrortxt(addForm.txtGiaBan, "Đơn giá không được để trống");

        } else if (soLuong.trim().equals("")) {
            return showErrortxt(addForm.txtSoLuong, "Số lượng không được để trống");

        } else {
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
        String maSach = addForm.txtMasp.getText();
        String theLoai = addForm.txtTheloai.getText();
        String ten = addForm.txtTen.getText();
        String giaNhap = Float.parseFloat(addForm.txtGiaNhap.getText());
        String giaBan = Float.parseFloat(addForm.txtGiaBan.getText());
        String soLuong = Integer.parseInt(addForm.txtSoLuong.getText());
        String tacGia = addForm.txtTacgia.getText();
        String namXB = addForm.txtNamXB.getText();

        if (mấch.trim().equals("")) {
            return showErrortxt(editForm.txtMasp, "Mã sp không được để trống");

        } else if (ten.trim().equals("")) {
            return showErrortxt(editForm.txtTen, "Tên không được để trống");
            
        } else if (tacGia.trim().equals("")) {
            return showErrortxt(editForm.txtTacgia, "Tên tác giả không được để trống");
            
        } else if (theLoai.trim().equals("")) {
            return showErrortxt(editForm.txtTheloai, "Thể loại không được để trống");
            
        } else if (namXB.trim().equals("")) {
            return showErrortxt(editForm.txtNamxb, "Năm xuất bản không được để trống"); 
            
        } else if (giaNhap.trim().equals("")) {
            return showErrortxt(editForm.txtGiaNhap, "Giá nhập không được để trống");
            
        } else if (giaBan.trim().equals("")) {
            return showErrortxt(editForm.txtGiaBan, "Giá bán không được để trống");

        } else if (soLuong.trim().equals("")) {
            return showErrortxt(editForm.txtSoLuong, "Số lượng không được để trống");

        } else {
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
    
    public static Boolean showErrortxt(JTextField txt, String errorInfo) {
        JOptionPane.showMessageDialog(txt, errorInfo);
        txt.requestFocus();
        return false;
    }
}
