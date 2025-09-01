package co.com.crediya.solicitudes.appservice.service;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.usecase.RegistrarSolicitudUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final RegistrarSolicitudUseCase useCase;

    public Mono<Solicitud> registrarSolicitud(Solicitud solicitud) {
        return useCase.ejecutar(solicitud)
                .doOnSuccess(s -> System.out.println("Solicitud registrada: " + s.getNumero()))
                .doOnError(e -> System.err.println("Error registrando solicitud: " + e.getMessage()));
    }
}
