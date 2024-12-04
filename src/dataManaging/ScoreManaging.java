/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataManaging;
import AccessDatabase.JDBCUtil;
import Data.Score;
import UI.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class ScoreManaging {
    public ArrayList<Score> selectAll(){
        ArrayList<Score> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT\n" +
                        "	Diem.MaSV, Diem.MaLHP, LopHocPhan.TenLHP AS LopHocPhan,Mon.HocKy, Diem.Tx1, Diem.Tx2, Diem.Gk, Diem.Ck, Diem.TongKet, Diem.DanhGia\n" +
                        "    FROM Diem\n" +
                        "    JOIN\n" +
                        "    LopHocPhan ON Diem.MaLHP = LopHocPhan.MaLHP\n" +
                        "	join\n" +
                        "	Mon ON LopHocPhan.MaMon = Mon.MaMon";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String masv = rs.getString("MaSV");
                String malop = rs.getString("MaLHP");
                String lop = rs.getString("LopHocPhan");
                int hk = rs.getInt("HocKy");
                float tx1 = rs.getFloat("Tx1");
                float tx2 = rs.getFloat("Tx2");
                float gk = rs.getFloat("Gk");
                float ck = rs.getFloat("Ck");
                float tk = rs.getFloat("TongKet");
                String danhgia = rs.getString("DanhGia");
                Score s = new Score(masv, malop, lop, hk, tx1, tx2, gk, ck, tk, danhgia);
                ds.add(s);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    
    public ArrayList selectByCondition(String condition, String txtsearch) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ArrayList<Score> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            //thuc thi cau lenh sql
            String sql = "SELECT\n" +
                        "	Diem.MaSV, Diem.MaLHP, LopHocPhan.TenLHP AS LopHocPhan,Mon.HocKy, Diem.Tx1, Diem.Tx2, Diem.Gk, Diem.Ck, Diem.TongKet, Diem.DanhGia\n" +
                        "    FROM Diem\n" +
                        "    JOIN\n" +
                        "    LopHocPhan ON Diem.MaLHP = LopHocPhan.MaLHP\n" +
                        "	join\n" +
                        "	Mon ON LopHocPhan.MaMon = Mon.MaMon";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String idr = rs.getString("MaLHP");
                String namer = rs.getString("LopHocPhan");
                if("Mã môn học".equals(condition) && idr.contains(txtsearch)){
                    String masv = rs.getString("MaSV");
                    String malop = rs.getString("MaLHP");
                    String lop = rs.getString("LopHocPhan");
                    int hk = rs.getInt("HocKy");
                    float tx1 = rs.getFloat("Tx1");
                    float tx2 = rs.getFloat("Tx2");
                    float gk = rs.getFloat("Gk");
                    float ck = rs.getFloat("Ck");
                    float tk = rs.getFloat("TongKet");
                    String danhgia = rs.getString("DanhGia");
                    Score s = new Score(masv, malop, lop, hk, tx1, tx2, gk, ck, tk, danhgia);
                    ds.add(s);
                }else if("Tên môn học".equals(condition) && namer.contains(txtsearch)){
                    String masv = rs.getString("MaSV");
                    String malop = rs.getString("MaLHP");
                    String lop = rs.getString("LopHocPhan");
                    int hk = rs.getInt("HocKy");
                    float tx1 = rs.getFloat("Tx1");
                    float tx2 = rs.getFloat("Tx2");
                    float gk = rs.getFloat("Gk");
                    float ck = rs.getFloat("Ck");
                    float tk = rs.getFloat("TongKet");
                    String danhgia = rs.getString("DanhGia");
                    Score s = new Score(masv, malop, lop, hk, tx1, tx2, gk, ck, tk, danhgia);
                    ds.add(s);
                }
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    public Score getScore(String ID){
        Login lg = new Login();
        String masv = lg.getID();
        ArrayList<Score> ds = this.selectAll();
        for(Score s:ds){
            if(ID.equals(s.getMaLHP()) && masv.equals(s.getMaSV())){
                String ma = s.getMaSV();
                String malop = s.getMaLHP();
                String tenlop = s.getTenLHP();
                int hk = s.getHocKy();
                float tx1 = s.getTx1();
                float tx2 = s.getTx2();
                float gk = s.getGk();
                float ck = s.getCk();
                float tk = s.getTongKet();
                String danhgia = s.getDanhGia();
                Score x = new Score(ma, malop, tenlop, hk, tx1, tx2, gk, ck, tk, danhgia);
                return x;
            }
        }
        return null;
    }
}
