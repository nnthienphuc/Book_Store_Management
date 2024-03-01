package bookstoremanagement.model.Frontend.FormHienThi;

import bookstoremanagement.model.Backend.Price.PriceFormat;
import bookstoremanagement.model.Backend.Sach.Sach;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HienThiSach {

    public static void AddRowToTable(Object[] dataRow, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(dataRow);
    }

    public static void AddTable(ArrayList<Sach> data, JTable table) {
        int stt = 1;
        for (Sach sp : data) {
            AddRowToTable(new Object[]{
                stt,
                sp.getMaSach(),
                sp.getTenSach(),
                sp.getTheLoai(),
                sp.getTacGia(),
                sp.getNamXB(),
                String.valueOf(sp.getSoLuong()),
                PriceFormat.format(sp.getGiaNhap()),
                PriceFormat.format(sp.getGiaBan()),
            }, table);
            stt++;
        }
    }

}
