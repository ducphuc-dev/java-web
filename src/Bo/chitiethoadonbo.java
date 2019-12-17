package Bo;

import java.util.ArrayList;

import Bean.chitiethoadonbean;
import Dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao cthd = new chitiethoadondao();

	public int add(String maSach, long soLuongMua, int maHoaDon) throws Exception {
		return cthd.add(maSach, soLuongMua, maHoaDon);
	}

	public ArrayList<chitiethoadonbean> getCTHDByMaHoaDon(int maHoaDon) throws Exception {
		return cthd.getCTHDByMaHoaDon(maHoaDon);
	}
}
