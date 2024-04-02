/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.ThongKe.ThangNam;

import java.time.LocalDate;

/**
 *
 * @author songnguyen
 */
public class Declare {
    private int thang;
    private int nam;
    private float tongTien = 0;
    public Declare(){
        
    }
    public Declare(int thang, int nam , float tongtien){
    this.thang = thang;
    this.nam = nam;
    this.tongTien = tongtien;
    }

    public int getThang() {
        return thang;
    }

    public int getNam() {
        return nam;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

   
    
}
