package cl.jose.huenul.springboot.app.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import cl.jose.huenul.springboot.app.constants.GlobalConstants;

public class RequestInfoUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 6296662703979750569L;

	@NotBlank(message = GlobalConstants.MENSAJE_ERROR_BLANK_NAME)
	private String name;
	@NotBlank(message = GlobalConstants.MENSAJE_ERROR_BLANK_EMAIL)
	@Email(message = GlobalConstants.MENSAJE_ERROR_EMAIL)
	private String email;
	@NotBlank(message = GlobalConstants.MENSAJE_ERROR_BLANK_PASSWORD)
	@Pattern(regexp = GlobalConstants.REGEX_PATTERN_PASSWORD, message = GlobalConstants.MENSAJE_ERROR_PASSWORD)
	private String password;
	private List<TelefonoDTO> phones;

	public RequestInfoUsuarioDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TelefonoDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<TelefonoDTO> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "RequestCreateUserDTO [name=" + name + ", email=" + email + ", password=" + password + ", phones="
				+ phones + "]";
	}

}
