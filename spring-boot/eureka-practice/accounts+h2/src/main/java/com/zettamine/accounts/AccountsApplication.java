package com.zettamine.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.zettamine.accounts.dto.AccountsContactInfoDto;

@SpringBootApplication

/*@ComponentScans({ @ComponentScan("com.zettamine.accounts.controller") })
@EnableJpaRepositories("com.zettamine.accounts.repository")
@EntityScan("com.zettamine.accounts.model")*/

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})

@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "ZettaBank Accounts microservice REST API Documentation",
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
				description =  "ZettaBank Accounts microservice REST API Documentation",
				url = "https://www.zettamine.com/swagger-ui.html"
		)
)
@EnableFeignClients
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
