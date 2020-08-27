package cl.jose.huenul.springboot.app.dao.test

import static org.junit.Assert.assertTrue
import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

import cl.jose.huenul.springboot.app.dao.UsuarioDao
import spock.lang.Specification

class UsuarioDaoTest extends Specification{

	def 'Test para metodo existsByEmail, caso para cuando el correo existe'(){
		given: 
			def usuarioDao = Stub(UsuarioDao)
			usuarioDao.existsByEmail('test@test.cl') >> true
			
		when:
			def correoExiste = usuarioDao.existsByEmail('test@test.cl')
		
		then:
		assertTrue(correoExiste)
		
	}
	
	def 'Test para metodo existsByEmail, caso para cuando el correo NO existe'(){
		given:
			def usuarioDao = Stub(UsuarioDao)
			usuarioDao.existsByEmail('test2@test.cl') >> false
			
		when:
			def correoExiste = usuarioDao.existsByEmail('test2@test.cl')
		
		then:
		assertFalse(correoExiste)
		
	}

}
