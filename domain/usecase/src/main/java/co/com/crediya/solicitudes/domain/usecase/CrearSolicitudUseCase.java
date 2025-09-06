package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

public class CrearSolicitudUseCase {

    private final SolicitudRepositoryPort repository;

    public CrearSolicitudUseCase(SolicitudRepositoryPort repository) {
        this.repository = repository;
    }

    public Mono<Solicitud> ejecutar(UUID id, UUID clienteId, String documentoIdentidad, String numero,
                                    Double monto, Integer plazoMeses, String tipoPrestamo,
                                    String estado, LocalDate fecha, UUID usuarioId) {

        Solicitud solicitud = new Solicitud(
                id,
                clienteId,
                documentoIdentidad,
                numero,
                monto,
                plazoMeses,
                tipoPrestamo,
                estado,
                fecha,
                usuarioId
        );

        return repository.guardarSolicitud(solicitud);
    }
}
