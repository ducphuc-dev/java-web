package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.slidebean;
import DungChung.DBUtils;

public class slidedao {
	public ArrayList<slidebean> getSlide() throws Exception {
		// B1: Tao noi chua trong RAM
		ArrayList<slidebean> ds = new ArrayList<slidebean>();
		// B2: Ket noi vao db
		DBUtils db = new DBUtils();

		// B3: Lay du lieu ve
		try {
			db.KetNoi();
			String sql = "SELECT * FROM Slide";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maSlide = rs.getString("maSlide");
				String url = rs.getString("url");
				slidebean slide = new slidebean(maSlide, url);
				ds.add(slide);
			}
			rs.close();
			db.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
