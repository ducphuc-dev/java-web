package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.loaisachbean;
import DungChung.DBUtils;

public class loaisachdao {
	DBUtils db = new DBUtils();

	public ArrayList<loaisachbean> getLoaiSach() throws Exception {
		// B1: Tao noi chua trong RAM
		ArrayList<loaisachbean> ds = new ArrayList<loaisachbean>();
		// B2: Ket noi vao db
		DBUtils db = new DBUtils();

		// B3: Lay du lieu ve
		try {
			db.KetNoi();
			String sql = "SELECT * FROM Loai";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maLoai = rs.getString("maloai");
				String tenLoai = rs.getString("tenloai");
				loaisachbean loaisach = new loaisachbean(maLoai, tenLoai);
				ds.add(loaisach);
			}
			rs.close();
			db.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean checkPresent(String maLoai) {
		System.out.println("maloai: " + maLoai);
		try {
			String sql = "SELECT * FROM Loai WHERE maLoai = ?";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, maLoai);
			ResultSet rs = stmt.executeQuery();
			boolean ketQua = rs.next();
			System.out.println("ketQua: " + ketQua);
			return ketQua;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public int add(String maLoai, String tenLoai) throws Exception {
		db.KetNoi();
		boolean isPresent = checkPresent(maLoai);
		if (isPresent) {
			System.out.println("Da ton tai");
			return 0;
		} else {
			System.out.println("Chua ton tai");
			String sql = "INSERT INTO Loai(maloai, tenloai) VALUES(?,?)";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, maLoai);
			stmt.setString(2, tenLoai);
			int cnt = stmt.executeUpdate();
			db.cn.close();
			return cnt;
		}
	}

	public boolean countBook(String maLoai) throws Exception {
		String sql = "SELECT maloai FROM Sach WHERE maloai=?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maLoai);
		ResultSet rs = stmt.executeQuery();
		boolean ketQua = rs.next();
		System.out.println("ketQua countBook: " + ketQua);
		return ketQua;
	}

	public int delete(String maLoai) throws Exception {
		// Neu loai khong co sach thi xoa
		db.KetNoi();
		if (countBook(maLoai)) {
			System.out.println("Xoa sach truoc");
			String sql = "DELETE FROM Sach WHERE maloai=?";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, maLoai);
			stmt.executeUpdate();
		}
		System.out.println("Xoa the loai");
		System.out.println(maLoai);
		String sql = "DELETE FROM Loai WHERE maloai=?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maLoai);
		int cnt = stmt.executeUpdate();
		db.cn.close();
		return cnt;

	}

	public int edit(String maLoai, String tenLoai) throws Exception {
		db.KetNoi();
		String sql = "UPDATE Loai SET tenloai=? WHERE maloai=?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, tenLoai);
		stmt.setString(2, maLoai);
		int cnt = stmt.executeUpdate();
		db.cn.close();
		return cnt;
	}

	public loaisachbean getLoaiByMaLoai(String maLoai) throws Exception {
		db.KetNoi();
		String sql = "SELECT * FROM Loai WHERE maLoai = ?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maLoai);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String r_maLoai = rs.getString("maloai");
			String r_tenLoai = rs.getString("tenloai");
			loaisachbean loaisach = new loaisachbean(r_maLoai, r_tenLoai);
			return loaisach;
		}
		return null;
	}
}
