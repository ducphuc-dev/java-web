package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.sachbean;
import DungChung.DBUtils;

public class sachdao {
	DBUtils db = new DBUtils();

	public ArrayList<sachbean> getSach() throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();

		try {
			db.KetNoi();
			String sql = "SELECT * FROM Sach";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				String tacGia = rs.getString("tacgia");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				Date ngayNhap = rs.getDate("NgayNhap");
				String loaiSach = rs.getString("maloai");
				int soLuong = rs.getInt("soluong");
				int soTap = rs.getInt("sotap");
				sachbean sach = new sachbean(maSach, tenSach, tacGia, gia, anh, ngayNhap, loaiSach, soLuong, soTap);
				ds.add(sach);
			}
			rs.close();
			db.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean checkPresent(String maSach) {
		System.out.println("maSach: " + maSach);
		try {
			String sql = "SELECT * FROM Sach WHERE masach = ?";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, maSach);
			ResultSet rs = stmt.executeQuery();
			boolean ketQua = rs.next();
			return ketQua;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public int add(String maSach, String tenSach, String tacGia, Long gia, String anh, Date ngayNhap, String maLoai,
			int soLuong, int soTap) throws Exception {
		db.KetNoi();
		boolean isPresent = checkPresent(maSach);
		if (isPresent) {
			System.out.println("Da ton tai");
			return 0;
		} else {
			System.out.println("Chua ton tai");
			String sql = "INSERT INTO Sach(masach, tensach, soluong, gia, maloai, sotap, anh, ngaynhap, tacgia) VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, maSach);
			stmt.setString(2, tenSach);
			stmt.setInt(3, soLuong);
			stmt.setLong(4, gia);
			stmt.setString(5, maLoai);
			stmt.setInt(6, soTap);
			stmt.setString(7, anh);
			stmt.setDate(8, new java.sql.Date(ngayNhap.getTime()));
			stmt.setString(9, tacGia);
			int cnt = stmt.executeUpdate();
			db.cn.close();
			return cnt;
		}
	}

	public sachbean getSachByMaSach(String maSach) throws Exception {
		db.KetNoi();
		String sql = "SELECT * FROM Sach WHERE masach = ?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maSach);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String tenSach = rs.getString("tensach");
			int soLuong = rs.getInt("soluong");
			long gia = rs.getLong("gia");
			String maLoai = rs.getString("maloai");
			int soTap = rs.getInt("sotap");
			String anh = rs.getString("anh");
			Date ngayNhap = rs.getDate("NgayNhap");
			String tacGia = rs.getString("tacgia");
			sachbean sach = new sachbean(maSach, tenSach, tacGia, gia, anh, ngayNhap, maLoai, soLuong, soTap);
			return sach;
		}
		return null;
	}

	public int edit(String maSach, String tenSach, String tacGia, Long gia, String anh, Date ngayNhap, String maLoai,
			int soLuong, int soTap) throws Exception {
		db.KetNoi();
		int cnt = 0;
		if (anh.length() > 0) {
			String sql = "UPDATE Sach SET tensach = ?, soluong = ?, gia = ?, maloai = ?, sotap = ?, anh = ?, NgayNhap = ?, tacgia = ? WHERE masach=?";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, tenSach);
			stmt.setInt(2, soLuong);
			stmt.setLong(3, gia);
			stmt.setString(4, maLoai);
			stmt.setInt(5, soTap);
			stmt.setString(6, anh);
			stmt.setDate(7, new java.sql.Date(ngayNhap.getTime()));
			stmt.setString(8, tacGia);
			stmt.setString(9, maSach);
			cnt = stmt.executeUpdate();
			System.out.println("Thay doi anh");
		} else {
			String sql = "UPDATE Sach SET tensach=?, soluong=?, gia=?, maloai=?, sotap=?, NgayNhap=?, tacgia=? WHERE masach=?";
			PreparedStatement stmt = db.cn.prepareStatement(sql);
			stmt.setString(1, tenSach);
			stmt.setInt(2, soLuong);
			stmt.setLong(3, gia);
			stmt.setString(4, maLoai);
			stmt.setInt(5, soTap);
			stmt.setDate(6, new java.sql.Date(ngayNhap.getTime()));
			stmt.setString(7, tacGia);
			stmt.setString(8, maSach);
			cnt = stmt.executeUpdate();
			System.out.println("Khong doi anh");
		}
		db.cn.close();
		return cnt;
	}

	public int delete(String maSach) throws Exception {
		db.KetNoi();
		System.out.println(maSach);
		String sql = "DELETE FROM Sach WHERE masach=?";
		PreparedStatement stmt = db.cn.prepareStatement(sql);
		stmt.setString(1, maSach);
		int cnt = stmt.executeUpdate();
		db.cn.close();
		return cnt;
	}
}
