/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.KhachHang;
import NewInterface.MainInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class KhachHangDAO implements MainInterface<KhachHang> {

    private List<KhachHang> list;
    String insert_sql = "INSERT INTO HocVien(MaKH,MaNH,Diem)VALUES (?,?,?)";
    String update_sql = "UPDATE HocVien SET Diem=? WHERE MaHV=?";
    String delete_sql = "DELETE FROM HocVien WHERE MaHV=?";
    String selectByID_sql = "SELECT * FROM HocVien WHERE MaHV=?";
    String selectAll_sql = "SELECT * FROM HocVien";

    public KhachHangDAO() {
        this.list = new ArrayList<>();
    }

    @Override
    public void insert(KhachHang t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(KhachHang t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String maNV) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhachHang selectById(String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> getList() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
