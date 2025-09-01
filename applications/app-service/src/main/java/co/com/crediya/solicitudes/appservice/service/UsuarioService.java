package co.com.crediya.solicitudes.appservice.service;

import co.com.crediya.solicitudes.domain.model.Usuario;
import co.com.crediya.solicitudes.application.usecase.RegistrarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;

    @Transactional
    public Mono<Usuario> registrarUsuario(Usuario usuario) {
        // Logs de traza
        return registrarUsuarioUseCase.ejecutar(usuario)
                .doOnSubscribe(sub -> System.out.println("Iniciando registro de usuario..."))
                .doOnSuccess(u -> System.out.println("Usuario registrado: " + u.getCorreoElectronico()))
                .doOnError(e -> System.err.println("Error registrando usuario: " + e.getMessage()));
    }
}
