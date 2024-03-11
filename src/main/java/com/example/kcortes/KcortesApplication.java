package com.example.kcortes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Challenge API", version = "2.0", description = "Task Information"))
public class KcortesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KcortesApplication.class, args);
	}

}
