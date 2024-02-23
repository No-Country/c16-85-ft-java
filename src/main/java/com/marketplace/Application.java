package com.marketplace;

import com.marketplace.security.auth.service.AuthenticationService;
import com.marketplace.security.auth.dto.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.marketplace.security.userauth.model.Role.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.email("admin@mail.com")
					.password("1234")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getToken());

			var user = RegisterRequest.builder()
					.email("user@mail.com")
					.password("1234")
					.role(USER)
					.build();

			System.out.println("Customer token: " + service.register(user).getToken());

			var contractor = RegisterRequest.builder()
					.email("contractor@mail.com")
					.password("1234")
					.role(CONTRACTOR)
					.build();

			System.out.println("Customer token: " + service.register(contractor).getToken());
		};
	}
}
