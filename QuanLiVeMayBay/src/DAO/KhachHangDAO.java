/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.KhachHang;
import NewInterface.KhachhangInterface;
import NewInterface.MainInterface;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class KhachHangDAO implements KhachhangInterface {

    private List<KhachHang> list;
    String insert_sql = "INSERT INTO KhachHang(MaKH,TenKH,MaVe,SDT,DiaChi,Cmnd,Email,MaChuyenBay)VALUES (?,?,?,?,?,?,?,?)";
    String update_sql = "UPDATE KhachHang SET TenKH=?,MaVe=?,SDT=?,DiaChi=?,Cmnd=?,MaChuyenBay=? WHERE MaKH=?";
    String delete_sql = "DELETE FROM KhachHang WHERE MaKH=?";
    String selectByID_sql = "SELECT * FROM KhachHang WHERE MaKH=? ";
    String delete_sql2 = "SELECT * FROM ChuyenBay WHERE MaKH=? ";
    String selectAll_sql = "SELECT * FROM KhachHang";

    public KhachHangDAO() {
        this.list = new ArrayList<>();
    }

    @Override
    public void insert(KhachHang kh) throws Exception {
        JdbcHelper.update(insert_sql, kh.getMaKhachHan(), kh.getMaVe(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getCmndCccd(), kh.getEmail(), kh.getMaChuyenBay());
    }

    @Override
    public void update(KhachHang kh) throws Exception {
        JdbcHelper.update(update_sql, kh.getTenKhachHang(), kh.getMaVe(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getCmndCccd(), kh.getEmail(), kh.getMaChuyenBay(), kh.getMaKhachHan());

    }

    @Override
    public void delete(String MaKH) throws Exception {
        JdbcHelper.update(delete_sql, MaKH);
    }

    @Override
    public KhachHang selectById(String MaKH) throws Exception {
        try {
            list.removeAll(list);
            ResultSet rs = JdbcHelper.query(selectByID_sql, MaKH);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHan(rs.getString("MaKH"));
                kh.setTenKhachHang(rs.getString("TenKH"));
                kh.setSoDienThoai(rs.getString("SDT"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setEmail(rs.getString("Email"));
                kh.setMaVe(rs.getString("MaVe"));
                kh.setMaChuyenBay(rs.getString("MaChuyenBay"));
                kh.setCmndCccd(rs.getString("Cmnd"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (SQLException ex) {
            return null;
//            throw new RuntimeException();
        }

    }

    @Override
    public List<KhachHang> getList() throws Exception {
        try {
            list.removeAll(list);
            ResultSet rs = JdbcHelper.query(selectAll_sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHan(rs.getString("MaKH"));
                kh.setTenKhachHang(rs.getString("TenKH"));
                kh.setSoDienThoai(rs.getString("SDT"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setEmail(rs.getString("Email"));
                kh.setMaVe(rs.getString("MaVe"));
                kh.setMaChuyenBay(rs.getString("MaChuyenBay"));
                kh.setCmndCccd(rs.getString("Cmnd"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

}
