package co.com.crediya.solicitudes.entrypoints.reactiveweb.config;

import co.com.crediya.solicitudes.domain.ports.UsuarioRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.RegistrarUsuarioUseCase;
import co.com.crediya.solicitudes.infrastructure.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans para usuarios.
 * Define el UseCase y el Service para inyección de dependencias.
 */
@Configuration
public class UsuarioConfig {

    private final UsuarioRepositoryPort usuarioRepository;

    /**
     * Constructor de UsuarioConfig.
     *
     * @param usuarioRepository Repositorio de usuarios para inyección de dependencias.
     */
    public UsuarioConfig(UsuarioRepositoryPort usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Bean de UseCase para registrar usuarios.
     *
     * @return instancia de RegistrarUsuarioUseCase
     */
    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase() {
        return new RegistrarUsuarioUseCase(usuarioRepository);
    }

    /**
     * Bean de servicio para manejar la lógica de usuarios.
     *
     * @param registrarUsuarioUseCase UseCase inyectado
     * @return instancia de UsuarioService
     */
    @Bean
    public UsuarioService usuarioService(RegistrarUsuarioUseCase registrarUsuarioUseCase) {
        return new UsuarioService(registrarUsuarioUseCase);
    }
}
