/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataManaging;

import AccessDatabase.JDBCUtil;
import Data.Student;
import UI.ManageAllStudent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class StudentManaging implements Interface<Student>{

    @Override
    public int insert(Student s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Student> selectAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ArrayList<Student> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT \n" +
                        "    SinhVien.MaSV, \n" +
                        "    SinhVien.HoTen, \n" +
                        "    SinhVien.NgaySinh, \n" +
                        "    Lop.TenLop AS Lop, \n" +
                        "    Nganh.TenNganh AS Nganh, \n" +
                        "    SinhVien.DiaChi, \n" +
                        "    SinhVien.Email, \n" +
                        "    SinhVien.SoDienThoai\n" +
                        "FROM \n" +
                        "    SinhVien\n" +
                        "JOIN \n" +
                        "    Lop ON SinhVien.MaLop = Lop.MaLop\n" +
                        "JOIN \n" +
                        "    Nganh ON SinhVien.MaNganh = Nganh.MaNganh;";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String msv = rs.getString("MaSV");
                String hoten = rs.getString("Hoten");
                String bday = rs.getString("NgaySinh");
                String lop = rs.getString("Lop");
                String nganh = rs.getString("Nganh");
                String address = rs.getString("DiaChi");
                String email = rs.getString("Email");
                String phone = rs.getString("SoDienThoai");
                Student s = new Student(msv, hoten, bday, lop, nganh, address, email, phone);
                ds.add(s);
            }
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Student selectBId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList selectByCondition(String condition, String txtsearch) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ArrayList<Student> ds = new ArrayList();
        try{
            ManageAllStudent mas = new ManageAllStudent();
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            //thuc thi cau lenh sql
            String sql = "SELECT \n" +
                        "    SinhVien.MaSV, SinhVien.HoTen, SinhVien.NgaySinh, Lop.TenLop AS Lop, Nganh.TenNganh AS Nganh, SinhVien.DiaChi, SinhVien.Email, SinhVien.SoDienThoai\n" +
                        "FROM SinhVien\n" +
                        "JOIN \n" +
                        "    Lop ON SinhVien.MaLop = Lop.MaLop\n" +
                        "JOIN \n" +
                        "    Nganh ON SinhVien.MaNganh = Nganh.MaNganh;";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String idr = rs.getString("MaSV");
                String namer = rs.getString("HoTen");
                String classr = rs.getString("Lop");
                String major = rs.getString("Nganh");
                if("ID".equals(condition) && idr.equals(txtsearch)){
                    String msv = rs.getString("MaSV");
                    String hoten = rs.getString("Hoten");
                    String bday = rs.getString("NgaySinh");
                    String lop = rs.getString("Lop");
                    String nganh = rs.getString("Nganh");
                    String address = rs.getString("DiaChi");
                    String email = rs.getString("Email");
                    String phone = rs.getString("SoDienThoai");
                    Student s = new Student(msv, hoten, bday, lop, nganh, address, email, phone);
                    ds.add(s);
                }else if("Họ tên".equals(condition) && namer.contains(txtsearch)){
                    String msv = rs.getString("MaSV");
                    String hoten = rs.getString("Hoten");
                    String bday = rs.getString("NgaySinh");
                    String lop = rs.getString("Lop");
                    String nganh = rs.getString("Nganh");
                    String address = rs.getString("DiaChi");
                    String email = rs.getString("Email");
                    String phone = rs.getString("SoDienThoai");
                    Student s = new Student(msv, hoten, bday, lop, nganh, address, email, phone);
                    ds.add(s);
                }else if("Lớp".equals(condition) && classr.contains(txtsearch)){
                    String msv = rs.getString("MaSV");
                    String hoten = rs.getString("Hoten");
                    String bday = rs.getString("NgaySinh");
                    String lop = rs.getString("Lop");
                    String nganh = rs.getString("Nganh");
                    String address = rs.getString("DiaChi");
                    String email = rs.getString("Email");
                    String phone = rs.getString("SoDienThoai");
                    Student s = new Student(msv, hoten, bday, lop, nganh, address, email, phone);
                    ds.add(s);
                }else if("Ngành".equals(condition) && major.contains(txtsearch)){
                    String msv = rs.getString("MaSV");
                    String hoten = rs.getString("Hoten");
                    String bday = rs.getString("NgaySinh");
                    String lop = rs.getString("Lop");
                    String nganh = rs.getString("Nganh");
                    String address = rs.getString("DiaChi");
                    String email = rs.getString("Email");
                    String phone = rs.getString("SoDienThoai");
                    Student s = new Student(msv, hoten, bday, lop, nganh, address, email, phone);
                    ds.add(s);
                }
            }
            
            JDBCUtil.closeConnection(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
    
}