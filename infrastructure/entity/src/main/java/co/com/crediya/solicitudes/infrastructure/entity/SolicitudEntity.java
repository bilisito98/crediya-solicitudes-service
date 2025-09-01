package co.com.crediya.solicitudes.infrastructure.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Table("solicitudes") // Tabla en la base de datos
public class SolicitudEntity {

    @Id
    private UUID id;

    @Column("cliente_id")
    private UUID clienteId;

    private String numero;

    private Double monto;

    @Column("plazo_meses")
    private Integer plazoMeses;

    private String estado;

    @Column("fecha_creacion")
    private LocalDate fechaCreacion;

    @Column("usuario_id")
    private UUID usuarioId;

    private LocalDate fecha;
}
