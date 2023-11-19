package br.com.udesc.ceavi.eso.ese.reviewservice

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class ReviewServiceApplication

fun main(args: Array<String>) {
	runApplication<ReviewServiceApplication>(*args)
}

@Configuration
class OpenApiConfig() {
	@Bean
	fun usersMicroserviceOpenApi(): OpenAPI {
		return OpenAPI()
			.info(
				Info().title("Review-Web-Service")
					.description("A Review web service")
					.version("1.0")
			)
	}
}