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
            String url = "jdbc:sqlserver://LAPTOP-MSCO3NCB:1433;databaseName=QuanLySinhvien;encrypt = true; trustServerCertificate = true";
            String taiKhoan = "sa";
            String matKhau = "123456789";
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
    
    public static void main(String[] args) {
	    Connection connection = null;
	    try {
	      connection = JDBCUtil.getConnection();
	      if (connection != null) {
	        System.out.println("Connection established successfully!");
	      } else {
	        System.out.println("Connection failed!");
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (connection != null) {
	        try {
	          connection.close();
	        } catch (SQLException sqle) {
	          sqle.printStackTrace();
	        }
	      }
	    }
	  }
}
