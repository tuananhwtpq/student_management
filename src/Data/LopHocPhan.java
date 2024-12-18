/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author admin
 */
public class LopHocPhan {
    String maLHP;
    String tenLHP;
    int siSoToiDa;
    String thoiGianBatDau;
    String thoiGianKetThuc;
    String maMon;
    String maGVPhuTrach;
    String thu;
    String tiet;
    int soLuongSinhVien;

    public LopHocPhan() {
    }

    public LopHocPhan(String maLHP, String tenLHP, int siSoToiDa, String thoiGianBatDau, String thoiGianKetThuc, String maMon, String maGVPhuTrach, String thu, String tiet, int soLuongSinhVien) {
        this.maLHP = maLHP;
        this.tenLHP = tenLHP;
        this.siSoToiDa = siSoToiDa;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.maMon = maMon;
        this.maGVPhuTrach = maGVPhuTrach;
        this.thu = thu;
        this.tiet = tiet;
        this.soLuongSinhVien = soLuongSinhVien;
    }

    public String getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public String getTenLHP() {
        return tenLHP;
    }

    public void setTenLHP(String tenLHP) {
        this.tenLHP = tenLHP;
    }

    public int getSiSoToiDa() {
        return siSoToiDa;
    }

    public void setSiSoToiDa(int siSoToiDa) {
        this.siSoToiDa = siSoToiDa;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMaGVPhuTrach() {
        return maGVPhuTrach;
    }

    public void setMaGVPhuTrach(String maGVPhuTrach) {
        this.maGVPhuTrach = maGVPhuTrach;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }

    public int getSoLuongSinhVien() {
        return soLuongSinhVien;
    }

    public void setSoLuongSinhVien(int soLuongSinhVien) {
        this.soLuongSinhVien = soLuongSinhVien;
    }

    @Override
    public String toString() {
        return "LopHocPhan{" + "maLHP=" + maLHP + ", tenLHP=" + tenLHP + ", siSoToiDa=" + siSoToiDa + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + ", maMon=" + maMon + ", maGVPhuTrach=" + maGVPhuTrach + ", thu=" + thu + ", tiet=" + tiet + ", soLuongSinhVien=" + soLuongSinhVien + '}';
    }
    
}