/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author laboradagr_sd2082
 */
public class deleteWithoutCon {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "");
            //here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            //insert data into database
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp);
            for (int i = 0; i < 1001; i++) {
                String sqlString = ("DELETE FROM `tblwithoutcon` WHERE `col1` = "+i+"");
                PreparedStatement pstmt = con.prepareStatement(sqlString);

                pstmt.executeUpdate();

                
                ResultSet rs = stmt.executeQuery("select * from tblwithoutcon");
                while (rs.next()) {
                    System.out.println("deleted");
                    
                }
            }
            Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp2);
            

            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

        
    

    }
}



