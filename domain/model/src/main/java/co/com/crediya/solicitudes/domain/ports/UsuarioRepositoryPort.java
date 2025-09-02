package co.com.crediya.solicitudes.domain.ports;

import reactor.core.publisher.Mono;

public interface UsuarioRepositoryPort {
    Mono<Boolean> correoExiste(String correoElectronico);
}
