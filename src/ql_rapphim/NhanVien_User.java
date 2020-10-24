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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josheph
 */
public class NhanVien_User extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String sql="";
    
    public NhanVien_User() {
        initComponents();
        setLocationRelativeTo(this);
        loadData(null);
        activeControl(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
    }
    
    public void loadData(String name){
        jdBirth.setDate(new java.util.Date()); 
        String errString = Connect.getConnection();
        Statement stmt;
        PreparedStatement pstmt;
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else {
            if(name == null){
            sql = "select * from nhan_vien";
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
                      tblNhanVien.setModel(dtm);
                  }
                  
                  tblNhanVien.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) ->{
                  if(tblNhanVien.getSelectedRow() >=0){
                      txtID.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 0));
                      txtName.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 1));
                      jdBirth.setDateFormatString((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 2));
                      txtPhone.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 3));
                      txtAddress.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 4));
                      txtLevel.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 5));
                  }
                  });
              }
              stmt.close();
              
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        
        }else{
                sql = "select * from nhan_vien where ten_nv = ?";
            try{
              pstmt = Connect.conn.prepareCall(sql);
              pstmt.setString(1, txtName.getText());
              try(ResultSet rs = pstmt.executeQuery(sql)){
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
                      tblNhanVien.setModel(dtm);
                  }
                  
                  tblNhanVien.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) ->{
                  if(tblNhanVien.getSelectedRow() >=0){
                      txtID.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 0));
                      txtName.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 1));
                      jdBirth.setDateFormatString((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 2));
                      txtPhone.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 3));
                      txtAddress.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 4));
                      txtLevel.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 5));
                  }
                  });
              }
              pstmt.close();
              
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            }
            
    }
        }
    public void activeControl(boolean status){
        txtID.setEditable(status);
        txtName.setEditable(status);
        txtPhone.setEditable(status);
        txtAddress.setEditable(status);
        txtLevel.setEditable(status);
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
        txtName = new javax.swing.JTextField();
        jdBirth = new com.toedter.calendar.JDateChooser();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtLevel = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ NHÂN VIÊN");

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(161, 157, 187));
        jPanel2.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(161, 157, 187));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(13, 234, 248));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(140, 20, 430, 80);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 750, 120);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã Nhân Viên:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 30, 100, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên Nhân Viên:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(30, 120, 100, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ngày Sinh:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 210, 100, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Số Điện Thoại:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(370, 30, 100, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Địa Chỉ:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(370, 120, 100, 40);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Chức Vụ:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(370, 210, 100, 40);
        jPanel3.add(txtID);
        txtID.setBounds(140, 30, 210, 40);
        jPanel3.add(txtName);
        txtName.setBounds(140, 120, 210, 40);
        jPanel3.add(jdBirth);
        jdBirth.setBounds(140, 210, 210, 40);
        jPanel3.add(txtPhone);
        txtPhone.setBounds(480, 30, 210, 40);
        jPanel3.add(txtAddress);
        txtAddress.setBounds(480, 120, 210, 40);
        jPanel3.add(txtLevel);
        txtLevel.setBounds(480, 210, 210, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 140, 700, 300);

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(590, 450, 90, 40);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Số Điện Thoại", "Địa Chỉ", "Chức Vụ"
            }
        ));
        jScrollPane1.setViewportView(tblNhanVien);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 520, 700, 230);

        btnFind.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnFind.setText("Tìm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        jPanel1.add(btnFind);
        btnFind.setBounds(310, 460, 90, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Main_User m = new Main_User();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "Mời bạn nhập tên muốn tìm");
        if(input.length()>0){
            loadData(input);
        }
        
    }//GEN-LAST:event_btnFindActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVien_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVien_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdBirth;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLevel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
