/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Detail;

import SqlConnection.SqlConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author huynh
 */
public class DetailFunc {
    
    public static boolean addDetail(Detail d) {
        String sql = "INSERT INTO CT_HOADON (MaHD, MaSP,SoLuong, GiaBan, GiaGiam)"
                + "VALUES (?,?,?,?,?)";
        try (
                 Connection conn = SqlConnection.getSqlConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, d.getMaHD());
            pstmt.setString(2, d.getMaSP());
            pstmt.setInt(3, d.getSoLuong());
            pstmt.setDouble(4, d.getGiaBan());
            pstmt.setDouble(5, d.getGiaGiam());

            pstmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
        return false;
    }
    
    public static List<Detail> listDetailByID(String id){
        List<Detail> lst = new ArrayList<>();
        String sql = "SELECT * FROM CT_HOADON WHERE MaHD = ?";
        try (
                Connection conn  = SqlConnection.getSqlConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Detail dt = new Detail(rs.getString("MaHD"),rs.getString("MaSP"),rs.getInt("SoLuong"),rs.getDouble("GiaBan"),rs.getDouble("GiaGiam"),rs.getDouble("ThanhTien"));
                lst.add(dt);
            }
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public static String getNameSP(String masp){
        String sql = "SELECT * FROM Sanpham WHERE masp = ?";
        try (
                Connection conn  = SqlConnection.getSqlConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, masp);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                return rs.getString("TenSP");
            
        } catch (Exception e) {
             System.out.println("Error :" + e.getMessage());
             
        }
        return null;
    }
    
    public static Detail getDetail(String mahd, String masp){
        String sql = "SELECT * FROM CT_Hoadon WHERE mahd = ? and masp = ?";
        try (
                Connection conn  = SqlConnection.getSqlConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, mahd);
            pstmt.setString(2, masp);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                 Detail dt = new Detail(rs.getString("MaHD"),rs.getString("MaSP"),rs.getInt("SoLuong"),rs.getDouble("GiaBan"),rs.getDouble("GiaGiam"),rs.getDouble("ThanhTien"));
                 return dt;
            }
            
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return null;
    }

    public static boolean updateDetail(String mahd, String masp, int sl){
        String sql = "Update CT_HOADON set SoLuong= ? where mahd = ? and masp = ?";
        try (
                 Connection conn = SqlConnection.getSqlConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            
            pstmt.setInt(1, sl);
            pstmt.setString(2, mahd);
            pstmt.setString(3, masp);

            pstmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
        return false;
    }
    
    public static boolean deleteSanPham(String mahd, String masp){
        String sql = "Delete from CT_HoaDon where mahd = ? and masp = ?";
        try (
                 Connection conn = SqlConnection.getSqlConnection();  
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            
            pstmt.setString(1, mahd);
            pstmt.setString(2, masp);
            pstmt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
        return false;
    }
    
    
}
