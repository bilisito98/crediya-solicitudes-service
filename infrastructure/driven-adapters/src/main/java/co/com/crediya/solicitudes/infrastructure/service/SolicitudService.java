package co.com.crediya.solicitudes.infrastructure.service;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.usecase.SolicitudUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class SolicitudService {

    private static final Logger log = LoggerFactory.getLogger(SolicitudService.class);

    private final SolicitudUseCase useCase;

    public SolicitudService(SolicitudUseCase useCase) {
        this.useCase = useCase;
    }

    public Mono<Solicitud> registrarSolicitud(Solicitud solicitud) {
        return validarSolicitud(solicitud)
                .flatMap(s -> useCase.existeSolicitudPorNumero(s.getNumero())
                        .flatMap(existe -> {
                            if (existe) {
                                return Mono.error(new RuntimeException("Ya existe una solicitud con el número " + s.getNumero()));
                            }
                            s.setEstado("Pendiente de revisión");
                            return useCase.crearSolicitud(s);
                        }))
                .doOnSubscribe(sub -> log.info("Iniciando registro de solicitud [{}]", solicitud.getNumero()))
                .doOnSuccess(s -> log.info("Solicitud registrada exitosamente [{}]", s.getNumero()))
                .doOnError(e -> log.error("Error registrando solicitud: {}", e.getMessage(), e));
    }

    public Flux<Solicitud> obtenerTodas() {
        log.info("Consultando todas las solicitudes registradas");
        return useCase.obtenerTodasLasSolicitudes();
    }

    public Mono<Solicitud> obtenerPorId(String id) {
        log.info("Consultando solicitud con id [{}]", id);
        return useCase.obtenerSolicitudPorId(UUID.fromString(id))
                .switchIfEmpty(Mono.error(new RuntimeException("Solicitud no encontrada")));
    }

    private Mono<Solicitud> validarSolicitud(Solicitud solicitud) {
        if (solicitud.getDocumentoIdentidad() == null || solicitud.getDocumentoIdentidad().isBlank()) {
            return Mono.error(new IllegalArgumentException("El documento del cliente es obligatorio."));
        }
        if (solicitud.getMonto() == null || solicitud.getMonto() <= 0) {
            return Mono.error(new IllegalArgumentException("El monto solicitado debe ser mayor a 0."));
        }
        if (solicitud.getPlazoMeses() == null || solicitud.getPlazoMeses() <= 0) {
            return Mono.error(new IllegalArgumentException("El plazo debe ser mayor a 0 meses."));
        }
        if (solicitud.getTipoPrestamo() == null || solicitud.getTipoPrestamo().isBlank()) {
            return Mono.error(new IllegalArgumentException("El tipo de préstamo es obligatorio."));
        }
        return Mono.just(solicitud);
    }
}
