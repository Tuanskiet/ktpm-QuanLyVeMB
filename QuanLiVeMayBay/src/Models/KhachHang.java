/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author FPT
 */
public class KhachHang {

    String maKhachHan,
            tenKhachHang,
            maVe,
            soDienThoai,
            DiaChi,
            cmndCccd,
            Email,
            maChuyenBay;

    public KhachHang(String maKhachHan, String tenKhachHang, String maVe, String soDienThoai, String DiaChi, String cmndCccd, String Email, String maChuyenBay) {
        this.maKhachHan = maKhachHan;
        this.tenKhachHang = tenKhachHang;
        this.maVe = maVe;
        this.soDienThoai = soDienThoai;
        this.DiaChi = DiaChi;
        this.cmndCccd = cmndCccd;
        this.Email = Email;
        this.maChuyenBay = maChuyenBay;
    }

    public KhachHang() {
    }

    public String getMaKhachHan() {
        return maKhachHan;
    }

    public void setMaKhachHan(String maKhachHan) {
        this.maKhachHan = maKhachHan;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getCmndCccd() {
        return cmndCccd;
    }

    public void setCmndCccd(String cmndCccd) {
        this.cmndCccd = cmndCccd;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    

}
