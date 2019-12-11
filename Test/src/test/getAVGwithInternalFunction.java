/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author laboradagr_sd2082
 */
public class getAVGwithInternalFunction {

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

            ResultSet rs = stmt.executeQuery("SELECT AVG(col1),AVG(col2),AVG(col3),AVG(col4),AVG(col5) FROM tblwithoutcon ");

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getInt(2));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getInt(4));
                System.out.println(rs.getInt(5));
            }

            Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp2);

            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
