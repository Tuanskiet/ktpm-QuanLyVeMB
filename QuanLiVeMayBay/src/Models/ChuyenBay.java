/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ACER
 */
public class ChuyenBay {

    String MaCB, DiemDi, DiemDen, GioBay, MaKH, MaMB, GhiChu;

    public ChuyenBay(String MaCB, String DiemDi, String DiemDen, String GioBay, String MaKH, String MaMB, String GhiChu) {
        this.MaCB = MaCB;
        this.DiemDi = DiemDi;
        this.DiemDen = DiemDen;
        this.GioBay = GioBay;
        this.MaKH = MaKH;
        this.MaMB = MaMB;
        this.GhiChu = GhiChu;
    }

    public ChuyenBay() {
    }

    public String getMaCB() {
        return MaCB;
    }

    public void setMaCB(String MaCB) {
        this.MaCB = MaCB;
    }

    public String getDiemDi() {
        return DiemDi;
    }

    public void setDiemDi(String DiemDi) {
        this.DiemDi = DiemDi;
    }

    public String getDiemDen() {
        return DiemDen;
    }

    public void setDiemDen(String DiemDen) {
        this.DiemDen = DiemDen;
    }

    public String getGioBay() {
        return GioBay;
    }

    public void setGioBay(String GioBay) {
        this.GioBay = GioBay;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaMB() {
        return MaMB;
    }

    public void setMaMB(String MaMB) {
        this.MaMB = MaMB;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

}
