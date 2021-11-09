/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huynhkha
 */
public class SqlConnection {

    public static Connection getSqlConnection() {

        try {
         
            String connectionUrl = "jdbc:sqlserver://localhost;databaseName=QLHD";
            String username = "sa";
            String password = "sa";
            Connection connection = DriverManager.getConnection(connectionUrl, username, password);       
            return connection;
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println("Failed to connection database: " + e.getMessage());
        }
        return null;
    }
}
