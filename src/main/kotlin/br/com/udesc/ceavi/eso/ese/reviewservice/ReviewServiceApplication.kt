package br.com.udesc.ceavi.eso.ese.reviewservice

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

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

@Configuration
@EnableWebMvc
class WebConfig : WebMvcConfigurer {
	override fun addCorsMappings(registry: CorsRegistry) {
		registry.addMapping("/**")
	}
}
