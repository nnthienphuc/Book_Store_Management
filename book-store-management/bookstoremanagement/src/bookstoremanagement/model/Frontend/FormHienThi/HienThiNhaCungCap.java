/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoremanagement.model.Frontend.FormHienThi;


import bookstoremanagement.model.Backend.NhaCungCap.NhaCungCap;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Admin
 */
public class HienThiNhaCungCap  {
    public static void AddRowToTable(Object[] dataRow,JTable table)
    {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(dataRow);
    }
    public static void AddTable(ArrayList<NhaCungCap> data,JTable table){
        int stt = 1;
        for (NhaCungCap ncc : data) {
            AddRowToTable(new Object[]{
                stt,
                ncc.getMaNCC(), 
                ncc.getTenNCC(), 
                ncc.getDiaChi(),
                String.valueOf(ncc.getSDT()), String.valueOf(ncc.getFAX())},table);
                stt++;
        }
    }
}
