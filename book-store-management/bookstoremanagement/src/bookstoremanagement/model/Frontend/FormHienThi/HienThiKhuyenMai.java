 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoremanagement.model.Frontend.FormHienThi;


import bookstoremanagement.model.Backend.KhuyenMai.KhuyenMai;
import bookstoremanagement.model.Backend.Price.PriceFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author DELL
 */
public class HienThiKhuyenMai {

   

    public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
  
    public static void AddTable(ArrayList<KhuyenMai> data,JTable table){
        int stt = 1;
        for (KhuyenMai km : data) {
            AddRowToTable(new Object[]{
                stt,
                km.getMaKM(),
                km.getTenKM(),
                "≥ " + PriceFormat.format(km.getDieuKienKM()),
                String.valueOf(km.getPhanTramKM()) + " %",
                String.valueOf(km.getNgayBD()),
                String.valueOf(km.getNgayKT()),
                km.getTrangThai()
                },table);
            stt++;
        }
    }
}
