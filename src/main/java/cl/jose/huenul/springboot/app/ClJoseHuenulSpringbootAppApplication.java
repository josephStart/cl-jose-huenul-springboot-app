package cl.jose.huenul.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ClJoseHuenulSpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClJoseHuenulSpringbootAppApplication.class, args);
	}

}
