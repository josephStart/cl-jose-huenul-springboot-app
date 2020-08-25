package cl.jose.huenul.springboot.app.dto;

import java.io.Serializable;
import java.util.List;

public class StatusResponse implements Serializable {

	private static final long serialVersionUID = -6650137069645996650L;

	private String codigo;
	List<String> mensaje;

	public StatusResponse() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<String> getMensaje() {
		return mensaje;
	}

	public void setMensaje(List<String> mensaje) {
		this.mensaje = mensaje;
	}

}
