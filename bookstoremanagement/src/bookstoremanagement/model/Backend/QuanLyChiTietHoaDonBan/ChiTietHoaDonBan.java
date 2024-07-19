
package bookstoremanagement.model.Backend.QuanLyChiTietHoaDonBan;


public class ChiTietHoaDonBan {
    
    private String maHDB;
    private String maSach;
    private int soLuong;
    
    
    public ChiTietHoaDonBan(String maHDB, String maSach, int soLuong) {
        this.maHDB = maHDB;
        this.maSach = maSach;
        this.soLuong = soLuong;
       
    }

    public String getMaHDB() {
        return maHDB;
    }

    public String getMaSach() {
        return maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

   

    public void setMaHDB(String maHDB) {
        this.maHDB = maHDB;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

  
    
    
}
