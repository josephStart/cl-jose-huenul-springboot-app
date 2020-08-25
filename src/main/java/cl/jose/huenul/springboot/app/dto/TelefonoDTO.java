package cl.jose.huenul.springboot.app.dto;

import java.io.Serializable;

public class TelefonoDTO implements Serializable {

	private static final long serialVersionUID = -612045282878196733L;

	private String number;
	private String citycode;
	private String countrycode;

	public TelefonoDTO() {

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	@Override
	public String toString() {
		return "TelefonoDTO [number=" + number + ", citycode=" + citycode + ", countrycode=" + countrycode + "]";
	}

}
