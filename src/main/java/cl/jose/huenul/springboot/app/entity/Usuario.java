package cl.jose.huenul.springboot.app.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "id_user", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idUsuario;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "creation_date", nullable = false)
	private LocalDateTime fechaCreacion;

	@Column(name = "update_date", insertable = false, updatable = true)
	private LocalDateTime fechaActualizacion;

	@Column(name = "lastlogin_date", nullable = false)
	private LocalDateTime fechaUltimoIngreso;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	@ManyToMany
	@JoinTable(name = "usuario_telefono", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_phone"))
	private List<Telefono> phones;

	public Usuario() {

	}

	public UUID getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UUID idUsuario) {
		this.idUsuario = idUsuario;
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

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public LocalDateTime getFechaUltimoIngreso() {
		return fechaUltimoIngreso;
	}

	public void setFechaUltimoIngreso(LocalDateTime fechaUltimoIngreso) {
		this.fechaUltimoIngreso = fechaUltimoIngreso;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Telefono> getPhones() {
		return phones;
	}

	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}

}
