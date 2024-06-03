package com.zettamine.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.zettamine.loans.controller") })
@EnableJpaRepositories("com.zettamine.loans.repository")
@EntityScan("com.zettamine.loans.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "ZettaBank Loans microservice REST API Documentation",
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
				description = "ZettaBank Loans microservice REST API Documentation",
				url = "https://www.zettamine.com/swagger-ui.html"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}
