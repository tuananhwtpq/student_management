/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataManaging;

import AccessDatabase.JDBCUtil;
import Data.Subject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SubjectManaging {
    public ArrayList<Subject> selectAll(){
        ArrayList<Subject> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from Mon";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString("MaMon");
                String ten = rs.getString("TenMon");
                String stc = rs.getString("SoTinChi");
                String mota = rs.getString("MoTa");
                String hk = rs.getString("HocKy");
                String hp = rs.getString("HocPhi");
                String ngaybanhanh = rs.getString("NgayBanHanh");
                Subject o = new Subject(ma, ten, stc, mota, hk, hp, ngaybanhanh);
                ds.add(o);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList selectByCondition(String condition, String txtsearch) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ArrayList<Subject> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            //thuc thi cau lenh sql
            String sql = "select * from Mon";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String idr = rs.getString("MaMon");
                String namer = rs.getString("TenMon");
                if("Mã môn học".equals(condition) && idr.contains(txtsearch)){
                    String ma = rs.getString("MaMon");
                    String ten = rs.getString("TenMon");
                    String stc = rs.getString("SoTinChi");
                    String mota = rs.getString("MoTa");
                    String hk = rs.getString("HocKy");
                    String hp = rs.getString("HocPhi");
                    String ngaybanhanh = rs.getString("NgayBanHanh");
                    Subject o = new Subject(ma, ten, stc, mota, hk, hp, ngaybanhanh);
                    ds.add(o);
                }else if("Tên môn học".equals(condition) && namer.contains(txtsearch)){
                    String ma = rs.getString("MaMon");
                    String ten = rs.getString("TenMon");
                    String stc = rs.getString("SoTinChi");
                    String mota = rs.getString("MoTa");
                    String hk = rs.getString("HocKy");
                    String hp = rs.getString("HocPhi");
                    String ngaybanhanh = rs.getString("NgayBanHanh");
                    Subject o = new Subject(ma, ten, stc, mota, hk, hp, ngaybanhanh);
                    ds.add(o);
                }
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
}
