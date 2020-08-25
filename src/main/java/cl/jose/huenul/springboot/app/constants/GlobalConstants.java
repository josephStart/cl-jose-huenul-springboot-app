package cl.jose.huenul.springboot.app.constants;

public class GlobalConstants {
	
	//Security JWT
	public static final String SECURITY_JWT_TOKEN_HEADER = "Authorization";
	public static final String SECURITY_JWT_TOKEN_PREFIX = "Bearer ";
	public static final String SECURITY_JWT_TOKEN_SECRET = "mySecretKey";
	
	public static final String MENSAJE_ERROR_EXISTS_EMAIL = "El correo ingresa ya existe";
	public static final String MENSAJE_ERROR_BLANK_NAME = "El nombre no puede estar vacio";
	public static final String MENSAJE_ERROR_BLANK_EMAIL = "El email no puede venir vacio";
	public static final String MENSAJE_ERROR_BLANK_PASSWORD = "La contraseña no puede venir vacia";
	public static final String MENSAJE_ERROR_EMAIL = "El email recibido no es válido";
	public static final String MENSAJE_ERROR_PASSWORD = "La contraseña debe tener por lo menos una mayúscula, dos números y minúsculas"; 
	public static final String REGEX_PATTERN_PASSWORD = "^(?=(?:.*[0-9]){2})(?=.*[a-z])(?=(?:.*[A-Z]){1})([a-zA-Z0-9]{0,})$";

	
}
