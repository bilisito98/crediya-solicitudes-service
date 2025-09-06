package co.com.crediya.solicitudes.entrypoints.reactiveweb.controller;

import co.com.crediya.solicitudes.infrastructure.service.ClienteService;
import co.com.crediya.solicitudes.domain.model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Controlador REST para la gestión de Clientes.
 * Proporciona endpoints para CRUD de clientes.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    /**
     * Constructor con inyección del servicio de cliente.
     *
     * @param clienteService servicio de clientes
     */
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Listar todos los clientes.
     *
     * @return Flux con todos los clientes
     */
    @Operation(summary = "Listar todos los clientes")
    @GetMapping
    public Flux<Cliente> listarClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    /**
     * Obtener un cliente por su ID.
     *
     * @param id UUID del cliente
     * @return Mono con el cliente encontrado
     */
    @Operation(summary = "Obtener cliente por ID")
    @GetMapping("/{id}")
    public Mono<Cliente> obtenerCliente(@PathVariable UUID id) {
        return clienteService.obtenerClientePorId(id);
    }

    /**
     * Crear un nuevo cliente.
     *
     * @param cliente objeto Cliente con los datos
     * @return Mono con el cliente creado
     */
    @Operation(summary = "Crear un nuevo cliente")
    @PostMapping
    public Mono<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    /**
     * Eliminar un cliente por su ID.
     *
     * @param id UUID del cliente
     * @return Mono vacío al completar
     */
    @Operation(summary = "Eliminar cliente por ID")
    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCliente(@PathVariable UUID id) {
        return clienteService.eliminarCliente(id);
    }
}
