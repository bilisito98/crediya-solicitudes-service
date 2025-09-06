package co.com.crediya.solicitudes.infrastructure.r2dbc;

import co.com.crediya.solicitudes.infrastructure.entity.SolicitudEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Repositorio R2DBC para solicitudes.
 */
@Repository
public interface SolicitudR2dbcRepository extends ReactiveCrudRepository<SolicitudEntity, UUID> {
    Mono<Boolean> existsByNumero(String numero);
}

