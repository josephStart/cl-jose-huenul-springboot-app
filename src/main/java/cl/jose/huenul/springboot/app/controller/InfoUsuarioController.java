package cl.jose.huenul.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.jose.huenul.springboot.app.dto.RequestInfoUsuarioDTO;
import cl.jose.huenul.springboot.app.dto.StatusResponse;
import cl.jose.huenul.springboot.app.service.InfoUsuarioService;

@RestController
@RequestMapping("/usuario")
public class InfoUsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(InfoUsuarioController.class);
	
	@Autowired
	private InfoUsuarioService infoUsuarioService;
	
	@PostMapping("/crear-usuario")
	public ResponseEntity<Object> crearUsuario(@Valid @RequestBody RequestInfoUsuarioDTO requestDTO,
			BindingResult result) {
		LOG.info("Inicio - crearUsuario");
		ResponseEntity<Object> response = null;
		
		if (!result.hasErrors()) {
			LOG.info("No hay errores");
			response = infoUsuarioService.obtenerUsuarioCreado(requestDTO);
		}else{
			LOG.info("Errores en Cuerpo de entrada");
			StatusResponse statusResponse = new StatusResponse();
			statusResponse.setCodigo(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			List<String> errores = new ArrayList<>();
			result.getAllErrors().stream().forEach(error -> errores.add(error.getDefaultMessage()));
			statusResponse.setMensaje(errores);
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(statusResponse);
		}
		LOG.info("Fin - crearUsuario");
		return response;
	}

}
