/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Detail;

/**
 *
 * @author huynh
 */
public class Detail {
    private String MaHD,MaSP, tenSP;
    private int SoLuong;
    private double GiaBan, GiaGiam,ThanhTien;

    public Detail(String MaHD, String MaSP, int SoLuong, double GiaBan, double GiaGiam, double ThanhTien) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.GiaGiam = GiaGiam;
        this.ThanhTien = ThanhTien;
    }

    public Detail() {
    }
    
    
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public double getGiaGiam() {
        return GiaGiam;
    }

    public void setGiaGiam(double GiaGiam) {
        this.GiaGiam = GiaGiam;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    @Override
    public String toString() {
        return MaHD + " " + MaSP + " " + SoLuong + " " + GiaBan + " " +GiaGiam + " " +ThanhTien; 
    }
    
}
