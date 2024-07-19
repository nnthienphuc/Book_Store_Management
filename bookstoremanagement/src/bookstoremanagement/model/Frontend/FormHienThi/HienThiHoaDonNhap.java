/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoremanagement.model.Frontend.FormHienThi;



import bookstoremanagement.model.Backend.HoaDonNhap.HoaDonNhap;
import bookstoremanagement.model.Backend.Price.PriceFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HienThiHoaDonNhap {

  
        public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
    public static void AddTable(ArrayList<HoaDonNhap> data,JTable table){
        int stt = 1;
        for (HoaDonNhap hdn : data) {
            AddRowToTable(new Object[]{
                stt,
                hdn.getMaHDN(),
                hdn.getMaNCC(),
                hdn.getMaNV(),
                String.valueOf(hdn.getNgayLap()),
                String.valueOf(hdn.getGioLap()),
                PriceFormat.format(hdn.getTongTien())},table);
            stt++;
        }
    }

}
