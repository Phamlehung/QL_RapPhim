/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_rapphim;

import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josheph
 */
public class QL_XuatChieu extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ArrayList<String> phongchieu = new ArrayList<>();
    ArrayList<String> phim = new ArrayList<>();
    boolean them;
    String sql;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    
    public QL_XuatChieu() {
        initComponents();
        setLocationRelativeTo(this);
        loadPhongChieu();
        loadPhim();
        loadData();
        activeControl(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
    }

    public void loadPhongChieu(){
        String errString = Connect.getConnection();
        
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            sql = "select * from phong_chieu;";
            Statement stmt;
            
            try{
                stmt = Connect.conn.createStatement();
                
                try(ResultSet rs = stmt.executeQuery(sql)){
                    while(rs.next()){
                        String maphongchieu = rs.getString("id_phong");
                        phongchieu.add(maphongchieu);
                        String tenpc = rs.getString("ten_phong");
                        cboPC.addItem(tenpc);
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
    
    public void loadPhim(){
        String errString = Connect.getConnection();
        
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            sql = "select * from phim;";
            Statement stmt;
            try{
                stmt = Connect.conn.createStatement();
                
                try (ResultSet rs = stmt.executeQuery(sql)){
                   while(rs.next()){
                       String maphim = rs.getString("ma_phim");
                       phim.add(maphim);
                       String tenphim = rs.getString("ten_phim");
                       cboPhim.addItem(tenphim);
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
        jdNgayBD.setDate(new java.util.Date());
        jdNgayKT.setDate(new java.util.Date());
        String errString = Connect.getConnection();
        
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
            
        }else{
            sql = "select ma_xc, ten_phim, ten_phong, gio_bd, gio_kt, ngay_bd, ngay_kt from ((xuat_chieu inner join phong_chieu on xuat_chieu.ma_phong = phong_chieu.id_rap) inner join phim on xuat_chieu.ma_phim = phim.ma_phim);";
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
                        cboPC.setSelectedItem(tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 1));
                        cboPhim.setSelectedItem(tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 2));
                        txtGioBD.setText((String) tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 3));
                        txtGioKT.setText((String) tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 4));
                        jdNgayBD.setDateFormatString( (String) tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 5));
                        jdNgayKT.setDateFormatString( (String) tblXuatChieu.getValueAt(tblXuatChieu.getSelectedRow(), 6));
                    }
                });
                
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void activeControl(boolean status){
        btnAdd.setVisible(!status);
        btnDelete.setVisible(!status);
        btnUpdate.setVisible(!status);
        btnSave.setVisible(status);
        btnNoSave.setVisible(status);
        txtID.setVisible(!status);
        txtID.setEditable(status);
        txtGioBD.setEditable(status);
        txtGioKT.setEditable(status);
        cboPC.setEditable(status);
        cboPhim.setEditable(status);
        jdNgayBD.setEnabled(status);
        jdNgayKT.setEnabled(status);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGioBD = new javax.swing.JTextField();
        txtGioKT = new javax.swing.JTextField();
        cboPC = new javax.swing.JComboBox<>();
        cboPhim = new javax.swing.JComboBox<>();
        jdNgayBD = new com.toedter.calendar.JDateChooser();
        jdNgayKT = new com.toedter.calendar.JDateChooser();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXuatChieu = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnNoSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ XUẤT CHIẾU");

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ XUẤT CHIẾU");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 710, 110);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 740, 130);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(81, 14, 14), new java.awt.Color(255, 102, 102)));
        jPanel3.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã Xuất Chiếu:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 30, 100, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Phòng Chiếu:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 90, 110, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Phim:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 150, 100, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Giờ Bắt Đầu:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(30, 210, 100, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Giờ Kết Thúc");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(360, 30, 100, 40);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ngày Băt Đầu:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(360, 110, 100, 40);
        jPanel3.add(txtID);
        txtID.setBounds(140, 30, 210, 40);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ngày Kết Thúc:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(360, 180, 100, 40);
        jPanel3.add(txtGioBD);
        txtGioBD.setBounds(140, 210, 210, 40);
        jPanel3.add(txtGioKT);
        txtGioKT.setBounds(480, 30, 210, 40);

        jPanel3.add(cboPC);
        cboPC.setBounds(140, 90, 210, 40);

        jPanel3.add(cboPhim);
        cboPhim.setBounds(140, 150, 210, 40);
        jPanel3.add(jdNgayBD);
        jdNgayBD.setBounds(480, 110, 210, 40);
        jPanel3.add(jdNgayKT);
        jdNgayKT.setBounds(480, 180, 210, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 140, 700, 260);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(120, 420, 90, 40);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(220, 420, 90, 40);

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(630, 420, 80, 40);

        tblXuatChieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Xuất Chiếu", "Phòng Chiếu", "Phim", "Giờ Bắt Đầu", "Giờ Kết Thúc", "Ngày Bắt Đầu", "Ngày Kết Thúc"
            }
        ));
        jScrollPane1.setViewportView(tblXuatChieu);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 480, 700, 150);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(380, 420, 90, 40);

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);
        btnAdd.setBounds(20, 420, 90, 40);

        btnNoSave.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnNoSave.setText("Không Lưu");
        btnNoSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnNoSave);
        btnNoSave.setBounds(500, 420, 111, 40);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
String errString = Connect.getConnection();
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            txtID.setVisible(true);
            PreparedStatement pst;
            sql = "delete from xuat_chieu where ma_xc = ?";
            try{
                PreparedStatement pstmt;
                pstmt = Connect.conn.prepareCall(sql);
                pstmt.setInt(1, Integer.parseInt(txtID.getText()));
                int kq = pstmt.executeUpdate();
                if(kq>0){
                    JOptionPane.showConfirmDialog(this, "Bạn đã xóa thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
                dtm.setRowCount(0);
                loadData();

            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(), "Lổi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        them = false;
        activeControl(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Main m = new Main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String errsString = Connect.getConnection();
        if(!errsString.equals("")){
            JOptionPane.showConfirmDialog(this, errsString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                PreparedStatement pst;
                sql = "insert into xuat_chieu(ma_phong, ma_phim, gio_bd, gio_kt, ngay_bd, ngay_kt) values (?, ?, ?, ?, ?, ?);";
                if(them){
                    pst = Connect.conn.prepareCall(sql);
                    pst.setString(1, phongchieu.get(cboPC.getSelectedIndex()));
                    pst.setString(2, phim.get(cboPhim.getSelectedIndex()));
                    pst.setString(3, txtGioBD.getText());
                    pst.setString(4, txtGioKT.getText());
                    String date = sdf.format(jdNgayBD.getDate());
                    pst.setString(5, date);
                    String dateKT = sdf.format(jdNgayKT.getDate());
                    pst.setString(6, dateKT);

                }else{
                    sql="update xuat_chieu set ma_phong = ?, ma_phim = ?, gio_bd = ?, gio_kt = ?, ngay_bd = ?, ngay_kt = ? where ma_xc= ?";
                    pst = Connect.conn.prepareCall(sql);
                    pst.setInt(7, Integer.parseInt(txtID.getText()));
                    pst.setString(1, phongchieu.get(cboPC.getSelectedIndex()));
                    pst.setString(2, phim.get(cboPhim.getSelectedIndex()));
                    pst.setString(3, txtGioBD.getText());
                    pst.setString(4, txtGioKT.getText());
                    String date = sdf.format(jdNgayBD.getDate());
                    pst.setString(5, date);
                    String dateKT = sdf.format(jdNgayKT.getDate());
                    pst.setString(6, dateKT);
                }
                int kq = pst.executeUpdate();
                if(kq>0){
                    if(them){
                        JOptionPane.showConfirmDialog(this, "Đã thêm thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                        them = false;
                    }else{
                        JOptionPane.showConfirmDialog(this, "Đã sửa thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                    dtm.setRowCount(0);
                    loadData();
                    activeControl(false);
                }
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        them = true;
        activeControl(true);
        txtID.setText("");
        txtGioBD.setText("");
        txtGioKT.setText("");
        cboPC.setSelectedIndex(0);
        cboPhim.setSelectedIndex(0);
        jdNgayBD.setDate(new java.util.Date());
        jdNgayKT.setDate(new java.util.Date());
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNoSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoSaveActionPerformed
        them = false;
        loadData();
        activeControl(false);
        tblXuatChieu.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_btnNoSaveActionPerformed

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
            java.util.logging.Logger.getLogger(QL_XuatChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_XuatChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_XuatChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_XuatChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_XuatChieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNoSave;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboPC;
    private javax.swing.JComboBox<String> cboPhim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdNgayBD;
    private com.toedter.calendar.JDateChooser jdNgayKT;
    private javax.swing.JTable tblXuatChieu;
    private javax.swing.JTextField txtGioBD;
    private javax.swing.JTextField txtGioKT;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
