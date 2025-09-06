package co.com.crediya.solicitudes.entrypoints.reactiveweb.config;

import co.com.crediya.solicitudes.domain.ports.ClienteRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.ClienteUseCase;
import co.com.crediya.solicitudes.domain.usecase.impl.ClienteUseCaseImpl;
import co.com.crediya.solicitudes.infrastructure.service.ClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans para Clientes.
 * Define los beans {@link ClienteUseCase} y {@link ClienteService} para inyección.
 */
@Configuration
public class ClienteConfig {

    private final ClienteRepositoryPort clienteRepository;

    /**
     * Constructor con inyección del repositorio de clientes.
     *
     * @param clienteRepository repositorio de clientes
     */
    public ClienteConfig(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Bean de tipo {@link ClienteUseCase} para inyección.
     *
     * @return instancia de {@link ClienteUseCaseImpl}
     */
    @Bean
    public ClienteUseCase clienteUseCase() {
        return new ClienteUseCaseImpl(clienteRepository);
    }

    /**
     * Bean de tipo {@link ClienteService} para inyección.
     *
     * @param clienteUseCase use case de cliente
     * @return instancia de {@link ClienteService}
     */
    @Bean
    public ClienteService clienteService(ClienteUseCase clienteUseCase) {
        return new ClienteService(clienteUseCase);
    }
}
