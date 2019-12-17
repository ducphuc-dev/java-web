package Bean;

public class giohangbean {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private String anh;
	private long gia;
	private long soLuong;
	private long thanhTien;

	// ham dung khong co ham so
	public giohangbean() {

	}

	public giohangbean(String maSach, String tenSach, String tacGia, String anh, long gia, long soLuong) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.anh = anh;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhTien = gia * soLuong;
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

	public void setTacgia(String tacGia) {
		this.tacGia = tacGia;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

}
