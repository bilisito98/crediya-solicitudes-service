package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import reactor.core.publisher.Mono;

public class RegistrarSolicitudUseCase {

    private final SolicitudRepositoryPort repositoryPort;

    public RegistrarSolicitudUseCase(SolicitudRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Mono<Solicitud> ejecutar(Solicitud solicitud) {
        if (solicitud.getNumero() == null || solicitud.getNumero().isEmpty()) {
            return Mono.error(new IllegalArgumentException("El número de solicitud es obligatorio"));
        }
        if (solicitud.getMonto() == null || solicitud.getMonto() <= 0) {
            return Mono.error(new IllegalArgumentException("El monto debe ser mayor a cero"));
        }

        return repositoryPort.existeSolicitud(solicitud.getNumero())
                .flatMap(existe -> {
                    if (existe) return Mono.error(new IllegalArgumentException("Número de solicitud ya registrado"));
                    return repositoryPort.guardarSolicitud(solicitud);
                });
    }
}
