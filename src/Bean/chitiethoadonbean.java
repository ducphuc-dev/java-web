package Bean;

public class chitiethoadonbean {
	private int maCTHD;
	private String maSach;
	private long soLuongMua;
	private int maHoaDon;
	private String tenSach;
	private String anh;
	private Long giaSach;

	public chitiethoadonbean(int maCTHD, String maSach, long soLuongMua, int maHoaDon, String tenSach, String anh,
			Long giaSach) {
		super();
		this.maCTHD = maCTHD;
		this.maSach = maSach;
		this.soLuongMua = soLuongMua;
		this.maHoaDon = maHoaDon;
		this.tenSach = tenSach;
		this.anh = anh;
		this.giaSach = giaSach;
	}

	public int getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(int maCTHD) {
		this.maCTHD = maCTHD;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public long getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Long getGiaSach() {
		return giaSach;
	}

	public void setGiaSach(Long giaSach) {
		this.giaSach = giaSach;
	}

}
