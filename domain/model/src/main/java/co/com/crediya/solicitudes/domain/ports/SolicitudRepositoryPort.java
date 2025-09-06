package co.com.crediya.solicitudes.domain.ports;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SolicitudRepositoryPort {

    Mono<Solicitud> guardarSolicitud(Solicitud solicitud);

    Mono<Solicitud> obtenerSolicitudPorId(UUID id);

    Flux<Solicitud> obtenerTodasLasSolicitudes();

    Mono<Boolean> existeSolicitud(String numero);
}
