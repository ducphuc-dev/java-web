package Bo;

import java.util.ArrayList;
import java.util.Date;

import Bean.hoadonbean;
import Dao.hoadondao;

public class hoadonbo {
	hoadondao hd = new hoadondao();

	public ArrayList<hoadonbean> getHoaDon() throws Exception {
		return hd.getHoaDon();
	}

	public int add(int maKhachHang, Date ngayMua, boolean daMua) throws Exception {
		return hd.add(maKhachHang, ngayMua, daMua);
	}

	public ArrayList<hoadonbean> getHoaDonByKhachHang(int maKhachHang) throws Exception {
		return hd.getHoaDonByKhachHang(maKhachHang);
	}

	public int confirm(int maHoaDon) throws Exception {
		return hd.confirm(maHoaDon);
	}
}
