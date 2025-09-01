package co.com.crediya.solicitudes.infrastructure.config;

import co.com.crediya.solicitudes.domain.model.solicitud.gateways.SolicitudRepository;
import co.com.crediya.solicitudes.domain.usecase.SolicitudUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolicitudUseCaseConfig {

    @Bean
    public SolicitudUseCase solicitudUseCase(SolicitudRepository solicitudRepository) {
        return new SolicitudUseCase(solicitudRepository);
    }
}
