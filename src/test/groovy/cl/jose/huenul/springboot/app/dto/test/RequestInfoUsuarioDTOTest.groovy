package cl.jose.huenul.springboot.app.dto.test

import static org.junit.jupiter.api.Assertions.*

import cl.jose.huenul.springboot.app.dto.RequestInfoUsuarioDTO
import org.junit.jupiter.api.Test

import spock.lang.Specification

class RequestInfoUsuarioDTOTest extends Specification{

	def "Test para clase RequestInfoUsuarioDTO metodo getName"(){
		given:
			def RequestInfoUsuarioDTO request
		when:
			request = new RequestInfoUsuarioDTO(name: 'TestName')
		then:
			assertEquals('TestName', request.getName())
	}

}
