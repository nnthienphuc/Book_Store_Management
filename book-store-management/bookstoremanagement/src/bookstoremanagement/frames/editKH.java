/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bookstoremanagement.frames;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import bookstoremanagement.MainPage;
import static bookstoremanagement.MainPage.KHTable;
import static bookstoremanagement.frames.ChonKHForm.SubKHTable;
import bookstoremanagement.model.Backend.KhachHang.KhachHang;
import bookstoremanagement.model.Backend.KhachHang.QuanLyKhachHangBUS;
import bookstoremanagement.model.Frontend.FormThemSua.ThemSuaKhachHangForm;

/**
 *
 * @author songnguyen
 */
public class editKH extends javax.swing.JFrame {
    public static void setText()
    {
        String makh = (String) SubKHTable.getValueAt(SubKHTable.getSelectedRow(), 1);
        String tenkh =(String) SubKHTable.getValueAt(SubKHTable.getSelectedRow(), 2);
        MainPage.txKhachHang.setText(makh + "-"+ tenkh);
        
        QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
        
        for(KhachHang kh : qlkhBUS.getDskh())
        {
            if(kh.getMaKH().equals(makh))
            {
                MainPage.KhachHang = kh;
            }
        }
       
        
    }
    public void changecolor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }
//    public void GetInput(){
//        String maKH = "";
//               maKH  =  (String)KHTable.getValueAt(KHTable.getSelectedRow(), 1);
//        if(maKH == "")
//        {
//        JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng nào để sửa");
//        }
//        else
//        {
//        SuaKH(maKH);
//        }
//    }
    public static void SuaKH ()
    {   
        String maKH =  (String)KHTable.getValueAt(KHTable.getSelectedRow(), 1);
        KhachHang khSua = null;
        QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
        for (KhachHang kh : qlkhBUS.getDskh()) {
                if (kh.getMaKH().equals(maKH)) {
                    khSua = kh;
                }
            }
//            if (spSua == null) {
//                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy sản phẩm");
//                this.dispose();
//            }

           
            txtTenKH.setText(khSua.getMaKH());
            txTenKH.setText(khSua.getTenKH());
            txDiaChi.setText(khSua.getDiaChi());
            txSDT.setText(String.valueOf(khSua.getSDT()));
            
    }
    public static void XoaKH(String maKH){
        QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
             
                if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn XÓA HOÀN TOÀN khách hàng " + maKH + " ?", 
                        "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    qlkhBUS.delete(maKH);
                   
                }
            
    }
    
    public static void ThemKH()
    {   
        QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
        addKH.txMaKH.setText(qlkhBUS.getNextID());
        
    }

    /**
     * Creates new form editKH
     */
    public editKH() {
        initComponents();
        setLocationRelativeTo(null);
        SuaKH();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditKH = new javax.swing.JPanel();
        pnlMaKH = new javax.swing.JPanel();
        txtMaKH = new javax.swing.JTextField();
        lblMaKH = new javax.swing.JLabel();
        pnlTenKH = new javax.swing.JPanel();
        txtTenKH = new javax.swing.JTextField();
        lblTenKH = new javax.swing.JLabel();
        pnlDiaChi = new javax.swing.JPanel();
        txtDiaChi = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        pnlSDT = new javax.swing.JPanel();
        txtSDT = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        pnlSua = new javax.swing.JPanel();
        lblSua = new javax.swing.JLabel();
        pnlHuy = new javax.swing.JPanel();
        lblHuy = new javax.swing.JLabel();

        pnlEditKH.setBackground(new java.awt.Color(255, 255, 255));

        txtMaKH.setEditable(false);
        txtMaKH.setToolTipText("Không được phép sửa Mã KH");

        lblMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaKH.setText("Mã khách hàng");

        javax.swing.GroupLayout pnlMaKHLayout = new javax.swing.GroupLayout(pnlMaKH);
        pnlMaKH.setLayout(pnlMaKHLayout);
        pnlMaKHLayout.setHorizontalGroup(
            pnlMaKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMaKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMaKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaKH)
                    .addGroup(pnlMaKHLayout.createSequentialGroup()
                        .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMaKHLayout.setVerticalGroup(
            pnlMaKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMaKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKH)
                .addContainerGap())
        );

        txtTenKH.setToolTipText("");
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenKH.setText("Tên khách hàng");

        javax.swing.GroupLayout pnlTenKHLayout = new javax.swing.GroupLayout(pnlTenKH);
        pnlTenKH.setLayout(pnlTenKHLayout);
        pnlTenKHLayout.setHorizontalGroup(
            pnlTenKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTenKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTenKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKH)
                    .addGroup(pnlTenKHLayout.createSequentialGroup()
                        .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlTenKHLayout.setVerticalGroup(
            pnlTenKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTenKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtDiaChi.setToolTipText("");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDiaChi.setText("Địa chỉ");

        javax.swing.GroupLayout pnlDiaChiLayout = new javax.swing.GroupLayout(pnlDiaChi);
        pnlDiaChi.setLayout(pnlDiaChiLayout);
        pnlDiaChiLayout.setHorizontalGroup(
            pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiaChiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi)
                    .addGroup(pnlDiaChiLayout.createSequentialGroup()
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDiaChiLayout.setVerticalGroup(
            pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDiaChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtSDT.setToolTipText("");
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        lblSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSDT.setText("Số điện thoại");

        javax.swing.GroupLayout pnlSDTLayout = new javax.swing.GroupLayout(pnlSDT);
        pnlSDT.setLayout(pnlSDTLayout);
        pnlSDTLayout.setHorizontalGroup(
            pnlSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSDTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT)
                    .addGroup(pnlSDTLayout.createSequentialGroup()
                        .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSDTLayout.setVerticalGroup(
            pnlSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSDTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSua.setBackground(new java.awt.Color(0, 204, 204));
        pnlSua.setPreferredSize(new java.awt.Dimension(80, 24));
        pnlSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSuaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlSuaMouseReleased(evt);
            }
        });

        lblSua.setBackground(new java.awt.Color(255, 255, 255));
        lblSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSua.setForeground(new java.awt.Color(255, 255, 255));
        lblSua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSua.setText("Sửa");

        javax.swing.GroupLayout pnlSuaLayout = new javax.swing.GroupLayout(pnlSua);
        pnlSua.setLayout(pnlSuaLayout);
        pnlSuaLayout.setHorizontalGroup(
            pnlSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnlSuaLayout.setVerticalGroup(
            pnlSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        pnlHuy.setBackground(new java.awt.Color(255, 0, 0));
        pnlHuy.setPreferredSize(new java.awt.Dimension(80, 24));
        pnlHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHuyMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHuyMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlHuyMouseReleased(evt);
            }
        });

        lblHuy.setBackground(new java.awt.Color(255, 255, 255));
        lblHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHuy.setForeground(new java.awt.Color(255, 255, 255));
        lblHuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHuy.setText("Hủy");

        javax.swing.GroupLayout pnlHuyLayout = new javax.swing.GroupLayout(pnlHuy);
        pnlHuy.setLayout(pnlHuyLayout);
        pnlHuyLayout.setHorizontalGroup(
            pnlHuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHuyLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlHuyLayout.setVerticalGroup(
            pnlHuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlEditKHLayout = new javax.swing.GroupLayout(pnlEditKH);
        pnlEditKH.setLayout(pnlEditKHLayout);
        pnlEditKHLayout.setHorizontalGroup(
            pnlEditKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditKHLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pnlEditKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditKHLayout.createSequentialGroup()
                        .addComponent(pnlDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(pnlSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditKHLayout.createSequentialGroup()
                        .addGroup(pnlEditKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditKHLayout.createSequentialGroup()
                                .addComponent(pnlSua, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditKHLayout.createSequentialGroup()
                                .addComponent(pnlMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)))
                        .addGroup(pnlEditKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );
        pnlEditKHLayout.setVerticalGroup(
            pnlEditKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditKHLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlEditKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(pnlEditKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(pnlEditKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSua, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlEditKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlEditKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSuaMousePressed
        changecolor(pnlSua,new Color(0,163,163));
    }//GEN-LAST:event_pnlSuaMousePressed

    private void pnlSuaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSuaMouseReleased
        changecolor(pnlSua,new Color(0,204,204));

        ThemSuaKhachHangForm.btnSuaMouseClicked();

        //        setTableCellAlignment(JLabel.CENTER,pTable);
    }//GEN-LAST:event_pnlSuaMouseReleased

    private void pnlHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHuyMouseClicked

    }//GEN-LAST:event_pnlHuyMouseClicked

    private void pnlHuyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHuyMousePressed
        changecolor(pnlHuy,new Color(221,0,0));
    }//GEN-LAST:event_pnlHuyMousePressed

    private void pnlHuyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHuyMouseReleased
        changecolor(pnlHuy,new Color(255,0,0));
        this.dispose();
    }//GEN-LAST:event_pnlHuyMouseReleased

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblHuy;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSua;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JPanel pnlDiaChi;
    private javax.swing.JPanel pnlEditKH;
    private javax.swing.JPanel pnlHuy;
    private javax.swing.JPanel pnlMaKH;
    private javax.swing.JPanel pnlSDT;
    private javax.swing.JPanel pnlSua;
    private javax.swing.JPanel pnlTenKH;
    public static javax.swing.JTextField txtDiaChi;
    public static javax.swing.JTextField txtMaKH;
    public static javax.swing.JTextField txtSDT;
    public static javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
