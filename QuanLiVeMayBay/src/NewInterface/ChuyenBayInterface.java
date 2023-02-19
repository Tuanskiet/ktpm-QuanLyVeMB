/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package NewInterface;

import Models.ChuyenBay;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ChuyenBayInterface {
   public void insert(ChuyenBay cb) throws Exception;
    public void update(ChuyenBay cb) throws Exception;
    public void delete(String MaCB) throws Exception;
    public ChuyenBay selectByID(String MaCB) throws Exception;
    public List<ChuyenBay> getList() throws Exception;
}
