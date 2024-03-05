
package bookstoremanagement.model.Frontend.FormHienThi;

import bookstoremanagement.model.Backend.Price.PriceFormat;
import bookstoremanagement.model.Backend.QuanLyChiTietHoaDonNhap.ChiTietHoaDonNhap;
import bookstoremanagement.model.Backend.Sach.QuanLySachBUS;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class HienThiChiTietHoaDonNhap {

    static QuanLySachBUS qlsBUS = new QuanLySachBUS();

    
    public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
  
    public static void AddTable(ArrayList<ChiTietHoaDonNhap> data,JTable table){
        int stt = 1;
        for (ChiTietHoaDonNhap hdn : data) {           
                AddRowToTable(new Object[]{
                stt,
                hdn.getMaHDN(),
                hdn.getMaSach(),
                qlsBUS.getSach(hdn.getMaSach()).getTenSach(),
                String.valueOf(hdn.getSoLuong()),
                PriceFormat.format(qlsBUS.getSach(hdn.getMaSach()).getGiaNhap()),
                PriceFormat.format(hdn.getSoLuong() * (qlsBUS.getSach(hdn.getMaSach()).getGiaNhap()))
        },table);
        stt++;
}
}

}
