/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataManaging;

import AccessDatabase.JDBCUtil;
import Data.TaiKhoan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TaiKhoanManaging {
    public ArrayList<TaiKhoan> selectAll(){
        ArrayList<TaiKhoan> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * From TaiKhoan";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String tk = rs.getString("Username").replace(" ", "");
                String mk = rs.getString("Passw");
                int role = rs.getInt("Role");
                TaiKhoan t = new TaiKhoan(tk, mk, role);
                ds.add(t);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList<TaiKhoan> selectByRole(int role){
        ArrayList<TaiKhoan> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * From TaiKhoan WHERE Role = "+role;
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String tk = rs.getString("Username");
                String mk = rs.getString("Passw");
                TaiKhoan t = new TaiKhoan(tk, mk, role);
                ds.add(t);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
}
