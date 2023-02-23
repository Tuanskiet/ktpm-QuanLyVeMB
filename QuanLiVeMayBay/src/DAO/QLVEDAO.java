/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.QLVE;
import NewInterface.QLVEInterface;
import UI.JPQLVE;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class QLVEDAO implements QLVEInterface{
    private List<QLVE> list;
    String insert_SQL = "INSERT INTO VeChiTiet(MaVe,MaCB,LoaiVe,GiaVe,SoLuong,SoLuongCon) values(?,?,?,?,?,?)";
    String update_SQL = "UPDATE VeChiTiet set MaCB=?,LoaiVe=?,GiaVe=?,SoLuong=?,SoLuongCon=? WHERE MaVe=?";
    String delete_SQL = "DELETE FROM VeChiTiet WHERE MaVe=?";
    String selectAll_SQL = "select * from VeChiTiet";
    String selectBy_ID_SQL = "SELECT * FROM VeChiTiet WHERE MaVe=?";
//    String loadcbb ="SELECT TOP (1000) [MaVe]FROM [QuanliMaybay].[dbo].[VeBan]";
    public QLVEDAO(){
        this.list = new ArrayList<>();
    }

    @Override
    public void insert(QLVE cd) throws RuntimeException { 
        JdbcHelper.update(insert_SQL, cd.getMaVe(),cd.getMaCB(),cd.getLoaiVe(),cd.getGiaVe(),cd.getSoLuong(),cd.getSoLuongcon());
    }

    @Override
    public void update(QLVE cd) throws RuntimeException {
        JdbcHelper.update(update_SQL,cd.getMaCB(),cd.getLoaiVe(),cd.getGiaVe(),cd.getSoLuong(),cd.getSoLuongcon(),cd.getMaVe());
    }

    @Override
    public void delete(String maVe) throws RuntimeException {
        JdbcHelper.update(delete_SQL, maVe);
    }

//    @Override
//    public QLVE selectByID(String maCD) throws RuntimeException {
//        try {
//            list.removeAll(list);
//            ResultSet rs = JdbcHelper.query(selectBy_ID_SQL, maCD);
//            while(rs.next()){
//                QLVE cd = new QLVE();
//                cd.setMaCD(rs.getString("MaCD"));
//                cd.setTenCD(rs.getString("tenCD"));
//                cd.setHocPhi(rs.getFloat("HocPhi"));
//                cd.setThoiLuong(rs.getInt("ThoiLuong"));
//                cd.setHinh(rs.getString("Hinh"));
//                cd.setMoTa(rs.getString("MoTa"));
//                list.add(cd);
//            }
//            rs.getStatement().getConnection().close();
//            return list.get(0);
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }
//    }

    @Override
    public List<QLVE> getList() throws RuntimeException {
        try {
            list.removeAll(list);
            ResultSet rs = JdbcHelper.query(selectAll_SQL);
            while(rs.next()){
                QLVE cd = new QLVE();
                cd.setMaVe(rs.getString("MaVe"));
                cd.setMaCB(rs.getString("MaCB"));
                cd.setLoaiVe(rs.getString("LoaiVe"));
                cd.setSoLuong(rs.getInt("SoLuong"));
                cd.setSoLuongcon(rs.getInt("SoLuongCon"));
                list.add(cd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public QLVE selectByID(String maCD) throws Exception {

        try {
            list.removeAll(list);
            ResultSet rs = JdbcHelper.query(selectBy_ID_SQL, maCD);
            while(rs.next()){
                QLVE cd = new QLVE();
                cd.setMaVe(rs.getString("MaVe"));
                cd.setMaCB(rs.getString("MaCB"));
                cd.setLoaiVe(rs.getString("LoaiVe"));
                cd.setGiaVe(rs.getDouble("GiaVe"));
                cd.setSoLuong(rs.getInt("SoLuong"));
                cd.setSoLuongcon(rs.getInt("SoLuongCon"));
                list.add(cd);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    

    @Override
    public void loadcbb(QLVE qlve) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   

    
}
