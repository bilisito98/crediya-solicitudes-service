package co.com.crediya.solicitudes.appservice;

import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.RegistrarSolicitudUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * Clase principal de la aplicación CrediYa Solicitues Service.
 * Configura Spring Boot y habilita el escaneo de repositorios R2DBC.
 */
@SpringBootApplication(scanBasePackages = "co.com.crediya.solicitudes")
@EnableR2dbcRepositories(basePackages = "co.com.crediya.solicitudes.infrastructure.r2dbc")
public class AppServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppServiceApplication.class, args);
    }

    /**
     * Bean para usar el caso de uso de registrar solicitudes.
     *
     * @param solicitudRepository Repositorio de solicitudes
     * @return Instancia de RegistrarSolicitudUseCase
     */
    @Bean
    public RegistrarSolicitudUseCase registrarSolicitudUseCase(SolicitudRepositoryPort solicitudRepository) {
        return new RegistrarSolicitudUseCase(solicitudRepository);
    }
}
