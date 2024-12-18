/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author admin
 */
public class dsDangKy {
    private String masv;
    private String maLHP;
    private String thu;
    private double hocPhi;
    private String mamon;

    public dsDangKy() {
    }

    public dsDangKy(String maLHP, String thu, String mamon) {
        this.maLHP = maLHP;
        this.thu = thu;
        this.mamon = mamon;
    }

    public dsDangKy(String masv, String maLHP, String thu, double hocPhi, String mamon) {
        this.masv = masv;
        this.maLHP = maLHP;
        this.thu = thu;
        this.hocPhi = hocPhi;
        this.mamon = mamon;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    @Override
    public String toString() {
        return "dsDangKy{" + "masv=" + masv + ", maLHP=" + maLHP + ", thu=" + thu + ", hocPhi=" + hocPhi + '}';
    }
    
}