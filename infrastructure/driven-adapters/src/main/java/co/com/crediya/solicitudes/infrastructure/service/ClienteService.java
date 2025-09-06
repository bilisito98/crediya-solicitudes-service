package co.com.crediya.solicitudes.infrastructure.service;

import co.com.crediya.solicitudes.domain.model.Cliente;
import co.com.crediya.solicitudes.domain.usecase.ClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Servicio de negocio para la gestión de Clientes.
 * Encapsula las operaciones sobre la entidad Cliente y delega en el ClienteUseCase.
 */
@Service
@RequiredArgsConstructor
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    private final ClienteUseCase clienteUseCase;

    public Mono<Cliente> crearCliente(Cliente cliente) {
        log.info("Creando cliente [{}]", cliente.getDocumento());
        return clienteUseCase.crearCliente(cliente)
                .doOnSuccess(c -> log.info("Cliente creado exitosamente [{}]", c.getId()))
                .doOnError(e -> log.error("Error creando cliente: {}", e.getMessage(), e));
    }

    public Mono<Cliente> obtenerClientePorId(UUID id) {
        log.info("Consultando cliente por id [{}]", id);
        return clienteUseCase.obtenerClientePorId(id)
                .doOnError(e -> log.error("Cliente no encontrado: {}", e.getMessage(), e));
    }

    public Flux<Cliente> obtenerTodosLosClientes() {
        log.info("Obteniendo todos los clientes");
        return clienteUseCase.obtenerTodosLosClientes();
    }

    public Mono<Void> eliminarCliente(UUID id) {
        log.info("Eliminando cliente [{}]", id);
        return clienteUseCase.eliminarCliente(id)
                .doOnSuccess(v -> log.info("Cliente [{}] eliminado", id))
                .doOnError(e -> log.error("Error eliminando cliente [{}]: {}", id, e.getMessage(), e));
    }

    public Mono<Cliente> obtenerClientePorDocumento(String documento) {
        log.info("Consultando cliente por documento [{}]", documento);
        return clienteUseCase.obtenerClientePorDocumento(documento)
                .doOnError(e -> log.error("Cliente no encontrado por documento [{}]: {}", documento, e.getMessage(), e));
    }
}
