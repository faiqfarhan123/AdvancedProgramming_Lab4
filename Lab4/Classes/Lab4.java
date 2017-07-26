/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfarhan.bscs13seecs
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //authentication
        try {
            Connection connection = null;

            try {
                //Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Open a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "seecs@123");
            try {
                //set this values using PreparedStatement
                Statement s = connection.createStatement();

                ResultSet results = s.executeQuery("SELECT * FROM user where userName='faiq' and password='nust'"); //where ps is Object of PreparedStatement
                while (results.next()) {
                    System.out.println(results.getString("userName"));
                }

            } catch (SQLException sql) {

                System.out.println(sql);
            } finally {
                //closing ResultSet,PreparedStatement and Connection object
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
        //initialising table
        ApplicationSystem mgs = new ApplicationSystem();
        mgs.initTable();
        //mgs.makeReservation(2, LocalTime.MIN);

    }
}
