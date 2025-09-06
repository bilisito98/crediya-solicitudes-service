package co.com.crediya.solicitudes.entrypoints.reactiveweb.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manejador global de excepciones para la aplicación.
 * Convierte excepciones en respuestas HTTP adecuadas.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones de validación de argumentos.
     *
     * @param ex Excepción de validación
     * @return Respuesta HTTP con detalle de errores
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Mono<ResponseEntity<Map<String, Object>>> handleValidationException(MethodArgumentNotValidException ex) {
        String validationErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return Mono.just(buildErrorResponse(HttpStatus.BAD_REQUEST, validationErrors));
    }

    /**
     * Maneja IllegalArgumentException.
     *
     * @param ex Excepción ilegal de argumento
     * @return Respuesta HTTP con detalle del error
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<Map<String, Object>>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return Mono.just(buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    /**
     * Maneja cualquier otra excepción no controlada.
     *
     * @param ex Excepción general
     * @return Respuesta HTTP con detalle del error
     */
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<Map<String, Object>>> handleGeneralException(Exception ex) {
        return Mono.just(buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    /**
     * Construye la respuesta de error estandarizada.
     *
     * @param status  Código de estado HTTP
     * @param message Mensaje de error
     * @return ResponseEntity con el cuerpo de error
     */
    private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String message) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("status", status.value());
        errorBody.put("error", status.getReasonPhrase());
        errorBody.put("message", message);
        return ResponseEntity.status(status).body(errorBody);
    }
}
