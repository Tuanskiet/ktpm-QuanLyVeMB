/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package NewInterface;

import Models.KhachHang;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface KhachhangInterface {
    public void insert(KhachHang t)throws Exception;
    public void update(KhachHang t)throws Exception;
    public void delete(String MaKH)throws Exception;
    public KhachHang selectById(String MaKH)throws Exception;
    List<KhachHang> getList()throws Exception;
}
