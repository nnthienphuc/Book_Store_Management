/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.ThongKe.Ngay;

import java.time.LocalDate;

/**
 *
 * @author songnguyen
 */
public class Declare {
    private LocalDate ngayLap;
    private float tongTien = 0;
    public Declare(){
        
    }
    public Declare(LocalDate ngaylap, float tongtien){
    this.ngayLap = ngaylap;
    this.tongTien = tongtien;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
}
