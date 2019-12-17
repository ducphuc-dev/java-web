package Bean;

import java.util.Date;

public class hoadonbean {
	private int maHoaDon;
	private int maKhachHang;
	private Date ngayMua;
	private boolean daMua;

	public hoadonbean(int maHoaDon, int maKhachHang, Date ngayMua, boolean daMua) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public boolean isDaMua() {
		return daMua;
	}

	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}

}
