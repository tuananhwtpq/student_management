/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import AccessDatabase.JDBCUtil;
import UI.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TaiKhoan {
    private String tk;
    private String mk;
    private int role;
    Login l = new Login();

    public TaiKhoan() {
    }

    public TaiKhoan(String tk, String mk, int role) {
        this.tk = tk;
        this.mk = mk;
        this.role = role;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    public String getTenSV(){
        String tensv = null;
        String masv = l.getID();
        ArrayList<Student> ds = new ArrayList();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "Select HoTen from SinhVien where MaSV = '"+masv+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tensv = rs.getString("HoTen");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tensv;
    }
}
