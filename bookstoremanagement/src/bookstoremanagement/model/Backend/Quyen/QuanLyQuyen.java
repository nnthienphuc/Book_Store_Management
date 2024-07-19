
package bookstoremanagement.model.Backend.Quyen;


public class QuanLyQuyen {
    String MaQuyen, TenQuyen, ChiTietQuyen;
    
    public QuanLyQuyen(String maquyen, String tenquyen, String chitietquyen) {
        this.MaQuyen = maquyen;
        this.TenQuyen = tenquyen;
        this.ChiTietQuyen = chitietquyen;
    }

    public String getTenQuyen() {
        return this.TenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }

    public String getMaQuyen() {
        return this.MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getChiTietQuyen() {
        return this.ChiTietQuyen;
    }

    public void setChiTietQuyen(String ChiTietQuyen) {
        this.ChiTietQuyen = ChiTietQuyen;
    }
}
