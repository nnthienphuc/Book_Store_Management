
package bookstoremanagement.model.Backend.NhanVien;

import java.time.LocalDate;
public class QuanLyNhanVien {
    private String maNV;
    private String tenNV;
    private LocalDate ngaySinh;
    private String diaChi;
    private String SDT;
    private int trangThai;
    public QuanLyNhanVien() {
    }

    public QuanLyNhanVien(String maNV, String tenNV, LocalDate ngaySinh, String diaChi, String SDT, int trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
    

    
    
}
