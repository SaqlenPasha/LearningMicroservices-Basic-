package com.microservice.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef ="auditorAwareImpl")
@OpenAPIDefinition(
			info = @Info(
					title ="Cards Microservice API",
					version ="1.0",
					description ="API for Cards Microservice",
					contact= @Contact(
								name ="Saqlen Pasha",
								email="saqlen@gmail.com"
							),
							license = @License(
									name ="License 1.0",
									url="www.google.com"
									)
					)
			)
public class CardsApplicatiom {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplicatiom.class, args);
	}

}
