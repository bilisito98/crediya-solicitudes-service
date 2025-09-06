package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.model.TipoPrestamo;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import reactor.core.publisher.Mono;

/**
 * Caso de uso para registrar una solicitud.
 */
public class RegistrarSolicitudUseCase {

    private final SolicitudRepositoryPort repository;

    public RegistrarSolicitudUseCase(SolicitudRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Ejecuta la lógica de registro de la solicitud.
     *
     * @param solicitud Solicitud a registrar
     * @return Mono<Solicitud> con la solicitud registrada o error
     */
    public Mono<Solicitud> ejecutar(Solicitud solicitud) {
        if (solicitud.getNumero() == null || solicitud.getNumero().isEmpty()) {
            return Mono.error(new IllegalArgumentException("El número de solicitud es obligatorio"));
        }
        if (solicitud.getMonto() == null || solicitud.getMonto() <= 0 || solicitud.getMonto() > 15000000) {
            return Mono.error(new IllegalArgumentException("El monto debe estar entre 1 y 15.000.000"));
        }
        if (solicitud.getPlazoMeses() == null || solicitud.getPlazoMeses() <= 0) {
            return Mono.error(new IllegalArgumentException("El plazo debe ser mayor a cero"));
        }
        if (solicitud.getTipoPrestamo() == null || !TipoPrestamo.isValid(solicitud.getTipoPrestamo())) {
            return Mono.error(new IllegalArgumentException("El tipo de préstamo es inválido"));
        }

        solicitud.setEstado("Pendiente de revisión");

        return repository.existeSolicitud(solicitud.getNumero())
                .flatMap(existe -> existe
                        ? Mono.error(new IllegalArgumentException("Número de solicitud ya registrado"))
                        : repository.guardarSolicitud(solicitud)
                );
    }
}
