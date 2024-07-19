package bookstoremanagement.model.Frontend.FormHienThi;


import bookstoremanagement.model.Backend.NhanVien.QuanLyNhanVien;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HienThiNhanVien{

   
    
  
    public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
    public static void AddTable(ArrayList<QuanLyNhanVien> data,JTable table){
        int stt = 1;
        for (QuanLyNhanVien nv : data) {
            AddRowToTable(new Object[]{
                    stt,
                    nv.getMaNV(),
                    nv.getTenNV(),
                    nv.getNgaySinh().toString(),
                    nv.getDiaChi(),
                    nv.getSDT(),
                    (nv.getTrangThai() == 0 ? "Hiện" : "Ẩn")},table);
            stt++;
        }
    }
}
