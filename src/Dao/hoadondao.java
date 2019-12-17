package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.hoadonbean;
import DungChung.DBUtils;

public class hoadondao {
	public ArrayList<hoadonbean> getHoaDon() throws Exception {
		ArrayList<hoadonbean> lsHoaDon = new ArrayList<hoadonbean>();
		DBUtils db = new DBUtils();
		db.KetNoi();
		String sql = "SELECT * FROM HoaDon";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int maHoaDon = rs.getInt("MaHoaDon");
			int makh = rs.getInt("makh");
			Date ngayMua = rs.getDate("NgayMua");
			boolean daMua = rs.getBoolean("damua");
			hoadonbean hd = new hoadonbean(maHoaDon, makh, ngayMua, daMua);
			lsHoaDon.add(hd);
		}
		return lsHoaDon;
	}

	public int add(int maKhachHang, Date ngayMua, boolean daMua) throws Exception {
		DBUtils db = new DBUtils();
		db.KetNoi();
		String sql = "INSERT INTO HoaDon(makh, NgayMua, damua) VALUES(?,?,?)";
		PreparedStatement stmt = db.cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, maKhachHang);
		stmt.setDate(2, new java.sql.Date(ngayMua.getTime()));
		stmt.setBoolean(3, daMua);
		int cnt = stmt.executeUpdate();

		int lastKey = 0;
		if (cnt > 0) {
			ResultSet keys = stmt.getGeneratedKeys();
			while (keys.next()) {
				lastKey = keys.getInt(1);
			}
		}

		db.cn.close();
		return lastKey; // return id
	}

	public ArrayList<hoadonbean> getHoaDonByKhachHang(int maKhachHang) throws Exception {
		ArrayList<hoadonbean> lsHoaDon = new ArrayList<hoadonbean>();
		DBUtils db = new DBUtils();
		db.KetNoi();
		String sql = "SELECT * FROM HoaDon WHERE makh = ?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setInt(1, maKhachHang);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int maHoaDon = rs.getInt("MaHoaDon");
			int makh = rs.getInt("makh");
			Date ngayMua = rs.getDate("NgayMua");
			boolean daMua = rs.getBoolean("damua");
			hoadonbean hd = new hoadonbean(maHoaDon, makh, ngayMua, daMua);
			lsHoaDon.add(hd);
		}
		return lsHoaDon;
	}

	public int confirm(int maHoaDon) throws Exception {
		ArrayList<hoadonbean> lsHoaDon = new ArrayList<hoadonbean>();
		DBUtils db = new DBUtils();
		db.KetNoi();
		String sql = "UPDATE HoaDon SET damua = 1 WHERE MaHoaDon = ?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setInt(1, maHoaDon);
		int cnt = stmt.executeUpdate();
		return cnt;
	}
}
