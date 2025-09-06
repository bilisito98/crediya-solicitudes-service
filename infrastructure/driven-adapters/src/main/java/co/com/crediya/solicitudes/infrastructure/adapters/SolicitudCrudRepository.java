package co.com.crediya.solicitudes.infrastructure.adapters;

import co.com.crediya.solicitudes.infrastructure.entity.SolicitudEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SolicitudCrudRepository extends ReactiveCrudRepository<SolicitudEntity, UUID> {
    Mono<Boolean> existsByNumero(String numero);
}
