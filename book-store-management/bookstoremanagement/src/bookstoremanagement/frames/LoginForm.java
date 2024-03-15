/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bookstoremanagement.frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlicuahangdienthoai.MainPage;
import quanlicuahangdienthoai.model.BackEnd.QuanLyNhanVien.NhanVien;
import quanlicuahangdienthoai.model.BackEnd.QuanLyNhanVien.QuanLyNhanVienBUS;
import quanlicuahangdienthoai.model.BackEnd.QuanLyQuyen.QuanLyQuyenBUS;
import quanlicuahangdienthoai.model.BackEnd.QuanLyQuyen.Quyen;
import quanlicuahangdienthoai.model.BackEnd.QuanLyTaiKhoan.QuanLyTaiKhoanBUS;
import quanlicuahangdienthoai.model.BackEnd.QuanLyTaiKhoan.TaiKhoan;
/**
 *
 * @author ACER
 */
public class LoginForm extends javax.swing.JFrame {
    int mouseX;
    int mouseY;
    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        SetIcon();
        KeyAdapter ka = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnDangNhap.doClick();
                }
            }
        };
        txTenDangNhap.addKeyListener(ka);
        txMatKhau.addKeyListener(ka);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        txTenDangNhap = new javax.swing.JTextField();
        txMatKhau = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        Nutthunho = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Nutdong = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnDangNhap = new com.k33ptoo.components.KButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(840, 550));

        kGradientPanel1.setkEndColor(new java.awt.Color(5, 218, 248));
        kGradientPanel1.setkGradientFocus(-200);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(800, 410));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(800, 410));
        kGradientPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseDragged(evt);
            }
        });
        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel1MousePressed(evt);
            }
        });
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        txTenDangNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txTenDangNhap.setCaretColor(new java.awt.Color(0, 255, 255));
        txTenDangNhap.setOpaque(false);
        txTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTenDangNhapActionPerformed(evt);
            }
        });
        kGradientPanel1.add(txTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 340, 30));

        txMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        txMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txMatKhau.setCaretColor(new java.awt.Color(0, 204, 204));
        txMatKhau.setOpaque(false);
        txMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txMatKhauActionPerformed(evt);
            }
        });
        kGradientPanel1.add(txMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 340, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Tài khoản");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 120, 30));

        Nutthunho.setBackground(new java.awt.Color(0, 0, 0));
        Nutthunho.setMinimumSize(new java.awt.Dimension(75, 50));
        Nutthunho.setPreferredSize(new java.awt.Dimension(50, 50));
        Nutthunho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NutthunhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NutthunhoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NutthunhoMousePressed(evt);
            }
        });
        Nutthunho.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlicuahangdienthoai/icons/icons8-subtract-30.png"))); // NOI18N
        Nutthunho.add(jLabel3, java.awt.BorderLayout.CENTER);

        kGradientPanel1.add(Nutthunho, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, -1));

        Nutdong.setBackground(new java.awt.Color(0, 0, 0));
        Nutdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NutdongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NutdongMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NutdongMousePressed(evt);
            }
        });
        Nutdong.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlicuahangdienthoai/icons/icons8-close-30.png"))); // NOI18N
        Nutdong.add(jLabel4, java.awt.BorderLayout.CENTER);

        kGradientPanel1.add(Nutdong, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 50, 50));

        btnDangNhap.setBorder(null);
        btnDangNhap.setText("Đăng  Nhập");
        btnDangNhap.setActionCommand("Đăng Nhập");
        btnDangNhap.setContentAreaFilled(false);
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btnDangNhap.setkBorderRadius(40);
        btnDangNhap.setkEndColor(new java.awt.Color(5, 218, 248));
        btnDangNhap.setkFillButton(false);
        btnDangNhap.setkHoverEndColor(new java.awt.Color(102, 102, 255));
        btnDangNhap.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnDangNhap.setkHoverStartColor(new java.awt.Color(5, 218, 248));
        btnDangNhap.setkStartColor(new java.awt.Color(255, 255, 255));
        btnDangNhap.setRequestFocusEnabled(false);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 340, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Mật khẩu");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 120, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlicuahangdienthoai/icons/output-onlinepngtools (2) (1).png"))); // NOI18N
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Monga");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlicuahangdienthoai/icons/icons8-male-user-64.png"))); // NOI18N
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 80, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTenDangNhapActionPerformed

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
                                                     
       int cordX = evt.getXOnScreen();
       int cordY = evt.getYOnScreen();
       
       this.setLocation(cordX - mouseX,cordY - mouseY);
     
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void NutthunhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NutthunhoMouseEntered
        MainPage.changecolor(Nutthunho, new Color(1,44,51));
    }//GEN-LAST:event_NutthunhoMouseEntered

    private void NutthunhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NutthunhoMouseExited
        MainPage.changecolor(Nutthunho, new Color(0,0,0));
    }//GEN-LAST:event_NutthunhoMouseExited

    private void NutthunhoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NutthunhoMousePressed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_NutthunhoMousePressed

    private void NutdongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NutdongMouseEntered
        MainPage.changecolor(Nutdong, new Color(1,44,51));
    }//GEN-LAST:event_NutdongMouseEntered

    private void NutdongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NutdongMouseExited
        MainPage.changecolor(Nutdong, new Color(0,0,0));
    }//GEN-LAST:event_NutdongMouseExited

    private void NutdongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NutdongMousePressed
        this.dispose();
    }//GEN-LAST:event_NutdongMousePressed

    private void txMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMatKhauActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String tentk = txTenDangNhap.getText();
        String mk = txMatKhau.getText();
        QuanLyTaiKhoanBUS qltk = new QuanLyTaiKhoanBUS();
        TaiKhoan tk = qltk.getTaiKhoan(tentk);

        if (tk != null) {
            // check xem nhân viên của tài khoản này có bị khóa (Ẩn) hay không
            NhanVien nv = new QuanLyNhanVienBUS().getNhanVien(tk.getMaNV());
            if (nv.getTrangThai() == 1) {
                JOptionPane.showMessageDialog(this, "Tài khoản này đã bị khóa, do chủ nhân tài khoản này đã bị ẨN khỏi hệ thống!");
                return;
            }

            // check password
            if (tk.getPassword().equals(mk)) {
                taiKhoanLogin = tk;
                nhanVienLogin = nv;
                quyenLogin = new QuanLyQuyenBUS().getQuyen(taiKhoanLogin.getMaQuyen());

                // Đăng nhập thành công
                

                new MainPage().setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu!");
                txMatKhau.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập!");
            txTenDangNhap.requestFocus();
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String args[]) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new LoginForm().setVisible(true);
            }
        });
    }
    
    public static Quyen quyenLogin;
    public static NhanVien nhanVienLogin;
    public static TaiKhoan taiKhoanLogin;
    
    
     public void SetIcon() {
      ImageIcon icon = new ImageIcon(getClass().getResource("/quanlicuahangdienthoai/images/icons8-mango-641.png"));
      Image img = icon.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
      setIconImage(img);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Nutdong;
    private javax.swing.JPanel Nutthunho;
    private com.k33ptoo.components.KButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPasswordField txMatKhau;
    private javax.swing.JTextField txTenDangNhap;
    // End of variables declaration//GEN-END:variables

   

    
}
