
package bookstoremanagement.model.Backend.Quyen;

import java.util.ArrayList;
public class QuanLyQuyenBUS {
    private ArrayList<QuanLyQuyen> dsq = new ArrayList<>();
    QuanLyQuyenDAO qlqDAO = new QuanLyQuyenDAO();

    public QuanLyQuyenBUS() {
        dsq = qlqDAO.readDB();
    }

    public void readDB() {
        dsq = qlqDAO.readDB();
    }
    
    public String getNextID() {
        return "Q" + String.valueOf(this.dsq.size() + 1);
    }

    public QuanLyQuyen getQuyen(String maquyen) {
        for (QuanLyQuyen q : dsq) {
            if (q.getMaQuyen().equals(maquyen)) {
                return q;
            }
        }
        return null;
    }

    public ArrayList<QuanLyQuyen> search(String value, String type) {
        ArrayList<QuanLyQuyen> result = new ArrayList<>();

        dsq.forEach((q) -> {
            if (type.equals("Tất cả")) {
                if (q.getMaQuyen().toLowerCase().contains(value.toLowerCase())
                        || q.getTenQuyen().toLowerCase().contains(value.toLowerCase())
                        || q.getChiTietQuyen().toLowerCase().contains(value.toLowerCase())) {
                    result.add(q);
                }
            } else {
                switch (type) {
                    case "Mã quyền":
                        if (q.getMaQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(q);
                        }
                        break;
                    case "Tên quyền":
                        if (q.getTenQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(q);
                        }
                        break;
                    case "Chi tiết quyền":
                        if (q.getChiTietQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(q);
                        }
                        break;
                }
            }

        });

        return result;
    }

    public Boolean add(QuanLyQuyen sp) {
        Boolean ok = qlqDAO.add(sp);

        if (ok) {
            dsq.add(sp);
        }
        return ok;
    }

    public Boolean add(String maquyen, String tenquyen, String chitiet) {
        QuanLyQuyen sp = new QuanLyQuyen(maquyen, tenquyen, chitiet);
        return add(sp);
    }

    public Boolean delete(String maquyen) {
        Boolean ok = qlqDAO.delete(maquyen);

        if (ok) {
            for (int i = (dsq.size() - 1); i >= 0; i--) {
                if (dsq.get(i).getMaQuyen().equals(maquyen)) {
                    dsq.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String maquyen, String tenquyen, String chitiet) {
        Boolean ok = qlqDAO.update(maquyen, tenquyen, chitiet);

        if (ok) {
            dsq.forEach((q) -> {
                if (q.getMaQuyen().equals(maquyen)) {
                    q.setTenQuyen(tenquyen);
                    q.setChiTietQuyen(chitiet);
                }
            });
        }

        return ok;
    }

    public ArrayList<QuanLyQuyen> getDsq() {
        return dsq;
    }
}
