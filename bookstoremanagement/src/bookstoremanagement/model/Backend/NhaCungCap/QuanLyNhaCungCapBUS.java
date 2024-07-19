package bookstoremanagement.model.Backend.NhaCungCap;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author THUY NGAN
 */
public class QuanLyNhaCungCapBUS {

    ArrayList<NhaCungCap> dsqlncc = new ArrayList<>();
    QuanLyNhaCungCapDAO qlnccDAO = new QuanLyNhaCungCapDAO();

    public QuanLyNhaCungCapBUS() {
        dsqlncc = qlnccDAO.readDB();
    }
    
    public void show() {
        dsqlncc.forEach((ncc) -> {
            System.out.print(ncc.getMaNCC() + " ");
            System.out.print(ncc.getMaNCC()+ " ");
            System.out.println(ncc.getDiaChi() + " ");
            System.out.println(ncc.getSDT() + " ");
            System.out.println(ncc.getFAX());
        });
    }
    
    public ArrayList<NhaCungCap> readDB() {
        dsqlncc = qlnccDAO.readDB();
        
        return dsqlncc;
    }

    public String getNextID() {
        return "NCC" + (dsqlncc.size() + 1);
    }

    public NhaCungCap getNhaCungCap(String maNCC) {
        for (NhaCungCap ncc : dsqlncc) {
            if (ncc.getMaNCC().equals(maNCC)) {
                return ncc;
            }
        }
        return null;
    }

    public ArrayList<NhaCungCap> getDsncc() {
        return this.dsqlncc;
    }
    public boolean add(String maNCC, String tenNCC, String diaChi, String SDT, String FAX) {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNCC(maNCC);
        ncc.setTenNCC(tenNCC);
        ncc.setDiaChi(diaChi);
        ncc.setSDT(SDT);
        ncc.setFAX(FAX);
        
        boolean success = qlnccDAO.add(ncc);
        if (success)
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        else 
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        return success;
        
    }

   public boolean update(String maNCC, String tenNCC, String diaChi, String SDT , String FAX){
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNCC(maNCC);
        ncc.setTenNCC(tenNCC);
        ncc.setDiaChi(diaChi);
        ncc.setSDT(SDT);
        ncc.setFAX(FAX);
        boolean success = qlnccDAO.update(ncc);
//        if (success)
//            JOptionPane.showMessageDialog(null, "Bạn cập nhật thành công");
//        else 
//            JOptionPane.showMessageDialog(null, "Bạn cập nhật thất bại");
      
        return success;
    }
    public Boolean add(NhaCungCap ncc) {
        qlnccDAO = new QuanLyNhaCungCapDAO();
        Boolean success = qlnccDAO.add(ncc);

        if (success) {
            dsqlncc.add(ncc);
        }
        return success;
    }

    public boolean delete(String maNCC) {
        Boolean success = qlnccDAO.delete(maNCC);
        if (success) {
            for (int i = (dsqlncc.size() - 1); i >= 0; i--) {
                if (dsqlncc.get(i).getMaNCC().equals(maNCC)) {
                    dsqlncc.remove(i);
                }
            }

        }
        return success;
    }
    public ArrayList<NhaCungCap> findByTenNCC(String tenNCC) {
        ArrayList<NhaCungCap> dsncc = new ArrayList<>();
        dsncc =qlnccDAO.findByTenNCC(tenNCC);
        return dsncc;
    }
}
