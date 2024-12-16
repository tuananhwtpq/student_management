/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author admin
 */
public class Score {
    private String MaSV;
    private String MaLHP;
    private String TenLHP;
    private int HocKy;
    private float tx1;
    private float tx2;
    private float gk;
    private float ck;
    private float TongKet;
    private String DanhGia;

    public Score() {
    }

    public Score(String MaSV, String MaLHP, String TenLHP, int HocKy, float tx1, float tx2, float gk, float ck, float TongKet, String DanhGia) {
        this.MaSV = MaSV;
        this.MaLHP = MaLHP;
        this.TenLHP = TenLHP;
        this.HocKy = HocKy;
        this.tx1 = tx1;
        this.tx2 = tx2;
        this.gk = gk;
        this.ck = ck;
        this.TongKet = TongKet;
        this.DanhGia = DanhGia;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getMaLHP() {
        return MaLHP;
    }

    public void setMaLHP(String MaLHP) {
        this.MaLHP = MaLHP;
    }

    public String getTenLHP() {
        return TenLHP;
    }

    public void setTenLHP(String TenLHP) {
        this.TenLHP = TenLHP;
    }

    public int getHocKy() {
        return HocKy;
    }

    public void setHocKy(int HocKy) {
        this.HocKy = HocKy;
    }

    public float getTx1() {
        return tx1;
    }

    public void setTx1(float tx1) {
        this.tx1 = tx1;
    }

    public float getTx2() {
        return tx2;
    }

    public void setTx2(float tx2) {
        this.tx2 = tx2;
    }

    public float getGk() {
        return gk;
    }

    public void setGk(float gk) {
        this.gk = gk;
    }

    public float getCk() {
        return ck;
    }

    public void setCk(float ck) {
        this.ck = ck;
    }

    public float getTongKet() {
        return TongKet;
    }

    public void setTongKet(float TongKet) {
        this.TongKet = TongKet;
    }

    public String getDanhGia() {
        return DanhGia;
    }

    public void setDanhGia(String DanhGia) {
        this.DanhGia = DanhGia;
    }

    @Override
    public String toString() {
        return "Score{" + "MaSV=" + MaSV + ", MaLHP=" + MaLHP + ", TenLHP=" + TenLHP + ", HocKy=" + HocKy + ", tx1=" + tx1 + ", tx2=" + tx2 + ", gk=" + gk + ", ck=" + ck + ", TongKet=" + TongKet + ", DanhGia=" + DanhGia + '}';
    }

    
    
}
