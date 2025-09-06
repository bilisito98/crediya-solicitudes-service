package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ClienteUseCase {

    Mono<Cliente> crearCliente(Cliente cliente);

    Mono<Cliente> obtenerClientePorId(UUID id);

    Flux<Cliente> obtenerTodosLosClientes();

    Mono<Void> eliminarCliente(UUID id);

    Mono<Cliente> obtenerClientePorDocumento(String documento);
}
