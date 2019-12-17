package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.khachhangbean;
import DungChung.DBUtils;

public class khachhangdao {
	public boolean checkLogin(String tenDangNhap, String pass) {
		DBUtils db = new DBUtils();
		try {
			db.KetNoi();
			String sql = "SELECT * FROM KhachHang WHERE tendn = ? AND pass = ?";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			boolean ketQua = rs.next();
			rs.close();
			db.cn.close();
			return ketQua;
//			if (rs.next()) {
//				String maKhachHang = rs.getString("makh");
//				String tenKhachHang = rs.getString("hoten");
//				String diaChi = rs.getString("diachi");
//				String soDienThoai = rs.getString("sdt");
//				String email = rs.getString("email");
//				String tdn = rs.getString("tendn");
//				khachhangbean kh = new khachhangbean(maKhachHang, tenKhachHang, diaChi, soDienThoai, email, tdn);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public khachhangbean getKhachHangByTenDN(String tenDangNhap) {
		DBUtils db = new DBUtils();
		khachhangbean kh = null;
		try {
			db.KetNoi();
			String sql = "SELECT * FROM KhachHang WHERE tendn = ?";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maKhachHang = rs.getInt("makh");
				String tenKhachHang = rs.getString("hoten");
				String diaChi = rs.getString("diachi");
				String soDienThoai = rs.getString("sodt");
				String email = rs.getString("email");
				String tdn = rs.getString("tendn");
				kh = new khachhangbean(maKhachHang, tenKhachHang, diaChi, soDienThoai, email, tdn);
				return kh;
			}
			rs.close();
			db.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
}
