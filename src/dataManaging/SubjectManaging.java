/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataManaging;

import AccessDatabase.JDBCUtil;
import Data.Subject;

import UI.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SubjectManaging {

    Login l = new Login();
    String masv = l.getID();
    public Subject selectSubjectbyID(String id){
        Subject o = new Subject();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from Mon where MaMon = '"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            o.setMaMon(rs.getString("MaMon"));
            o.setTenMon(rs.getString("TenMon"));
            o.setStc(rs.getString("SoTinChi"));
            o.setMoTa(rs.getString("MoTa"));
            o.setHocKy(rs.getString("HocKy"));
            o.setHocPhi(rs.getDouble("HocPhi"));
            o.setNgayBanHanh(rs.getString("NgayBanHanh"));
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return o;
    }

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

//                 String hp = rs.getString("HocPhi");

                double hp = rs.getDouble("HocPhi");

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

//                     String hp = rs.getString("HocPhi");

                    double hp = rs.getDouble("HocPhi");

                    String ngaybanhanh = rs.getString("NgayBanHanh");
                    Subject o = new Subject(ma, ten, stc, mota, hk, hp, ngaybanhanh);
                    ds.add(o);
                }else if("Tên môn học".equals(condition) && namer.contains(txtsearch)){
                    String ma = rs.getString("MaMon");
                    String ten = rs.getString("TenMon");
                    String stc = rs.getString("SoTinChi");
                    String mota = rs.getString("MoTa");
                    String hk = rs.getString("HocKy");

//                     String hp = rs.getString("HocPhi");

                    Double hp = rs.getDouble("HocPhi");

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

    public ArrayList<Subject> selectSubjectforDKHP(){
        ArrayList<Subject> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select distinct m.MaMon, m.TenMon, m.SoTinChi, m.HocKy, m.HocPhi, lhp.ThoiGianBatdau\n" +
                        "  from Mon m\n" +
                        "  inner join LopHocPhan lhp on m.MaMon = lhp.MaMon";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString("MaMon");
                String ten = rs.getString("TenMon");
                String stc = rs.getString("SoTinChi");
                String hk = rs.getString("HocKy");
                double hp = rs.getDouble("HocPhi");
                String ngaybd = rs.getString("ThoiGianBatDau");
                Subject o = new Subject(ma, ten, stc, hk, hp, ngaybd);
                ds.add(o);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList<Subject> selecthocphi(){
        ArrayList<Subject> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select TaiLieuThanhToanHocPhi.MaMon, Mon.TenMon, TaiLieuThanhToanHocPhi.HocPhi from TaiLieuThanhToanHocPhi inner join Mon on TaiLieuThanhToanHocPhi.MaMon = Mon.MaMon where MaSV = '"+masv+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString("MaMon");
                String ten = rs.getString("TenMon");
                double hp = rs.getDouble("HocPhi");
                Subject s = new Subject(ma, ten, hp);
                ds.add(s);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return ds;
    }
    public double selecttonghocphi(ArrayList<Subject> example){
        double tong = 0;
        for(Subject s: example){
            tong += s.getHocPhi();
        }
        return tong;
    }
    public int thanhtoanhocphi(int a){
        try{
            double tongtien = 0;
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select SoDu from SinhVien where MaSV = '"+l.getID()+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tongtien = rs.getDouble("SoDu");
            }
            String sql2 = "select * from TaiLieuThanhToanHocPhi";
            ResultSet rs2 = st.executeQuery(sql2);
            int check = 0;
            while(rs2.next()){
                double hocphi = rs2.getDouble("HocPhi");
                String ma = rs2.getString("MaMon");
                if(check == a){
                    if(tongtien < hocphi){
                        return 1;
                    }else{
                        tongtien = tongtien - hocphi;
                        String sql1 = "DELETE FROM TaiLieuThanhToanHocPhi WHERE MaSV = '"+l.getID()+"' AND MaMon = '"+ma+"';";
                        String sql3 = "update SinhVien SET SoDu = "+tongtien+" WHERE MaSV = '"+l.getID()+"';";
                        st.executeUpdate(sql1);
                        st.executeUpdate(sql3);
                        return 2;
                    }
                }
                check++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 3;
    }

}
