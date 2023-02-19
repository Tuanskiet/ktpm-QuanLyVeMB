/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.ChuyenBay;
import NewInterface.ChuyenBayInterface;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ChuyenBayDao implements ChuyenBayInterface {

    private List<ChuyenBay> list;
    String selectByID_SQL = "select * from ChuyenBay where MaCB = ?";
    String insert_SQL = "insert into ChuyenBay(MaCB,DiemDi,DiemDen,GioBay,MaKH,MaMB,GhiChu) values(?,?,?,?,?,?,?)";
    String update_SQL = "update ChuyenBay set DiemDi=?, DiemDen=?,GioBay=?,MaKH=?,MaMB=?,GhiChu=? where MaCB=?";
    String delete_SQL = "delete from ChuyenBay where MaCB=?";
    String selectAll_SQL = "select * From ChuyenBay";

    public ChuyenBayDao() {
        this.list = new ArrayList();
    }

    @Override
    public void insert(ChuyenBay cb) throws Exception {
         JdbcHelper.update(insert_SQL, cb.getMaCB(),cb.getDiemDi(),cb.getDiemDen(),cb.getGioBay(),cb.getMaKH(),cb.getMaMB(),cb.getGhiChu());
    }

    @Override
    public void update(ChuyenBay cb) throws Exception {
        JdbcHelper.update(update_SQL,cb.getDiemDi(),cb.getDiemDen(),cb.getGioBay(),cb.getMaKH(),cb.getMaMB(),cb.getGhiChu(),cb.getMaCB());
    }

    @Override
    public void delete(String MaCB) throws Exception {
         JdbcHelper.update(delete_SQL, MaCB);
    }

    @Override
    public ChuyenBay selectByID(String MaCB) throws Exception {
         try {
            list.removeAll(list);
            ResultSet rs = JdbcHelper.query(selectByID_SQL, MaCB);
            while(rs.next()){
                ChuyenBay cb = new ChuyenBay();
                cb.setMaCB(rs.getString("MaCB"));
                cb.setDiemDi(rs.getString("DiemDi"));
                cb.setDiemDen(rs.getString("DiemDen"));
                cb.setGioBay(rs.getString("GioBay"));
                cb.setMaKH(rs.getString("MaKH"));
                cb.setMaMB(rs.getString("MaMB"));
                cb.setGhiChu(rs.getString("GhiChu"));
                list.add(cb);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<ChuyenBay> getList() throws Exception {
       try {
            list.removeAll(list);
            ResultSet rs = JdbcHelper.query(selectAll_SQL);
            while(rs.next()){
                ChuyenBay cb = new ChuyenBay();
                cb.setMaCB(rs.getString("MaCB"));
                cb.setDiemDi(rs.getString("DiemDi"));
                cb.setDiemDen(rs.getString("DiemDen"));
                cb.setGioBay(rs.getString("GioBay"));
                cb.setMaKH(rs.getString("MaKH"));
                cb.setMaMB(rs.getString("MaMB"));
                cb.setGhiChu(rs.getString("GhiChu"));
                list.add(cb);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
    }

    

