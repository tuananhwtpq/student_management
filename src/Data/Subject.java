/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;


/**
 *
 * @author admin
 */
public class Subject {
    private String MaMon;
    private String TenMon;
    private String stc;
    private String MoTa;
    private String HocKy;
    private double HocPhi;
    private String NgayBanHanh;

    public Subject(String ma, String ten, String stc2, String hk, double hp, String ngaybd) {
    }
    public Subject(String MaMon, String TenMon, double HocPhi) {
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.HocPhi = HocPhi;
    }
    

    public Subject(String MaMon, String TenMon, String stc, String MoTa, String HocKy, double HocPhi, String NgayBanHanh) {
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.stc = stc;
        this.MoTa = MoTa;
        this.HocKy = HocKy;
        this.HocPhi = HocPhi;
        this.NgayBanHanh = NgayBanHanh;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public String getStc() {
        return stc;
    }

    public void setStc(String stc) {
        this.stc = stc;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String HocKy) {
        this.HocKy = HocKy;
    }

    public double getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(double HocPhi) {
        this.HocPhi = HocPhi;
    }

    public String getNgayBanHanh() {
        return NgayBanHanh;
    }

    public void setNgayBanHanh(String NgayBanHanh) {
        this.NgayBanHanh = NgayBanHanh;
    }

    

    @Override
    public String toString() {
        return "Object{" + "MaMon=" + MaMon + ", TenMon=" + TenMon + ", stc=" + stc + ", MoTa=" + MoTa + ", HocKy=" + HocKy + ", HocPhi=" + HocPhi + ", NgayBanHanh=" + NgayBanHanh + '}';
    }
}
