package model;
// Generated Mar 24, 2019 4:26:40 PM by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Taikhoankhachhang generated by hbm2java
 */
@Entity
@Table(name = "taikhoankhachhang", catalog = "QLSTK")
public class Taikhoankhachhang implements java.io.Serializable {

	private String maTaiKhoan;
	private Loaitaikhoan loaitaikhoan;
	private String hoTen;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String cmnd;
	private String dienThoai;
	private String email;
	private Set<Sotietkiem> sotietkiems = new HashSet<Sotietkiem>(0);

	public Taikhoankhachhang() {
	}

	public Taikhoankhachhang(String maTaiKhoan, Loaitaikhoan loaitaikhoan, String hoTen, Date ngaySinh, String gioiTinh,
			String diaChi, String cmnd, String dienThoai, String email) {
		this.maTaiKhoan = maTaiKhoan;
		this.loaitaikhoan = loaitaikhoan;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.cmnd = cmnd;
		this.dienThoai = dienThoai;
		this.email = email;
	}

	public Taikhoankhachhang(String maTaiKhoan, Loaitaikhoan loaitaikhoan, String hoTen, Date ngaySinh, String gioiTinh,
			String diaChi, String cmnd, String dienThoai, String email, Set<Sotietkiem> sotietkiems) {
		this.maTaiKhoan = maTaiKhoan;
		this.loaitaikhoan = loaitaikhoan;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.cmnd = cmnd;
		this.dienThoai = dienThoai;
		this.email = email;
		this.sotietkiems = sotietkiems;
	}

	@Id

	@Column(name = "MaTaiKhoan", unique = true, nullable = false, length = 20)
	public String getMaTaiKhoan() {
		return this.maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaLoaiTaiKhoan", nullable = false)
	public Loaitaikhoan getLoaitaikhoan() {
		return this.loaitaikhoan;
	}

	public void setLoaitaikhoan(Loaitaikhoan loaitaikhoan) {
		this.loaitaikhoan = loaitaikhoan;
	}

	@Column(name = "HoTen", nullable = false, length = 50)
	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgaySinh", nullable = false, length = 10)
	public Date getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Column(name = "GioiTinh", nullable = false, length = 10)
	public String getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Column(name = "DiaChi", nullable = false)
	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Column(name = "CMND", nullable = false, length = 20)
	public String getCmnd() {
		return this.cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	@Column(name = "DienThoai", nullable = false, length = 20)
	public String getDienThoai() {
		return this.dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	@Column(name = "Email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taikhoankhachhang")
	public Set<Sotietkiem> getSotietkiems() {
		return this.sotietkiems;
	}

	public void setSotietkiems(Set<Sotietkiem> sotietkiems) {
		this.sotietkiems = sotietkiems;
	}

}