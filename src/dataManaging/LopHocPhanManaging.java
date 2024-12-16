/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataManaging;

import AccessDatabase.JDBCUtil;
import Data.LopHocPhan;
import Data.dsDangKy;
import UI.Login;
import UserUI.Registration;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class LopHocPhanManaging {
    Login l = new Login();
    public ArrayList sellectAll(){
        ArrayList<LopHocPhan> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from LopHocPhan";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("MaLHP");
                String name = rs.getString("TenLHP");
                int siso = rs.getInt("SiSoToiDa");
                String tgbd = rs.getString("ThoiGianBatDau");
                String tgkt = rs.getString("ThoiGianKetThuc");
                String monid = rs.getString("MaMon");
                String gvid = rs.getString("MaGVPhuTrach");
                String thu = rs.getString("Thu");
                String tiet = rs.getString("Tiet");
                int soluongsv = rs.getInt("SoLuongSinhVien");
                LopHocPhan lhp = new LopHocPhan(id, name, siso, tgbd, tgkt, monid, gvid, thu, tiet, soluongsv);
                ds.add(lhp);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    public int checkdangkilop(LopHocPhan lhp){
        ArrayList<dsDangKy> ds = this.selectAlldsdk();
        if(lhp.getSoLuongSinhVien() >= lhp.getSiSoToiDa()){
            return 1;
        }else{
            for(dsDangKy l:ds){
                String newthu = lhp.getTiet()+" "+lhp.getThu();
                if(l.getThu().equals(newthu)){
                    return 2;
                }
            }
        }
        Registration regis = new Registration();
        String subjectid = regis.getsubjectID();
        for(dsDangKy l:ds){
            if(subjectid.equals(l.getMamon())){
                return 4;
            }
        }
        return 3;
    }
    public void DangKyLHP(int a, String masv, LopHocPhan lhp){
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select distinct LopHocPhan.MaMon, Mon.TenMon, Mon.HocPhi from LopHocPhan inner join Mon on Mon.MaMon = LopHocPhan.MaMon where LopHocPhan.MaMon = '"+lhp.getMaMon()+"'";
            
            ResultSet rs = st.executeQuery(sql);
            double hocphi = 0;
            while(rs.next()){
                hocphi = rs.getDouble("HocPhi");
                break;
            }
            Registration regis = new Registration();
            
            String sqlu = "insert into TaiLieuDangKi values('"+masv+"', '"+lhp.getMaLHP()+"', '"+regis.getsubjectID()+"', N'"+lhp.getTiet()+"', "+hocphi+")";
            String sqlu1 = "insert into TaiLieuThanhToanHocPhi values('"+masv+"', '"+lhp.getMaMon()+"', "+hocphi+")";
            if(a == 3){
                st.executeUpdate(sqlu);
                st.executeUpdate(sqlu1);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updatesoluongsv(int a, LopHocPhan l){
        if(a == 3){
            try{
                Connection con = JDBCUtil.getConnection();
                Statement st = con.createStatement();
                String sql = "update LopHocPhan SET SoLuongSinhVien = (SoLuongSinhVien + 1) WHERE MaLHP = N'"+l.getMaLHP()+"';";
                st.executeUpdate(sql);
                JDBCUtil.closeConnection(con);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public ArrayList selectAlldsdk(){
        ArrayList<dsDangKy> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from TaiLieuDangKi where MaSV = '"+l.getID()+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String idsv = rs.getString("MaSV");
                String idlhp = rs.getString("MaLHP");
                String thu = rs.getString("Thu");
                double hp = rs.getDouble("HocPhi");
                String mamon = rs.getString("MaMon");
                dsDangKy d = new dsDangKy(idsv, idlhp, thu, hp, mamon);
                ds.add(d);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList selectbyID(String lhpid){
        ArrayList<LopHocPhan> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from LopHocPhan where MaMon = '"+lhpid+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("MaLHP");
                String name = rs.getString("TenLHP");
                int siso = rs.getInt("SiSoToiDa");
                String tgbd = rs.getString("ThoiGianBatDau");
                String tgkt = rs.getString("ThoiGianKetThuc");
                String monid = rs.getString("MaMon");
                String gvid = rs.getString("MaGVPhuTrach");
                String thu = rs.getString("Thu");
                String tiet = rs.getString("Tiet");
                int soluongsv = rs.getInt("SoLuongSinhVien");
                LopHocPhan lhp = new LopHocPhan(id, name, siso, tgbd, tgkt, monid, gvid, thu, tiet, soluongsv);
                ds.add(lhp);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    public LopHocPhan selectbyIndex(String lhpid, int x){
        LopHocPhan lhp = new LopHocPhan();
        ArrayList<LopHocPhan> ds = this.selectbyID(lhpid);
        int n = 1;
        for(LopHocPhan l:ds){
            if(n == x){
                lhp.setMaLHP(l.getMaLHP());
                lhp.setTenLHP(l.getTenLHP());
                lhp.setSiSoToiDa(l.getSiSoToiDa());
                lhp.setThoiGianBatDau(l.getThoiGianBatDau());
                lhp.setThoiGianKetThuc(l.getThoiGianKetThuc());
                lhp.setMaMon(l.getMaMon());
                lhp.setMaGVPhuTrach(l.getMaGVPhuTrach());
                lhp.setThu(l.getThu());
                lhp.setTiet(l.getTiet());
                lhp.setSoLuongSinhVien(l.getSoLuongSinhVien());
            }
            n++;
        }
        return lhp;
    }
    public ArrayList selectlichhoc(){
        ArrayList<dsDangKy> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select TaiLieuDangKi.MaMon, LopHocPhan.Thu, LopHocPhan.Tiet, Mon.TenMon from TaiLieuDangKi inner join Mon on Mon.MaMon = TaiLieuDangKi.MaMon inner join LopHocPhan on TaiLieuDangKi.MaLHP = LopHocPhan.MaLHP where MaSV = '"+l.getID()+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String thu = rs.getString("Thu");
                String tiet = rs.getString("Tiet");
                String tenmon = rs.getString("TenMon");
                dsDangKy dk = new dsDangKy(thu, tiet, tenmon);
                ds.add(dk);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
}
