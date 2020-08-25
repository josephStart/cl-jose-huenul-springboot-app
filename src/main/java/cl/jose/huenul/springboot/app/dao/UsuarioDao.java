package cl.jose.huenul.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jose.huenul.springboot.app.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	
	public boolean existsByEmail(String email);

}
