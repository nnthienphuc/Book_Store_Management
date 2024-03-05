package bookstoremanagement.model.Frontend.FormHienThi;

import bookstoremanagement.model.Backend.Price.PriceFormat;
import bookstoremanagement.model.Backend.QuanLyChiTietHoaDonBan.ChiTietHoaDonBan;
import bookstoremanagement.model.Backend.Sach.QuanLySachBUS;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class HienThiChiTietHoaDonBan {

  
    static QuanLySachBUS qlsBUS = new QuanLySachBUS();

   
    
    public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
  
    public static void AddTable(ArrayList<ChiTietHoaDonBan> data,JTable table){
        int stt = 1;
        for (ChiTietHoaDonBan cthd : data) {
                AddRowToTable(new Object[]{
                stt,
                cthd.getMaSach(),
                qlsBUS.getSach(cthd.getMaSach()).getTenSach(),
                String.valueOf(cthd.getSoLuong()),
                PriceFormat.format(qlsBUS.getSach(cthd.getMaSach()).getGiaBan()),
                PriceFormat.format(cthd.getSoLuong() * (qlsBUS.getSach(cthd.getMaSach()).getGiaBan()))
               
        },table);
            stt++;
}
}
}



