
package com.mycompany.jdbcproject;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class mainClass {
    public static void main(String[] args) {
        try {
            System.out.println("yes this is working");
            Connection c=connection.getConnection();
            
            String q="insert into images(pic) value (?)";
            PreparedStatement pstmt=c.prepareStatement(q);
            
            JFileChooser jpc=new JFileChooser();
            jpc.showOpenDialog(null);
            File file=jpc.getSelectedFile();
            
            FileInputStream fis=new FileInputStream(file);
            
            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Success..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
