package Bean;

import java.util.Date;

public class sachbean {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private Long gia;
	private String anh;
	private Date ngayNhap;
	private String maLoai;
	private int soLuong;
	private int soTap;

	public sachbean(String maSach, String tenSach, String tacGia, Long gia, String anh, Date ngayNhap, String maLoai,
			int soLuong, int soTap) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.anh = anh;
		this.ngayNhap = ngayNhap;
		this.maLoai = maLoai;
		this.soLuong = soLuong;
		this.soTap = soTap;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getSoTap() {
		return soTap;
	}

	public void setSoTap(int soTap) {
		this.soTap = soTap;
	}

}
