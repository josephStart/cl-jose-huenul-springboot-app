package cl.jose.huenul.springboot.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "telefono")
public class Telefono {

	@Id
	@Column(name = "id_phone", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefono;

	@Column(name = "number", nullable = false)
	private String number;

	@Column(name = "city_code", nullable = false)
	private String cityCode;

	@Column(name = "country_code", nullable = false)
	private String countryCode;

	@ManyToMany(mappedBy = "phones")
	private List<Usuario> users;

	public Telefono() {

	}

	public Long getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
}
