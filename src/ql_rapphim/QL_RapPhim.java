/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesg
 * and open the template in the editor.
 */
package ql_rapphim;

import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josheph
 */
public class QL_RapPhim extends javax.swing.JFrame {
    boolean them;
    DefaultTableModel dtm = new DefaultTableModel();
    String sql = null;
    public QL_RapPhim() {
        initComponents();
        loadData();
        setLocationRelativeTo(this);
        activeControl(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
    }

    public void loadData(){
   
        String errString = Connect.getConnection();
        Statement stmt;
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else {
            sql = "select * from rap_phim";
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
                      tblRapPhim.setModel(dtm);
                  }
                  tblRapPhim.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) ->{
                  if(tblRapPhim.getSelectedRow() >=0){
                      txtID.setText((String) tblRapPhim.getValueAt(tblRapPhim.getSelectedRow(), 0));
                      txtName.setText((String) tblRapPhim.getValueAt(tblRapPhim.getSelectedRow(), 1));
                      txtAddreses.setText((String) tblRapPhim.getValueAt(tblRapPhim.getSelectedRow(), 2));
                      txtPhone.setText((String) tblRapPhim.getValueAt(tblRapPhim.getSelectedRow(), 3));
                      txtManager.setText((String) tblRapPhim.getValueAt(tblRapPhim.getSelectedRow(), 4));
                      txtKV.setText((String) tblRapPhim.getValueAt(tblRapPhim.getSelectedRow(), 5));
                  }
                  });
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
        btnEdit.setVisible(!status);
        txtID.setVisible(!status);
        btnSave.setVisible(status);
        btnNoSave.setVisible(status);
        txtID.setEditable(status);
        txtName.setEditable(status);
        txtPhone.setEditable(status);
        txtAddreses.setEditable(status);
        txtManager.setEditable(status);
        txtPhone.setEditable(status);
        txtKV.setEditable(status);
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
        txtAddreses = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtManager = new javax.swing.JTextField();
        txtKV = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRapPhim = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnNoSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ RẠP PHIM");

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(235, 163, 178));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ RẠP PHIM");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(120, 20, 470, 90);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 750, 130);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã Rạp Phim:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(40, 40, 90, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên Rạp Phim:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(40, 120, 90, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Địa Chỉ:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(40, 220, 90, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Số Điện Thoại:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(360, 40, 90, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Người Quản Lý:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(360, 110, 90, 30);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Khu Vực:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(360, 220, 90, 30);
        jPanel3.add(txtID);
        txtID.setBounds(140, 30, 190, 40);
        jPanel3.add(txtName);
        txtName.setBounds(140, 110, 190, 40);
        jPanel3.add(txtAddreses);
        txtAddreses.setBounds(140, 210, 190, 40);
        jPanel3.add(txtPhone);
        txtPhone.setBounds(460, 30, 190, 40);
        jPanel3.add(txtManager);
        txtManager.setBounds(460, 110, 190, 40);
        jPanel3.add(txtKV);
        txtKV.setBounds(460, 210, 190, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(30, 150, 670, 290);

        btnAdd.setBackground(new java.awt.Color(102, 0, 0));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(204, 204, 204));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);
        btnAdd.setBounds(20, 460, 90, 50);

        btnDelete.setBackground(new java.awt.Color(102, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(204, 204, 204));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(130, 460, 90, 50);

        btnEdit.setBackground(new java.awt.Color(102, 0, 0));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(204, 204, 204));
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(240, 460, 90, 50);

        btnExit.setBackground(new java.awt.Color(102, 0, 0));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnExit.setForeground(new java.awt.Color(204, 204, 204));
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(620, 460, 90, 50);

        tblRapPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Rạp Phim", "Tên Rạp Phim", "Địa Chỉ", "Số Điện Thoai", "Người Quản Lý", "Khu Vực"
            }
        ));
        jScrollPane1.setViewportView(tblRapPhim);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 520, 690, 170);

        btnSave.setBackground(new java.awt.Color(102, 0, 0));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnSave.setForeground(new java.awt.Color(204, 204, 204));
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(380, 460, 90, 50);

        btnNoSave.setBackground(new java.awt.Color(102, 0, 0));
        btnNoSave.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnNoSave.setForeground(new java.awt.Color(204, 204, 204));
        btnNoSave.setText("Không Lưu");
        btnNoSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnNoSave);
        btnNoSave.setBounds(490, 460, 110, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        them = true;
        activeControl(true);
        txtName.requestFocus();
        txtName.setText("");
        txtPhone.setText("(+84)");
        txtAddreses.setText("");
        txtManager.setText("");
        txtKV.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String errsString = Connect.getConnection();
        if(!errsString.equals("")){
            JOptionPane.showConfirmDialog(this, errsString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                PreparedStatement pst;
                sql = "insert into rap_phim(ten_rap, dia_chi, sdt, nguoi_quan_ly, khu_vuc) values (?, ?, ?, ?, ?);";
                if(them){
                    pst = Connect.conn.prepareCall(sql);
                    pst.setString(1, txtName.getText());
                    pst.setString(2, txtAddreses.getText());
                    pst.setString(3, txtPhone.getText());
                    pst.setInt(4, Integer.parseInt(txtManager.getText()));
                    pst.setString(5, txtKV.getText());
                }else{
                    sql="update rap_phim set ten_rap = ?, dia_chi = ?, sdt = ?, nguoi_quan_ly = ?, khu_vuc = ? where ma_rap= ?";
                    pst = Connect.conn.prepareCall(sql);
                    pst.setInt(6, Integer.parseInt(txtID.getText()));
                    pst.setString(1, txtName.getText());
                    pst.setString(2, txtAddreses.getText());
                    pst.setString(3, txtPhone.getText());
                    pst.setInt(4,Integer.parseInt (txtManager.getText()));
                    pst.setString(5, txtKV.getText());
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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        them = false;
        activeControl(true);
        txtID.setEditable(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnNoSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoSaveActionPerformed
        // TODO add your handling code here:
        them = false;
        loadData();
        activeControl(false);
        tblRapPhim.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_btnNoSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
         String errString = Connect.getConnection();
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            PreparedStatement pst;
            sql = "delete from rap_phim where ma_rap = ?";
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
            java.util.logging.Logger.getLogger(QL_RapPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_RapPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_RapPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_RapPhim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_RapPhim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNoSave;
    private javax.swing.JButton btnSave;
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
    private javax.swing.JTable tblRapPhim;
    private javax.swing.JTextField txtAddreses;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtKV;
    private javax.swing.JTextField txtManager;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}