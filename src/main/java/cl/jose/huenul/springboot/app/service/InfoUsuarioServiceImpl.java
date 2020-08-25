package cl.jose.huenul.springboot.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.jose.huenul.springboot.app.constants.GlobalConstants;
import cl.jose.huenul.springboot.app.dao.TelefonoDao;
import cl.jose.huenul.springboot.app.dao.UsuarioDao;
import cl.jose.huenul.springboot.app.dto.RequestInfoUsuarioDTO;
import cl.jose.huenul.springboot.app.dto.ResponseInfoUsuarioDTO;
import cl.jose.huenul.springboot.app.dto.StatusResponse;
import cl.jose.huenul.springboot.app.entity.Telefono;
import cl.jose.huenul.springboot.app.entity.Usuario;
import cl.jose.huenul.springboot.app.util.InfoUsuarioUtil;

@Service
public class InfoUsuarioServiceImpl implements InfoUsuarioService {

	private static final Logger LOG = LoggerFactory.getLogger(InfoUsuarioServiceImpl.class);

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private TelefonoDao telefonoDao;
	@Autowired
	private InfoUsuarioUtil infoUsuarioUtil;

	@Override
	public ResponseEntity<Object> obtenerUsuarioCreado(RequestInfoUsuarioDTO requestDTO) {
		LOG.info("Inicio - obtenerUsuarioCreado");
		ResponseEntity<Object> response = null;
		boolean existeCorreo = usuarioDao.existsByEmail(requestDTO.getEmail());

		ResponseInfoUsuarioDTO responseInfo = null;

		if (!existeCorreo) {
			StatusResponse status = new StatusResponse();
			status.setCodigo(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			status.setMensaje(Arrays.asList(GlobalConstants.MENSAJE_ERROR_EXISTS_EMAIL));
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(status);
		}else {
			Usuario user = crearObtenerUsuarioTelefono(requestDTO);

			responseInfo = infoUsuarioUtil.fillResponseInfoUsuarioDTO(user);
			response = ResponseEntity.status(HttpStatus.OK).body(responseInfo);
		}
		LOG.info("Fin - obtenerUsuarioCreado");
		return response;
	}

	private Usuario crearObtenerUsuarioTelefono(RequestInfoUsuarioDTO requestDTO) {
		Usuario user = new Usuario();

		if (requestDTO.getPhones() != null) {
			List<Telefono> listaTelefonos = new ArrayList<>();
			requestDTO.getPhones().stream().forEach(phone -> {
				Telefono telefono = new Telefono();
				telefono.setCityCode(phone.getCitycode());
				telefono.setCountryCode(phone.getCountrycode());
				telefono.setNumber(phone.getNumber());
				telefonoDao.saveAndFlush(telefono);
				listaTelefonos.add(telefono);
			});
			user.setPhones(listaTelefonos);
		}
		user.setName(requestDTO.getName());
		user.setEmail(requestDTO.getEmail());
		user.setPassword(requestDTO.getPassword());
		user.setActive(Boolean.TRUE);
		LocalDateTime fechaActual = LocalDateTime.now();
		user.setFechaCreacion(fechaActual);
		user.setFechaUltimoIngreso(fechaActual);
		user.setFechaActualizacion(fechaActual);

		usuarioDao.saveAndFlush(user);
		return user;
	}

}
