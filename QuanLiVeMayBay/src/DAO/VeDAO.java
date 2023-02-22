/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Models.Ve;
import NewInterface.MainInterface;
import helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

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
   
    public Ve findById(String MaVe) {
        String sql = "SELECT * FROM ThongKe WHERE MaVe = ?";
        List<Ve> list = select(sql, MaVe);
        return list.size() > 0 ? list.get(0) : null;
    }
   private List<Ve> select(String sql, Object... args) {
        List<Ve> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    Ve model = readFromResultSet(rs);
                    list.add(model);
                }
                System.err.println(rs);
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    private Ve readFromResultSet(ResultSet rs) throws SQLException {
        Ve model = new Ve();
        model.setMaVe(rs.getString("MaVe"));
        model.setMaCB(rs.getString("MaCB"));
        model.setLoaiVe(rs.getString("LoaiVe"));
        model.setGiaVe(rs.getDouble("GiaVe"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setSoLuongCon(rs.getInt("SoLuongCon"));
        return model;
    }
}