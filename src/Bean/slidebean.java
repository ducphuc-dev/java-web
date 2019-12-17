package Bean;

public class slidebean {
	private String maSlide;
	private String url;

	public slidebean(String maSlide, String url) {
		super();
		this.maSlide = maSlide;
		this.url = url;
	}

	public String getMaSlide() {
		return maSlide;
	}

	public void setMaSlide(String maSlide) {
		this.maSlide = maSlide;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
