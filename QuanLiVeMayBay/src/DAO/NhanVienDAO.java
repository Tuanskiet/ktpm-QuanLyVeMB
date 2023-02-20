/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NhanVien;
import NewInterface.MainInterface;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 * @param <NhanVien>
 */
public class NhanVienDAO implements MainInterface<NhanVien> {

    String selectByID_SQL = "select * from NhanVien where TenDN = ?";
    String selectByEmail_SQL = "select * from NhanVien where email = ?";
    String insert_SQL = "insert into NhanVien(MaNV,MatKhau,HoTen,VaiTro) values(?,?,?,?)";
    String update_SQL = "update NhanVien set MatKhau=?, TenNV=?,ChucVu=? where MaNV=?";
    String delete_SQL = "delete from NhanVien where MaNV=?";
    String selectAll_SQL = "select * From NhanVien";

    private List<NhanVien> list;

    public NhanVienDAO() {
        this.list = new ArrayList();
    }

    @Override
    public void insert(NhanVien nv) throws Exception {
        JdbcHelper.update(insert_SQL, nv.getMaNV(), nv.getMatKhau(), nv.getTenNV(), nv.getChucVu());
    }

    @Override
    public void update(NhanVien nv) throws Exception {
        JdbcHelper.update(update_SQL, nv.getMatKhau(), nv.getTenNV(), nv.getChucVu(), nv.getMaNV());
    }

    @Override
    public void delete(String maNV) throws Exception {
        JdbcHelper.update(delete_SQL, maNV);
    }

    @Override
    public NhanVien selectById(String maNV) throws Exception {
        try {
            ResultSet rs = JdbcHelper.query(selectByID_SQL, maNV);
            System.out.println(rs);

            list.removeAll(list);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setSDT(rs.getString("SDT"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setTenDN(rs.getString("TenDN"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setChucVu(rs.getBoolean("ChucVu"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (Exception e) {
//            throw new RuntimeException();
            return null;
        }
    }

    @Override
    public List getList() throws Exception {
        list.removeAll(list);
        ResultSet rs = JdbcHelper.query(selectAll_SQL);
        while (rs.next()) {
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setMatKhau(rs.getString("MatKhau"));
            nv.setTenNV(rs.getString("HoTen"));
            nv.setChucVu(rs.getBoolean("VaiTro"));
            list.add(nv);
        }
        rs.getStatement().getConnection().close();
        return list;
    }

    public NhanVien selectByEmail(String email) throws Exception {
        try {
            ResultSet rs = JdbcHelper.query(selectByEmail_SQL, email);
            System.out.println(rs);

            list.removeAll(list);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setSDT(rs.getString("SDT"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setTenDN(rs.getString("TenDN"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setChucVu(rs.getBoolean("ChucVu"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (Exception e) {
//            throw new RuntimeException();
            return null;
        }
    }

}
