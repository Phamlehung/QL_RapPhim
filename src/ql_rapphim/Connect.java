/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_rapphim;

import java.awt.Image;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



/**
 *
 * @author Josheph
 */
public class Connect {
    public static Connection conn = null;
    public static String  connString = "jdbc:mysql://localhost:3306/ql_rapphim?"+"user=root&password=123456";
    
    public static String getConnection(){
        String kq = "";
        try{
            conn = DriverManager.getConnection(connString);
        }catch(SQLException ex){
            kq = "Lỗi: "+ ex.getMessage();
            System.err.println(kq);
        }
        return kq;
    }
    
    public static String MD5 (String str){
        String kq="";
        try{
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1, md.digest());
            kq = bigInteger.toString(16);   
            }catch(NoSuchAlgorithmException ex){
                kq = "";
            }
        return kq;
            }

    public  void scaleImageLabel(String image, JLabel lbl){
        ImageIcon icon = new ImageIcon(getClass().getResource(image));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        lbl.setIcon(scaleIcon);
    }
     public void scaleImageButton(String image, JButton btn){
        ImageIcon icon = new ImageIcon(getClass().getResource(image));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        btn.setIcon(scaleIcon);
    
}
}

