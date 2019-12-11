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
public class WithCon {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        for (int i = 0; i < 201; i++) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test", "root", "");
                //here sonoo is database name, root is username and password  
                Statement stmt = con.createStatement();
                //insert data into database

                String sqlString = ("INSERT INTO `tblwithcon`(col1,col2,col3,col4,col5) VALUES ("+i+","+i+1+","+i+2+","+i+3+","+i+4+")");
                PreparedStatement pstmt = con.prepareStatement(sqlString);
                pstmt.executeUpdate();
                ResultSet rs = stmt.executeQuery("select * from tblwithcon");
                while (rs.next()) {
                    System.out.println(rs.getInt(1)+ " " +rs.getInt(2)+ " " +rs.getInt(3)+ " "+rs.getInt(4)+ " "+rs.getInt(5));
                    
                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);

            }

        }

        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp2);
        //m.timeEnd = m.hour + ":" + m.min+ ":"+m.sec ;
        //System.out.println( m.d2.getHours()+ ":"+ m.d2.getMinutes()+":"+m.d2.getSeconds());

    }
}
