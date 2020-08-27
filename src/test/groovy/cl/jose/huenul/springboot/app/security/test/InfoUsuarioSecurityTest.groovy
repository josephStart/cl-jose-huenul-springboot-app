package cl.jose.huenul.springboot.app.security.test

import static org.junit.Assert.assertNotNull
import static org.junit.jupiter.api.Assertions.*

import cl.jose.huenul.springboot.app.entity.Usuario
import cl.jose.huenul.springboot.app.security.InfoUsuarioSecurity
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication

import spock.lang.Specification
class InfoUsuarioSecurityTest extends Specification{
	
	def "Evaluar token NOTNULL"(){
		given:
			def	infoUsuarioSecurity = new InfoUsuarioSecurity()
			def user = new Usuario(name: 'joseph', email: 'josephs@test.com')
		when:
			def valor = infoUsuarioSecurity.getJWTToken(user) 
		then:
			assertNotNull(valor)
	}
}
