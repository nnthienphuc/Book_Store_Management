/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.HoaDonBan;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ASUS
 */
public class HoaDonBan {
     private String maHDB = "";
    private String maKH = "";
    private String maNV = "";
    private String maKM = "";
    private LocalDate ngayLap;
    private LocalTime gioLap;
    private float tongTien = 0;
    
    public HoaDonBan() {
        
    }
    
    public HoaDonBan(String maHDB, String maKH, String maNV, String maKM, LocalDate ngayLap, LocalTime gioLap, float tongTien) {
        this.maHDB = maHDB;
        this.maKH = maKH;
        this.maNV= maNV;
        this.maKM = maKM;
        this.ngayLap = ngayLap;
        this.gioLap = gioLap;
        this.tongTien = tongTien;
    }

    public String getMaHDB() {
        return maHDB;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKM() {
        return maKM;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public LocalTime getGioLap() {
        return gioLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setMaHDB(String maHDB) {
        this.maHDB = maHDB;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setGioLap(LocalTime gioLap) {
        this.gioLap = gioLap;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
}
