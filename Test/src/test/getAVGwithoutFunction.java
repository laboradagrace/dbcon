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
public class getAVGwithoutFunction {

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
      
            ResultSet rs = stmt.executeQuery("SELECT SUM(col1),SUM(col2),SUM(col3),SUM(col4),SUM(col5) FROM tblwithoutcon ");
  
            while (rs.next()) {
                System.out.println(rs.getInt(1)/1000);
                System.out.println(rs.getInt(2)/1000);
                System.out.println(rs.getInt(3)/1000);
                System.out.println(rs.getInt(4)/1000);
                System.out.println(rs.getInt(5)/1000);
            }
            
            
            Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp2);

            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }
}
