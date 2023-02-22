/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Administrator
 */
public class NhanVien {
    private String maNV;
    private String tenNV;
     private String email;
    private String SDT;
    private String DiaChi;
    private String TenDN;
    private String MatKhau;
    private boolean chucVu;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String email,  String SDT, String DiaChi, String TenDN, String MatKhau, boolean chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
        this.chucVu = chucVu;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    /**
     * @return the maNV
     */
    public String getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the tenNV
     */
    public String getTenNV() {
        return tenNV;
    }

    /**
     * @param tenNV the tenNV to set
     */
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    /**
     * @return the SDT
     */
    public String getSDT() {
        return SDT;
    }

    /**
     * @param SDT the SDT to set
     */
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    /**
     * @return the DiaChi
     */
    public String getDiaChi() {
        return DiaChi;
    }

    /**
     * @param DiaChi the DiaChi to set
     */
    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    /**
     * @return the TenDN
     */
    public String getTenDN() {
        return TenDN;
    }

    /**
     * @param TenDN the TenDN to set
     */
    public void setTenDN(String TenDN) {
        this.TenDN = TenDN;
    }

    /**
     * @return the MatKhau
     */
    public String getMatKhau() {
        return MatKhau;
    }

    /**
     * @param MatKhau the MatKhau to set
     */
    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean getChucVu() {
        return chucVu;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu;
    }

 
}
