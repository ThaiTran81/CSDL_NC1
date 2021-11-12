/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
/**
 *
 * @author huynhkha
 */
public class SqlConnection {
    public static Statement st;
    public static Connection conn = null;
    public static SQLAcc sql;
    
   
    public static Connection getSqlConnection() throws SQLServerException {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(sql.usr);
        ds.setPassword(sql.pwd);
        ds.setDatabaseName(sql.db);
        ds.setServerName(sql.sv);
        ds.setPortNumber(sql.prt);
        conn = ds.getConnection();
        return conn;
    }
    public static Connection getSqlConnection(String server, String nameDb, String user, String pass, int port) throws SQLServerException{
        SQLAcc info = new SQLAcc();
        info.sv =server;
        info.db = nameDb;
        info.usr = user;
        info.pwd = pass;
        info.prt = port;
//            info.sv ="localhost";
//        info.db = "QLHD";
//        info.usr = "sa";
//        info.pwd = "sa";
//        info.prt = 1433;

        sql = info;
        conn = getSqlConnection();
        return conn;
    }
    
    public static ResultSet excuteQuery(String query) throws SQLServerException {
        ResultSet res = null;
        Statement stmt = null;
        conn = getSqlConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            res = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public static void excuteQueryUpdate(String query) throws SQLServerException, SQLException{
        conn = getSqlConnection();
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
};

class SQLAcc{
    public String sv;
    public String db;
    public String usr;
    public String pwd;
    public int prt = 0;
}