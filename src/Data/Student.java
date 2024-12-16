/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author admin
 */
public class Student {
    private String MaSV;
    private String HoTen;
    private String NgaySinh;
    private String Lop;
    private String Nganh;
    private String DiaChi;
    private String Email;
    private String Phone;



    private double sodu;

    public Student() {
    }

    public Student(String MaSV, String HoTen, String NgaySinh, String Lop, String Nganh, String DiaChi, String Email, String Phone) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.Lop = Lop;
        this.Nganh = Nganh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.Phone = Phone;
    }



    public Student(String MaSV, String HoTen, String NgaySinh, String Lop, String Nganh, String DiaChi, String Email, String Phone, double sodu) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.Lop = Lop;
        this.Nganh = Nganh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.Phone = Phone;
        this.sodu = sodu;
    }

    public double getSodu() {
        return sodu;
    }

    public void setSodu(double sodu) {
        this.sodu = sodu;
    }
    

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String Nganh) {
        this.Nganh = Nganh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Student{" + "MaSV=" + MaSV + ", HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", Lop=" + Lop + ", Nganh=" + Nganh + ", DiaChi=" + DiaChi + ", Email=" + Email + ", Phone=" + Phone + '}';
    }
}
