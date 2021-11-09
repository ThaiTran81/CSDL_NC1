/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import SqlConnection.SqlConnection;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huynhkha
 */
public class BillFunc {

    public boolean addBillToDatabase(Bill b) {
        String sql = "insert into HoaDon (MaHD, MaKH,NgayLap) values (?,?,?)";

        try (
                Connection conn = SqlConnection.getSqlConnection();  
                PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, b.getMaHD());
            pstmt.setString(2, b.getMaKh());
            pstmt.setDate(3, java.sql.Date.valueOf(b.getNgayLap()));

            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return false;
    }
    
    
}
