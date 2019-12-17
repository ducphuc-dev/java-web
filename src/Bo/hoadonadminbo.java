package Bo;

import java.util.ArrayList;

import Bean.hoadonadminbean;
import Dao.hoadonadmindao;

public class hoadonadminbo {
	hoadonadmindao hd = new hoadonadmindao();

	public ArrayList<hoadonadminbean> getHoaDon() throws Exception {
		return hd.getHoaDon();
	}
}
