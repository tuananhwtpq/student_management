/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccessDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author admin
 */
public class JDBCUtil {
    public static Connection getConnection(){
        Connection x = null;
        try{
            //dang ky sqlserver voi driver
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String url = "jdbc:sqlserver://DESKTOP-BKRJKH4:1433;databaseName=QuanLySinhvien;encrypt = true; trustServerCertificate = true";
            String taiKhoan = "sa";
            String matKhau = "12345678";
            //tao ket noi
            x = DriverManager.getConnection(url, taiKhoan, matKhau);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return x;
    }
    public static void closeConnection(Connection c){
        try{
            if(c != null)
                c.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
