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
    private String GioiTinh;
    public Student() {
    }

   

    public Student(String maSV, String hoTen, String ngaySinh, String lop, String nganh, String diaChi, String email,
			String phone, String gioiTinh) {
		super();
		MaSV = maSV;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		Lop = lop;
		Nganh = nganh;
		DiaChi = diaChi;
		Email = email;
		Phone = phone;
		GioiTinh = gioiTinh;
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

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
}
