package co.com.crediya.solicitudes.infrastructure.entrypoints;

import co.com.crediya.solicitudes.application.usecase.CrearSolicitudUseCase;
import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class SolicitudController {

    private final CrearSolicitudUseCase crearSolicitudUseCase;
    private final SolicitudRepositoryPort solicitudRepository;

    public SolicitudController(CrearSolicitudUseCase crearSolicitudUseCase, SolicitudRepositoryPort solicitudRepository) {
        this.crearSolicitudUseCase = crearSolicitudUseCase;
        this.solicitudRepository = solicitudRepository;
    }

    // DTO interno para request
    public static class CrearSolicitudRequest {
        @NotNull
        private UUID clienteId;
        @NotNull @Min(1)
        private Double monto;
        @NotNull @Min(1)
        private Integer plazoMeses;
        // getters/setters
        public UUID getClienteId() { return clienteId; }
        public void setClienteId(UUID clienteId) { this.clienteId = clienteId; }
        public Double getMonto() { return monto; }
        public void setMonto(Double monto) { this.monto = monto; }
        public Integer getPlazoMeses() { return plazoMeses; }
        public void setPlazoMeses(Integer plazoMeses) { this.plazoMeses = plazoMeses; }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Solicitud> crear(@Valid @RequestBody CrearSolicitudRequest request) {
        return crearSolicitudUseCase.ejecutar(request.getClienteId(), request.getMonto(), request.getPlazoMeses());
    }

    @GetMapping
    public Flux<Solicitud> listarTodas() {
        return solicitudRepository.findAll();
    }

    @GetMapping("/cliente/{clienteId}")
    public Flux<Solicitud> listarPorCliente(@PathVariable UUID clienteId) {
        return solicitudRepository.findAllByClienteId(clienteId);
    }
}
