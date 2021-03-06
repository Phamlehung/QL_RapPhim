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
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

    
public class QL_PhongChieu extends javax.swing.JFrame {

    boolean them;
    DefaultTableModel dtm = new DefaultTableModel();
    String sql = null;
    ArrayList<String> marp = new ArrayList<>();
    
    
    public QL_PhongChieu() {
        initComponents();
        setLocationRelativeTo(this);
        loadRP();
        loadData();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
        
    }

    public void loadRP(){
        String errConnect = Connect.getConnection();
        if(!errConnect.equals("")){
            JOptionPane.showConfirmDialog(this, errConnect, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            sql = "select * from rap_phim";
            Statement stmt;
            try{
                stmt = Connect.conn.createStatement();
                try (ResultSet rs = stmt.executeQuery(sql)){
                    while(rs.next()){
                        String marap = rs.getString("ma_rap");
                        marp.add(marap);
                        String tenrp = rs.getString("ten_rap");
                        cboRP.addItem(tenrp);
                    }
                    rs.close();
                }
                stmt.close();
                Connect.conn.close();
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void loadData(){
   
        String errString = Connect.getConnection();
        Statement stmt;
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else {
            sql = "select id_phong, ten_phong, ghe_thuong, ghe_vip, ghe_doi, ten_rap from phong_chieu inner join rap_phim on rap_phim.ma_rap = phong_chieu.id_rap;";
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
                      tblPhongChieu.setModel(dtm);
                  }
                  tblPhongChieu.getSelectionModel().addListSelectionListener(((e) -> {
                        if(tblPhongChieu.getSelectedRow() >= 0){
                            txtID.setText((String) tblPhongChieu.getValueAt(tblPhongChieu.getSelectedRow(), 0));
                            txtName.setText((String) tblPhongChieu.getValueAt(tblPhongChieu.getSelectedRow(), 1));
                            txtNormal.setText((String) tblPhongChieu.getValueAt(tblPhongChieu.getSelectedRow(), 2));
                            txtVip.setText((String) tblPhongChieu.getValueAt(tblPhongChieu.getSelectedRow(), 3));
                            txtDouble.setText((String) tblPhongChieu.getValueAt(tblPhongChieu.getSelectedRow(), 4));
                            cboRP.setSelectedItem(tblPhongChieu.getValueAt(tblPhongChieu.getSelectedRow(), 5));
                        }
                    }));
              }
              stmt.close();
              
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(this, ex.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    public void activeControl(boolean status){
        btnAdd.setVisible(!status);
        btnDelete.setVisible(!status);
        btnUpdate.setVisible(!status);
        btnSave.setVisible(status);
        btnNoSave.setVisible(status);
        txtID.setEditable(status);
        txtName.setEditable(status);
        txtNormal.setEditable(status);
        txtVip.setEditable(status);
        txtDouble.setEditable(status);
        cboRP.setEditable(status);
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
        txtVip = new javax.swing.JTextField();
        txtDouble = new javax.swing.JTextField();
        cboRP = new javax.swing.JComboBox<>();
        txtNormal = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhongChieu = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnNoSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ PHÒNG CHIẾU ");

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHÒNG CHIẾU PHIM");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 710, 110);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 740, 130);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(81, 14, 14), new java.awt.Color(255, 102, 102)));
        jPanel3.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã Phòng Chiếu:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 30, 100, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên Phòng Chiếu:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 110, 110, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ghế Thường:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 190, 100, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ghế Vip:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(370, 30, 100, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ghê Đôi");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(370, 110, 100, 40);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Rạp Phim");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(370, 190, 100, 40);
        jPanel3.add(txtID);
        txtID.setBounds(140, 30, 210, 40);
        jPanel3.add(txtName);
        txtName.setBounds(140, 110, 210, 40);
        jPanel3.add(txtVip);
        txtVip.setBounds(470, 30, 210, 40);
        jPanel3.add(txtDouble);
        txtDouble.setBounds(470, 110, 210, 40);

        cboRP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel3.add(cboRP);
        cboRP.setBounds(470, 190, 210, 40);
        jPanel3.add(txtNormal);
        txtNormal.setBounds(140, 190, 210, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 140, 700, 270);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(110, 440, 90, 40);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(210, 440, 90, 40);

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(620, 440, 80, 40);

        tblPhongChieu.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Phòng Chiếu", "Tên Phòng Chiếu", "Phòng Thường", "Phòng VIP", "Phòng Đôi", "Rạp Phim"
            }
        ));
        jScrollPane1.setViewportView(tblPhongChieu);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 500, 700, 230);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(370, 440, 90, 40);

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);
        btnAdd.setBounds(10, 440, 90, 40);

        btnNoSave.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnNoSave.setText("Không Lưu");
        btnNoSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnNoSave);
        btnNoSave.setBounds(490, 440, 111, 40);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String errString = Connect.getConnection();
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            PreparedStatement pst;
            sql = "delete from phong_chieu where id_phong = ?";
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
        // TODO add your handling code here:
        them = false;
        activeControl(true);
        txtID.setEditable(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Main m = new Main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String errsString = Connect.getConnection();
        if(!errsString.equals("")){
            JOptionPane.showConfirmDialog(this, errsString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                PreparedStatement pst;
                sql = "insert into phong_chieu (ten_phong, ghe_thuong, ghe_vip, ghe_doi, id_rap) values ( ?, ?, ?, ?, ?);";
                if(them){
                    pst = Connect.conn.prepareCall(sql);
                    pst.setString(1, txtName.getText());
                    pst.setInt(2, Integer.parseInt(txtNormal.getText()));
                    pst.setInt(3, Integer.parseInt(txtVip.getText()));
                    pst.setInt(4, Integer.parseInt(txtDouble.getText()));
                    pst.setString(5, marp.get(cboRP.getSelectedIndex()));
                }else{
                    sql="update phong_chieu set ten_phong = ?, ghe_thuong = ?, ghe_vip = ?, ghe_doi = ?, id_rap = ? where id_nv= ?";
                    pst = Connect.conn.prepareCall(sql);
                    pst.setInt(6, Integer.parseInt(txtID.getText()));
                    pst.setString(1, txtName.getText());
                    pst.setInt(2, Integer.parseInt(txtNormal.getText()));
                    pst.setInt(3, Integer.parseInt(txtVip.getText()));
                    pst.setInt(4, Integer.parseInt(txtDouble.getText()));
                    pst.setString(5, marp.get(cboRP.getSelectedIndex()));
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
        // TODO add your handling code here:
        txtID.setVisible(false);
        them = true;
        activeControl(true);
        txtName.requestFocus();
        txtName.setText("");
        txtVip.setText("");
        txtDouble.setText("");
        txtNormal.setText("");
        cboRP.setSelectedIndex(0);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNoSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoSaveActionPerformed
        // TODO add your handling code here:
        them = false;
        loadData();
        activeControl(false);
        tblPhongChieu.setRowSelectionInterval(0, 0);
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
            java.util.logging.Logger.getLogger(QL_PhongChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_PhongChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_PhongChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_PhongChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_PhongChieu().setVisible(true);
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
    private javax.swing.JComboBox<String> cboRP;
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
    private javax.swing.JTable tblPhongChieu;
    private javax.swing.JTextField txtDouble;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNormal;
    private javax.swing.JTextField txtVip;
    // End of variables declaration//GEN-END:variables
}
