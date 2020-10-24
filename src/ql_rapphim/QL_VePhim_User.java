/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ql_rapphim;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josheph
 */
public class QL_VePhim_User extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ArrayList<String> khachhang = new ArrayList<>();
    ArrayList<String> nhanvien = new ArrayList<>();
    String sql;
    /** Creates new form QL_VePhim_User */
    public QL_VePhim_User() {
        initComponents();
        setLocationRelativeTo(this);
        loadKhachHang();
        loadNhanVien();
        loadData();
        activeControl(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
    }
    
    public void loadKhachHang(){
        String errString = Connect.getConnection();
        
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            sql = "select * from khach_hang;";
            Statement stmt;
            
            try{
                stmt = Connect.conn.createStatement();
                
                try(ResultSet rs = stmt.executeQuery(sql)){
                    while(rs.next()){
                        String makh = rs.getString("ma_kh");
                        khachhang.add(makh);
                        String tenkh = rs.getString("ten_kh");
                        cboKH.addItem(tenkh);
                    }
                    rs.close();
                }
                Connect.conn.close();
                stmt.close();
                
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void loadNhanVien(){
        String errString = Connect.getConnection();
        
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            sql = "select * from nhan_vien;";
            Statement stmt;
            try{
                stmt = Connect.conn.createStatement();
                
                try (ResultSet rs = stmt.executeQuery(sql)){
                   while(rs.next()){
                       String manv = rs.getString("id_nv");
                       nhanvien.add(manv);
                       String tenphim = rs.getString("ten_nv");
                       cboNV.addItem(tenphim);
                   }
                   rs.close();
                }
                Connect.conn.close();
                stmt.close();
                
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    public void loadData(){
        
        String errString = Connect.getConnection();
        
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
            
        }else{
            sql = "select id_ve, ten_kh, ten_nv, so_ghe, gia, xuat_chieu.ma_xc from (((vephim inner join khach_hang on vephim.ma_kh = khach_hang.ma_kh) inner join nhan_vien on vephim.ma_nv = nhan_vien.id_nv) inner join xuat_chieu on vephim.id_xc = xuat_chieu.ma_xc);";
            Statement stmt;
            
            try{
                stmt = Connect.conn.createStatement();
                
                try(ResultSet rs = stmt.executeQuery(sql)){
                  ResultSetMetaData rsmd = rs.getMetaData();
                  int n = rsmd.getColumnCount();
                  Vector col, row;
                  col = new Vector();
                  for (int i = 1; i <= n; i++) {
                      col.add(rsmd.getColumnName(i));
                  }
                  dtm.setColumnIdentifiers(col);
                  while (rs.next()) {                      
                      row = new Vector();
                      for (int i = 1; i <= n; i++) {
                          row.addElement(rs.getString(i));
                      }
                      dtm.addRow(row);
                      tblXuatChieu.setModel(dtm);
                  }
                }
                tblXuatChieu.getSelectionModel().addListSelectionListener((e) -> {
                    if(tblXuatChieu.getSelectedRow() >= 0){
                        txtID.setText((String) tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 0));
                        cboKH.setSelectedItem(tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 1));
                        cboNV.setSelectedItem(tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 2));
                        txtSoGhe.setText((String) tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 3));
                        txtGia.setText((String) tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 4));
                        txtXC.setText((String) tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 5));
                       
                    }
                });
                
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void activeControl(boolean status){
        txtID.setEditable(status);
        txtSoGhe.setEditable(status);
        txtXC.setEditable(status);
        cboNV.setEditable(status);
        cboKH.setEditable(status);
        txtGia.setEditable(status);
        
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSoGhe = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        cboKH = new javax.swing.JComboBox<>();
        cboNV = new javax.swing.JComboBox<>();
        txtXC = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXuatChieu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ VÉ PHIM");

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ VÉ PHIM");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 710, 110);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 740, 130);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(81, 14, 14), new java.awt.Color(255, 102, 102)));
        jPanel3.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã Vé Phim:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 30, 100, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Khách Hàng:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 90, 110, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nhân Viên:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 150, 100, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Số Ghế:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(370, 30, 100, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Giá:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(370, 90, 100, 40);
        jPanel3.add(txtID);
        txtID.setBounds(140, 30, 210, 40);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Xuất Chiếu:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(370, 150, 100, 40);
        jPanel3.add(txtSoGhe);
        txtSoGhe.setBounds(470, 30, 210, 40);
        jPanel3.add(txtGia);
        txtGia.setBounds(470, 90, 210, 40);

        jPanel3.add(cboKH);
        cboKH.setBounds(140, 90, 210, 40);

        jPanel3.add(cboNV);
        cboNV.setBounds(140, 150, 210, 40);
        jPanel3.add(txtXC);
        txtXC.setBounds(470, 150, 210, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 140, 700, 220);

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(330, 380, 80, 40);

        tblXuatChieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Vé Phim", "Khách Hàng", "Nhân Viên", "Số Ghế", "Giờ Kết Thúc", "Xuất Chiếu"
            }
        ));
        jScrollPane1.setViewportView(tblXuatChieu);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 440, 700, 130);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Main m = new Main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(QL_VePhim_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_VePhim_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_VePhim_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_VePhim_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_VePhim_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cboKH;
    private javax.swing.JComboBox<String> cboNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblXuatChieu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSoGhe;
    private javax.swing.JTextField txtXC;
    // End of variables declaration//GEN-END:variables

}
