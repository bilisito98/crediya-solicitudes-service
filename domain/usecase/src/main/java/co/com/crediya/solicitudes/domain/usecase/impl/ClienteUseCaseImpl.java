package co.com.crediya.solicitudes.domain.usecase.impl;

import co.com.crediya.solicitudes.domain.model.Cliente;
import co.com.crediya.solicitudes.domain.ports.ClienteRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.ClienteUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Implementación del caso de uso para clientes.
 */
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteRepositoryPort repository;

    public ClienteUseCaseImpl(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Cliente> crearCliente(Cliente cliente) {
        return repository.guardarCliente(cliente);
    }

    @Override
    public Mono<Cliente> obtenerClientePorId(UUID id) {
        return repository.obtenerClientePorId(id);
    }

    @Override
    public Flux<Cliente> obtenerTodosLosClientes() {
        return repository.obtenerTodosLosClientes();
    }

    @Override
    public Mono<Void> eliminarCliente(UUID id) {
        return repository.eliminarClientePorId(id);
    }

    @Override
    public Mono<Cliente> obtenerClientePorDocumento(String documento) {
        return repository.obtenerClientePorDocumento(documento);
    }
}
