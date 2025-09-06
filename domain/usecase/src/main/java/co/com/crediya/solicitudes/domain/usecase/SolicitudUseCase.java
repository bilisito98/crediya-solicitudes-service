package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SolicitudUseCase {

    Mono<Solicitud> crearSolicitud(Solicitud solicitud);

    Mono<Boolean> existeSolicitudPorNumero(String numero);

    Flux<Solicitud> obtenerTodasLasSolicitudes();

    Mono<Solicitud> obtenerSolicitudPorId(UUID id);
}
