/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ql_rapphim;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Josheph
 */
public class DangKy extends javax.swing.JFrame {
    String errString = Connect.getConnection();
    String sql = "";
    /** Creates new form DangKy */
    public DangKy() {
        initComponents();
        setLocationRelativeTo(this);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
        scaleImageLabel("login.jpg", lblbg);
        scaleImageLabel("login.jpg", lblbg1);
    }
    
    public  void scaleImageLabel(String image, JLabel lbl){
        ImageIcon icon = new ImageIcon(getClass().getResource(image));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        lbl.setIcon(scaleIcon);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        txtTK = new javax.swing.JTextField();
        pwMK = new javax.swing.JPasswordField();
        lblbg1 = new javax.swing.JLabel();
        btnDN = new javax.swing.JButton();
        btnLL = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnDK = new javax.swing.JButton();
        lblbg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Ký");

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN ĐĂNG KÝ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 570, 140);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 570, 140);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tài Khoản:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 30, 80, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mật Khẩu:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(30, 100, 80, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tên Đăng Nhập:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 180, 100, 40);
        jPanel3.add(txtTenDN);
        txtTenDN.setBounds(160, 170, 240, 50);
        jPanel3.add(txtTK);
        txtTK.setBounds(160, 20, 240, 50);
        jPanel3.add(pwMK);
        pwMK.setBounds(160, 90, 240, 50);
        jPanel3.add(lblbg1);
        lblbg1.setBounds(0, 0, 460, 290);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(50, 150, 460, 290);

        btnDN.setText("Đăng Nhập");
        btnDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDNActionPerformed(evt);
            }
        });
        jPanel1.add(btnDN);
        btnDN.setBounds(150, 480, 110, 60);

        btnLL.setText("Làm Lại");
        btnLL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLLActionPerformed(evt);
            }
        });
        jPanel1.add(btnLL);
        btnLL.setBounds(310, 480, 90, 60);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btnThoat);
        btnThoat.setBounds(440, 480, 90, 60);

        btnDK.setText("Đăng Ký");
        btnDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDKActionPerformed(evt);
            }
        });
        jPanel1.add(btnDK);
        btnDK.setBounds(20, 480, 90, 60);
        jPanel1.add(lblbg);
        lblbg.setBounds(0, 140, 570, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDKActionPerformed
        // TODO add your handling code here:
        String taikhoan = txtTK.getText();
        String tendn = txtTenDN.getText();
        String matkhau = String.valueOf(pwMK.getPassword());
        matkhau = Connect.MD5(matkhau);
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, "Lỗi Kết Nối CSDL", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else if(taikhoan.equals("")|| matkhau.equals("")||tendn.equals("")){
            JOptionPane.showConfirmDialog(this, "Bạn phải nhập đầu đủ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }else{
            PreparedStatement pstmt;
            sql="insert into Users values (?,?,?,?);";
            try{
                pstmt = Connect.conn.prepareStatement(sql);
                pstmt.setString(1, taikhoan);
                pstmt.setString(2, matkhau);
                pstmt.setString(3, tendn);
                if(pstmt.executeUpdate() != 0){
                JOptionPane.showConfirmDialog(this, "Đã Thêm Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btnDKActionPerformed

    private void btnDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDNActionPerformed
        // TODO add your handling code here:
        DangNhap dn = new DangNhap();
        this.dispose();
        dn.setVisible(true);
    }//GEN-LAST:event_btnDNActionPerformed

    private void btnLLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLLActionPerformed
        // TODO add your handling code here:
        txtTK.setText("");
        pwMK.setText("");
        txtTenDN.setText("");
    }//GEN-LAST:event_btnLLActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDK;
    private javax.swing.JButton btnDN;
    private javax.swing.JButton btnLL;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblbg;
    private javax.swing.JLabel lblbg1;
    private javax.swing.JPasswordField pwMK;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenDN;
    // End of variables declaration//GEN-END:variables

}
