package cl.jose.huenul.springboot.app.service;

import org.springframework.http.ResponseEntity;

import cl.jose.huenul.springboot.app.dto.RequestInfoUsuarioDTO;

public interface InfoUsuarioService {

	public ResponseEntity<Object> obtenerUsuarioCreado(RequestInfoUsuarioDTO requestDTO);

}
