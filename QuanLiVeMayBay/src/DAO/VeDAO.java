/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Ve;
import NewInterface.MainInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class VeDAO  implements MainInterface<Ve>{
private List<Ve> list;
    String insert_sql = "INSERT INTO HocVien(MaKH,MaNH,Diem)VALUES (?,?,?)";
    String update_sql = "UPDATE HocVien SET Diem=? WHERE MaHV=?";
    String delete_sql = "DELETE FROM HocVien WHERE MaHV=?";
    String selectByID_sql = "SELECT * FROM HocVien WHERE MaHV=?";
    String selectAll_sql = "SELECT * FROM HocVien";

    public VeDAO() {
        this.list = new ArrayList<>();
    }

    @Override
    public void insert(Ve t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Ve t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String maNV) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ve selectById(String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ve> getList() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
}
