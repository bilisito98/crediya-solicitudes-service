package co.com.crediya.solicitudes.domain.usecase.impl;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.SolicitudUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Implementación del caso de uso para solicitudes.
 */
public class SolicitudUseCaseImpl implements SolicitudUseCase {

    private final SolicitudRepositoryPort repositoryPort;

    public SolicitudUseCaseImpl(SolicitudRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Mono<Solicitud> crearSolicitud(Solicitud solicitud) {
        return repositoryPort.guardarSolicitud(solicitud);
    }

    @Override
    public Mono<Boolean> existeSolicitudPorNumero(String numero) {
        return repositoryPort.existeSolicitud(numero);
    }

    @Override
    public Flux<Solicitud> obtenerTodasLasSolicitudes() {
        return repositoryPort.obtenerTodasLasSolicitudes();
    }

    @Override
    public Mono<Solicitud> obtenerSolicitudPorId(UUID id) {
        return repositoryPort.obtenerSolicitudPorId(id);
    }
}
