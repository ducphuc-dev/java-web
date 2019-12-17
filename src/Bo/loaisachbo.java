package Bo;

import java.util.ArrayList;

import Bean.loaisachbean;
import Dao.loaisachdao;

public class loaisachbo {
	loaisachdao ls = new loaisachdao();

	public ArrayList<loaisachbean> getLoaiSach() throws Exception {
		return ls.getLoaiSach();
	}

	public int add(String maLoai, String tenLoai) throws Exception {
		return ls.add(maLoai, tenLoai);
	}

	public int edit(String maLoai, String tenLoai) throws Exception {
		return ls.edit(maLoai, tenLoai);
	}

	public int delete(String maLoai) throws Exception {
		return ls.delete(maLoai);
	}

	public loaisachbean getLoaiByMaLoai(String maLoai) throws Exception {
		return ls.getLoaiByMaLoai(maLoai);
	}
}
