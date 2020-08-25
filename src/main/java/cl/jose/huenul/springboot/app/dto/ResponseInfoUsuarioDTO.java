package cl.jose.huenul.springboot.app.dto;

import java.io.Serializable;

public class ResponseInfoUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1595160353175557521L;

	private String id;
	private String created;
	private String modified;
	private String last_login;
	private String token;
	private boolean isActive;

	public ResponseInfoUsuarioDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ResponseInfoUsuarioDTO [id=" + id + ", created=" + created + ", modified=" + modified + ", last_login="
				+ last_login + ", token=" + token + ", isActive=" + isActive + "]";
	}

}
