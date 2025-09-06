package co.com.crediya.solicitudes.entrypoints.reactiveweb.controller;

import co.com.crediya.solicitudes.infrastructure.service.SolicitudService;
import co.com.crediya.solicitudes.domain.model.Solicitud;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Controlador REST para la gestión de Solicitudes.
 * Proporciona endpoints para CRUD de solicitudes.
 */
@RestController
@RequestMapping("/api/v1/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService service;

    /**
     * Registrar una nueva solicitud.
     *
     * @param solicitud objeto Solicitud
     * @return Mono con la solicitud registrada
     */
    @Operation(summary = "Registrar nueva solicitud")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Solicitud registrada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Solicitud.class))),
            @ApiResponse(responseCode = "400", description = "Error de validación"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Solicitud> registrarSolicitud(@RequestBody Solicitud solicitud) {
        return service.registrarSolicitud(solicitud);
    }

    /**
     * Obtener todas las solicitudes registradas.
     *
     * @return Flux con todas las solicitudes
     */
    @Operation(summary = "Obtener todas las solicitudes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de solicitudes",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Solicitud.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Solicitud> obtenerTodas() {
        return service.obtenerTodas();
    }

    /**
     * Obtener una solicitud por su ID.
     *
     * @param id UUID de la solicitud
     * @return Mono con la solicitud encontrada
     */
    @Operation(summary = "Obtener solicitud por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitud encontrada",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Solicitud.class))),
            @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public Mono<Solicitud> obtenerPorId(@PathVariable UUID id) {
        return service.obtenerPorId(id.toString());
    }
}
