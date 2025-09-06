package co.com.crediya.solicitudes.infrastructure.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad R2DBC para solicitudes.
 */
@Data
@Builder
@Table("solicitudes")
public class SolicitudEntity {

    @Id
    private UUID id;

    private UUID clienteId;
    private String documentoIdentidad;
    private String numero;
    private Double monto;
    private Integer plazoMeses;
    private String tipoPrestamo;
    private String estado;
    private LocalDate fechaCreacion;
    private UUID usuarioId;
}
