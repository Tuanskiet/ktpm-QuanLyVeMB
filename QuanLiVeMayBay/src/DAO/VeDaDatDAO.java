/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.ChiTietVe;
import NewInterface.MainInterface;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author FPT
 */
public class VeDaDatDAO  implements MainInterface<ChiTietVe>{
    private List<ChiTietVe> list;
    String insert_sql = "INSERT INTO HocVien(MaKH,MaNH,Diem)VALUES (?,?,?)";
    String update_sql = "UPDATE HocVien SET Diem=? WHERE MaHV=?";
    String delete_sql = "DELETE FROM HocVien WHERE MaHV=?";
    String selectByID_sql = "SELECT * FROM HocVien WHERE MaHV=?";
    String selectAll_sql = "SELECT * FROM HocVien";

    public VeDaDatDAO() {
        this.list = new ArrayList<>();
    }

    @Override
    public void insert(ChiTietVe t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChiTietVe t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String maNV) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietVe selectById(String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietVe> getList() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
