/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewInterface;

import Models.QLVE;
import UI.JPQLVE;
import java.util.List;

/**
 *
 * @author pc
 */
public interface QLVEInterface {
    public void insert(QLVE qlve) throws Exception;
    public void update(QLVE qlve) throws Exception;
    public void delete(String maVe) throws Exception;
    public QLVE selectByID(String maCD) throws Exception;
    public List<QLVE> getList() throws Exception;
    public void loadcbb(QLVE qlve) throws Exception;
}
