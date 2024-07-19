package bookstoremanagement.model.Frontend.FormHienThi;


import bookstoremanagement.model.Backend.KhachHang.KhachHang;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class HienThiKhachHang{
  
    public static void addRowtotable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
    public static void addTable (ArrayList<KhachHang> data,JTable table){
        int stt = 1;
        for (KhachHang kh : data) {
            addRowtotable(new Object[]{
                    stt,
                    kh.getMaKH(),
                    kh.getTenKH(),
                    kh.getDiaChi(),
                    kh.getSDT()
                },table);
            stt++;
        }
    }
}
