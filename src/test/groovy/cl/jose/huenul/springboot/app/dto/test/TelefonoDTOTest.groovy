package cl.jose.huenul.springboot.app.dto.test

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

import cl.jose.huenul.springboot.app.dto.TelefonoDTO
import spock.lang.Specification


class TelefonoDTOTest extends Specification{
	
	def "Test para clase TelefonoDTO metodo getCityCode"(){
		given:
			def TelefonoDTO telefonoDto
		when:
			telefonoDto = new TelefonoDTO(citycode: '45', countrycode: '78', number: '456123')
		then:
		assertEquals("45", telefonoDto.getCitycode())
	}
	
	def "Test para clase TelefonoDTO metodo getCountryCode"(){
		given:
			def TelefonoDTO telefonoDto
		when:
			telefonoDto = new TelefonoDTO(countrycode: '78')
		then:
		assertEquals("78", telefonoDto.getCountrycode())
	}
	
	def "Test para clase TelefonoDTO metodo getNumber"(){
		given:
			def TelefonoDTO telefonoDto
		when:
			telefonoDto = new TelefonoDTO(number: '456123')
		then:
		assertEquals("456123", telefonoDto.getNumber())
	}

}
