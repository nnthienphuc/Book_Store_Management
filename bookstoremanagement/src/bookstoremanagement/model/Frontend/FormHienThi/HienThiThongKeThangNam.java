/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Frontend.FormHienThi;

import bookstoremanagement.model.Backend.Price.PriceFormat;
import bookstoremanagement.model.Backend.ThongKe.ThangNam.Declare;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author songnguyen
 */
public class HienThiThongKeThangNam {
    public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
    public static void AddTable(ArrayList<Declare> data,JTable table){
        
        for (Declare hd : data) {
                AddRowToTable(new Object[]{
              
                String.valueOf(hd.getThang()),
                String.valueOf(hd.getNam()),
                PriceFormat.format(hd.getTongTien())},table);
                
}
} 
}
