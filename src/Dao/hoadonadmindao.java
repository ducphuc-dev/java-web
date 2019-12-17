package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.hoadonadminbean;
import DungChung.DBUtils;

public class hoadonadmindao {
	public ArrayList<hoadonadminbean> getHoaDon() throws Exception {
		ArrayList<hoadonadminbean> lsHoaDon = new ArrayList<hoadonadminbean>();
		DBUtils db = new DBUtils();
		db.KetNoi();
		String sql = "SELECT * FROM View_DSHoaDon";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int maHoaDon = rs.getInt("MaHoaDon");
			String hoTen = rs.getString("hoten");
			int makh = rs.getInt("makh");
			int tongSLM = rs.getInt("TongSoLuongMua");
			Long tongGia = rs.getLong("TongGia");
			Long thanhTien = rs.getLong("ThanhTien");
			boolean daMua = rs.getBoolean("damua");
			hoadonadminbean hd = new hoadonadminbean(maHoaDon, hoTen, makh, tongSLM, tongGia, thanhTien, daMua);
			lsHoaDon.add(hd);
		}
		return lsHoaDon;
	}
}
