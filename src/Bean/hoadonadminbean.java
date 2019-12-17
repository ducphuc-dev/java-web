package Bean;

public class hoadonadminbean {
	private int maHoaDon;
	private String hoTen;
	private int maKH;
	private int tongSoLuongMua;
	private Long tongGia;
	private Long thanhTien;
	private boolean daMua;

	public hoadonadminbean(int maHoaDon, String hoTen, int maKH, int tongSoLuongMua, Long tongGia, Long thanhTien,
			boolean daMua) {
		super();
		this.maHoaDon = maHoaDon;
		this.hoTen = hoTen;
		this.maKH = maKH;
		this.tongSoLuongMua = tongSoLuongMua;
		this.tongGia = tongGia;
		this.thanhTien = thanhTien;
		this.daMua = daMua;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public int getTongSoLuongMua() {
		return tongSoLuongMua;
	}

	public void setTongSoLuongMua(int tongSoLuongMua) {
		this.tongSoLuongMua = tongSoLuongMua;
	}

	public Long getTongGia() {
		return tongGia;
	}

	public void setTongGia(Long tongGia) {
		this.tongGia = tongGia;
	}

	public Long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(Long thanhTien) {
		this.thanhTien = thanhTien;
	}

	public boolean isDaMua() {
		return daMua;
	}

	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}

}
