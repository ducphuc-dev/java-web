package Bo;

import java.util.ArrayList;
import java.util.Date;

import Bean.sachbean;
import Dao.sachdao;

public class sachbo {
	sachdao s = new sachdao();
	ArrayList<sachbean> dsSach = new ArrayList<sachbean>();

	public ArrayList<sachbean> getSach() throws Exception {
		dsSach = s.getSach();
		return dsSach;
	}

	public ArrayList<sachbean> getSachByLoaiSach(String maLoai) throws Exception {
		ArrayList<sachbean> dsSachByLoai = new ArrayList<sachbean>();
		for (sachbean s : dsSach) {
			if (s.getMaLoai().equals(maLoai)) {
				dsSachByLoai.add(s);
			}
		}
		return dsSachByLoai;
	}

	public ArrayList<sachbean> searchSach(String content) throws Exception {
		content = content.toLowerCase();

		ArrayList<sachbean> dsTimKiemSach = new ArrayList<sachbean>();
		for (sachbean s : dsSach) {
			if (s.getMaLoai().toLowerCase().contains(content) || s.getMaSach().toLowerCase().contains(content)
					|| s.getTenSach().toLowerCase().contains(content) || s.getTacGia().toLowerCase().contains(content)
					|| s.getGia().toString().toLowerCase().equals(content)) {
				dsTimKiemSach.add(s);
			}
		}
		return dsTimKiemSach;
	}

	public int add(String maSach, String tenSach, String tacGia, Long gia, String anh, Date ngayNhap, String maLoai,
			int soLuong, int soTap) throws Exception {
		return s.add(maSach, tenSach, tacGia, gia, anh, ngayNhap, maLoai, soLuong, soTap);
	}

	public sachbean getSachByMaSach(String maSach) throws Exception {
		return s.getSachByMaSach(maSach);
	}

	public int edit(String maSach, String tenSach, String tacGia, Long gia, String anh, Date ngayNhap, String maLoai,
			int soLuong, int soTap) throws Exception {
		return s.edit(maSach, tenSach, tacGia, gia, anh, ngayNhap, maLoai, soLuong, soTap);
	}

	public int delete(String maSach) throws Exception {
		return s.delete(maSach);
	}
}
