package co.com.crediya.solicitudes.infrastructure.entrypoints.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Crediya Solicitudes API")
                        .description("Documentación generada automáticamente con Swagger y Springdoc")
                        .version("1.0.0"));
    }
}
