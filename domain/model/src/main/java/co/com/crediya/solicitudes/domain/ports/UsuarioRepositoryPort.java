package co.com.crediya.solicitudes.domain.ports;

import co.com.crediya.solicitudes.domain.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UsuarioRepositoryPort {

    Mono<Usuario> guardarUsuario(Usuario usuario);

    Mono<Boolean> correoExiste(String correo);

    Mono<Usuario> findById(UUID id);

    Flux<Usuario> findAll();

    Mono<Void> deleteById(UUID id);
}
