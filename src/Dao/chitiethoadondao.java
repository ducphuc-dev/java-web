package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.chitiethoadonbean;
import Bean.sachbean;
import Bo.sachbo;
import DungChung.DBUtils;

public class chitiethoadondao {
	public int add(String maSach, long soLuongMua, int maHoaDon) throws Exception {
		DBUtils db = new DBUtils();
		db.KetNoi();
		String sql = "INSERT INTO ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon) VALUES(?,?,?)";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maSach);
		stmt.setLong(2, soLuongMua);
		stmt.setInt(3, maHoaDon);
		int cnt = stmt.executeUpdate();
		db.cn.close();
		return cnt; // return id
	}

	public ArrayList<chitiethoadonbean> getCTHDByMaHoaDon(int maHoaDon) throws Exception {
		ArrayList<chitiethoadonbean> lsCTHD = new ArrayList<chitiethoadonbean>();
		DBUtils db = new DBUtils();
		db.KetNoi();
		String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHoaDon = ?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setInt(1, maHoaDon);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int maCTHD = rs.getInt("MaChiTietHD");
			String maSach = rs.getString("MaSach");
			long soLuongMua = rs.getLong("SoLuongMua");
			sachbo sbo = new sachbo();
			sachbean sach = sbo.getSachByMaSach(maSach);
			chitiethoadonbean hd = new chitiethoadonbean(maCTHD, maSach, soLuongMua, maHoaDon, sach.getTenSach(),
					sach.getAnh(), sach.getGia());
			lsCTHD.add(hd);
		}
		return lsCTHD;
	}
}
