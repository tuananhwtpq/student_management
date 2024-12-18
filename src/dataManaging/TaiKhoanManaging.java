/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataManaging;


import Data.TaiKhoan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import AccessDatabase.JDBCUtil;

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
                String tk = rs.getString("Username").replace(" ", " ");
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
            String sql = "SELECT * FROM TaiKhoan WHERE Role = "+role;
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
    public TaiKhoan login(String username, String password) {
        TaiKhoan account = null;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM TaiKhoan WHERE Username = '" + username + "' AND Passw = '" + password + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                // If a matching record is found, create a TaiKhoan object with the result
                String tk = rs.getString("Username");
                String mk = rs.getString("Passw");
                int role = rs.getInt("Role");
                account = new TaiKhoan(tk, mk, role);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;  // Returns the account object if login is successful, else returns null
    }

}