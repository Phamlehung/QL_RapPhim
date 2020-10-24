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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josheph
 */
public class QL_RapPhim_user extends javax.swing.JFrame {

   DefaultTableModel dtm = new DefaultTableModel();
    
    public QL_RapPhim_user() {
        initComponents();
        setLocationRelativeTo(this);
        loadData();
        activeControl(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
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
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRapPhim = new javax.swing.JTable();

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
        btnExit.setBounds(320, 460, 90, 50);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Main_User m = new Main_User();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed
    public void loadData(){
   
        String errString = Connect.getConnection();
        Statement stmt;
        if(!errString.equals("")){
            JOptionPane.showConfirmDialog(this, errString, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else {
            String sql = "select * from rap_phim";
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
        txtID.setVisible(!status);
        txtID.setEditable(status);
        txtName.setEditable(status);
        txtPhone.setEditable(status);
        txtAddreses.setEditable(status);
        txtManager.setEditable(status);
        txtPhone.setEditable(status);
        txtKV.setEditable(status);
    }
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
            java.util.logging.Logger.getLogger(QL_RapPhim_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_RapPhim_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_RapPhim_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_RapPhim_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_RapPhim_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
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
