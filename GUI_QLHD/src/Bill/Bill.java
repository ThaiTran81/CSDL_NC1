/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bill;

import java.util.Date;

/**
 *
 * @author huynhkha
 */
public class Bill {
    private String maHD, maKh, ngayLap;
    private double tongTien;

    public Bill() {
    }

    public Bill(String maHD, String maKh, String ngayLap, double tongTien) {
        this.maHD = maHD;
        this.maKh = maKh;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
   
}
