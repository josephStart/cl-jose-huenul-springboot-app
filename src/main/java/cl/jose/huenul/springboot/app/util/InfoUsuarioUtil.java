package cl.jose.huenul.springboot.app.util;

import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.jose.huenul.springboot.app.dto.ResponseInfoUsuarioDTO;
import cl.jose.huenul.springboot.app.entity.Usuario;
import cl.jose.huenul.springboot.app.security.InfoUsuarioSecurity;

@Component
public class InfoUsuarioUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoUsuarioUtil.class);
	
	@Autowired
	private InfoUsuarioSecurity infoUsuarioSecurity;

	public ResponseInfoUsuarioDTO fillResponseInfoUsuarioDTO(Usuario user) {
		LOG.info("Inicio - fillResponseInfoUsuarioDTO");
		ResponseInfoUsuarioDTO responseInfo = new ResponseInfoUsuarioDTO();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		responseInfo.setId(user.getIdUsuario().toString());
		responseInfo.setCreated(user.getFechaCreacion().format(dtf));
		responseInfo.setModified(user.getFechaActualizacion().format(dtf));
		responseInfo.setLast_login(user.getFechaUltimoIngreso().format(dtf));
		responseInfo.setToken(infoUsuarioSecurity.getJWTToken(user));
		responseInfo.setActive(user.isActive());
		LOG.info("Fin - fillResponseInfoUsuarioDTO");
		return responseInfo;
	}
	

}
