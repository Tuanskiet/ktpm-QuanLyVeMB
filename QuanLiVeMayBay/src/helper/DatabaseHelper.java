/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;
import quanlivemaybay.helper.*;
import java.sql.*;
/**
 *
 * @author Administrator
 */
public class DatabaseHelper {
    
    public static Connection openConnection () throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String userName = "sa";
        String password = "123";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=quanlimaybay;integratedSecurity=false;trustServerCertificate=true";
        Connection con = DriverManager.getConnection(url,userName,password);
        return con;
    }
}
