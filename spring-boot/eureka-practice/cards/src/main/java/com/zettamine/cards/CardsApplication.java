package com.zettamine.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.zettamine.cards.controller") })
@EnableJpaRepositories("com.zettamine.cards.repository")
@EntityScan("com.eazybytes.cards.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "ZettaBank Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Sunil Joseph",
						email = "sunil@zettamine.com",
						url = "https://www.zettamine.com"
				),
				license = @License(
						name = "Zetta 2.0",
						url = "https://www.zettamine.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "ZettaBank Cards microservice REST API Documentation",
				url = "https://www.zettamine.com/swagger-ui.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
