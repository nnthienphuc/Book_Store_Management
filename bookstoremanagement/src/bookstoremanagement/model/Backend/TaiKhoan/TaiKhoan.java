/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.TaiKhoan;

/**
 *
 * @author ASUS
 */
public class TaiKhoan {
        String tenDangNhap, matKhau, maNV, maQuyen;
    
    public TaiKhoan(String tenDangNhap, String matKhau, String maNV, String maQuyen) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maNV = maNV;
        this.maQuyen = maQuyen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", maNV=" + maNV + ", maQuyen=" + maQuyen + '}';
    }

    
}
