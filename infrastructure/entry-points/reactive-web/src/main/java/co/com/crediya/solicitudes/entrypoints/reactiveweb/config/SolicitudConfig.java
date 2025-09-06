package co.com.crediya.solicitudes.entrypoints.reactiveweb.config;

import co.com.crediya.solicitudes.domain.usecase.SolicitudUseCase;
import co.com.crediya.solicitudes.domain.usecase.impl.SolicitudUseCaseImpl;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans para Solicitudes.
 * Define el bean {@link SolicitudUseCase} para inyección en los servicios.
 */
@Configuration
public class SolicitudConfig {

    private final SolicitudRepositoryPort solicitudRepository;

    /**
     * Constructor con inyección del repositorio de solicitudes.
     *
     * @param solicitudRepository repositorio de solicitudes
     */
    public SolicitudConfig(SolicitudRepositoryPort solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    /**
     * Bean de tipo {@link SolicitudUseCase} para inyección.
     *
     * @return instancia de {@link SolicitudUseCaseImpl}
     */
    @Bean
    public SolicitudUseCase solicitudUseCase() {
        return new SolicitudUseCaseImpl(solicitudRepository);
    }
}
