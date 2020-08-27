package cl.jose.huenul.springboot.app.controller.test

import static org.junit.jupiter.api.Assertions.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

import cl.jose.huenul.springboot.app.controller.InfoUsuarioController
import cl.jose.huenul.springboot.app.dao.TelefonoDao
import cl.jose.huenul.springboot.app.dto.RequestInfoUsuarioDTO
import cl.jose.huenul.springboot.app.dto.TelefonoDTO
import cl.jose.huenul.springboot.app.service.InfoUsuarioService
import spock.lang.Specification

@WebMvcTest(controllers = [InfoUsuarioController], excludeAutoConfiguration = SecurityAutoConfiguration)
class InfoUsuarioControllerTest extends Specification{

	MockMvc mockMvc
	InfoUsuarioService infoUsuarioService
	InfoUsuarioController infoUsuarioController

	def "Llamada a metodo POST devuelve respuesta 200 al enviar cuerpo correcto"(){

		given:
			infoUsuarioService = Mock(InfoUsuarioService)
			infoUsuarioController = new InfoUsuarioController([infoUsuarioService: infoUsuarioService])
			def telefonoDto = new TelefonoDTO(citycode: '15', countrycode: '45', number: '894561')
			def requestInfoUsuario = new RequestInfoUsuarioDTO(name: 'Test', email: 'test@test.com', password: 'Testeo123', phones: Arrays.asList(telefonoDto))
			def objectMapper = new ObjectMapper();
			objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
			def objectWriter =  objectMapper.writer().withDefaultPrettyPrinter()
			def jsonRequest = objectWriter.writeValueAsString(requestInfoUsuario)
			mockMvc = MockMvcBuilders.standaloneSetup(infoUsuarioController).build()
		expect:
			mockMvc.perform(post("/usuario/crear-usuario").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)).andExpect(status().is2xxSuccessful())
	}
	
	def "Llamada a metodo POST devuelve respuesta 404 al enviar cuerpo incorrecto"(){
		
				given:
					infoUsuarioService = Mock(InfoUsuarioService)
					infoUsuarioController = new InfoUsuarioController([infoUsuarioService: infoUsuarioService])
					def telefonoDto = new TelefonoDTO(citycode: '15', countrycode: '45', number: '894561')
					def requestInfoUsuario = new RequestInfoUsuarioDTO()
					def objectMapper = new ObjectMapper();
					objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
					def objectWriter =  objectMapper.writer().withDefaultPrettyPrinter()
					def jsonRequest = objectWriter.writeValueAsString(requestInfoUsuario)
					mockMvc = MockMvcBuilders.standaloneSetup(infoUsuarioController).build()
				expect:
					mockMvc.perform(post("/usuario/crear-usuario").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)).andExpect(status().is4xxClientError())
			}
}
