package co.com.crediya.solicitudes.infrastructure.adapters;

import co.com.crediya.solicitudes.domain.model.Usuario;
import co.com.crediya.solicitudes.domain.ports.UsuarioRepositoryPort;
import co.com.crediya.solicitudes.infrastructure.entity.UsuarioEntity;
import co.com.crediya.solicitudes.infrastructure.mapper.UsuarioMapper;
import co.com.crediya.solicitudes.infrastructure.r2dbc.UsuarioR2dbcRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioR2dbcRepository repository;

    public UsuarioRepositoryAdapter(UsuarioR2dbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Usuario> guardarUsuario(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        return repository.save(entity)
                .map(UsuarioMapper::toDomain);
    }

    @Override
    public Mono<Boolean> correoExiste(String correo) {
        return repository.findByCorreoElectronico(correo)
                .hasElement();
    }

    @Override
    public Mono<Usuario> findById(UUID id) {
        return repository.findById(id)
                .map(UsuarioMapper::toDomain);
    }

    @Override
    public Flux<Usuario> findAll() {
        return repository.findAll()
                .map(UsuarioMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }
}
