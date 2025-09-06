package co.com.crediya.solicitudes.infrastructure.adapters;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import co.com.crediya.solicitudes.infrastructure.entity.SolicitudEntity;
import co.com.crediya.solicitudes.infrastructure.mapper.SolicitudMapper;
import co.com.crediya.solicitudes.infrastructure.r2dbc.SolicitudR2dbcRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Adapter para el repositorio de solicitudes usando R2DBC.
 */
@Component
public class SolicitudRepositoryAdapter implements SolicitudRepositoryPort {

    private final SolicitudR2dbcRepository repository;

    public SolicitudRepositoryAdapter(SolicitudR2dbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Solicitud> guardarSolicitud(Solicitud solicitud) {
        SolicitudEntity entity = SolicitudMapper.toEntity(solicitud);
        return repository.save(entity).map(SolicitudMapper::toDomain);
    }

    @Override
    public Mono<Solicitud> obtenerSolicitudPorId(UUID id) {
        return repository.findById(id).map(SolicitudMapper::toDomain);
    }

    @Override
    public Flux<Solicitud> obtenerTodasLasSolicitudes() {
        return repository.findAll().map(SolicitudMapper::toDomain);
    }

    @Override
    public Mono<Boolean> existeSolicitud(String numero) {
        return repository.existsByNumero(numero);
    }
}
