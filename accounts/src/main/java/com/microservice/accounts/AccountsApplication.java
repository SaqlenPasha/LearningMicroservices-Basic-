package com.microservice.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef ="auditorAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title ="Accounts Microservice API",
				version ="1.0",
				description ="API for Accounts Microservice",
				contact = @Contact(
						name ="Saqlen Pasha",
						email = "saqlen@gmail.com",
						url ="www.linkedin.com/in/saqlen-pasha-4a6b44197"
						)
				)
		)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}


}
