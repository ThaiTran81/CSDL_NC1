/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import SqlConnection.SqlConnection;
import java.awt.AlphaComposite;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    
    public Bill findBillById(String maHD){
        String sql = "Select * from KhachHang where MaKH= ?";
        try (
                 Connection conn = SqlConnection.getSqlConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, maHD);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Bill b = new Bill();
                b.setMaHD(rs.getString("MaHD"));
                b.setMaKh(rs.getString("MaKH"));
                b.setNgayLap(rs.getDate("NgayLap").toString());
                b.setTongTien(rs.getDouble("TongTien"));
                return b;
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return null; 
    }
    
    public List<Bill> listBillByID(String maHD){
        List<Bill> lst = new ArrayList<>();
        String sql = "Select * from HoaDon where MaHD= ? "
                + "Order By Case When IsNumeric(mahd) = 1 \n" +
"              Then Right('0000000000000000000' + mahd, 15) \n" +
"              Else mahd End";
        try (
                Connection conn = SqlConnection.getSqlConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, maHD);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setMaHD(rs.getString("MaHD"));
                b.setMaKh(rs.getString("MaKH"));
                b.setNgayLap(rs.getDate("NgayLap").toString());
                b.setTongTien(rs.getDouble("TongTien"));
                lst.add(b);
                System.out.println(b.toString());
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return null; 
    }
    
    public List<Bill> listBillByMaKH(String maKH){
        List<Bill> lst = new ArrayList<>();
        String sql = "Select * from HoaDon where MaKH= ?"
                + " Order By Case When IsNumeric(mahd) = 1 \n" +
"              Then Right('0000000000000000000' + mahd, 15) \n" +
"              Else mahd End";
        try (
                Connection conn = SqlConnection.getSqlConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, maKH);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setMaHD(rs.getString("MaHD"));
                b.setMaKh(rs.getString("MaKH"));
                b.setNgayLap(rs.getDate("NgayLap").toString());
                b.setTongTien(rs.getDouble("TongTien"));
                lst.add(b);
                System.out.println(b.toString());
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return null; 
    }
    
    public List<Bill> listBillByNgayLap(String ngayLap){
        List<Bill> lst = new ArrayList<>();
        String sql = "Select * from HoaDon where NgayLap = ?"
                + " Order By Case When IsNumeric(mahd) = 1 \n" +
"              Then Right('0000000000000000000' + mahd, 15) \n" +
"              Else mahd End";
        try (
                Connection conn = SqlConnection.getSqlConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            String replace = ngayLap.replace("/", "-");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(replace);
            
            pstmt.setDate(1,java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(date)));
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setMaHD(rs.getString("MaHD"));
                b.setMaKh(rs.getString("MaKH"));
                b.setNgayLap(rs.getDate("NgayLap").toString());
                b.setTongTien(rs.getDouble("TongTien"));
                lst.add(b);
                System.out.println(b.toString());
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("ParseException: " + ex.getMessage());
        }
        return null; 
    }
    
    public List<Bill> listBillByHD_KH(String maHD, String maKH){
        List<Bill> lst = new ArrayList<>();
        String sql = "Select * from HoaDon where MaHD = ? and maKH = ?"
                + " Order By Case When IsNumeric(mahd) = 1 \n" +
"              Then Right('0000000000000000000' + mahd, 15) \n" +
"              Else mahd End";
        try (
                Connection conn = SqlConnection.getSqlConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            
            pstmt.setString(1,maHD);
            pstmt.setString(2, maKH);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setMaHD(rs.getString("MaHD"));
                b.setMaKh(rs.getString("MaKH"));
                b.setNgayLap(rs.getDate("NgayLap").toString());
                b.setTongTien(rs.getDouble("TongTien"));
                lst.add(b);
                System.out.println(b.toString());
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return null; 
    }
    
    public List<Bill> listBillByHD_NL(String maHD, String ngayLap){
        List<Bill> lst = new ArrayList<>();
        String sql = "Select * from HoaDon where MaHD = ? and NgayLap = ?"
                + " Order By Case When IsNumeric(mahd) = 1 \n" +
"              Then Right('0000000000000000000' + mahd, 15) \n" +
"              Else mahd End";
        try (
                Connection conn = SqlConnection.getSqlConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            
            pstmt.setString(1,maHD);
            String replace = ngayLap.replace("/", "-");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(replace);
            
            pstmt.setDate(2,java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(date)));
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setMaHD(rs.getString("MaHD"));
                b.setMaKh(rs.getString("MaKH"));
                b.setNgayLap(rs.getDate("NgayLap").toString());
                b.setTongTien(rs.getDouble("TongTien"));
                lst.add(b);
                System.out.println(b.toString());
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("Parse Exception: " + ex.getMessage());
        }
        return null; 
    }
    
    public List<Bill> listBillByKH_NL(String maKH, String ngayLap){
        List<Bill> lst = new ArrayList<>();
        String sql = "Select * from HoaDon where MaKH = ? and NgayLap = ?"
                + " Order By Case When IsNumeric(mahd) = 1 \n" +
"              Then Right('0000000000000000000' + mahd, 15) \n" +
"              Else mahd End";
        try (
                Connection conn = SqlConnection.getSqlConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            
            pstmt.setString(1,maKH);
            String replace = ngayLap.replace("/", "-");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(replace);
            
            pstmt.setDate(2,java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(date)));
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setMaHD(rs.getString("MaHD"));
                b.setMaKh(rs.getString("MaKH"));
                b.setNgayLap(rs.getDate("NgayLap").toString());
                b.setTongTien(rs.getDouble("TongTien"));
                lst.add(b);
                System.out.println(b.toString());
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("Parse Exception: " + ex.getMessage());
        }
        return null; 
    }
    
     public List<Bill> listBill(String maHD,String maKH,String ngayLap){
        List<Bill> lst = new ArrayList<>();
        String sql = "Select * from HoaDon where MaHD = ? and maKH = ? and NgayLap = ?"
                + " Order By Case When IsNumeric(mahd) = 1 \n" +
"              Then Right('0000000000000000000' + mahd, 15) \n" +
"              Else mahd End";
        try (
                Connection conn = SqlConnection.getSqlConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            
            pstmt.setString(1,maHD);
            pstmt.setString(2, maKH);
            String replace = ngayLap.replace("/", "-");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(replace);
            
            pstmt.setDate(3,java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(date)));
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setMaHD(rs.getString("MaHD"));
                b.setMaKh(rs.getString("MaKH"));
                b.setNgayLap(rs.getDate("NgayLap").toString());
                b.setTongTien(rs.getDouble("TongTien"));
                lst.add(b);
                System.out.println(b.toString());
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("Parse Exception: " + ex.getMessage());
        }
        return null; 
    }
    
}
