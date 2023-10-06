package com.RestAPIdb.RestApiDB;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Catalin",
						email = "catacoman11@gmail.com"
				)


		)
)
public class RestApiDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiDbApplication.class, args);
	}

}
