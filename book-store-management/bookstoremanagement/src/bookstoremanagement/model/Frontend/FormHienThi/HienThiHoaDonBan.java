package bookstoremanagement.model.Frontend.FormHienThi;


import bookstoremanagement.model.Backend.HoaDonBan.HoaDonBan;
import bookstoremanagement.model.Backend.Price.PriceFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class HienThiHoaDonBan{

  
     public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
  
    public static void AddTable(ArrayList<HoaDonBan> data,JTable table){
        int stt = 1;
        for (HoaDonBan hd : data) {
                AddRowToTable(new Object[]{
                    stt,
                hd.getMaHDB(),
                hd.getMaKH(),
                hd.getMaNV(),
                hd.getMaKM(),
                String.valueOf(hd.getNgayLap()),
                String.valueOf(hd.getGioLap()),
                PriceFormat.format(hd.getTongTien())},table);
                stt++;
}
}
}


