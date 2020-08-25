package cl.jose.huenul.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jose.huenul.springboot.app.entity.Telefono;

public interface TelefonoDao extends JpaRepository<Telefono, Long>{

}
