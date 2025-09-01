package co.com.crediya.solicitudes.appservice.controller;

import co.com.crediya.solicitudes.appservice.service.SolicitudService;
import co.com.crediya.solicitudes.domain.model.Solicitud;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService service;

    @Operation(summary = "Registrar nueva solicitud")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Solicitud registrada correctamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación en los datos enviados")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Solicitud> registrarSolicitud(@RequestBody Solicitud solicitud) {
        return service.registrarSolicitud(solicitud)
                .onErrorResume(e -> Mono.error(new RuntimeException("Error registrando solicitud: " + e.getMessage())));
    }
}
