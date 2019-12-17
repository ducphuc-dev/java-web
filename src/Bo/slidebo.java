package Bo;

import java.util.ArrayList;

import Bean.slidebean;
import Dao.slidedao;

public class slidebo {
	slidedao s = new slidedao();
	ArrayList<slidebean> dsSlide = new ArrayList<slidebean>();

	public ArrayList<slidebean> getSlide() throws Exception {
		dsSlide = s.getSlide();
		return dsSlide;
	}
}
