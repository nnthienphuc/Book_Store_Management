
package bookstoremanagement.model.Backend.QuanLyChiTietHoaDonNhap;


public class ChiTietHoaDonNhap {
    
    private String maHDN;
    private String maSach;
    private int soLuong;
 
    public ChiTietHoaDonNhap() {

    }

    public ChiTietHoaDonNhap(String maHDN, String maSach, int soLuong) {
        this.maHDN = maHDN;
        this.maSach = maSach;
        this.soLuong = soLuong;
        
    }

    public String getMaHDN() {
        return maHDN;
    }

    public String getMaSach() {
        return maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

   

    public void setMaHDN(String maHDN) {
        this.maHDN = maHDN;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
    
}
