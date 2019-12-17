package Bo;

import Bean.khachhangbean;
import Dao.khachhangdao;

public class khachhangbo {
	khachhangdao kh = new khachhangdao();

	public boolean checkLogin(String tenDangNhap, String pass) {
		return kh.checkLogin(tenDangNhap, pass);
	}

	public khachhangbean getKhachHangByTenDN(String tenDangNhap) {
		return kh.getKhachHangByTenDN(tenDangNhap);
	}
}
