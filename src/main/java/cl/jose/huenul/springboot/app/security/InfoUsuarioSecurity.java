package cl.jose.huenul.springboot.app.security;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import cl.jose.huenul.springboot.app.constants.GlobalConstants;
import cl.jose.huenul.springboot.app.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class InfoUsuarioSecurity {
	
	private final static Logger LOG = LoggerFactory.getLogger(InfoUsuarioSecurity.class);
	
	public String getJWTToken(Usuario user) {
		String secretKey = GlobalConstants.SECURITY_JWT_TOKEN_SECRET;
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts
				.builder()
				.setId(UUID.randomUUID().toString())
				.setSubject(user.getName())
				.setSubject(user.getEmail())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(Date.from(ZonedDateTime.now().plusHours(2).toInstant()))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		
		LOG.info("token: " + GlobalConstants.SECURITY_JWT_TOKEN_PREFIX.concat(" ").concat(token));
		return token;
	}

}
