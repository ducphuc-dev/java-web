package Bo;

import java.util.ArrayList;

import Bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();

	public void Add(String maSach, String tenSach, String tacGia, String anh, long gia) {
		boolean present = false;
		for (giohangbean item : ds) {
			if (item.getMaSach().equals(maSach)) {
				long soLuong = item.getSoLuong() + 1;
				item.setSoLuong(soLuong);
				item.setThanhTien(gia * soLuong);
				present = true;
				return;
			}
		}
		if (!present)
			ds.add(new giohangbean(maSach, tenSach, tacGia, anh, gia, 1));
	}

	public long Sum() {
		long sum = 0;
		for (giohangbean item : ds) {
			sum += item.getThanhTien();
		}
		return sum;
	}

	public long calSoLuong() {
		long soluong = 0;
		for (giohangbean item : ds) {
			soluong += item.getSoLuong();
		}
		return soluong;
	}

	public void Edit(String maSach, long soLuong) {
		for (giohangbean item : ds) {
			if (item.getMaSach().equals(maSach)) {
				item.setSoLuong(soLuong);
				item.setThanhTien(item.getGia() * soLuong);
				return;
			}
		}
	}

	public void Delete(String maSach) {
		for (giohangbean item : ds) {
			if (item.getMaSach().equals(maSach)) {
				ds.remove(item);
				return;
			}
		}
	}
}
