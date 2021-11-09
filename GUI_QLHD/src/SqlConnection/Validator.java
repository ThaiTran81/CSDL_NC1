/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SqlConnection;

import java.awt.Color;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huynhkha
 */
public class Validator {

    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage) {
        if (field.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.white);
        }
    }

    /**
     *
     * @param maKH
     * @return
     */
    public static boolean validateExistingKH(String maKH) {
        String sql = "Select * from KhachHang where MaKH= ?";
        try (
                 Connection conn = SqlConnection.getSqlConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, maKH);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return false;
    }

    public static boolean validateExistingBillID(String billID) {
        String sql = "Select * from KhachHang where MaKH= ?";
        try (
                 Connection conn = SqlConnection.getSqlConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, billID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return false;
    }

}
