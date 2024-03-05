package bookstoremanagement.model.Frontend.FormHienThi;

import bookstoremanagement.model.Backend.Quyen.QuanLyQuyen;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HienThiQuyen{


    public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
    public static void AddTable(ArrayList<QuanLyQuyen> data,JTable table){
        int stt = 1;
        for (QuanLyQuyen q : data) {
            AddRowToTable(new Object[]{
                stt,
                q.getMaQuyen(),
                q.getTenQuyen(),
                q.getChiTietQuyen()},table);
            stt++;
        }
    }
}
