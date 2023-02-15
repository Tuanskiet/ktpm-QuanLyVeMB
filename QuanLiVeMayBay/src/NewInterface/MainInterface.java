/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewInterface;

import java.util.List;

/**
 *
 * @author FPT
 * @param <T>
 */
public interface MainInterface<T> {
    void insert(T t)throws Exception;
    void update(T t)throws Exception;
    void delete(String maNV)throws Exception;
    T selectById(String s)throws Exception;
    List<T> getList()throws Exception;
}
