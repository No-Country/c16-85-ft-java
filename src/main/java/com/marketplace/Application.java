package com.marketplace;

import com.marketplace.security.auth.service.AuthenticationService;
import com.marketplace.security.auth.dto.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			var admin23 = RegisterRequest.builder()
					.username("admin111@mail.com")
					.password("1234")
					.firstname("pepe")
					.lastname("perez")
					.birthday("02/02/1990")
					.mobile("323666654")
					.build();
			System.out.println("Admin token: " + service.userRegister(admin23).getToken());

//			var user = RegisterRequest.builder()
//					.username("user@mail.com")
//					.password("1234")
//					.build();
//
//			System.out.println("Customer token: " + service.userRegister(user).getToken());
//
//			var contractor = RegisterRequest.builder()
//					.username("contractor@mail.com")
//					.password("1234")
//					.build();
//
//			System.out.println("Customer token: " + service.userRegister(contractor).getToken());
		};
	}
}
