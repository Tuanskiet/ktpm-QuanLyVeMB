/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author pc
 */
public class QLVE {
    private String maVe,MaCB,loaiVe;
    private double giaVe ;
    private int soLuong, soLuongcon;

    public QLVE() {
    }

    public QLVE(String maVe, String MaCB, String loaiVe, double giaVe, int soLuong, int soLuongcon) {
        this.maVe = maVe;
        this.MaCB = MaCB;
        this.loaiVe = loaiVe;
        this.giaVe = giaVe;
        this.soLuong = soLuong;
        this.soLuongcon = soLuongcon;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaCB() {
        return MaCB;
    }

    public void setMaCB(String MaCB) {
        this.MaCB = MaCB;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoLuongcon() {
        return soLuongcon;
    }

    public void setSoLuongcon(int soLuongcon) {
        this.soLuongcon = soLuongcon;
    }
    
}
