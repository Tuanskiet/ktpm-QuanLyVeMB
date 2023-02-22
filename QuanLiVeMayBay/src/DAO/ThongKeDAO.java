/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ThongKeDAO {

    public List<Object[]> getThongTin(String mave) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM ThongKe WHERE MaVe = ?";
                rs = JdbcHelper.query(sql, mave);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaVe"),
                        rs.getString("MaKH"),
                        rs.getString("NgayDat"),
                        rs.getString("GiaVe"),
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
}
