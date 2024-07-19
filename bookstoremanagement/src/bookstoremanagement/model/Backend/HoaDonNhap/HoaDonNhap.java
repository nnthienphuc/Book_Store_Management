/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.HoaDonNhap;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ASUS
 */
public class HoaDonNhap {
    String maHDN;
    String maNCC;
    String maNV;
    LocalDate ngayLap;
    LocalTime gioLap;
    float tongTien = 0;
    
    public HoaDonNhap() {
       
    }
    
    public HoaDonNhap(String maHDN, String maNCC, String maNV, LocalDate ngayLap, LocalTime gioLap, float tongTien) {

        this.maHDN = maHDN;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.gioLap = gioLap;
        this.tongTien = tongTien;
    }

    public String getMaHDN() {
        return maHDN;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getMaNV() {
        return maNV;
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

    public void setMaHDN(String maHDN) {
        this.maHDN = maHDN;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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
