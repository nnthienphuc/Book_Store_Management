/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.KhuyenMai;

import java.time.LocalDate;

/**
 *
 * @author nnthienphuc
 */

public class KhuyenMai {
    String maKM, tenKM;
    float dieuKienKM, phanTramKM;
    LocalDate ngayBD, ngayKT;

    public KhuyenMai(String maKM, String tenKM, float dieuKienKM, float phanTramKM, LocalDate ngayBD, LocalDate ngayKT) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.dieuKienKM = dieuKienKM;
        this.phanTramKM = phanTramKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public String getTrangThai() {
        LocalDate now = LocalDate.now();
        if (now.isBefore(this.ngayBD)) {
            return "Chưa bắt đầu";
        } else if (now.isAfter(this.ngayKT)) {
            return "Đã kết thúc";
        } else {
            return "Đang diễn ra";
        }
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public float getDieuKienKM() {
        return dieuKienKM;
    }

    public void setDieuKienKM(float dieuKienKM) {
        this.dieuKienKM = dieuKienKM;
    }

    public float getPhanTramKM() {
        return phanTramKM;
    }

    public void setPhanTramKM(float phanTramKM) {
        this.phanTramKM = phanTramKM;
    }

    public LocalDate getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(LocalDate ngayBD) {
        this.ngayBD = ngayBD;
    }

    public LocalDate getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        this.ngayKT = ngayKT;
    }
}
