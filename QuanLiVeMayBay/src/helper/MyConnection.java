/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class MyConnection {
    public static Connection ketNoi(String dataBase){
        try {
            String user ="sa",
                    pass = "123",
                    url = "jdbc:sqlserver://localhost:1433;database=" + dataBase;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        ketNoi("QuanliMaybay_ktpm");
    }
}
