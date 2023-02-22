/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author FPT
 */
public class Ve {
  
    String MaVe, MaCB, LoaiVe;
    double GiaVe;
    int SoLuong, SoLuongCon;

    public Ve() {
    }

    public Ve(String MaVe, String MaCB, String LoaiVe, double GiaVe, int SoLuong, int SoLuongCon) {
        this.MaVe = MaVe;
        this.MaCB = MaCB;
        this.LoaiVe = LoaiVe;
        this.GiaVe = GiaVe;
        this.SoLuong = SoLuong;
        this.SoLuongCon = SoLuongCon;
    }

    public String getMaVe() {
        return MaVe;
    }

    public void setMaVe(String MaVe) {
        this.MaVe = MaVe;
    }

    public String getMaCB() {
        return MaCB;
    }

    public void setMaCB(String MaCB) {
        this.MaCB = MaCB;
    }

    public String getLoaiVe() {
        return LoaiVe;
    }

    public void setLoaiVe(String LoaiVe) {
        this.LoaiVe = LoaiVe;
    }

    public double getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(double GiaVe) {
        this.GiaVe = GiaVe;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getSoLuongCon() {
        return SoLuongCon;
    }

    public void setSoLuongCon(int SoLuongCon) {
        this.SoLuongCon = SoLuongCon;
    }
}
